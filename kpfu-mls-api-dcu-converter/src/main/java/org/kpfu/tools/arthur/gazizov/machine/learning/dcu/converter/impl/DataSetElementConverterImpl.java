package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.annotation.Conversion;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.DataSetElementConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.MetaInfoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetElementDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetElementModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 11.11.17.
 */
@Conversion(dto = DataSetElementDto.class, model = DataSetElementModel.class)
public class DataSetElementConverterImpl implements DataSetElementConverter {
  @Autowired
  private MetaInfoConverter metaInfoConverter;

  @Override
  public DataSetElementDto convert(DataSetElementModel model) {
    return DataSetElementDto.Builder.aDataSetElementDto()
            .id(model.getId())
            .imageId(model.getImageId())
            .datasetId(model.getDatasetId())
            .metaInfoDto(metaInfoConverter.convert(model.getMetaInfoModel()))
            .build();
  }

  @Override
  public DataSetElementModel convert(DataSetElementDto dto) {
    return DataSetElementModel.Builder.aDataSetElementModel()
            .id(dto.getId())
            .imageId(dto.getImageId())
            .datasetId(dto.getDatasetId())
            .metaInfoModel(metaInfoConverter.convert(dto.getMetaInfoDto()))
            .build();
  }
}
