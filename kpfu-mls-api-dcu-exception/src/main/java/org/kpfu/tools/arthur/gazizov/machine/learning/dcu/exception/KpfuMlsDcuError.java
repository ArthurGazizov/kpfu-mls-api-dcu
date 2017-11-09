package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
public enum KpfuMlsDcuError {
  UNSPECIFIED(1_00_01, HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),

  DATA_SET_NOT_FOUND(1_01_01, HttpStatus.NOT_FOUND, "Data set not found");

  private int code;
  private HttpStatus httpStatus;
  private String defaultMessage;

  KpfuMlsDcuError(int code, HttpStatus httpStatus, String defaultMessage) {
    this.code = code;
    this.httpStatus = httpStatus;
    this.defaultMessage = defaultMessage;
  }

  public int getCode() {
    return code;
  }

  public HttpStatus getHttpStatus() {
    return httpStatus;
  }

  public String getDefaultMessage() {
    return defaultMessage;
  }

  public KpfuMlsDcuException exception() {
    return new KpfuMlsDcuException(this);
  }

  public KpfuMlsDcuException exception(String message) {
    return new KpfuMlsDcuException(this, message);
  }

  public KpfuMlsDcuException exception(String message, Throwable throwable) {
    return new KpfuMlsDcuException(this, message, throwable);
  }
}
