package com.zlx.resume.service;



import com.alibaba.druid.util.StringUtils;
import com.zlx.resume.entity.Companyuser;
import com.zlx.resume.entity.CompanyuserExample;
import com.zlx.resume.exception.GlobalException;
import com.zlx.resume.mapper.CompanyuserMapper;
import com.zlx.resume.mapper.User1Mapper;
import com.zlx.resume.myentity.CompanyApply;
import com.zlx.resume.mymapper.ApplyMapper;
import com.zlx.resume.redis.CompanyKey;
import com.zlx.resume.redis.RedisService;
import com.zlx.resume.redis.UserKey;
import com.zlx.resume.result.CodeMsg;
import com.zlx.resume.util.UUIDUtil;
import com.zlx.resume.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Service
public class CompanyService {

    @Autowired
    CompanyuserMapper companyuserMapper;
    @Autowired
    User1Mapper user1Mapper;

    @Autowired
    RedisService redisService;

    @Autowired
    ApplyMapper apply;

    public static final String COOKIE_NAME_TOKEN = "cutoken";


    /**
     * 公司关联账号申请
     * @param cuser
     * @param capply
     */
    public void cuApply(Companyuser cuser, CompanyApply capply){
        //检测是否已关联公司，是否已经提交申请
        Integer cId = cuser.getcId();
        if (cId!=null){
            //关联公司已经存在
            throw new GlobalException(CodeMsg.COMPANY_IS_EXIST);
        }
        capply.setCuId(cuser.getCuId());
        apply.insertApply(capply);
    }

    /**
     * 查看申请请求
     * @param cuser
     */
    public void findApply(Companyuser cuser){
        List<CompanyApply> apply = this.apply.findApply(cuser);
        for (int i = 0; i < apply.size(); i++) {
            System.out.println(apply.get(i).toString());

        }
    }



    public Companyuser getById(String id) {
        //对象缓存
        Companyuser user = redisService.get(CompanyKey.getById, "" + id, Companyuser.class);
        if (user != null) {
            return user;
        }
        //取数据库
        CompanyuserExample user1Example=new CompanyuserExample();
        CompanyuserExample.Criteria criteria = user1Example.createCriteria();
        criteria.andCuTelEqualTo(id);
        List<Companyuser> user1s = companyuserMapper.selectByExample(user1Example);
        if (user1s.size()>0){
            user=user1s.get(0);
        }

        //再存入缓存
        if (user != null) {
            redisService.set(CompanyKey.getById, "" + id, user);
        }
        return user;
    }

    /**
     * 典型缓存同步场景：更新密码
     */
    public boolean updatePassword(String token, String id, String formPass) {
        //取user
        CompanyuserExample user1Example=new CompanyuserExample();
        CompanyuserExample.Criteria criteria = user1Example.createCriteria();
        criteria.andCuTelEqualTo(id);
        List<Companyuser> user1s = companyuserMapper.selectByExample(user1Example);
        Companyuser user=null;
        if (user1s.size()>0){
            user=user1s.get(0);
        }
        if(user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //更新数据库
        Companyuser toBeUpdate = new Companyuser();
        toBeUpdate.setCuTel(id);
        toBeUpdate.setCuPassword(formPass);
        companyuserMapper.updateByPrimaryKeySelective(toBeUpdate);
        //更新缓存：先删除再插入
        redisService.delete(UserKey.getById, ""+id);
        user.setCuPassword(toBeUpdate.getCuPassword());
        redisService.set(UserKey.token, token, user);
        return true;
    }

    //登录场景,md5加密

    public String login(HttpServletResponse response, LoginVo loginVo) {
        if (loginVo == null) {
            throw new GlobalException(CodeMsg.SERVER_ERROR);
        }
        String mobile = loginVo.getMobile();
        String formPass = loginVo.getPassword();
        //判断手机号是否存在
        Companyuser user = getById(mobile);
        if (user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbPass = user.getCuPassword();
//        String calcPass = MD5Util.formPassToDBPass(formPass, saltDB);
        String calcPass=formPass;
        if (!calcPass.equals(dbPass)) {
            throw new GlobalException(CodeMsg.PASSWORD_ERROR);
        }
        //生成唯一id作为token
        String token = UUIDUtil.uuid();
        addCookie(response, token, user);
        return token;
    }

    /**
     * 将token做为key，用户信息做为value 存入redis模拟session
     * 同时将token存入cookie，保存登录状态
     */
    public void addCookie(HttpServletResponse response, String token,Companyuser user) {
        //插入redis 类名+cutoken+uuid
        redisService.set(CompanyKey.token, token, user);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(CompanyKey.token.expireSeconds());
        cookie.setPath("/");//设置为网站根目录
        response.addCookie(cookie);
    }

    /**
     * 根据token获取用户信息
     */
    public Companyuser getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        Companyuser user = redisService.get(CompanyKey.token, token, Companyuser.class);
        //延长有效期，有效期等于最后一次操作+有效期
        if (user != null) {
            addCookie(response, token, user);
        }
        return user;
    }



}
