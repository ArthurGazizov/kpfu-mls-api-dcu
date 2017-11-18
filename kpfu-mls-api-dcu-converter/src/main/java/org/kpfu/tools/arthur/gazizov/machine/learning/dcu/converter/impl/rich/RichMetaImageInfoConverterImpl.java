package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.rich;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.annotation.Conversion;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.MetaInfoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.rich.RichMetaImageInfoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.rich.RichTagPositionsConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.rich.RichMetaImageInfoDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.rich.RichMetaImageInfoModel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Conversion(dto = RichMetaImageInfoDto.class, model = RichMetaImageInfoModel.class)
public class RichMetaImageInfoConverterImpl implements RichMetaImageInfoConverter {
  @Autowired
  private MetaInfoConverter metaInfoConverter;

  @Autowired
  private RichTagPositionsConverter tagPositionsConverter;

  @Override
  public RichMetaImageInfoDto convert(RichMetaImageInfoModel model) {
    return RichMetaImageInfoDto.Builder.aRichMetaImageInfoDto()
            .id(model.getId())
            .imageId(model.getId())
            .metaInfoDto(metaInfoConverter.convert(model.getMetaInfoModel()))
            .tagPositionsDto(tagPositionsConverter.convert(model.getRichTagPositions()))
            .build();
  }
}
