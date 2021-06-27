package com.subway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableDiscoveryClient  //nacos注册
@EnableFeignClients
public class CenterApp {
    public static void main(String[] args) {
        SpringApplication.run(CenterApp.class,args);
    }
}
