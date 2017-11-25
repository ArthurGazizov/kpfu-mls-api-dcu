package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.test;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.client.DcuClient;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.client.DcuClientImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.config.KpfuMlsDcuServerConfigurationProperties;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.base.BaseDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.meta.MetaInfoDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.app.KpfuMlsApiDcuApp;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 25/11/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {
        KpfuMlsApiDcuApp.class,
        AbstractTest.TestClientConfig.class
})
@WebIntegrationTest
@TestExecutionListeners({
        SqlScriptsTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
})
public abstract class AbstractTest {
  protected DataSetDto generateDataSet() {
    return DataSetDto.Builder.aDataSetDto()
            .name(randomName())
            .build();
  }

  protected String randomName() {
    return UUID.randomUUID().toString();
  }

  protected void checkMetaInfoDtoForNotNull(MetaInfoDto dto) {
    Assert.assertNotNull(dto);
    final LocalDateTime createdTs = dto.getCreatedTs();
    Assert.assertNotNull(createdTs);
    final LocalDateTime updatedTs = dto.getUpdatedTs();
    Assert.assertNotNull(updatedTs);
  }

  protected void checkBaseDtoForNotNull(BaseDto baseDto) {
    Assert.assertNotNull(baseDto);
    checkMetaInfoDtoForNotNull(baseDto.getMetaInfoDto());
  }

  protected void checkBaseDtoPatchOrUpdateMetaInfo(BaseDto oldDto, BaseDto newDto) {
    checkBaseDtoForNotNull(newDto);
    final MetaInfoDto oldDtoMetaInfoDto = oldDto.getMetaInfoDto();
    final MetaInfoDto newDtoMetaInfoDto = newDto.getMetaInfoDto();
    Assert.assertEquals(oldDtoMetaInfoDto.getCreatedTs(), newDtoMetaInfoDto.getCreatedTs());
    Assert.assertNotEquals(oldDtoMetaInfoDto.getUpdatedTs(), newDtoMetaInfoDto.getUpdatedTs());
    Assert.assertTrue(oldDtoMetaInfoDto.getUpdatedTs().isBefore(newDtoMetaInfoDto.getUpdatedTs()));
  }

  @SpringBootApplication
  @ComponentScan(excludeFilters = @ComponentScan.Filter(
          classes = {Repository.class, Service.class},
          type = FilterType.ANNOTATION))
  public static class TestClientConfig {
    @Bean
    @ConfigurationProperties(prefix = "dcu")
    public KpfuMlsDcuServerConfigurationProperties kpfuMlsDcuServerConfigurationProperties() {
      return new KpfuMlsDcuServerConfigurationProperties();
    }

    private String serverUrl() {
      return "http://localhost:8080";
    }

    @Bean
    public DcuClient dcuClient() {
      return DcuClientImpl.Builder.aFsClientImpl()
              .serverUrl(serverUrl())
              .build();
    }
  }
}
