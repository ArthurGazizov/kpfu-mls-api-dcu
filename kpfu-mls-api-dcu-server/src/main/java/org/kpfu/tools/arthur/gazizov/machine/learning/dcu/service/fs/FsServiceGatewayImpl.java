package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.fs;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.exception.KpfuMlsDcuError;
import org.kpfu.tools.arthur.gazizov.machine.learning.fs.client.FsClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 21.11.17.
 */
@Service("fsServiceGatewayImpl")
public class FsServiceGatewayImpl implements FsService {
  @Autowired
  private FsClient fsClient;

  @Override
  public Long saveImage(MultipartFile file) {
    try {
      final byte[] bytes = file.getBytes();
      return fsClient.uploadOriginImage(bytes);
    } catch (IOException e) {
      throw KpfuMlsDcuError.CLIENT_EXCEPTION.exception(e);
    }
  }
}
