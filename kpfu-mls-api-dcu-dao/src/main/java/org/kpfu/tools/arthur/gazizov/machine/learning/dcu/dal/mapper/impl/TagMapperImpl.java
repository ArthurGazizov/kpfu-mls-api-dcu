package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.impl;

import org.jooq.Record;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.jooq.kpfu_dcu_data.tables.records.TagRecord;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.interfaces.TagMapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.MetaInfoModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.TagModel;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import static org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.jooq.kpfu_dcu_data.tables.Tag.TAG;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Component
public class TagMapperImpl implements TagMapper {
  @Override
  public TagModel mapToModel(Record record) {
    if (record == null) {
      return null;
    }
    return TagModel.Builder.aTagModel()
            .id(record.getValue(TAG.TAG_ID))
            .name(record.getValue(TAG.TAG_NAME))
            .code(record.getValue(TAG.TAG_CODE))
            .isDeleted(record.getValue(TAG.TAG_IS_DELETED))
            .metaInfoModel(
                    MetaInfoModel.Builder.aMetaInfoEntity()
                            .createdTs(
                                    Optional.ofNullable(record.getValue(TAG.TAG_CREATED_TS))
                                            .map(Timestamp::toLocalDateTime)
                                            .orElse(null))
                            .updatedTs(
                                    Optional.ofNullable(record.getValue(TAG.TAG_UPDATED_TS))
                                            .map(Timestamp::toLocalDateTime)
                                            .orElse(null))
                            .deletedTs(
                                    Optional.ofNullable(record.getValue(TAG.TAG_DELETED_TS))
                                            .map(Timestamp::toLocalDateTime)
                                            .orElse(null))
                            .build()
            )
            .build();
  }

  @Override
  public TagRecord mapToEntity(TagModel model) {
    final TagRecord record = new TagRecord();
    record.setTagName(model.getName());
    record.setTagCode(model.getCode());
    record.setTagIsDeleted(Optional.ofNullable(model.getDeleted()).orElse(false));
    final MetaInfoModel metaInfoModel = model.getMetaInfoModel();
    if (Objects.nonNull(metaInfoModel)) {
      if (Objects.nonNull(metaInfoModel.getCreatedTs())) {
        record.setTagCreatedTs(Timestamp.valueOf(metaInfoModel.getCreatedTs()));
      }
      if (Objects.nonNull(metaInfoModel.getDeletedTs())) {
        record.setTagDeletedTs(Timestamp.valueOf(metaInfoModel.getDeletedTs()));
      }
    }
    record.setTagUpdatedTs(Timestamp.valueOf(LocalDateTime.now()));
    return record;
  }
}
