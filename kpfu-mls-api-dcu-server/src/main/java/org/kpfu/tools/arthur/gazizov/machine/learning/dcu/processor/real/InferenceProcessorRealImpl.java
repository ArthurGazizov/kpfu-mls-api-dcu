package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.real;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.inference.InferenceDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.InferenceProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.inference.InferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 24/11/2017.
 */
@Service("inferenceProcessorRealImpl")
public class InferenceProcessorRealImpl implements InferenceProcessor {
  @Autowired
  private InferenceService inferenceService;

  @Override
  public ResponseEntity<InferenceDto> makeInference(Long dataSetId, MultipartFile multipartFile) {
    final InferenceDto inferenceDto = inferenceService.makeInference(dataSetId, multipartFile);
    return ResponseEntity.ok(inferenceDto);
  }
}
