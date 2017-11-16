package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.image.support;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.annotation.Conversion;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.image.support.BoundingBoxDtoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.image.support.TagPositionDtoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image.TagPositionDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image.pojo.TagPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Conversion(dto = TagPositionDto.class, model = TagPosition.class)
public class TagPositionDtoConverterImpl implements TagPositionDtoConverter {
  @Autowired
  private BoundingBoxDtoConverter boundingBoxDtoConverter;

  @Override
  public TagPositionDto convert(TagPosition model) {
    return TagPositionDto.Builder.aTagPositionDto()
            .tagId(model.getTagId())
            .boundingBox(boundingBoxDtoConverter.convert(model.getBoundingBox()))
            .build();
  }

  @Override
  public TagPosition convert(TagPositionDto dto) {
    return TagPosition.Builder.aTagPosition()
            .tagId(dto.getTagId())
            .boundingBox(boundingBoxDtoConverter.convert(dto.getBoundingBox()))
            .build();
  }
}
