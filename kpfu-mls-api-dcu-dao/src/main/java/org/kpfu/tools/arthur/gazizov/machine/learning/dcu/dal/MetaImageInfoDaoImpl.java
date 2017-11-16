package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal;

import org.jooq.Field;
import org.jooq.Table;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.base.AbstractCRUDDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.jooq.kpfu_dcu_data.tables.records.MetaImageInfoRecord;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.base.Mapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.interfaces.MetaImageInfoMapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image.MetaImageInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.jooq.kpfu_dcu_data.tables.MetaImageInfo.META_IMAGE_INFO;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Repository
public class MetaImageInfoDaoImpl extends AbstractCRUDDao<MetaImageInfoModel, MetaImageInfoRecord> implements MetaImageInfoDao {
  @Autowired
  private MetaImageInfoMapper metaImageInfoMapper;

  @Override
  protected Table<MetaImageInfoRecord> table() {
    return META_IMAGE_INFO;
  }

  @Override
  protected Mapper<MetaImageInfoModel, MetaImageInfoRecord> mapper() {
    return metaImageInfoMapper;
  }

  @Override
  protected Field<Long> idField() {
    return META_IMAGE_INFO.META_IMAGE_INFO_ID;
  }
}
