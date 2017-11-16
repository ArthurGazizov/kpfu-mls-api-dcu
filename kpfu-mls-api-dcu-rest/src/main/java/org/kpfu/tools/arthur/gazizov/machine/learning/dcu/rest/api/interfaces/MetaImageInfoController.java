package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.api.interfaces;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image.MetaImageInfoDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.api.base.CRUDController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public interface MetaImageInfoController extends CRUDController<MetaImageInfoDto> {
  ResponseEntity<MetaImageInfoDto> upload(MultipartFile multipartFile, MetaImageInfoDto metaImageInfoDto);
}
