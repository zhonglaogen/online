package com.zlx.resume.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.internet.MimeMessage;
import java.io.File;

public class MyMail {



    @Autowired
    JavaMailSenderImpl javaMailSender;

    public void contextLoads() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //标题
        simpleMailMessage.setSubject("开会");
        simpleMailMessage.setText("9.30开会ssss");
        simpleMailMessage.setTo("ZLXzlxxs98@163.com");
        simpleMailMessage.setFrom("603943860@qq.com");
        javaMailSender.send(simpleMailMessage);

    }

    public void test2()throws Exception{
        //复杂消息邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        //邮件设置
        //标题
        mimeMessageHelper.setSubject("开会");
        //可以写html标签,第二个参数设置是否为html
        mimeMessageHelper.setText("<h1>9.30开会ssss</h1><hr>",false);
        mimeMessageHelper.setTo("ZLXzlxxs98@163.com");
        mimeMessageHelper.setFrom("603943860@qq.com");
        //传文件
        mimeMessageHelper.addAttachment("1.pg",new File("/home/zhonglianxi/图片/timg.jpeg"));
        javaMailSender.send(mimeMessage);

    }
}
