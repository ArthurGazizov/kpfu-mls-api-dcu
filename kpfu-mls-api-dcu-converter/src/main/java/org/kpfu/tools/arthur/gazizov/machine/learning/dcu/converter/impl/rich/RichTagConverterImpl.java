package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.rich;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.annotation.Conversion;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.MetaInfoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.rich.RichTagConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.rich.RichTagDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.rich.RichTagModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Conversion(dto = RichTagDto.class, model = RichTagModel.class)
public class RichTagConverterImpl implements RichTagConverter {
  @Autowired
  private MetaInfoConverter metaInfoConverter;

  @Override
  public RichTagDto convert(RichTagModel model) {
    return RichTagDto.Builder.aRichTagDto()
            .id(model.getId())
            .name(model.getName())
            .code(model.getCode())
            .metaInfoDto(metaInfoConverter.convert(model.getMetaInfoModel()))
            .build();
  }
}
