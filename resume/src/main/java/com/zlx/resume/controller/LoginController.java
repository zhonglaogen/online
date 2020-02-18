package com.zlx.resume.controller;

import com.zlx.resume.entity.Companyuser;
import com.zlx.resume.result.Result;
import com.zlx.resume.service.CompanyService;
import com.zlx.resume.service.UserService;
import com.zlx.resume.vo.LoginVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;


@Api(description = "用于登录操作")
@Controller
@RequestMapping("/login")
public class LoginController {

    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    UserService userService;
    @Autowired
    CompanyService companyService;


    @GetMapping("/to_login")
    public String toLogin() {
        return "l2";
    }

    /**
     * 用户登录
     * @param response
     * @param loginVo
     * @return
     */

    @ApiOperation(value = "用于普通用户登录的接口")
    @PostMapping("/do_login")
    @ResponseBody
    public Result<String> doLogin(HttpServletResponse response, @Valid LoginVo loginVo) {//加入JSR303参数校验
        log.info(loginVo.toString());
        String token = userService.login(response, loginVo);
        return Result.success("登录成功");
    }

    /**
     * 企业用户登录
     * @param response
     * @param loginVo
     * @return
     */
    @ApiOperation(value = "用于企业用户登录的接口")
    @PostMapping("/do_culogin")
    @ResponseBody
    public Result<String> docuLogin(HttpServletResponse response, @Valid LoginVo loginVo, Companyuser companyuser) {//加入JSR303参数校验
        log.info(loginVo.toString());
        if (companyuser==null){
            String token = companyService.login(response, loginVo);
        }
        return Result.success("登录成功");
    }

    @GetMapping("/do_culogout")
    @ResponseBody
    public Result<String> docuLoginOut(HttpServletRequest request, HttpServletResponse response, Companyuser companyuser) {//加入JSR303参数校验
        if (companyuser != null){
            companyService.loginOut(request,response, companyuser);
            return Result.success("退出成功");
        }
        return Result.success("退出成功");
    }

}
