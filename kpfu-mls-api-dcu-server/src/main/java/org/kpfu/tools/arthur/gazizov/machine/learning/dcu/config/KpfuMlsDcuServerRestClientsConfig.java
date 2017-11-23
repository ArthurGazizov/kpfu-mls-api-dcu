package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.config;

import org.kpfu.tools.arthur.gazizov.machine.learning.fs.client.FsClient;
import org.kpfu.tools.arthur.gazizov.machine.learning.fs.client.FsClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 21.11.17.
 */
@Configuration
public class KpfuMlsDcuServerRestClientsConfig {
  @Autowired
  private KpfuMlsDcuServerConfigurationProperties properties;

  @Bean
  public FsClient fsClient(){
    return FsClientImpl.Builder.aFsClientImpl()
            .serverUrl(properties.getMlsFsServerUrl())
            .build();
  }
}
