package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.impl;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.Valid;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.interfaces.DataSetDtoValidator;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.ValidationReport;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.builder.ValidationReportBuildersFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.Util.buildReport;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
@Component
public class DataSetDtoValidatorImpl implements DataSetDtoValidator {
  @Override
  public ValidationReport validateToSave(DataSetDto dto) {
    final List<Valid> errors = Stream.of(idIsNotNull(dto), nameIsEmpty(dto))
            .filter(Valid::isFail)
            .collect(Collectors.toList());
    return buildReport(errors);
  }

  @Override
  public ValidationReport validateToUpdate(DataSetDto dto) {
    final List<Valid> errors = Stream.of(idIsNull(dto), nameIsEmpty(dto))
            .filter(Valid::isFail)
            .collect(Collectors.toList());
    return buildReport(errors);
  }

  @Override
  public ValidationReport validateToPatch(DataSetDto dto) {
    final List<Valid> errors = Stream.of(idIsNull(dto), incorrectName(dto))
            .filter(Valid::isFail)
            .collect(Collectors.toList());
    return buildReport(errors);
  }

  private Valid idIsNotNull(DataSetDto dataSetDto) {
    return new Valid(Objects.nonNull(dataSetDto.getId()), "Id is not null");
  }

  private Valid idIsNull(DataSetDto dataSetDto) {
    return new Valid(Objects.isNull(dataSetDto.getId()), "Id is null");
  }

  private Valid nameIsEmpty(DataSetDto dataSetDto) {
    return new Valid(StringUtils.isEmpty(dataSetDto.getName()), "Name is empty");
  }

  private Valid incorrectName(DataSetDto dataSetDto){
    final String name = dataSetDto.getName();
    return new Valid(Objects.nonNull(name) && !StringUtils.hasText(name), "Incorrect name");
  }
}
