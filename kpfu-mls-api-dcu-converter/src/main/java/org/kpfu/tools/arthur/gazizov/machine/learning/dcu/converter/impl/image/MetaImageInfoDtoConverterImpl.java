package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.image;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.annotation.Conversion;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.MetaInfoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.image.MetaImageInfoDtoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.image.support.TagPositionsDtoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image.MetaImageInfoDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image.MetaImageInfoModel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Conversion(dto = MetaImageInfoDto.class, model = MetaImageInfoModel.class)
public class MetaImageInfoDtoConverterImpl implements MetaImageInfoDtoConverter {
  @Autowired
  private MetaInfoConverter metaInfoConverter;

  @Autowired
  private TagPositionsDtoConverter tagPositionsDtoConverter;

  @Override
  public MetaImageInfoDto convert(MetaImageInfoModel model) {
    return MetaImageInfoDto.Builder.aMetaImageDto()
            .id(model.getId())
            .imageId(model.getImageId())
            .metaInfoDto(metaInfoConverter.convert(model.getMetaInfoModel()))
            .tagPositionsDto(tagPositionsDtoConverter.convert(model.getTagPositions()))
            .originalFilename(model.getOriginalFilename())
            .build();
  }

  @Override
  public MetaImageInfoModel convert(MetaImageInfoDto dto) {
    return MetaImageInfoModel.Builder.aMetaImageModel()
            .id(dto.getId())
            .imageId(dto.getImageId())
            .metaInfoModel(metaInfoConverter.convert(dto.getMetaInfoDto()))
            .tagPositions(tagPositionsDtoConverter.convert(dto.getTagPositionsDto()))
            .originalFilename(dto.getOriginalFilename())
            .build();
  }
}
