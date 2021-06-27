package com.subway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableTransactionManagement
@EnableAsync
public class InspectionApp {
    public static void main(String[] args) {
        SpringApplication.run(InspectionApp.class,args);
    }
}
