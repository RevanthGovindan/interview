package com.example.msf.demo.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select().apis(RequestHandlerSelectors.basePackage("com.example.msf.demo.controller"))
                .paths(regex("/.*"))
                .build()
                .apiInfo(metaData());
        
    }
	private ApiInfo metaData() {
       ApiInfo apiInfo = new ApiInfo("Spring Boot REST API",
    		   "Spring Boot REST API for Online Store", "1.0", "Terms of service", 
    		   "revanth", "Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0"
    		   	);
       return apiInfo;
    }
}