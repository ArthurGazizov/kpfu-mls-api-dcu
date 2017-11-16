package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.real;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.DataSetElementConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.base.Converter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetElementDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetElementModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.base.AbstractCRUDProcessorImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.DataSetElementProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.CRUDService;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.DataSetElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 12.11.17.
 */
@Service("dataSetElementProcessorRealImpl")
public class DataSetElementProcessorRealImpl extends AbstractCRUDProcessorImpl<DataSetElementDto, DataSetElementModel> implements DataSetElementProcessor {
  @Autowired
  private DataSetElementService dataSetElementService;

  @Autowired
  private DataSetElementConverter dataSetElementConverter;

  @Override
  public CRUDService<DataSetElementModel> crudService() {
    return dataSetElementService;
  }

  @Override
  public Converter<DataSetElementModel, DataSetElementDto> converter() {
    return dataSetElementConverter;
  }
}
