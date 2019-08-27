package com.zlx.resume.controller;


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

    @GetMapping("/")
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/login")
    public String loginPage(){
        return "login";
    }

    @GetMapping("/culogin")
    public String culoginPage(){
        return "culogin";
    }




}
