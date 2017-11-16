package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.impl;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image.MetaImageInfoDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.interfaces.MetaImageInfoDtoValidator;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.ValidationReport;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.builder.ValidationReportBuildersFactory;
import org.springframework.stereotype.Component;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Component
public class MetaImageInfoDtoValidatorImpl implements MetaImageInfoDtoValidator {
  @Override
  public ValidationReport validateToSave(MetaImageInfoDto dto) {
    // TODO: 16.11.17 implement me
    return ValidationReportBuildersFactory.instance()
            .successValidationReportBuilder()
            .build();
  }

  @Override
  public ValidationReport validateToUpdate(MetaImageInfoDto dto) {
    // TODO: 16.11.17 implement me
    return ValidationReportBuildersFactory.instance()
            .successValidationReportBuilder()
            .build();
  }

  @Override
  public ValidationReport validateToPatch(MetaImageInfoDto dto) {
    // TODO: 16.11.17 implement me
    return ValidationReportBuildersFactory.instance()
            .successValidationReportBuilder()
            .build();
  }
}
