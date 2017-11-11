package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.DataSetProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
@Service
@Primary
public class DataSetProcessorImpl implements DataSetProcessor {
  @Autowired
  @Qualifier("dataSetProcessorProxyImpl")
  private DataSetProcessor dataSetProcessor;

  @Override
  public ResponseEntity<DataSetDto> get(Long id) {
    return dataSetProcessor.get(id);
  }

  @Override
  public ResponseEntity<DataSetDto> save(DataSetDto dataSetDto) {
    return dataSetProcessor.save(dataSetDto);
  }

  @Override
  public ResponseEntity<DataSetDto> update(DataSetDto dataSetDto) {
    return dataSetProcessor.update(dataSetDto);
  }

  @Override
  public ResponseEntity<DataSetDto> patch(DataSetDto dataSetDto) {
    return dataSetProcessor.patch(dataSetDto);
  }

  @Override
  public ResponseEntity<Void> delete(Long id) {
    return dataSetProcessor.delete(id);
  }

  @Override
  public ResponseEntity<DataSetDto> restore(Long id) {
    return dataSetProcessor.restore(id);
  }

  @Override
  public ResponseEntity<List<DataSetDto>> findAll() {
    return dataSetProcessor.findAll();
  }
}
