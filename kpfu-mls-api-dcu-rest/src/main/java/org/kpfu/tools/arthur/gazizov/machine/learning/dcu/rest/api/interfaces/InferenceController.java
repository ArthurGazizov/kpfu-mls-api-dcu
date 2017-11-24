package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.api.interfaces;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.inference.InferenceDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 24/11/2017.
 */
public interface InferenceController {
  ResponseEntity<InferenceDto> makeInference(Long dataSetId, MultipartFile multipartFile);
}
