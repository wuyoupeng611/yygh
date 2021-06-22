package com.wyp.yygh.msm.service;

import com.wyp.yygh.vo.msm.MsmVo;

public interface MsmService {

    //发送手机验证码
    boolean send(String phone, String code);

    //mq使用发送短信
//    boolean send(MsmVo msmVo);
}
