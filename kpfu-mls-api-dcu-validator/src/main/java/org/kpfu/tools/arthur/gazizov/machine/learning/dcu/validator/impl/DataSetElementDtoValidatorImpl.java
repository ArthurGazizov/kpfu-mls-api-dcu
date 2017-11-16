package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.impl;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetElementDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.Valid;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.interfaces.DataSetElementDtoValidator;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.ValidationReport;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.Util.buildReport;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 11.11.17.
 */
@Component
public class DataSetElementDtoValidatorImpl implements DataSetElementDtoValidator {
  @Override
  public ValidationReport validateToSave(DataSetElementDto dto) {
    final List<Valid> errors = Stream.of(idIsNotNull(dto), imageIdIsNull(dto), datasetIdIsNull(dto))
            .filter(Valid::isFail)
            .collect(Collectors.toList());
    return buildReport(errors);
  }

  @Override
  public ValidationReport validateToUpdate(DataSetElementDto dto) {
    final List<Valid> errors = Stream.of(idIsNull(dto), imageIdIsNull(dto), datasetIdIsNull(dto))
            .filter(Valid::isFail)
            .collect(Collectors.toList());
    return buildReport(errors);
  }

  @Override
  public ValidationReport validateToPatch(DataSetElementDto dto) {
    final List<Valid> errors = Stream.of(idIsNull(dto))
            .filter(Valid::isFail)
            .collect(Collectors.toList());
    return buildReport(errors);
  }

  private Valid idIsNotNull(DataSetElementDto dataSetElementDto) {
    return new Valid(Objects.nonNull(dataSetElementDto.getId()), "Id is not null");
  }

  private Valid idIsNull(DataSetElementDto dataSetElementDto) {
    return new Valid(Objects.isNull(dataSetElementDto.getId()), "Id is null");
  }

  private Valid datasetIdIsNull(DataSetElementDto dataSetElementDto) {
    return new Valid(Objects.isNull(dataSetElementDto.getDatasetId()), "Dataset id is null");
  }

  private Valid imageIdIsNull(DataSetElementDto dataSetElementDto) {
    return new Valid(Objects.isNull(dataSetElementDto.getImageId()), "Name is empty");
  }
}
