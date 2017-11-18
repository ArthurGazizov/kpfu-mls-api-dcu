package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal;

import org.jooq.Field;
import org.jooq.Table;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.base.AbstractCRUDDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.jooq.kpfu_dcu_data.tables.records.DataSetElementRecord;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.base.Mapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.interfaces.DataSetElementMapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetElementModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.support.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.jooq.kpfu_dcu_data.tables.DataSetElement.DATA_SET_ELEMENT;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 12.11.17.
 */
@Repository
public class DataSetElementDaoImpl extends AbstractCRUDDao<DataSetElementModel, DataSetElementRecord> implements DataSetElementDao {
  @Autowired
  private DataSetElementMapper dataSetElementMapper;

  @Override
  protected Table<DataSetElementRecord> table() {
    return DATA_SET_ELEMENT;
  }

  @Override
  protected Mapper<DataSetElementModel, DataSetElementRecord> mapper() {
    return dataSetElementMapper;
  }

  @Override
  protected Field<Long> idField() {
    return DATA_SET_ELEMENT.DATA_SET_ELEMENT_ID;
  }

  @Override
  public PageModel<DataSetElementModel> searchByDataSetId(Long dataSetId, Integer limit, Integer offset) {
    return search(Collections.singletonList(DATA_SET_ELEMENT.DATA_SET_ID.eq(dataSetId)), limit, offset);
  }

  @Override
  public List<DataSetElementModel> searchByDataSetId(Long dataSetId) {
    return StreamSupport.stream(findAll(Collections.singletonList(DATA_SET_ELEMENT.DATA_SET_ID.eq(dataSetId))).spliterator(), false)
            .collect(Collectors.toList());
  }

  @Override
  public Integer elementsCountInDataSet(Long dataSetId) {
    return (int) count(Collections.singletonList(DATA_SET_ELEMENT.DATA_SET_ID.eq(dataSetId)));
  }
}
