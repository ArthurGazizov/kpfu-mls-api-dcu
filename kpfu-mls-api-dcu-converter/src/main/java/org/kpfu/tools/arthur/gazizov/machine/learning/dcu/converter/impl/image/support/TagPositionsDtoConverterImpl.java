package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.image.support;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.annotation.Conversion;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.image.support.TagPositionDtoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.image.support.TagPositionsDtoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image.TagPositionsDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image.pojo.TagPositions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Conversion(dto = TagPositionsDto.class, model = TagPositions.class)
public class TagPositionsDtoConverterImpl implements TagPositionsDtoConverter {
  @Autowired
  private TagPositionDtoConverter tagPositionDtoConverter;

  @Override
  public TagPositionsDto convert(TagPositions model) {
    return TagPositionsDto.Builder.aTagPositionsDto()
            .data(model.getData().stream()
                    .map(tagPositionDtoConverter::convert)
                    .collect(Collectors.toList()))
            .build();
  }

  @Override
  public TagPositions convert(TagPositionsDto dto) {
    return TagPositions.Builder.aTagPositions()
            .data(dto.getData().stream()
                    .map(tagPositionDtoConverter::convert)
                    .collect(Collectors.toList()))
            .build();
  }
}
