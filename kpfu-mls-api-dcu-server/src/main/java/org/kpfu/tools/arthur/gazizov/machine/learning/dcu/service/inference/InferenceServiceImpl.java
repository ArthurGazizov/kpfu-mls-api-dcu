package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.inference;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.config.KpfuMlsDcuServerConfigurationProperties;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.inference.InferenceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 25/11/2017.
 */
@Service
@Primary
public class InferenceServiceImpl implements InferenceService {
  @Autowired
  private KpfuMlsDcuServerConfigurationProperties configurationProperties;

  @Autowired
  @Qualifier("inferenceServiceMockImpl")
  private InferenceService inferenceServiceMock;

  @Autowired
  @Qualifier("inferenceServiceLocaleImpl")
  private InferenceService inferenceServiceLocale;

  @Autowired
  @Qualifier("inferenceServiceGatewayImpl")
  private InferenceService inferenceServiceGateway;

  @Override
  public InferenceDto makeInference(Long dataSetId, MultipartFile multipartFile) {
    return choose().makeInference(dataSetId, multipartFile);
  }

  private InferenceService choose() {
    return configurationProperties.isEnableInference() ?
            configurationProperties.isEnableInferenceMicroservice()
                    ? inferenceServiceGateway
                    : inferenceServiceLocale
            : inferenceServiceMock;
  }
}
