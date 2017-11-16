package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.impl;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.TagDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.Valid;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.interfaces.TagDtoValidator;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.ValidationReport;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.Util.buildReport;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Component
public class TagDtoValidatorImpl implements TagDtoValidator {
  @Override
  public ValidationReport validateToSave(TagDto dto) {
    final List<Valid> errors = Stream.of(idIsNotNull(dto), nameIsEmpty(dto), codeIsEmpty(dto))
            .filter(Valid::isFail)
            .collect(Collectors.toList());
    return buildReport(errors);
  }

  @Override
  public ValidationReport validateToUpdate(TagDto dto) {
    final List<Valid> errors = Stream.of(idIsNull(dto), nameIsEmpty(dto), codeIsEmpty(dto))
            .filter(Valid::isFail)
            .collect(Collectors.toList());
    return buildReport(errors);
  }

  @Override
  public ValidationReport validateToPatch(TagDto dto) {
    final List<Valid> errors = Stream.of(idIsNull(dto), incorrectName(dto), incorrectCode(dto))
            .filter(Valid::isFail)
            .collect(Collectors.toList());
    return buildReport(errors);
  }

  private Valid idIsNotNull(TagDto tagDto) {
    return new Valid(Objects.nonNull(tagDto.getId()), "Id is not null");
  }

  private Valid idIsNull(TagDto TagDto) {
    return new Valid(Objects.isNull(TagDto.getId()), "Id is null");
  }

  private Valid nameIsEmpty(TagDto tagDto) {
    return new Valid(StringUtils.isEmpty(tagDto.getName()), "Name is empty");
  }

  private Valid incorrectName(TagDto tagDto) {
    final String name = tagDto.getName();
    return new Valid(Objects.nonNull(name) && !StringUtils.hasText(name), "Incorrect name");
  }

  private Valid incorrectCode(TagDto tagDto) {
    final String code = tagDto.getCode();
    return new Valid(Objects.nonNull(code) && !StringUtils.hasText(code), "Incorrect code");
  }

  private Valid codeIsEmpty(TagDto tagDto) {
    return new Valid(StringUtils.isEmpty(tagDto.getCode()), "Code is empty");
  }
}
