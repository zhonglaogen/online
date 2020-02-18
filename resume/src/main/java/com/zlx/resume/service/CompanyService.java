package com.zlx.resume.service;



import com.alibaba.druid.util.StringUtils;
import com.zlx.resume.entity.Company;
import com.zlx.resume.entity.Companyuser;
import com.zlx.resume.entity.CompanyuserExample;
import com.zlx.resume.exception.GlobalException;
import com.zlx.resume.mapper.CompanyMapper;
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
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class CompanyService {

    @Autowired
    CompanyuserMapper companyuserMapper;
    @Autowired
    User1Mapper user1Mapper;

    @Autowired
    RedisService redisService;

    @Autowired
    ApplyMapper applyMapper;

    @Autowired
    CompanyMapper companyMapper;

    public static final String COOKIE_NAME_TOKEN = "cutoken";


    /**
     * 公司关联账号申请
     * @param cuser
     * @param capply
     * @param company
     */
    @Transactional
    public void cuApply(Companyuser cuser, CompanyApply capply, Company company){
        //检测是否已关联公司，是否已经提交申请
        Integer cId = cuser.getcId();
        if (cId!=null){
            //关联公司已经存在
            throw new GlobalException(CodeMsg.COMPANY_IS_EXIST);
        }
        List<CompanyApply> allApply = applyMapper.findApply(cuser);
//        正在申请的记录
        List<CompanyApply> apply = allApply.stream().filter(data -> data.getaResult() == 0).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(apply)){
            throw new GlobalException(CodeMsg.APPLY_IS_COMMIT);
        }
        capply.setCuId(cuser.getCuId());
        companyMapper.insert(company);
        capply.setcId(company.getcId());
        applyMapper.insertApply(capply);
    }

    /**
     * 查看申请请求
     * @param cuser
     */
    public List<CompanyApply> findApply(Companyuser cuser){
        return this.applyMapper.findApply(cuser);

    }

    /**
     * 取消申请关联
     * @param companyApply
     */
    public void cancelApply(CompanyApply companyApply) {
        companyApply.setaResult(3);
        applyMapper.updateApply(companyApply.getCaId());
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
        addCookie(response,
                token,
                COOKIE_NAME_TOKEN + System.currentTimeMillis() + user.getCuTel());
        return token;
    }

    /**
     * 将token做为key，用户信息做为value 存入redis模拟session
     * 同时将token存入cookie，保存登录状态
     */
    public void addCookie(HttpServletResponse response, String tokenValue, String tokenKey) {
        //插入redis 类名+cutoken+uuid


        redisService.set(CompanyKey.NullStr,tokenKey , tokenValue);
        Cookie cookie = new Cookie(tokenKey, tokenValue);
        cookie.setMaxAge(CompanyKey.token.expireSeconds());
        cookie.setPath("/");//设置为网站根目录
        response.addCookie(cookie);
    }

    /**
     * 根据token获取用户信息
     */
    public Companyuser getByToken(HttpServletResponse response, String tokenKey, String tokenVelue) {
        if (StringUtils.isEmpty(tokenKey) || StringUtils.isEmpty(tokenVelue)) {
            return null;
        }
        String hashValue = redisService.get(CompanyKey.NullStr, tokenKey, String.class);
        //延长有效期，有效期等于最后一次操作+有效期
        if (tokenVelue.equals(hashValue)) {
            addCookie(response, tokenVelue, tokenKey);
            return redisService.get(CompanyKey.getById,
                    tokenKey.substring(tokenKey.length()- 11, tokenKey.length()),
                    Companyuser.class
            );
        }
        return null;
    }


    public void loginOut(HttpServletRequest request, HttpServletResponse response, Companyuser companyuser) {
//        reids和浏览器同时清除缓存
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length <= 0) {
            return ;
        }
        Cookie cur = null;
        for (Cookie cookie : cookies) {
            if (cookie.getName().contains(COOKIE_NAME_TOKEN)) {
                cur =  cookie;
            }
        }
        if (cur != null){
            cur.setMaxAge(0);
            response.addCookie(cur);

            redisService.delete(CompanyKey.NullStr,cur.getName());
        }

        return ;
    }
}
