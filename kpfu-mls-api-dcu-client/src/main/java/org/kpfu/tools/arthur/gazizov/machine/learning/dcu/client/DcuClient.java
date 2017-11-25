package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.client;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetDto;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 25/11/2017.
 */
public interface DcuClient {
  DataSetDto save(DataSetDto dataSetDto);

  DataSetDto get(Long dataSetId);

  DataSetDto update(DataSetDto dataSetDto);

}
