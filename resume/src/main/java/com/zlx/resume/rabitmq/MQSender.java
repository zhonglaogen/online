package com.zlx.resume.rabitmq;


import com.zlx.resume.entity.Companyuser;
import com.zlx.resume.entity.User1;
import com.zlx.resume.redis.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MQSender {
    @Autowired
    AmqpTemplate amqpTemplate;


    private static Logger log = LoggerFactory.getLogger(MQSender.class);

    public void sendMessage(MailAddress message) {
        String msg = RedisService.beanToString(message);
        log.info("send message:" + msg);
        amqpTemplate.convertAndSend(MQConfig.MESSAGE_QUEUE, msg);

    }

    public void sendMessage(Companyuser user, User1 user1) {
        String msg = RedisService.beanToString(
                new MailAddress(user.getCuEamil(),
                        user1.getuEmail(),
                        user.getCuId()));
        log.info("send message" + msg);
        amqpTemplate.convertAndSend(MQConfig.MESSAGE_QUEUE, msg);

    }
}
