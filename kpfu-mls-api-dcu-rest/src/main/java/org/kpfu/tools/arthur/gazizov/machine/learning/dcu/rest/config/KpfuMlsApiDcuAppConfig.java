package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.config.KpfuMlsDcuServerConfig;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.web.utils.DcuControllerAdvice;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.web.utils.DcuControllerAdviceImpl;
import org.springframework.boot.context.embedded.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import javax.servlet.MultipartConfigElement;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
@Configuration
@ComponentScan("org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest")
@Import({
        KpfuMlsDcuServerConfig.class})
public class KpfuMlsApiDcuAppConfig {
  @Bean
  public DcuControllerAdvice dcuControllerAdvice() {
    return new DcuControllerAdviceImpl();
  }

  @Bean
  public MultipartConfigElement multipartConfigElement() {
    MultipartConfigFactory multipartConfigFactory = new MultipartConfigFactory();
    multipartConfigFactory.setMaxFileSize("10MB");
    multipartConfigFactory.setMaxRequestSize("50MB");
    return multipartConfigFactory.createMultipartConfig();
  }

  @Bean
  public ObjectMapper jsonObjectMapper() {
    return Jackson2ObjectMapperBuilder.json()
            .serializationInclusion(JsonInclude.Include.NON_NULL) // Don’t include null values
            .featuresToDisable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS) //ISODate
            .modules(new JavaTimeModule())
            .build();
  }
}
