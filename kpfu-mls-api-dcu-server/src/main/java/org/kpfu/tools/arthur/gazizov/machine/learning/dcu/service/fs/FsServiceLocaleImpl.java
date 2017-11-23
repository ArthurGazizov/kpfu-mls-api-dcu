package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.fs;

import org.apache.commons.io.FileUtils;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.config.KpfuMlsDcuServerConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 21.11.17.
 */
@Service("fsServiceLocaleImpl")
public class FsServiceLocaleImpl implements FsService {
  @Autowired
  private KpfuMlsDcuServerConfigurationProperties configurationProperties;

  @Override
  public Long saveImage(MultipartFile file) {
    byte[] bytes = null;
    try {
      bytes = file.getBytes();
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
    try {
      FileUtils.writeByteArrayToFile(new File(configurationProperties.getImageStorePath() + file.getOriginalFilename()), bytes);
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }

    // TODO: 23/11/2017 implement me
    return Math.abs(ThreadLocalRandom.current().nextInt()) + 1_000_000_000L;
  }
}
