package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.inference;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.inference.InferenceDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.inference.TagValueDto;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collections;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 25/11/2017.
 */
@Service("inferenceServiceMockImpl")
public class InferenceServiceMockImpl implements InferenceService {
  @Override
  public InferenceDto makeInference(Long dataSetId, MultipartFile multipartFile) {
    return InferenceDto.Builder.anInferenceDto()
            .tagValues(Collections.singletonList(
                    TagValueDto.Builder.aTagValueDto()
                            .tagId(0L)
                            .probability(0.0)
                            .build()
            ))
            .build();
  }
}
