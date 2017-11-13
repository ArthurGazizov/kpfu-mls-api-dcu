package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.impl;

import org.jooq.Record;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.jooq.kpfu_dcu_data.tables.records.DataSetRecord;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.interfaces.DataSetMapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.MetaInfoModel;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import static org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.jooq.kpfu_dcu_data.tables.DataSet.DATA_SET;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
@Component
public class DataSetMapperImpl implements DataSetMapper {
  @Override
  public DataSetModel mapToModel(Record record) {
    if (record == null) {
      return null;
    }
    return DataSetModel.Builder.aDataSetModel()
            .id(record.getValue(DATA_SET.DATA_SET_ID))
            .name(record.getValue(DATA_SET.DATA_SET_NAME))
            .isDeleted(record.getValue(DATA_SET.DATA_SET_IS_DELETED))
            .metaInfoModel(
                    MetaInfoModel.Builder.aMetaInfoEntity()
                            .createdTs(
                                    Optional.ofNullable(record.getValue(DATA_SET.DATA_SET_CREATED_TS))
                                            .map(Timestamp::toLocalDateTime)
                                            .orElse(null))
                            .updatedTs(
                                    Optional.ofNullable(record.getValue(DATA_SET.DATA_SET_UPDATED_TS))
                                            .map(Timestamp::toLocalDateTime)
                                            .orElse(null))
                            .deletedTs(
                                    Optional.ofNullable(record.getValue(DATA_SET.DATA_SET_DELETED_TS))
                                            .map(Timestamp::toLocalDateTime)
                                            .orElse(null))
                            .build()
            )
            .build();
  }

  @Override
  public DataSetRecord mapToEntity(DataSetModel model) {
    final DataSetRecord record = new DataSetRecord();
    record.setDataSetName(model.getName());
    record.setDataSetIsDeleted(Optional.ofNullable(model.getDeleted()).orElse(false));
    final MetaInfoModel metaInfoModel = model.getMetaInfoModel();
    if (Objects.nonNull(metaInfoModel)) {
      if (Objects.nonNull(metaInfoModel.getCreatedTs())) {
        record.setDataSetCreatedTs(Timestamp.valueOf(metaInfoModel.getCreatedTs()));
      }
      if (Objects.nonNull(metaInfoModel.getDeletedTs())) {
        record.setDataSetDeletedTs(Timestamp.valueOf(metaInfoModel.getDeletedTs()));
      }
    }
    record.setDataSetUpdatedTs(Timestamp.valueOf(LocalDateTime.now()));
    return record;
  }
}
