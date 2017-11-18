package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.real;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.rich.RichDataSetConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.rich.RichDataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.rich.RichDataSetModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.RichProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.RichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Service("richProcessorRealImpl")
public class RichProcessorRealImpl implements RichProcessor {
  @Autowired
  private RichService richService;

  @Autowired
  private RichDataSetConverter richDataSetConverter;

  @Override
  public ResponseEntity<RichDataSetDto> loadReachDataSet(Long dataSetId) {
    final RichDataSetModel richDataSetModel = richService.loadReachDataSet(dataSetId);
    final RichDataSetDto dto = richDataSetConverter.convert(richDataSetModel);
    return ResponseEntity.ok(dto);
  }
}
