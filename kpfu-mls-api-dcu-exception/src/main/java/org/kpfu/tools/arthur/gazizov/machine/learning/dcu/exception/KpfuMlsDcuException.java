package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
public class KpfuMlsDcuException extends RuntimeException {
  private final KpfuMlsDcuError error;

  KpfuMlsDcuException(KpfuMlsDcuError error, String message, Throwable cause) {
    super(message, cause);
    this.error = error;
  }

  KpfuMlsDcuException(String message) {
    this(KpfuMlsDcuError.UNSPECIFIED, message, null);
  }

  KpfuMlsDcuException(KpfuMlsDcuError error, String message) {
    this(error, message, null);
  }

  KpfuMlsDcuException(KpfuMlsDcuError error) {
    this(error, error.getDefaultMessage(), null);
  }

  public KpfuMlsDcuError getError() {
    return error;
  }

  public HttpStatus getStatus() {
    return error.getHttpStatus();
  }

  public int getCode() {
    return error.getCode();
  }
}
