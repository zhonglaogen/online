package com.zlx.resume.controller;

import com.zlx.resume.result.Result;
import com.zlx.resume.service.CompanyService;
import com.zlx.resume.service.UserService;
import com.zlx.resume.vo.LoginVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


/**
 * Created by jiangyunxiong on 2018/5/21.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;
    @Autowired
    CompanyService companyService;


    @RequestMapping("/to_login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/do_login")
    @ResponseBody
    public Result<String> doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {//加入JSR303参数校验
        log.info(loginVo.toString());
        String token = userService.login(response, loginVo);
        return Result.success(token);
    }

    @RequestMapping("/do_culogin")
    @ResponseBody
    public Result<String> docuLogin(HttpServletResponse response, @Valid LoginVo loginVo) {//加入JSR303参数校验
        log.info(loginVo.toString());
        String token = companyService.login(response, loginVo);
        return Result.success(token);
    }

}
