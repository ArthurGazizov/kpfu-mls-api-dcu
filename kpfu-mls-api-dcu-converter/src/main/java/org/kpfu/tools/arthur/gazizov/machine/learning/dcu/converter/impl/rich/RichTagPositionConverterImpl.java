package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.rich;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.annotation.Conversion;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.image.support.BoundingBoxDtoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.rich.RichTagConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.rich.RichTagPositionConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.rich.RichTagPositionDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.rich.RichTagPosition;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Conversion(dto = RichTagPositionDto.class, model = RichTagPosition.class)
public class RichTagPositionConverterImpl implements RichTagPositionConverter {
  @Autowired
  private RichTagConverter richTagConverter;

  @Autowired
  private BoundingBoxDtoConverter boundingBoxDtoConverter;

  @Override
  public RichTagPositionDto convert(RichTagPosition model) {
    return RichTagPositionDto.Builder.aRichTagPositionDto()
            .tag(richTagConverter.convert(model.getRichTagModel()))
            .boundingBox(boundingBoxDtoConverter.convert(model.getBoundingBox()))
            .build();
  }
}
