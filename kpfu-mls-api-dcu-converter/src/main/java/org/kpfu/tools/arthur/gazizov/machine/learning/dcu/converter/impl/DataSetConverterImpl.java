package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.annotation.Conversion;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.DataSetConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetModel;
import org.springframework.stereotype.Component;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
@Component
@Conversion(model = DataSetModel.class, dto = DataSetDto.class)
public class DataSetConverterImpl implements DataSetConverter {
  @Override
  public DataSetDto convert(DataSetModel model) {
    return null;
  }

  @Override
  public DataSetModel convert(DataSetDto dto) {
    return null;
  }
}
