package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetElementDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.support.PageResponse;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.base.CRUDProcessor;
import org.springframework.http.ResponseEntity;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 12.11.17.
 */
public interface DataSetElementProcessor extends CRUDProcessor<DataSetElementDto> {
  ResponseEntity<PageResponse<DataSetElementDto>> searchByDataSetId(Long dataSetId, Integer limit, Integer offset);

  ResponseEntity<Integer> elementsCountInDataSet(Long dataSetId);
}
