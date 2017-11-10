package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.web.utils;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.ErrorDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.exception.KpfuMlsDcuException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
@ControllerAdvice
public class DcuControllerAdvice {
  private ResponseEntity<ErrorDto> generateResponse(Throwable throwable) {
    if (throwable instanceof KpfuMlsDcuException) {
      final KpfuMlsDcuException kpfuMlsDcuException = (KpfuMlsDcuException) throwable;
      final ErrorDto errorDto = ErrorDto.Builder.anErrorDto()
              .errorId(UUID.randomUUID().toString())
              .code(kpfuMlsDcuException.getCode())
              .message(kpfuMlsDcuException.getMessage())
              .build();
      return new ResponseEntity<>(errorDto, kpfuMlsDcuException.getStatus());
    } else {
      final ErrorDto errorDto = ErrorDto.Builder.anErrorDto()
              .errorId(UUID.randomUUID().toString())
              .code(-1)
              .message(throwable.getMessage())
              .build();
      return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @ExceptionHandler({RuntimeException.class})
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ResponseEntity<ErrorDto> handleUnknownException(Exception exception) {
    return this.generateResponse(exception);
  }

  @ExceptionHandler({RuntimeException.class})
  public ResponseEntity<ErrorDto> handleKpfuMlsDcuException(KpfuMlsDcuException kpfuMlsDcuException) {
    return this.generateResponse(kpfuMlsDcuException);
  }
}
