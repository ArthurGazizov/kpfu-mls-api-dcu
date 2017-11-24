package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.inference;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.inference.InferenceDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.engine.inference.rest.client.EngineInferenceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 25/11/2017.
 */
@Service("inferenceServiceGatewayImpl")
public class InferenceServiceGatewayImpl implements InferenceService {
  @Autowired
  private EngineInferenceClient engineInferenceClient;

  @Override
  public InferenceDto makeInference(Long dataSetId, MultipartFile multipartFile) {
    byte[] bytes = null;
    try {
      // TODO: 25/11/2017 check that bytes[] == all bytes in file
      bytes = multipartFile.getBytes();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return engineInferenceClient.makeInference(dataSetId, bytes);
  }
}
