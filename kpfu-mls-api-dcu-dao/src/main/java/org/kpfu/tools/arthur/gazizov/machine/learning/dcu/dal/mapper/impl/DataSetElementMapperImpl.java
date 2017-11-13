package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.impl;

import org.jooq.Record;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.jooq.kpfu_dcu_data.tables.records.DataSetElementRecord;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.interfaces.DataSetElementMapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetElementModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.MetaInfoModel;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import static org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.jooq.kpfu_dcu_data.tables.DataSetElement.DATA_SET_ELEMENT;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 12.11.17.
 */
public class DataSetElementMapperImpl implements DataSetElementMapper {
  @Override
  public DataSetElementModel mapToModel(Record record) {
    if (record == null) {
      return null;
    }
    return DataSetElementModel.Builder.aDataSetElementModel()
            .id(record.getValue(DATA_SET_ELEMENT.DATA_SET_ELEMENT_ID))
            .datasetId(record.getValue(DATA_SET_ELEMENT.DATA_SET_ID))
            .imageId(record.getValue(DATA_SET_ELEMENT.DATA_SET_ELEMENT_IMAGE_ID))
            .isDeleted(record.getValue(DATA_SET_ELEMENT.DATA_SET_ELEMENT_IS_DELETED))
            .metaInfoModel(
                    MetaInfoModel.Builder.aMetaInfoEntity()
                            .createdTs(
                                    Optional.ofNullable(record.getValue(DATA_SET_ELEMENT.DATA_SET_ELEMENT_CREATED_TS))
                                            .map(Timestamp::toLocalDateTime)
                                            .orElse(null))
                            .updatedTs(
                                    Optional.ofNullable(record.getValue(DATA_SET_ELEMENT.DATA_SET_ELEMENT_UPDATED_TS))
                                            .map(Timestamp::toLocalDateTime)
                                            .orElse(null))
                            .deletedTs(
                                    Optional.ofNullable(record.getValue(DATA_SET_ELEMENT.DATA_SET_ELEMENT_DELETED_TS))
                                            .map(Timestamp::toLocalDateTime)
                                            .orElse(null))
                            .build()
            )
            .build();
  }

  @Override
  public DataSetElementRecord mapToEntity(DataSetElementModel model) {
    final DataSetElementRecord dataSetElementRecord = new DataSetElementRecord();
    dataSetElementRecord.setDataSetElementId(model.getDatasetId());
    dataSetElementRecord.setDataSetId(model.getDatasetId());
    dataSetElementRecord.setDataSetElementImageId(model.getImageId());
    dataSetElementRecord.setDataSetElementIsDeleted(Optional.ofNullable(model.getDeleted()).orElse(false));
    final MetaInfoModel metaInfoModel = model.getMetaInfoModel();
    if (Objects.nonNull(metaInfoModel)) {
      if (Objects.nonNull(metaInfoModel.getCreatedTs())) {
        dataSetElementRecord.setDataSetElementCreatedTs(Timestamp.valueOf(metaInfoModel.getCreatedTs()));
      }
      if (Objects.nonNull(metaInfoModel.getDeletedTs())) {
        dataSetElementRecord.setDataSetElementDeletedTs(Timestamp.valueOf(metaInfoModel.getDeletedTs()));
      }
    }
    dataSetElementRecord.setDataSetElementUpdatedTs(Timestamp.valueOf(LocalDateTime.now()));
    return dataSetElementRecord;
  }
}
