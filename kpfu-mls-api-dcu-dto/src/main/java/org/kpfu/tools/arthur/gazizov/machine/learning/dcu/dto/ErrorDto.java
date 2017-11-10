package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
public class ErrorDto implements Dto {
  private String errorId;
  private Integer code;
  private String message;

  public String getErrorId() {
    return errorId;
  }

  public void setErrorId(String errorId) {
    this.errorId = errorId;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public static final class Builder {
    private String errorId;
    private Integer code;
    private String message;

    private Builder() {
    }

    public static Builder anErrorDto() {
      return new Builder();
    }

    public Builder errorId(String errorId) {
      this.errorId = errorId;
      return this;
    }

    public Builder code(Integer code) {
      this.code = code;
      return this;
    }

    public Builder message(String message) {
      this.message = message;
      return this;
    }

    public ErrorDto build() {
      ErrorDto errorDto = new ErrorDto();
      errorDto.setErrorId(errorId);
      errorDto.setCode(code);
      errorDto.setMessage(message);
      return errorDto;
    }
  }
}
