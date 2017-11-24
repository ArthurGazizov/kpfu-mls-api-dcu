package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.config;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
public class KpfuMlsDcuServerConfigurationProperties {
  private String imageStorePath;

  private String mlsFsServerUrl;

  private boolean enableFsMicroservice;

  private boolean enableInference;

  private boolean enableInferenceMicroservice;

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

  public String getImageStorePath() {
    return imageStorePath;
  }

  public void setImageStorePath(String imageStorePath) {
    this.imageStorePath = imageStorePath;
  }

  public boolean isEnableInference() {
    return enableInference;
  }

  public void setEnableInference(boolean enableInference) {
    this.enableInference = enableInference;
  }

  public boolean isEnableInferenceMicroservice() {
    return enableInferenceMicroservice;
  }

  public void setEnableInferenceMicroservice(boolean enableInferenceMicroservice) {
    this.enableInferenceMicroservice = enableInferenceMicroservice;
  }
}
