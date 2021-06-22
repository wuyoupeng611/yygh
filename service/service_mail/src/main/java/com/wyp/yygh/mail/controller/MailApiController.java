package com.wyp.yygh.mail.controller;

import com.wyp.yygh.common.result.Result;
import com.wyp.yygh.mail.service.MailService;
import com.wyp.yygh.mail.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/mail")
public class MailApiController {
    @Autowired
    private MailService mailService;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    //发送邮箱验证码
    @GetMapping("send/{mail}")
    public Result sendCode(@PathVariable String mail) {
        //从redis获取验证码，如果获取获取到，返回ok
        // key 邮箱  value 验证码
        String code = redisTemplate.opsForValue().get(mail);
        if(!StringUtils.isEmpty(code)) {
            return Result.ok();
        }
        //如果从redis获取不到，
        // 生成验证码，
        code = RandomUtil.getSixBitRandom();
        //调用service方法，通过整合短信服务进行发送
        mailService.send(mail,code);
        //生成验证码放到redis里面，设置有效时间
        redisTemplate.opsForValue().set(mail,code,2, TimeUnit.MINUTES);
        return Result.ok();
    }
}
