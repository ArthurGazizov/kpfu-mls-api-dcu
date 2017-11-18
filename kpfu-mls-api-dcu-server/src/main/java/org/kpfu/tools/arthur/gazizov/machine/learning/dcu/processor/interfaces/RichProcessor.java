package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.rich.RichDataSetDto;
import org.springframework.http.ResponseEntity;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public interface RichProcessor {
  ResponseEntity<RichDataSetDto> loadReachDataSet(Long dataSetId);
}
