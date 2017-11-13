package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetElementDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.DataSetElementProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.util.ValidationReportChecker;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.interfaces.DataSetElementDtoValidator;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.ValidationReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 12.11.17.
 */
@Service("dataSetElementProcessorProxyImpl")
public class DataSetElementProcessorProxyImpl implements DataSetElementProcessor {
  @Autowired
  private DataSetElementDtoValidator dataSetElementDtoValidator;

  @Autowired
  private ValidationReportChecker validationReportChecker;

  @Autowired
  @Qualifier("dataSetElementProcessorRealImpl")
  private DataSetElementProcessor dataSetElementProcessor;

  @Override
  public ResponseEntity<DataSetElementDto> get(Long id) {
    Objects.requireNonNull(id);
    return dataSetElementProcessor.get(id);
  }

  @Override
  public ResponseEntity<DataSetElementDto> save(DataSetElementDto dataSetElementDto) {
    final ValidationReport validationReport = dataSetElementDtoValidator.validateToSave(dataSetElementDto);
    validationReportChecker.check(validationReport);
    return dataSetElementProcessor.save(dataSetElementDto);
  }

  @Override
  public ResponseEntity<DataSetElementDto> update(DataSetElementDto dataSetElementDto) {
    final ValidationReport validationReport = dataSetElementDtoValidator.validateToUpdate(dataSetElementDto);
    validationReportChecker.check(validationReport);
    return dataSetElementProcessor.update(dataSetElementDto);
  }

  @Override
  public ResponseEntity<DataSetElementDto> patch(DataSetElementDto dataSetElementDto) {
    final ValidationReport validationReport = dataSetElementDtoValidator.validateToPatch(dataSetElementDto);
    validationReportChecker.check(validationReport);
    return dataSetElementProcessor.patch(dataSetElementDto);
  }

  @Override
  public ResponseEntity<Void> delete(Long id) {
    Objects.requireNonNull(id);
    return dataSetElementProcessor.delete(id);
  }

  @Override
  public ResponseEntity<DataSetElementDto> restore(Long id) {
    Objects.requireNonNull(id);
    return dataSetElementProcessor.restore(id);
  }

  @Override
  public ResponseEntity<List<DataSetElementDto>> findAll() {
    return dataSetElementProcessor.findAll();
  }
}
