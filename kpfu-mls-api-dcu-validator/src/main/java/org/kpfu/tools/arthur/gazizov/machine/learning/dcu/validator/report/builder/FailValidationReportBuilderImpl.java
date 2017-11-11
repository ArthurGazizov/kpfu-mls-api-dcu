package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.builder;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.Valid;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.ValidationReport;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.base.FailValidationReportImpl;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
public class FailValidationReportBuilderImpl implements ValidationReportBuilder {
  private List<Valid> valids;

  @Override
  public ValidationReport build() {
    return FailValidationReportImpl.Builder.aFailValidationReportImpl()
            .message(valids.stream().map(Valid::getMessage).collect(Collectors.joining(",", "[", "]")))
            .build();
  }

  public FailValidationReportBuilderImpl valids(List<Valid> valids) {
    this.valids = valids;
    return this;
  }
}
