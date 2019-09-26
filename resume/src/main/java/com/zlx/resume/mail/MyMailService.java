package com.zlx.resume.mail;

import com.zlx.resume.entity.Companyuser;
import com.zlx.resume.entity.User1;
import com.zlx.resume.vo.FindVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Random;
@Service
public class MyMailService {





    @Autowired
    JavaMailSenderImpl javaMailSender;



    /**
     * 产生四位随机数
     *
     * @return
     */
    public  static String createCode() {
        Random random = new Random();
        String fourRandom = random.nextInt(10000) + "";
        int randLength = fourRandom.length();
        if (randLength < 4) {
            for (int i = 1; i <= 4 - randLength; i++){
                fourRandom = "0" + fourRandom;
            }

        }
        return fourRandom;
    }


    public String sendCode(Companyuser user, User1 user1){
        String code = createCode();
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setSubject("查询简历验证码");
        simpleMailMessage.setText("您的简历将会被查看，验证码为"+code);
        simpleMailMessage.setTo(user1.getuEmail());
        simpleMailMessage.setFrom(user.getCuEamil());
        javaMailSender.send(simpleMailMessage);
        return code;
    }

    /**
     * 测试方法
     */

    public void contextLoads() {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        //标题
        simpleMailMessage.setSubject("开会");
        simpleMailMessage.setText("9.30开会ssss");
        simpleMailMessage.setTo("ZLXzlxxs98@163.com");
        simpleMailMessage.setFrom("603943860@qq.com");
        javaMailSender.send(simpleMailMessage);

    }

    /**
     * 测试方法
     */

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
