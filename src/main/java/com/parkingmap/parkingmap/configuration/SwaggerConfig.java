package com.parkingmap.parkingmap.configuration;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//@EnableSwagger2
public class SwaggerConfig {
/**
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis((Predicate<RequestHandler>) RequestHandlerSelectors.basePackage("com.parkingmap.parkingmap.configuration"))
                .build()
                .apiInfo(apiInfo());
    }


    private ApiInfo apiInfo() {
        String description = "Recupération des parkings à proximité";
        return new ApiInfoBuilder()
                .title("Parking Map")
                .description(description)
                .termsOfServiceUrl("github")
                .license("MIT License")
                .licenseUrl("")
                .version("1.0")
                .build();
    }*/
}
