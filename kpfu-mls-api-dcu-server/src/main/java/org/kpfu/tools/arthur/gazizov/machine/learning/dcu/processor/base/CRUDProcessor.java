package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.base;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.Dto;
import org.springframework.http.ResponseEntity;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
public interface CRUDProcessor<T extends Dto> {
  ResponseEntity<T> get(Long id);

  ResponseEntity<T> save(T t);

  ResponseEntity<T> update(T t);

  ResponseEntity<T> patch(T t);

  ResponseEntity<Void> delete(Long id);
}
