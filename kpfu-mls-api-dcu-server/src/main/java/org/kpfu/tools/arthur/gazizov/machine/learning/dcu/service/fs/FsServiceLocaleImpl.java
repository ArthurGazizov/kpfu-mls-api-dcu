package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.fs;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 21.11.17.
 */
@Service("fsServiceLocaleImpl")
public class FsServiceLocaleImpl implements FsService {
  @Override
  public Long saveImage(MultipartFile file) {
    return null;
  }
}
