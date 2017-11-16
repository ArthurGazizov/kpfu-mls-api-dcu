package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal;

import org.jooq.Field;
import org.jooq.Table;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.base.AbstractCRUDDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.jooq.kpfu_dcu_data.tables.records.TagRecord;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.base.Mapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.interfaces.TagMapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.TagModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.jooq.kpfu_dcu_data.tables.Tag.TAG;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Repository
public class TagDaoImpl extends AbstractCRUDDao<TagModel, TagRecord> implements TagDao {
  @Autowired
  private TagMapper tagMapper;

  @Override
  protected Table<TagRecord> table() {
    return TAG;
  }

  @Override
  protected Mapper<TagModel, TagRecord> mapper() {
    return tagMapper;
  }

  @Override
  protected Field<Long> idField() {
    return TAG.TAG_ID;
  }
}
