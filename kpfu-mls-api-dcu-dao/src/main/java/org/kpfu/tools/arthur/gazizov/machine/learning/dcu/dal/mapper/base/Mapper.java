package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.base;

import org.jooq.Record;
import org.jooq.UpdatableRecord;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.Model;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
public interface Mapper<T extends Model, R extends UpdatableRecord<R>> {
  T mapToModel(Record record);

  R mapToEntity(T model);
}
