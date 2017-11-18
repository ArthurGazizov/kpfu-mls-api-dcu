package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.impl;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetElementDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.support.PageResponse;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.DataSetElementProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

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

  @Override
  public ResponseEntity<PageResponse<DataSetElementDto>> findAll(Integer limit, Integer offset) {
    return dataSetElementProcessor.findAll(limit, offset);
  }

  @Override
  public ResponseEntity<PageResponse<DataSetElementDto>> searchByDataSetId(Long dataSetId, Integer limit, Integer offset) {
    return dataSetElementProcessor.searchByDataSetId(dataSetId, limit, offset);
  }

  @Override
  public ResponseEntity<Integer> elementsCountInDataSet(Long dataSetId) {
    return dataSetElementProcessor.elementsCountInDataSet(dataSetId);
  }
}
