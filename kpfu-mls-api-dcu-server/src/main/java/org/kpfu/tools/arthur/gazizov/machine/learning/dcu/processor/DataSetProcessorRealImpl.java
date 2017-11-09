package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.DataSetConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.DataSetProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.DataSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
@Service("dataSetProcessorRealImpl")
public class DataSetProcessorRealImpl implements DataSetProcessor {
  @Autowired
  private DataSetService dataSetService;

  @Autowired
  private DataSetConverter dataSetConverter;

  @Override
  public ResponseEntity<DataSetDto> get(Long id) {
    final DataSetModel dataSetModel = dataSetService.get(id);
    final DataSetDto dto = dataSetConverter.convert(dataSetModel);
    return ResponseEntity.ok(dto);
  }

  @Override
  public ResponseEntity<DataSetDto> save(DataSetDto dataSetDto) {
    final DataSetModel dataSetModel = dataSetConverter.convert(dataSetDto);
    final DataSetModel saved = dataSetService.save(dataSetModel);
    final DataSetDto dto = dataSetConverter.convert(saved);
    return ResponseEntity.status(HttpStatus.CREATED).body(dto);
  }

  @Override
  public ResponseEntity<DataSetDto> update(DataSetDto dataSetDto) {
    final DataSetModel dataSetModel = dataSetConverter.convert(dataSetDto);
    final DataSetModel updated = dataSetService.save(dataSetModel);
    final DataSetDto dto = dataSetConverter.convert(updated);
    return ResponseEntity.ok(dto);
  }

  @Override
  public ResponseEntity<DataSetDto> patch(DataSetDto dataSetDto) {
    final DataSetModel dataSetModel = dataSetConverter.convert(dataSetDto);
    final DataSetModel patched = dataSetService.save(dataSetModel);
    final DataSetDto dto = dataSetConverter.convert(patched);
    return ResponseEntity.ok(dto);
  }

  @Override
  public ResponseEntity<Void> delete(Long id) {
    dataSetService.delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
