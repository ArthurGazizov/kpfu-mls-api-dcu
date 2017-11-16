package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jooq.Record;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.jooq.kpfu_dcu_data.tables.records.MetaImageInfoRecord;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.interfaces.MetaImageInfoMapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.MetaInfoModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image.MetaImageInfoModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image.pojo.TagPositions;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import static org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.jooq.kpfu_dcu_data.tables.MetaImageInfo.META_IMAGE_INFO;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Component
public class MetaImageInfoMapperImpl implements MetaImageInfoMapper {
  private ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public MetaImageInfoModel mapToModel(Record record) {
    if (record == null) {
      return null;
    }
    return MetaImageInfoModel.Builder.aMetaImageModel()
            .id(record.getValue(META_IMAGE_INFO.META_IMAGE_INFO_ID))
            .imageId(record.getValue(META_IMAGE_INFO.META_IMAGE_INFO_IMAGE_ID))
            .isDeleted(record.getValue(META_IMAGE_INFO.META_IMAGE_INFOT_IS_DELETED))
            .tagPositions(tagPositionsFromString(record.getValue(META_IMAGE_INFO.META_IMAGE_INFO_TAG_POSITIONS)))
            .metaInfoModel(
                    MetaInfoModel.Builder.aMetaInfoEntity()
                            .createdTs(
                                    Optional.ofNullable(record.getValue(META_IMAGE_INFO.META_IMAGE_INFO_CREATED_TS))
                                            .map(Timestamp::toLocalDateTime)
                                            .orElse(null))
                            .updatedTs(
                                    Optional.ofNullable(record.getValue(META_IMAGE_INFO.META_IMAGE_INFO_UPDATED_TS))
                                            .map(Timestamp::toLocalDateTime)
                                            .orElse(null))
                            .deletedTs(
                                    Optional.ofNullable(record.getValue(META_IMAGE_INFO.META_IMAGE_INFO_DELETED_TS))
                                            .map(Timestamp::toLocalDateTime)
                                            .orElse(null))
                            .build()
            )
            .build();
  }

  @Override
  public MetaImageInfoRecord mapToEntity(MetaImageInfoModel model) {
    final MetaImageInfoRecord metaImageInfoRecord = new MetaImageInfoRecord();
    metaImageInfoRecord.setMetaImageInfoImageId(model.getImageId());
    metaImageInfoRecord.setMetaImageInfoTagPositions(tagPositionsToString(model.getTagPositions()));
    metaImageInfoRecord.setMetaImageInfotIsDeleted(Optional.ofNullable(model.getDeleted()).orElse(false));
    final MetaInfoModel metaInfoModel = model.getMetaInfoModel();
    if (Objects.nonNull(metaInfoModel)) {
      if (Objects.nonNull(metaInfoModel.getCreatedTs())) {
        metaImageInfoRecord.setMetaImageInfoCreatedTs(Timestamp.valueOf(metaInfoModel.getCreatedTs()));
      }
      if (Objects.nonNull(metaInfoModel.getDeletedTs())) {
        metaImageInfoRecord.setMetaImageInfoDeletedTs(Timestamp.valueOf(metaInfoModel.getDeletedTs()));
      }
    }
    metaImageInfoRecord.setMetaImageInfoUpdatedTs(Timestamp.valueOf(LocalDateTime.now()));
    return metaImageInfoRecord;
  }

  private TagPositions tagPositionsFromString(String json) {
    try {
      final JsonNode jsonNode = objectMapper.readTree(json);
      return objectMapper.treeToValue(jsonNode, TagPositions.class);
    } catch (IOException e) {
      e.printStackTrace();
      throw new RuntimeException(e);
    }
  }

  private String tagPositionsToString(TagPositions tagPositions) {
    try {
      return objectMapper.writeValueAsString(tagPositions);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }
}
