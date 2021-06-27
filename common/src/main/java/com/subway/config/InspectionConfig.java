package com.subway.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


@Configuration
@MapperScan("com.subway.mapper")
@ComponentScan(value = "com.subway")
public class InspectionConfig {
    /**
     * 注册逻辑删除插件
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }

    /**
     * 注册分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }


    @Bean

    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurerAdapter() {

            @Override

            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/**")

                        .allowCredentials(true)

                        .allowedMethods("GET");
            }

        };

    }

}
