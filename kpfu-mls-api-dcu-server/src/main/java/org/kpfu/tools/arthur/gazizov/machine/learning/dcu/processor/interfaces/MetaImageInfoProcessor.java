package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image.MetaImageInfoDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.base.CRUDProcessor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public interface MetaImageInfoProcessor extends CRUDProcessor<MetaImageInfoDto> {
  ResponseEntity<MetaImageInfoDto> upload(MultipartFile multipartFile, MetaImageInfoDto metaImageInfoDto);

  ResponseEntity<MetaImageInfoDto> findByImageId(Long imageId);
}
