package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.builder;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.ValidationReport;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.base.SuccessValidationReportImpl;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
public class SuccessValidationReportBuilderImpl implements ValidationReportBuilder {
  @Override
  public ValidationReport build() {
    return SuccessValidationReportImpl.Builder.aSuccessValidationReportImpl()
            .build();
  }
}
