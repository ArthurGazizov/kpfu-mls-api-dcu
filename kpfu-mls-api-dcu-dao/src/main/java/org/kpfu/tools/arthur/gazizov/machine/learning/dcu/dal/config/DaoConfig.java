package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.config;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.DataSetDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.DataSetDaoImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.DataSetElementDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.DataSetElementDaoImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.MetaImageInfoDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.MetaImageInfoDaoImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.TagDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.TagDaoImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.impl.DataSetElementMapperImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.impl.DataSetMapperImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.impl.MetaImageInfoMapperImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.impl.TagMapperImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.interfaces.DataSetElementMapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.interfaces.DataSetMapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.interfaces.MetaImageInfoMapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.interfaces.TagMapper;
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
  public MetaImageInfoMapper metaImageInfoMapper() {
    return new MetaImageInfoMapperImpl();
  }

  @Bean
  public MetaImageInfoDao metaImageInfoDao() {
    return new MetaImageInfoDaoImpl();
  }

  @Bean
  @Primary
  @ConfigurationProperties(prefix = "spring.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }
}
