package com.subway.config;

import com.subway.interceptor.FirstLoginInterceptor;
import com.subway.interceptor.FourthLoginInterceptor;
import com.subway.interceptor.SecondLoginInterceptor;
import com.subway.utils.SnowFlake;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.locks.ReentrantLock;

@Configuration
public class WebConfig implements WebMvcConfigurer {


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new FirstLoginInterceptor()).addPathPatterns("/center/**");
//        .excludePathPatterns(new String[]{"/center/webSocket", "/center/a","/center/b"})

    }
    @Bean
    public SnowFlake snowFlake(){
        return new SnowFlake(1,1);
    }

}
