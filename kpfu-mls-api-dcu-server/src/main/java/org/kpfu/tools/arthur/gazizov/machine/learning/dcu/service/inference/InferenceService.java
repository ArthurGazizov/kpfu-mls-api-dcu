package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.inference;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.inference.InferenceDto;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 25/11/2017.
 */
public interface InferenceService {
  InferenceDto makeInference(Long dataSetId, MultipartFile multipartFile);
}
