package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.Dto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.ValidationReport;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 03.11.17.
 */
@FunctionalInterface
public interface Validator<T extends Dto> {
  ValidationReport validate(T dto);
}

