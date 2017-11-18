package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.api.interfaces;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.rich.RichDataSetDto;
import org.springframework.http.ResponseEntity;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public interface RichController {
  ResponseEntity<RichDataSetDto> loadReachDataSet(Long dataSetId);
}
