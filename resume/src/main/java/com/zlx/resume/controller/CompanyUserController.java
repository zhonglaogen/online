package com.zlx.resume.controller;

import com.zlx.resume.dto.CuCheckState;
import com.zlx.resume.dto.Expirence;
import com.zlx.resume.entity.Companyuser;
import com.zlx.resume.entity.User1;
import com.zlx.resume.result.CodeMsg;
import com.zlx.resume.result.Result;
import com.zlx.resume.service.AddExpirenceService;
import com.zlx.resume.service.CompanyService;
import com.zlx.resume.service.FindUserService;
import com.zlx.resume.vo.FindVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/find")
public class CompanyUserController {

    //登录
    @Autowired
    CompanyService companyService;
    //验证
    @Autowired
    FindUserService findUserService;
    //添加经历
    @Autowired
    AddExpirenceService addExpirenceService;

    /**
     * @param user
     * @param findVo
     * @return
     * @Valid 发送验证码
     */
    @RequestMapping("/sendcode")
    public Result<Object> sendCode(Companyuser user, FindVo findVo) {
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        findUserService.sendCode(user, findVo);
        return Result.success("验证码发送成功");
    }


    /**
     * 检验验证码，检验成功生成token，和redis的key（token）和v（stat）
     * 验证通过生成查询token
     *
     * @param user
     * @param findVo
     * @return
     */
    @RequestMapping("/checkcode")
    public Result<String> checkCode(HttpServletResponse response, Companyuser user, FindVo findVo) {
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        //将验证码信息以 userid：code的形式存入redis
        findUserService.checkCode(response, user, findVo);
        return Result.success("验证通过");

    }

    /**
     * 拿到简历信息
     *
     * @param user
     * @param state
     * @return
     */
    @RequestMapping("/getuser")
    public Result<User1> getUser(Companyuser user, CuCheckState state) {
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        if (state == null) {
            //未验证的用户
            return Result.error(CodeMsg.USER_NOT_CHECK);
        }
        User1 user1 = findUserService.getUser(user, state);
        return Result.success(user1);
    }

    /**
     * 添加工作经历
     *
     * @param user
     * @param state
     * @param experienceUser1
     * @return
     */

    @RequestMapping("/addexpir")
    public Result<String> addExpir(Companyuser user, CuCheckState state, Expirence expirence) {
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        if (state == null) {
            //未验证的用户
            return Result.error(CodeMsg.USER_NOT_CHECK);
        }
        addExpirenceService.addExpir(user, state, expirence);
        return Result.success("添加成功");


    }

    /**
     * 查询工作经历
     * @param user
     * @param state
     * @return
     */

    @RequestMapping("/findexpri")
    public Result<List<Expirence>> findExpir(Companyuser user, CuCheckState state){
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        if (state == null) {
            //未验证的用户
            return Result.error(CodeMsg.USER_NOT_CHECK);
        }
        List<Expirence> expir = addExpirenceService.findExpir( user, state);
        return Result.success(expir);
    }

}
