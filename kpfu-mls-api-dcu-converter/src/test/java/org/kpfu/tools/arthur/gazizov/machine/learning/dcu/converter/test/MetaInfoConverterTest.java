package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.test;

import org.junit.Assert;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.common.Dto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.meta.MetaInfoDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.MetaInfoModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.Model;

import java.time.LocalDateTime;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 03.11.17.
 */
public class MetaInfoConverterTest extends AbstractConverterTest {
  @Override
  protected Class<? extends Model> model() {
    return MetaInfoModel.class;
  }

  @Override
  protected Class<? extends Dto> dto() {
    return MetaInfoDto.class;
  }

  @Override
  protected Dto generateDto() {
    return MetaInfoDto.Builder.aMetaInfoDto()
            .createdTs(LocalDateTime.now())
            .updatedTs(LocalDateTime.now())
            .build();
  }

  @Override
  protected Model generateModel() {
    return MetaInfoModel.Builder.aMetaInfoEntity()
            .createdTs(LocalDateTime.now())
            .updatedTs(LocalDateTime.now())
            .deletedTs(LocalDateTime.now())
            .build();
  }

  @Override
  protected void checkModelToDtoConversion(Model model, Dto converted) {
    MetaInfoModel metaInfoModel = (MetaInfoModel) model;
    MetaInfoDto metaInfoDto = (MetaInfoDto) converted;

    Assert.assertEquals(metaInfoModel.getCreatedTs(), metaInfoDto.getCreatedTs());
    Assert.assertEquals(metaInfoModel.getUpdatedTs(), metaInfoDto.getUpdatedTs());
  }

  @Override
  protected void checkDtoToModelConversion(Dto dto, Model converted) {
    MetaInfoDto metaInfoDto = (MetaInfoDto) dto;
    MetaInfoModel metaInfoModel = (MetaInfoModel) converted;

    Assert.assertNull(metaInfoModel.getCreatedTs());
    Assert.assertNull(metaInfoModel.getUpdatedTs());
    Assert.assertNull(metaInfoModel.getDeletedTs());
  }
}
