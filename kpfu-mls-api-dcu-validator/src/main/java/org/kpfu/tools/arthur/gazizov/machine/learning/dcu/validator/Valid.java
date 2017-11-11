package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.validator;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 11.11.17.
 */
public class Valid {
  private boolean fail;
  private String message;

  public Valid(boolean fail, String message) {
    this.fail = fail;
    this.message = message;
  }

  public boolean isFail() {
    return fail;
  }

  public String getMessage() {
    return message;
  }
}
