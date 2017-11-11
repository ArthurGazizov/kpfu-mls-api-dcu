package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.DataSetProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.util.ValidationReportChecker;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.interfaces.DataSetDtoValidator;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.ValidationReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
@Service("dataSetProcessorProxyImpl")
public class DataSetProcessorProxyImpl implements DataSetProcessor {
  @Autowired
  private DataSetDtoValidator dataSetDtoValidator;

  @Autowired
  private ValidationReportChecker validationReportChecker;

  @Autowired
  @Qualifier("dataSetProcessorRealImpl")
  private DataSetProcessor dataSetProcessor;

  @Override
  public ResponseEntity<DataSetDto> get(Long id) {
    Objects.requireNonNull(id);
    return dataSetProcessor.get(id);
  }

  @Override
  public ResponseEntity<DataSetDto> save(DataSetDto dataSetDto) {
    final ValidationReport validationReport = dataSetDtoValidator.validateToSave(dataSetDto);
    validationReportChecker.check(validationReport);
    return dataSetProcessor.save(dataSetDto);
  }

  @Override
  public ResponseEntity<DataSetDto> update(DataSetDto dataSetDto) {
    final ValidationReport validationReport = dataSetDtoValidator.validateToUpdate(dataSetDto);
    validationReportChecker.check(validationReport);
    return dataSetProcessor.update(dataSetDto);
  }

  @Override
  public ResponseEntity<DataSetDto> patch(DataSetDto dataSetDto) {
    final ValidationReport validationReport = dataSetDtoValidator.validateToPatch(dataSetDto);
    validationReportChecker.check(validationReport);
    return dataSetProcessor.patch(dataSetDto);
  }

  @Override
  public ResponseEntity<Void> delete(Long id) {
    Objects.requireNonNull(id);
    return dataSetProcessor.delete(id);
  }

  @Override
  public ResponseEntity<DataSetDto> restore(Long id) {
    Objects.requireNonNull(id);
    return dataSetProcessor.restore(id);
  }

  @Override
  public ResponseEntity<List<DataSetDto>> findAll() {
    return dataSetProcessor.findAll();
  }
}
