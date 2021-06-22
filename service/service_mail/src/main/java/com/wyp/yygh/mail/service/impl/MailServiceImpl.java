package com.wyp.yygh.mail.service.impl;

import com.wyp.yygh.mail.service.MailService;
import com.wyp.yygh.mail.utils.ConstantMailPropertiesUtils;
import com.wyp.yygh.vo.mail.MailVo;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSenderImpl mailSender;

    @Override
    @Async
    public void send(String email, String code) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setSubject("验证码");
        simpleMailMessage.setText("您的验证码为：" + code + " ,请在 5 分钟之内使用！");
        simpleMailMessage.setTo(email);
        simpleMailMessage.setFrom(ConstantMailPropertiesUtils.USERNAME);

        mailSender.send(simpleMailMessage);
    }

    @Override
    public void send(MailVo mailVo) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setSubject((String) mailVo.getParam().get("subject"));
        simpleMailMessage.setText(mailVo.getTemplateCode());
        simpleMailMessage.setTo(mailVo.getEmail());
        simpleMailMessage.setFrom(ConstantMailPropertiesUtils.USERNAME);

        mailSender.send(simpleMailMessage);
    }
}
