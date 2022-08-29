package com.thales.employee.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@Slf4j
@EnableSwagger2
@EnableWebMvc
@PropertySource("classpath:application.properties")
public class SwaggerConfig {

    @Value("${swaggerHostname}")
    String swaggerHostName;

    @Bean
    public Docket api(){
        log.info("Hostname : {}",swaggerHostName);
        return new Docket(DocumentationType.SWAGGER_2)
                .host(swaggerHostName)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaData());
    }

    private ApiInfo metaData(){

        return new ApiInfoBuilder()
                .title("API  for employees")
                .description("API to retrieve employees info")
                .build();

    }

}
