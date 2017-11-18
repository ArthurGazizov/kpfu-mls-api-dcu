package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.rich;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.annotation.Conversion;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.rich.RichTagPositionConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.rich.RichTagPositionsConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.rich.RichTagPositionsDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.rich.RichTagPositions;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Conversion(dto = RichTagPositionsDto.class, model = RichTagPositions.class)
public class RichTagPositionsConverterImpl implements RichTagPositionsConverter {
  @Autowired
  private RichTagPositionConverter richTagPositionConverter;

  @Override
  public RichTagPositionsDto convert(RichTagPositions model) {
    return RichTagPositionsDto.Builder.aRichTagPositionsDto()
            .data(model.getData().stream()
                    .map(m -> richTagPositionConverter.convert(m)).collect(Collectors.toList()))
            .build();
  }
}
