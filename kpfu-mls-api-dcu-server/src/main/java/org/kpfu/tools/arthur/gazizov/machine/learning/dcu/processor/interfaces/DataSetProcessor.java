package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetDto;
import org.springframework.http.ResponseEntity;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
public interface DataSetProcessor {
  ResponseEntity<DataSetDto> get(Long id);

  ResponseEntity<DataSetDto> save(DataSetDto dataSetDto);

  ResponseEntity<DataSetDto> update(DataSetDto dataSetDto);

  ResponseEntity<DataSetDto> patch(DataSetDto dataSetDto);

  ResponseEntity<Void> delete(Long id);
}
