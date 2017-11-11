package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.base;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.ValidationReport;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
public class FailValidationReportImpl implements ValidationReport {
  private String message;

  private FailValidationReportImpl() {
  }

  public String getMessage() {
    return message;
  }

  public static final class Builder {
    private String message;

    private Builder() {
    }

    public static Builder aFailValidationReportImpl() {
      return new Builder();
    }

    public Builder message(String message) {
      this.message = message;
      return this;
    }

    public FailValidationReportImpl build() {
      FailValidationReportImpl failValidationReportImpl = new FailValidationReportImpl();
      failValidationReportImpl.message = this.message;
      return failValidationReportImpl;
    }
  }
}
