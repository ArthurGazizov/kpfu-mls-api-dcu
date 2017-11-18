package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.rich;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.annotation.Conversion;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.MetaInfoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.rich.RichDataSetElementConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.rich.RichMetaImageInfoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.rich.RichDataSetElementDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.rich.RichDataSetElementModel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Conversion(dto = RichDataSetElementDto.class, model = RichDataSetElementModel.class)
public class RichDataSetElementConverterImpl implements RichDataSetElementConverter {
  @Autowired
  private MetaInfoConverter metaInfoConverter;

  @Autowired
  private RichMetaImageInfoConverter richMetaImageInfoConverter;

  @Override
  public RichDataSetElementDto convert(RichDataSetElementModel model) {
    return RichDataSetElementDto.Builder.aRichDataSetElementDto()
            .id(model.getId())
            .metaInfoDto(metaInfoConverter.convert(model.getMetaInfoModel()))
            .richMetaImageInfoDto(richMetaImageInfoConverter.convert(model.getRichMetaImageInfoModel()))
            .build();
  }
}
