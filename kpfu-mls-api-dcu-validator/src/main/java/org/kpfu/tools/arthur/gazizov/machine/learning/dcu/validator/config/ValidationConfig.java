package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.config;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.impl.DataSetDtoValidatorImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.impl.DataSetElementDtoValidatorImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.interfaces.DataSetDtoValidator;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.interfaces.DataSetElementDtoValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
@Configuration
public class ValidationConfig {
  @Bean
  public DataSetDtoValidator dataSetDtoValidator() {
    return new DataSetDtoValidatorImpl();
  }

  @Bean
  public DataSetElementDtoValidator dataSetElementDtoValidator() {
    return new DataSetElementDtoValidatorImpl();
  }
}
