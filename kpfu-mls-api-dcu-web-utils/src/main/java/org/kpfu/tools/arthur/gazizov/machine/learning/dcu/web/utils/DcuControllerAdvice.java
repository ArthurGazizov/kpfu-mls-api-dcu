package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.web.utils;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.ErrorDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.exception.KpfuMlsDcuException;
import org.springframework.http.ResponseEntity;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
public interface DcuControllerAdvice {
  ResponseEntity<ErrorDto> handleUnknownException(Exception exception);

  ResponseEntity<ErrorDto> handleKpfuMlsDcuException(KpfuMlsDcuException kpfuMlsDcuException);
}
