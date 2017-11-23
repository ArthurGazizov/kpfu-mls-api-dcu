package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.fs;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.config.KpfuMlsDcuServerConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 21.11.17.
 */
@Service
@Primary
public class FsServiceImpl implements FsService {
  @Autowired
  @Qualifier("fsServiceGatewayImpl")
  private FsService fsServiceGatewayImpl;

  @Autowired
  @Qualifier("fsServiceLocaleImpl")
  private FsService fsServiceLocaleImpl;

  @Autowired
  private KpfuMlsDcuServerConfigurationProperties configurationProperties;

  @Override
  public Long saveImage(MultipartFile file) {
    return choose().saveImage(file);
  }


  private FsService choose(){
    return configurationProperties.isEnableFsMicroservice()
            ? fsServiceGatewayImpl
            : fsServiceLocaleImpl;
  }
}
