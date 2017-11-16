package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.proxy;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.TagDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.support.PageResponse;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.TagProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.util.ValidationReportChecker;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.interfaces.TagDtoValidator;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.ValidationReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Service("tagProcessorProxyImpl")
public class TagProcessorProxyImpl implements TagProcessor {
  @Autowired
  private TagDtoValidator tagDtoValidator;

  @Autowired
  private ValidationReportChecker validationReportChecker;

  @Autowired
  @Qualifier("tagProcessorRealImpl")
  private TagProcessor tagProcessor;

  @Override
  public ResponseEntity<TagDto> get(Long id) {
    Objects.requireNonNull(id);
    return tagProcessor.get(id);
  }

  @Override
  public ResponseEntity<TagDto> save(TagDto tagDto) {
    final ValidationReport validationReport = tagDtoValidator.validateToSave(tagDto);
    validationReportChecker.check(validationReport);
    return tagProcessor.save(tagDto);
  }

  @Override
  public ResponseEntity<TagDto> update(TagDto tagDto) {
    final ValidationReport validationReport = tagDtoValidator.validateToUpdate(tagDto);
    validationReportChecker.check(validationReport);
    return tagProcessor.update(tagDto);
  }

  @Override
  public ResponseEntity<TagDto> patch(TagDto tagDto) {
    final ValidationReport validationReport = tagDtoValidator.validateToPatch(tagDto);
    validationReportChecker.check(validationReport);
    return tagProcessor.patch(tagDto);
  }

  @Override
  public ResponseEntity<Void> delete(Long id) {
    Objects.requireNonNull(id);
    return tagProcessor.delete(id);
  }

  @Override
  public ResponseEntity<TagDto> restore(Long id) {
    Objects.requireNonNull(id);
    return tagProcessor.restore(id);
  }

  @Override
  public ResponseEntity<List<TagDto>> findAll() {
    return tagProcessor.findAll();
  }

  @Override
  public ResponseEntity<PageResponse<TagDto>> findAll(Integer limit, Integer offset) {
    Objects.requireNonNull(limit);
    return tagProcessor.findAll(limit, offset);
  }
}
