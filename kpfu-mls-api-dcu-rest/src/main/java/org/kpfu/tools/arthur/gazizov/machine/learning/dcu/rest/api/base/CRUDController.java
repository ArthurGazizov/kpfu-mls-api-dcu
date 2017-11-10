package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.api.base;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.Dto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.base.CRUDProcessor;
import org.springframework.http.ResponseEntity;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
public interface CRUDController<T extends Dto> {
  default ResponseEntity<T> get(Long id) {
    return processor().get(id);
  }

  default ResponseEntity<T> save(T t) {
    return processor().save(t);
  }

  default ResponseEntity<T> update(T t) {
    return processor().update(t);
  }

  default ResponseEntity<T> patch(T t) {
    return processor().patch(t);
  }

  default ResponseEntity<Void> delete(Long id) {
    return processor().delete(id);
  }

  CRUDProcessor<T> processor();
}
