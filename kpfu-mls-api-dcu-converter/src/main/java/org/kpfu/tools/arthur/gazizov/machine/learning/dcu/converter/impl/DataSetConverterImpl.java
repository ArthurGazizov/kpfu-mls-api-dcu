package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.annotation.Conversion;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.DataSetConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.MetaInfoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
@Conversion(dto = DataSetDto.class, model = DataSetModel.class)
public class DataSetConverterImpl implements DataSetConverter {
  @Autowired
  private MetaInfoConverter metaInfoConverter;

  @Override
  public DataSetDto convert(DataSetModel model) {
    return DataSetDto.Builder.aDataSetDto()
            .id(model.getId())
            .name(model.getName())
            .metaInfoDto(metaInfoConverter.convert(model.getMetaInfoModel()))
            .build();
  }

  @Override
  public DataSetModel convert(DataSetDto dto) {
    return DataSetModel.Builder.aDataSetModel()
            .id(dto.getId())
            .name(dto.getName())
            .metaInfoModel(metaInfoConverter.convert(dto.getMetaInfoDto()))
            .build();
  }
}
