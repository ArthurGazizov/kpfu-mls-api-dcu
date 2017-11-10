package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.DataSetConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.base.Converter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.base.AbstractCRUDProcessorImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.DataSetProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.CRUDService;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.DataSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
@Service("dataSetProcessorRealImpl")
public class DataSetProcessorRealImpl extends AbstractCRUDProcessorImpl<DataSetDto, DataSetModel> implements DataSetProcessor {
  @Autowired
  private DataSetService dataSetService;

  @Autowired
  private DataSetConverter dataSetConverter;

  @Override
  public CRUDService<DataSetModel> crudService() {
    return dataSetService;
  }

  @Override
  public Converter<DataSetModel, DataSetDto> converter() {
    return dataSetConverter;
  }
}
