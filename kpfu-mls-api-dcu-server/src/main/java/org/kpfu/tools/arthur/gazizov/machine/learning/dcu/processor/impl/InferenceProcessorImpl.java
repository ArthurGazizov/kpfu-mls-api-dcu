package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.impl;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.inference.InferenceDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.InferenceProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 25/11/2017.
 */
@Service
@Primary
public class InferenceProcessorImpl implements InferenceProcessor {
  @Autowired
  @Qualifier("inferenceProcessorProxyImpl")
  private InferenceProcessor inferenceProcessor;

  @Override
  public ResponseEntity<InferenceDto> makeInference(Long dataSetId, MultipartFile multipartFile) {
    return inferenceProcessor.makeInference(dataSetId, multipartFile);
  }
}
