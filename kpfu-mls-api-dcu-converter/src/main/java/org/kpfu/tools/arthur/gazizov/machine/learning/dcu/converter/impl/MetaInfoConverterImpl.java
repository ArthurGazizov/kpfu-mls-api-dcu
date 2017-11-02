package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.annotation.Conversion;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.MetaInfoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.MetaInfoDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.MetaInfoModel;
import org.springframework.stereotype.Component;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 03.11.17.
 */
@Component
@Conversion(model = MetaInfoModel.class, dto = MetaInfoDto.class)
public class MetaInfoConverterImpl implements MetaInfoConverter {
  @Override
  public MetaInfoDto convert(MetaInfoModel model) {
    return MetaInfoDto.Builder.aMetaInfoDto()
            .createdTs(model.getCreatedTs())
            .updatedTs(model.getUpdatedTs())
            .build();
  }

  @Override
  public MetaInfoModel convert(MetaInfoDto dto) {
    return MetaInfoModel.Builder.aMetaInfoEntity()
            .build();
  }
}
