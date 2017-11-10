package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.config;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.config.ConverterConfig;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.config.DaoConfig;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.util.ValidationReportChecker;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.util.ValidationReportCheckerImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.config.ValidationConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
@Configuration
@Import({
        DaoConfig.class
        , ConverterConfig.class
        , ValidationConfig.class
})
@ComponentScan(
        basePackages = {
                "org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor",
                "org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service"
        }
)
public class KpfuMlsDcuServerConfig {
  @Bean
  @ConfigurationProperties
  public KpfuMlsDcuServerConfigurationProperties kpfuMlsDcuConfigurationProperties() {
    return new KpfuMlsDcuServerConfigurationProperties();
  }

  @Bean
  public ValidationReportChecker validationReportChecker() {
    return new ValidationReportCheckerImpl();
  }
}
