package com.zlx.resume.service;

import com.alibaba.druid.util.StringUtils;
import com.zlx.resume.dto.CuCheckState;
import com.zlx.resume.entity.Companyuser;
import com.zlx.resume.entity.User1;
import com.zlx.resume.entity.User1Example;
import com.zlx.resume.exception.GlobalException;
import com.zlx.resume.mail.MyMailService;
import com.zlx.resume.mapper.User1Mapper;
import com.zlx.resume.rabitmq.MQSender;
import com.zlx.resume.redis.CompanyKey;
import com.zlx.resume.redis.RedisService;
import com.zlx.resume.redis.UserKey;
import com.zlx.resume.result.CodeMsg;
import com.zlx.resume.util.UUIDUtil;
import com.zlx.resume.vo.FindVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Service
public class FindUserService {
    public static final String COOKIE_NAME_FIND_TOKEN = "findtoken";
    @Autowired
    RedisService redisService;
    @Autowired
    MyMailService myMailService;
    @Autowired
    User1Mapper userMapper;
    @Autowired
    MQSender mqSender;

    /**
     * 发送验证码
     * @param user
     * @param findVo
     */
    public void sendCode(Companyuser user, FindVo findVo) {
        //检查验证码是否已经存在redis中

        String s1 = redisService.get(CompanyKey.getCode, "" + user.getCuId(), String.class);
        if (s1!=null){
            throw new GlobalException(CodeMsg.COED_IS_EXIST);
        }
        //redis查询vo的身份证号码对应的信息，没有再查mysql
        User1 user1 = redisService.get(UserKey.getByCard, "" + findVo.getIdCard(), User1.class);
        if (user1 != null) {
            //放入消息队列，异步发送
            mqSender.sendMessage(user, user1);

            return;
        }


        //取数据库
        User1Example user1Example=new User1Example();
        User1Example.Criteria criteria = user1Example.createCriteria();
        criteria.andUCardEqualTo(findVo.getIdCard());
        List<User1> user1s = userMapper.selectByExample(user1Example);
        if (user1s.size()>0){
            user1=user1s.get(0);
        }
        //账户不存在，------->>>>>>为防止缓存击穿，以后可优化为不存在就将redis的相应value设置为null
        if (user1==null){
           throw new GlobalException(CodeMsg.CARD_NOT_EXIST);
        }
        //将进行检验的用户存入redis，方便下次检验
        redisService.set(UserKey.getByCard,""+findVo.getIdCard(),user1);

        //放入消息队列，异步发送
        mqSender.sendMessage(user, user1);

    }

    /**
     * 验证验证码是否正确，如果正确在cookie增加标识信息(findtoken:随机数)（设置过期时间），
     * 每次访问查询随机数在redis是否存在token随机数，得到查找状态
     * @param cuser
     * @param findVo
     */
    public void checkCode(HttpServletResponse response, Companyuser cuser, FindVo findVo){
        //比对cuser的id和redis存的验证码是否一致
        String s = redisService.get(CompanyKey.getCode, "" + cuser.getCuId(), String.class);
        if (s==null || !s.equals(findVo.getCheckCode())){
            throw new GlobalException(CodeMsg.COED_IS_WRONG);
        }
        //生成token，放入cookie中，以后只需要发送token就可以验证用户信息
        //生成唯一id作为token
        String token = UUIDUtil.uuid();
        addCookie(response
                ,""+token
                , new CuCheckState(cuser.getCuId()
                        , findVo.getIdCard()));

    }

    /**
     * 将查询此id的状态信息存入cookie和redis
     * @param response
     * @param token
     * @param cuCheckState
     */
    public void addCookie(HttpServletResponse response,String token, CuCheckState cuCheckState) {
        redisService.set(CompanyKey.getUserToken
                ,""+token
                ,cuCheckState);
        Cookie cookie = new Cookie(COOKIE_NAME_FIND_TOKEN, token);
        cookie.setMaxAge(CompanyKey.getUserToken.expireSeconds());
        cookie.setPath("/");//设置为网站根目录
        response.addCookie(cookie);
    }



    /**
     * 根据token获取公司查询的findtoken状态
     */
    public CuCheckState getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        CuCheckState cuCheckState = redisService.get(CompanyKey.getUserToken, token, CuCheckState.class);
        //延长有效期，有效期等于最后一次操作+有效期
        if (cuCheckState != null) {
            addCookie(response, token, cuCheckState);
        }
        return cuCheckState;
    }


    /**
     * 查询用户信息，只是获取信息，将验证拆分
     * @param cuser
     * @param findVo
     * @return
     */

    public User1 getUser(Companyuser cuser,CuCheckState cuCheckState) {

        User1 user1 = redisService.get(UserKey.getByCard, "" + cuCheckState.getuCard(), User1.class);

        return user1;
    }


    public void cleanFindHistory(HttpServletRequest request, HttpServletResponse response, Companyuser user) {
        //        分别清理浏览器的缓存和redis的缓存
        Cookie[] cookies = request.getCookies();
        Cookie cleanCookie = null;
        for(Cookie c : cookies){
            if (c.getName().equals(COOKIE_NAME_FIND_TOKEN)) {
                cleanCookie = c;
            }
        }
        if (null == cleanCookie){
            return;
        }
        String hashValue = cleanCookie.getValue();
        redisService.delete(CompanyKey.getUserToken,hashValue);
        cleanCookie.setMaxAge(0);
        response.addCookie(cleanCookie);
    }
}
