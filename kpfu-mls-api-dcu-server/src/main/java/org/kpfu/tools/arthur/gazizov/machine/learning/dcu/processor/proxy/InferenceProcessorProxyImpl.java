package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.proxy;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.inference.InferenceDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.InferenceProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Objects;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 24/11/2017.
 */
@Service("inferenceProcessorProxyImpl")
public class InferenceProcessorProxyImpl implements InferenceProcessor {
  @Autowired
  @Qualifier("inferenceProcessorRealImpl")
  private InferenceProcessor inferenceProcessor;

  @Override
  public ResponseEntity<InferenceDto> makeInference(Long dataSetId, MultipartFile multipartFile) {
    Objects.requireNonNull(dataSetId);
    Objects.requireNonNull(multipartFile);
    return inferenceProcessor.makeInference(dataSetId, multipartFile);
  }
}
