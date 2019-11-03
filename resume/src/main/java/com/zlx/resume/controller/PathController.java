package com.zlx.resume.controller;


import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class PathController {
    private final String PREFIX="pages/";
    @GetMapping("/leve1/{path}")
    public String leve1(@PathVariable("path") String path){
        return PREFIX+"leve1/"+path;

    }
    @GetMapping("/leve2/{path}")
    public String leve2(@PathVariable("path") String path){
        return PREFIX+"leve2/"+path;

    }
    @GetMapping("/leve3/{path}")
    public String leve3(@PathVariable("path") String path){
        return PREFIX+"leve3/"+path;

    }

    @ApiOperation(value = "欢迎首页")
    @GetMapping("/")
    public String welcome(){
        return "welcome";
    }

    @ApiOperation(value = "普通用户登录界面")
    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @ApiOperation(value = "企业用户登录界面")
    @GetMapping("/culogin")
    public String culoginPage(){
        return "culogin";
    }




}
