package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.ValidationReport;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator.report.builder.ValidationReportBuildersFactory;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 11.11.17.
 */
public class Util {
  public static ValidationReport buildReport(List<Valid> errors) {
    return errors.isEmpty()
            ?
            ValidationReportBuildersFactory.instance()
                    .successValidationReportBuilder()
                    .build()
            :
            ValidationReportBuildersFactory.instance()
                    .failValidationReportBuilder()
                    .valids(errors)
                    .build();
  }
}
