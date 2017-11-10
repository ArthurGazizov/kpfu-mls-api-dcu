package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
  @Bean
  public Docket productApi() {
    return new Docket(DocumentationType.SWAGGER_2)
            .select().apis(RequestHandlerSelectors.basePackage("org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.api"))
            .paths(regex("/v1.*"))
            .build()
            .apiInfo(apiInfo());
  }

  private ApiInfo apiInfo() {
    ApiInfo apiInfo = new ApiInfo(
            "Spring Boot REST API",
            "Spring Boot REST API for KPFU MLS DCU",
            "1.0",
            "Terms of service",
            new Contact("Arthur Gazizov", "https://github.com/ArthurGazizov", "artynoobs@gmail.com"),
            "Apache License Version 2.0",
            "https://www.apache.org/licenses/LICENSE-2.0");
    return apiInfo;
  }
}
