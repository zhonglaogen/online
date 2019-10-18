package com.zlx.resume.controller;

import com.zlx.resume.entity.Admin;
import com.zlx.resume.mapper.AdminMapper;
import com.zlx.resume.rabitmq.MQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class TestSession {
    @Autowired
    AdminMapper adminMapper;
    @Autowired
    MQSender mqSender;

    @GetMapping(value = "session")
    public String test(HttpSession session){
       session.setAttribute("aa","aaa");

        Object aa = session.getAttribute("aa");
        return aa.toString();
    }

    @GetMapping(value = "admin")
    public String getAdmin(){
        Admin admin = this.adminMapper.selectByPrimaryKey(1);
        return admin.toString();

    }



}
