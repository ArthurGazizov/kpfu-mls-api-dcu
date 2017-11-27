package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.exception;

import org.springframework.http.HttpStatus;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
public enum KpfuMlsDcuError {
  UNSPECIFIED(1_000_001, HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error"),

  DATA_SET_NOT_FOUND(1_001_001, HttpStatus.NOT_FOUND, "Data set not found"),

  DATA_SET_ELEMENT_NOT_FOUND(1_001_002, HttpStatus.NOT_FOUND, "Data set element not found"),

  TAG_NOT_FOUND(1_001_003, HttpStatus.NOT_FOUND, "Tag not found"),

  META_IMAGE_INFO_NOT_FOUND(1_001_004, HttpStatus.NOT_FOUND, "Meta image info not found"),

  VALIDATION_ERROR(1_002_001, HttpStatus.BAD_REQUEST, "Validation Error"),

  CLIENT_EXCEPTION(1_003_001, HttpStatus.INTERNAL_SERVER_ERROR, "client error"),

  BYTE_MANIPULATIONS_ERROR(1_003_001, HttpStatus.INTERNAL_SERVER_ERROR, "bytes manipulations error"),

  INCORRECT_META_IMAGE_INFO_FORMAT(1_002_002, HttpStatus.BAD_REQUEST, "Incorrect meta image info format error"),

  UNSUPPORTED_OPERATION(1_900_001, HttpStatus.BAD_REQUEST, "Unsupported operation");

  private Integer code;
  private HttpStatus httpStatus;
  private String defaultMessage;

  KpfuMlsDcuError(int code, HttpStatus httpStatus, String defaultMessage) {
    this.code = code;
    this.httpStatus = httpStatus;
    this.defaultMessage = defaultMessage;
  }

  public Integer getCode() {
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

  public KpfuMlsDcuException exception(Throwable throwable) {
    return new KpfuMlsDcuException(this, defaultMessage, throwable);
  }
}
