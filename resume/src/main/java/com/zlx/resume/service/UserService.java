package com.zlx.resume.service;

import com.alibaba.druid.util.StringUtils;
import com.zlx.resume.entity.Companyuser;
import com.zlx.resume.entity.User1;
import com.zlx.resume.entity.User1Example;
import com.zlx.resume.exception.GlobalException;
import com.zlx.resume.mapper.User1Mapper;
import com.zlx.resume.redis.RedisService;
import com.zlx.resume.redis.UserKey;
import com.zlx.resume.result.CodeMsg;
import com.zlx.resume.util.MD5Util;
import com.zlx.resume.util.UUIDUtil;
import com.zlx.resume.vo.LoginVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by jiangyunxiong on 2018/5/22.
 */
@Service
public class UserService {

    @Autowired
    User1Mapper userMapper;

    @Autowired
    RedisService redisService;

    public static final String COOKIE_NAME_TOKEN = "token";

    public User1 getById(String id) {
        //对象缓存
        User1 user = redisService.get(UserKey.getById, "" + id, User1.class);
        if (user != null) {
            return user;
        }
        //取数据库
        User1Example user1Example=new User1Example();
        User1Example.Criteria criteria = user1Example.createCriteria();
        criteria.andUTelEqualTo(id);
        List<User1> user1s = userMapper.selectByExample(user1Example);
        if (user1s.size()>0){
            user=user1s.get(0);
        }

        //再存入缓存
        if (user != null) {
            redisService.set(UserKey.getById, "" + id, user);
        }
        return user;
    }

    /**
     * 典型缓存同步场景：更新密码
     */
    public boolean updatePassword(String token, String id, String formPass) {
        //取user
        User1Example user1Example=new User1Example();
        User1Example.Criteria criteria = user1Example.createCriteria();
        criteria.andUTelEqualTo(id);
        List<User1> user1s = userMapper.selectByExample(user1Example);
        User1 user=null;
        if (user1s.size()>0){
            user=user1s.get(0);
        }
        if(user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //更新数据库
        User1 toBeUpdate = new User1();
        toBeUpdate.setuTel(id);
        toBeUpdate.setuPassword(formPass);
        userMapper.updateByPrimaryKeySelective(toBeUpdate);
        //更新缓存：先删除再插入
        redisService.delete(UserKey.getById, ""+id);
        user.setuPassword(toBeUpdate.getuPassword());
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
        User1 user = getById(mobile);
        if (user == null) {
            throw new GlobalException(CodeMsg.MOBILE_NOT_EXIST);
        }
        //验证密码
        String dbPass = user.getuPassword();
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
    public void addCookie(HttpServletResponse response, String token, User1 user) {
        redisService.set(UserKey.token, token, user);
        Cookie cookie = new Cookie(COOKIE_NAME_TOKEN, token);
        cookie.setMaxAge(UserKey.token.expireSeconds());
        cookie.setPath("/");//设置为网站根目录
        response.addCookie(cookie);
    }

    /**
     * 根据token获取用户信息
     */
    public User1 getByToken(HttpServletResponse response, String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        User1 user = redisService.get(UserKey.token, token, User1.class);
        //延长有效期，有效期等于最后一次操作+有效期
        if (user != null) {
            addCookie(response, token, user);
        }
        return user;
    }

}
