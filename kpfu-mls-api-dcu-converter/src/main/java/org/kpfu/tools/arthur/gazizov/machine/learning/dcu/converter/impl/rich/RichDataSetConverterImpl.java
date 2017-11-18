package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.rich;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.annotation.Conversion;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.MetaInfoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.rich.RichDataSetConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.rich.RichDataSetElementConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.rich.RichDataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.rich.RichDataSetModel;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Conversion(dto = RichDataSetDto.class, model = RichDataSetModel.class)
public class RichDataSetConverterImpl implements RichDataSetConverter {
  @Autowired
  private MetaInfoConverter metaInfoConverter;

  @Autowired
  private RichDataSetElementConverter richDataSetElementConverter;

  @Override
  public RichDataSetDto convert(RichDataSetModel model) {
    return RichDataSetDto.Builder.aRichDataSetDto()
            .id(model.getId())
            .metaInfoDto(metaInfoConverter.convert(model.getMetaInfoModel()))
            .name(model.getName())
            .richDataSetElementDtos(model.getRichDataSetElement()
                    .stream()
                    .map(m -> richDataSetElementConverter.convert(m))
                    .collect(Collectors.toList()))
            .build();
  }
}
