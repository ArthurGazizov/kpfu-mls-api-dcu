package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.test.config;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.DataSetDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.DataSetDaoImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.DataSetElementDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.DataSetElementDaoImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.TagDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.TagDaoImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.impl.DataSetElementMapperImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.impl.DataSetMapperImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.impl.TagMapperImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.interfaces.DataSetElementMapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.interfaces.DataSetMapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.interfaces.TagMapper;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
@SpringBootApplication
@ComponentScan(excludeFilters = @ComponentScan.Filter(classes = Repository.class,
        type = FilterType.ANNOTATION))
public class BaseDalTestConfig {
  @Bean
  public DataSetMapper dataSetMapper() {
    return new DataSetMapperImpl();
  }

  @Bean
  public DataSetDao dataSetDao() {
    return new DataSetDaoImpl();
  }

  @Bean
  public DataSetElementMapper dataSetElementMapper() {
    return new DataSetElementMapperImpl();
  }

  @Bean
  public DataSetElementDao dataSetElementDao() {
    return new DataSetElementDaoImpl();
  }

  @Bean
  public TagMapper tagMapper() {
    return new TagMapperImpl();
  }

  @Bean
  public TagDao tagDao() {
    return new TagDaoImpl();
  }

  @Bean
  @Primary
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }
}
