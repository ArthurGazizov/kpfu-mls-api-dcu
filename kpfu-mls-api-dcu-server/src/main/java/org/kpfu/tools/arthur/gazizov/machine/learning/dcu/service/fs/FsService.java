package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.fs;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 21.11.17.
 */
public interface FsService {
  Long saveImage(MultipartFile file);
}
