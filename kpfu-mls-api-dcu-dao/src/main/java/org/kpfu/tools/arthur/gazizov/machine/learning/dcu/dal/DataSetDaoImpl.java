package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal;

import org.jooq.Field;
import org.jooq.Table;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.base.AbstractCRUDDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.jooq.kpfu_dcu_data.tables.DataSet;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.jooq.kpfu_dcu_data.tables.records.DataSetRecord;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.base.Mapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.interfaces.DataSetMapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
@Repository
public class DataSetDaoImpl extends AbstractCRUDDao<DataSetModel, DataSetRecord> implements DataSetDao {
  @Autowired
  private DataSetMapper dataSetMapper;

  @Override
  protected Table<DataSetRecord> table() {
    return DataSet.DATA_SET;
  }

  @Override
  protected Mapper<DataSetModel, DataSetRecord> mapper() {
    return dataSetMapper;
  }

  @Override
  protected Field<Long> idField() {
    return DataSet.DATA_SET.DATA_SET_ID;
  }
}
