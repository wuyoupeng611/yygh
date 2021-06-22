package com.wyp.yygh.mail.service;

import com.wyp.yygh.vo.mail.MailVo;

public interface MailService {
    void send(String mail, String code);

    void send(MailVo mailVo);
}
