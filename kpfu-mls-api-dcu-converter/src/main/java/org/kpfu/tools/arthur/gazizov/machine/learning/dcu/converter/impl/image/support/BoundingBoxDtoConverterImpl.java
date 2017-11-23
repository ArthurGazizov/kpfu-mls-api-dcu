package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.image.support;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.annotation.Conversion;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.image.support.BoundingBoxDtoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.image.support.PointDtoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image.BoundingBoxDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image.pojo.BoundingBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Conversion(dto = BoundingBoxDto.class, model = BoundingBox.class)
public class BoundingBoxDtoConverterImpl implements BoundingBoxDtoConverter {
  @Autowired
  private PointDtoConverter pointDtoConverter;

  @Override
  public BoundingBoxDto convert(BoundingBox model) {
    if (model == null){
      return null;
    }
    return BoundingBoxDto.Builder.aBoundingBoxDto()
            .points(model.getPoints().stream()
                    .map(pointDtoConverter::convert)
                    .collect(Collectors.toList()))
            .build();
  }

  @Override
  public BoundingBox convert(BoundingBoxDto dto) {
    if (dto == null){
      return null;
    }
    return BoundingBox.Builder.aBoundingBox()
            .points(dto.getPoints().stream()
                    .map(pointDtoConverter::convert)
                    .collect(Collectors.toList()))
            .build();
  }
}
