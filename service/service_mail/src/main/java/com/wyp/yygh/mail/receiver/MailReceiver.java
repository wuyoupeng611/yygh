package com.wyp.yygh.mail.receiver;

import com.wyp.common.rabbit.constant.MqConst;
import com.rabbitmq.client.Channel;
import com.wyp.yygh.mail.service.MailService;
import com.wyp.yygh.vo.mail.MailVo;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MailReceiver {

    @Autowired
    private MailService mailService;

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = MqConst.QUEUE_MAIL_ITEM, durable = "true"),
            exchange = @Exchange(value = MqConst.EXCHANGE_DIRECT_MAIL),
            key = {MqConst.ROUTING_MAIL_ITEM}
    ))
    public void send(MailVo mailVo, Message message, Channel channel) {
        mailService.send(mailVo);
    }
}
