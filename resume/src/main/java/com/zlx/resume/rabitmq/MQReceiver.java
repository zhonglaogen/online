package com.zlx.resume.rabitmq;

import com.zlx.resume.mail.MyMailService;
import com.zlx.resume.redis.CompanyKey;
import com.zlx.resume.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQReceiver {
    @Autowired
    MyMailService myMailService;
    @Autowired
    RedisService redisService;

    private static Logger log = LoggerFactory.getLogger(MQReceiver.class);

    @RabbitListener(queues = MQConfig.MESSAGE_QUEUE)
    public void receive(String message) {
        MailAddress mailAddress = RedisService.stringToBean(message, MailAddress.class);
        log.info("receive message:" + message);
        String code = myMailService.sendCode(mailAddress);
        //将验证码存在redis中，
        redisService.set(CompanyKey.getCode, "" + mailAddress.getCuId(), code);
    }
}
