package com.subway.utils;


import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Oss_Util implements InitializingBean {
    public static String END_POIND;
    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String BUCKET_NAME;
    public static String ROLE_ARN;

    @Value("${END_POIND}")
    private String end_point;

    @Value("${ACCESS_KEY_ID}")
    private String access_key_id;

    @Value("${ACCESS_KEY_SECRET}")
    private String access_key_secret;

    @Value("${BUCKET_NAME}")
    private String bucketName;

    @Value("${ROLE_ARN}")
    private String role_Arn;

    @Override
    public void afterPropertiesSet() throws Exception {
        END_POIND = end_point;
        ACCESS_KEY_ID = access_key_id;
        ACCESS_KEY_SECRET = access_key_secret;
        BUCKET_NAME = bucketName;
        ROLE_ARN = role_Arn;
    }

}
