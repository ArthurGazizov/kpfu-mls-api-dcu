package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.config;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
public class KpfuMlsDcuServerConfigurationProperties {
  private String mlsFsServerUrl;

  private boolean enableFsMicroservice;

  public String getMlsFsServerUrl() {
    return mlsFsServerUrl;
  }

  public void setMlsFsServerUrl(String mlsFsServerUrl) {
    this.mlsFsServerUrl = mlsFsServerUrl;
  }

  public boolean isEnableFsMicroservice() {
    return enableFsMicroservice;
  }

  public void setEnableFsMicroservice(boolean enableFsMicroservice) {
    this.enableFsMicroservice = enableFsMicroservice;
  }
}
