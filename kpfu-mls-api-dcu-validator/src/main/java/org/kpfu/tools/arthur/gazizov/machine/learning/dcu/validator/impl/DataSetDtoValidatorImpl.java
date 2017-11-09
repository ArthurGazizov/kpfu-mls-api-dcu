package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.impl;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.interfaces.DataSetDtoValidator;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.ValidationReport;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.builder.ValidationReportBuildersFactory;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
public class DataSetDtoValidatorImpl implements DataSetDtoValidator {
  @Override
  public ValidationReport validateToSave(DataSetDto dto) {
    // TODO: 10.11.17 implement
    return ValidationReportBuildersFactory.intsance()
            .successValidationReportBuilder()
            .build();
  }

  @Override
  public ValidationReport validateToUpdate(DataSetDto dto) {
    // TODO: 10.11.17 implement
    return ValidationReportBuildersFactory.intsance()
            .successValidationReportBuilder()
            .build();
  }

  @Override
  public ValidationReport validateToPatch(DataSetDto dto) {
    // TODO: 10.11.17 implement
    return ValidationReportBuildersFactory.intsance()
            .failValidationReportBuilder()
            .build();
  }
}
