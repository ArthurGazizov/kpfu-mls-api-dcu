package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.builder;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
public class ValidationReportBuildersFactory {
  private static final ValidationReportBuildersFactory instance = new ValidationReportBuildersFactory();

  private ValidationReportBuildersFactory() {

  }

  public static ValidationReportBuildersFactory instance() {
    return instance;
  }

  public SuccessValidationReportBuilderImpl successValidationReportBuilder() {
    return new SuccessValidationReportBuilderImpl();
  }

  public FailValidationReportBuilderImpl failValidationReportBuilder() {
    return new FailValidationReportBuilderImpl();
  }
}
