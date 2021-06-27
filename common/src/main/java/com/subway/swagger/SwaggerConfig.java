package com.subway.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.service.ApiInfo.DEFAULT_CONTACT;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket docket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .groupName("swagger");
    }

    private ApiInfo apiInfo(){
        Contact contact = new Contact("zx","https://star.rainbowsea.top/","2860698744@qq.com");
        return new ApiInfo("swagger",
                "再小的帆也能远航",
                "1.0",
                "https://star.rainbowsea.top/",
                DEFAULT_CONTACT,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }
}
