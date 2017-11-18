package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.impl;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.rich.RichDataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.RichProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Service
@Primary
public class RichProcessorImpl implements RichProcessor {
  @Autowired
  @Qualifier("richProcessorProxyImpl")
  private RichProcessor richProcessor;

  @Override
  public ResponseEntity<RichDataSetDto> loadReachDataSet(Long dataSetId) {
    return richProcessor.loadReachDataSet(dataSetId);
  }
}
