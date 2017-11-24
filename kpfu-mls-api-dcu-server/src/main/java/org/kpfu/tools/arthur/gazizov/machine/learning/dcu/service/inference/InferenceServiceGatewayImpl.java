package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.inference;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.inference.InferenceDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 25/11/2017.
 */
@Service("inferenceServiceGatewayImpl")
public class InferenceServiceGatewayImpl implements InferenceService {
  @Override
  public InferenceDto makeInference(Long dataSetId, MultipartFile multipartFile) {
    // TODO: 25/11/2017 use kpfu-mls-inference-client
    return null;
  }
}
