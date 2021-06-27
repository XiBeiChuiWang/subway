package com.subway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
@EnableDiscoveryClient
public class LoginApp {

    public static void main(String[] args) {
        SpringApplication.run(LoginApp.class,args);
    }

}
