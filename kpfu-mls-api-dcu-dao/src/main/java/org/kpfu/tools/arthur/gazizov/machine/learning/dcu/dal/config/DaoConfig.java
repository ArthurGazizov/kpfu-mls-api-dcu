package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.config;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.DataSetDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.DataSetDaoImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.impl.DataSetMapperImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.interfaces.DataSetMapper;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
@Configuration
public class DaoConfig {
  @Bean
  public DataSetMapper dataSetMapper() {
    return new DataSetMapperImpl();
  }

  @Bean
  public DataSetDao dataSetDao() {
    return new DataSetDaoImpl();
  }

  @Bean
  @Primary
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }
}
