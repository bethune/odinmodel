
package com.vladolium.odinmodel.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import static springfox.documentation.builders.PathSelectors.regex;
import java.util.Collections;

@Configuration
@EnableSwagger2
public class Swagger2Config {
//Start of user code for swagger
	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.vladolium.odinmodel.controller"))
                .paths(regex("/api.*"))
                .build()
                .apiInfo(apiInfo());
    }
	
	private ApiInfo apiInfo() {
        ApiInfo apiInfo = new ApiInfo(
        		"The name of REST API", 
        	    "Some custom description of API.", 
        	    "version", 
        	    "Terms of service URL", 
        	    new Contact("Person/Company name", "www.company.com", "email_address@company.com"), 
        	    "License of API", "API license URL", Collections.emptyList());
        return apiInfo;
    }
//End of user code
}

