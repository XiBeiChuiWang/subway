package com.subway.login;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class WeiXinUtil implements InitializingBean {

    public static String APPID;
    public static String SECRET;

    @Value("${appid}")
    private String appid;

    @Value("${secret}")
    private String secret;

    @Override
    public void afterPropertiesSet() throws Exception {
        APPID = appid;
        SECRET = secret;
    }
}
