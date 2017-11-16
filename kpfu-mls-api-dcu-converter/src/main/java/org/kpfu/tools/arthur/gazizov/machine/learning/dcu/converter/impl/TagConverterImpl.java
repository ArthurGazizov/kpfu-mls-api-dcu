package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.annotation.Conversion;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.MetaInfoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.TagConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.TagDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.TagModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Component
@Conversion(model = TagModel.class, dto = TagDto.class)
public class TagConverterImpl implements TagConverter {
  @Autowired
  private MetaInfoConverter metaInfoConverter;

  @Override
  public TagDto convert(TagModel model) {
    return TagDto.Builder.aTagDto()
            .code(model.getCode())
            .name(model.getName())
            .id(model.getId())
            .metaInfoDto(metaInfoConverter.convert(model.getMetaInfoModel()))
            .build();
  }

  @Override
  public TagModel convert(TagDto dto) {
    return TagModel.Builder.aTagModel()
            .code(dto.getCode())
            .name(dto.getName())
            .id(dto.getId())
            .metaInfoModel(metaInfoConverter.convert(dto.getMetaInfoDto()))
            .build();
  }
}
