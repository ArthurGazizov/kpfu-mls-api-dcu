package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.app;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.config.KpfuMlsApiDcuAppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
@SpringBootApplication
@Import(KpfuMlsApiDcuAppConfig.class)
public class KpfuMlsApiDcuApp {
  public static void main(String[] args) {
    SpringApplication.run(KpfuMlsApiDcuApp.class, args);
  }
}
