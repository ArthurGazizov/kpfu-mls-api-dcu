package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.image.support;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.annotation.Conversion;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.image.support.PointDtoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image.PointDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image.pojo.Point;
import org.springframework.stereotype.Component;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Conversion(dto = PointDto.class, model = Point.class)
public class PointDtoConverterImpl implements PointDtoConverter {
  @Override
  public PointDto convert(Point model) {
    return PointDto.Builder.aPointDto()
            .x(model.getX())
            .y(model.getY())
            .build();
  }

  @Override
  public Point convert(PointDto dto) {
    return Point.Builder.aPoint()
            .x(dto.getX())
            .y(dto.getY())
            .build();
  }
}
