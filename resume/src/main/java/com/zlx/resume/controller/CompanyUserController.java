package com.zlx.resume.controller;

import com.zlx.resume.entity.Company;
import com.zlx.resume.entity.Companyuser;
import com.zlx.resume.entity.User1;
import com.zlx.resume.result.CodeMsg;
import com.zlx.resume.result.Result;
import com.zlx.resume.service.CompanyService;
import com.zlx.resume.vo.FindVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyUserController {

    @Autowired
    CompanyService companyService;

    @RequestMapping("/cucook")
    public Companyuser get(Companyuser user){
        return user;
    }

    @RequestMapping("/find")
    public Result<User1> getUser(Companyuser user, FindVo findVo){
        if (user == null) {
            return Result.error(CodeMsg.SESSION_ERROR);
        }
        //将验证码信息以 userid：code的形式存入redis
        User1 user1 = companyService.getUser(user, findVo);
        return Result.success(user1);

    }



}
