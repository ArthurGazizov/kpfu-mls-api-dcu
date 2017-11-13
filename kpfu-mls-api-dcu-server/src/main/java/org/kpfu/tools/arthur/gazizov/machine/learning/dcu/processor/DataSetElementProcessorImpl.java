package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetElementDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.DataSetElementProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 12.11.17.
 */
@Service
@Primary
public class DataSetElementProcessorImpl implements DataSetElementProcessor {
  @Autowired
  @Qualifier("dataSetElementProcessorProxyImpl")
  private DataSetElementProcessor dataSetElementProcessor;

  @Override
  public ResponseEntity<DataSetElementDto> get(Long id) {
    return dataSetElementProcessor.get(id);
  }

  @Override
  public ResponseEntity<DataSetElementDto> save(DataSetElementDto dataSetElementDto) {
    return dataSetElementProcessor.save(dataSetElementDto);
  }

  @Override
  public ResponseEntity<DataSetElementDto> update(DataSetElementDto dataSetElementDto) {
    return dataSetElementProcessor.update(dataSetElementDto);

  }

  @Override
  public ResponseEntity<DataSetElementDto> patch(DataSetElementDto dataSetElementDto) {
    return dataSetElementProcessor.patch(dataSetElementDto);
  }

  @Override
  public ResponseEntity<Void> delete(Long id) {
    return dataSetElementProcessor.delete(id);
  }

  @Override
  public ResponseEntity<DataSetElementDto> restore(Long id) {
    return dataSetElementProcessor.restore(id);
  }

  @Override
  public ResponseEntity<List<DataSetElementDto>> findAll() {
    return dataSetElementProcessor.findAll();
  }
}
