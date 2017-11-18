package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.proxy;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image.MetaImageInfoDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.support.PageResponse;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.MetaImageInfoProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.util.ValidationReportChecker;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.interfaces.MetaImageInfoDtoValidator;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.ValidationReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Service("metaImageInfoProcessorProxyImpl")
public class MetaImageInfoProcessorProxyImpl implements MetaImageInfoProcessor {
  @Autowired
  @Qualifier("metaImageInfoProcessorRealImpl")
  private MetaImageInfoProcessor metaImageInfoProcessor;

  @Autowired
  private MetaImageInfoDtoValidator metaImageInfoDtoValidator;

  @Autowired
  private ValidationReportChecker validationReportChecker;

  @Override
  public ResponseEntity<MetaImageInfoDto> upload(MultipartFile multipartFile, MetaImageInfoDto metaImageInfoDto) {
    return metaImageInfoProcessor.upload(multipartFile, metaImageInfoDto);
  }

  @Override
  public ResponseEntity<MetaImageInfoDto> findByImageId(Long imageId) {
    Objects.requireNonNull(imageId);
    return metaImageInfoProcessor.findByImageId(imageId);
  }

  @Override
  public ResponseEntity<MetaImageInfoDto> get(Long id) {
    Objects.requireNonNull(id);
    return metaImageInfoProcessor.get(id);
  }

  @Override
  public ResponseEntity<MetaImageInfoDto> save(MetaImageInfoDto metaImageInfoDto) {
    final ValidationReport validationReport = metaImageInfoDtoValidator.validateToSave(metaImageInfoDto);
    validationReportChecker.check(validationReport);
    return metaImageInfoProcessor.save(metaImageInfoDto);
  }

  @Override
  public ResponseEntity<MetaImageInfoDto> update(MetaImageInfoDto metaImageInfoDto) {
    final ValidationReport validationReport = metaImageInfoDtoValidator.validateToUpdate(metaImageInfoDto);
    validationReportChecker.check(validationReport);
    return metaImageInfoProcessor.update(metaImageInfoDto);
  }

  @Override
  public ResponseEntity<MetaImageInfoDto> patch(MetaImageInfoDto metaImageInfoDto) {
    final ValidationReport validationReport = metaImageInfoDtoValidator.validateToPatch(metaImageInfoDto);
    validationReportChecker.check(validationReport);
    return metaImageInfoProcessor.patch(metaImageInfoDto);
  }

  @Override
  public ResponseEntity<Void> delete(Long id) {
    Objects.requireNonNull(id);
    return metaImageInfoProcessor.delete(id);
  }

  @Override
  public ResponseEntity<MetaImageInfoDto> restore(Long id) {
    Objects.requireNonNull(id);
    return metaImageInfoProcessor.restore(id);
  }

  @Override
  public ResponseEntity<List<MetaImageInfoDto>> findAll() {
    return metaImageInfoProcessor.findAll();
  }

  @Override
  public ResponseEntity<PageResponse<MetaImageInfoDto>> findAll(Integer limit, Integer offset) {
    return metaImageInfoProcessor.findAll(limit, offset);
  }
}
