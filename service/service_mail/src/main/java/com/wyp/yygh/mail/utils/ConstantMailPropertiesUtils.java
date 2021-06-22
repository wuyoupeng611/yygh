package com.wyp.yygh.mail.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ConstantMailPropertiesUtils implements InitializingBean {

    @Value("${spring.mail.username}")
    private String username;

    @Value("${spring.mail.password}")
    private String password;

    @Value("${spring.mail.host}")
    private String host;

    public static String USERNAME;
    public static String PASSWORD;
    public static String HOST;

    @Override
    public void afterPropertiesSet() throws Exception {
        USERNAME=username;
        PASSWORD=password;
        HOST=host;
    }
}
