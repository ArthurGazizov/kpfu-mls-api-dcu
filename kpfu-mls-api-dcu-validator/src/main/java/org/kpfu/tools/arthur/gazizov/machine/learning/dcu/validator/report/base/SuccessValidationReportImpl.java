package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.base;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.ValidationReport;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
public class SuccessValidationReportImpl implements ValidationReport {
  private SuccessValidationReportImpl() {
  }

  public static final class Builder {
    public static Builder aSuccessValidationReportImpl() {
      return new Builder();
    }

    public SuccessValidationReportImpl build() {
      return new SuccessValidationReportImpl();
    }
  }
}
