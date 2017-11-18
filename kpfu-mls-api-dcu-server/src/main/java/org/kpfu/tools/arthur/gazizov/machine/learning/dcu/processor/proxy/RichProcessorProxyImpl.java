package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.proxy;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.rich.RichDataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.RichProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Service("richProcessorProxyImpl")
public class RichProcessorProxyImpl implements RichProcessor {
  @Autowired
  @Qualifier("richProcessorRealImpl")
  private RichProcessor richProcessor;

  @Override
  public ResponseEntity<RichDataSetDto> loadReachDataSet(Long dataSetId) {
    Objects.requireNonNull(dataSetId);
    return richProcessor.loadReachDataSet(dataSetId);
  }
}
