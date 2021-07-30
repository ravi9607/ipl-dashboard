package com.example.ipldashboard.cogfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.ipldashboard"))
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "IPL Dashboard REST API",
                "Browse your favorite IPL teams and access their past games details, wins and losses ratios - accessible by team and tournament year..",
                "1.0",
                "Free to use",
                new Contact("Ravi Gupta", "https://ravi9607.github.io/", "ravi2018cs177abesit@gmail.com"),
                "API License",
                "https://ravi9607.github.io",
                Collections.emptyList());
    }

}
