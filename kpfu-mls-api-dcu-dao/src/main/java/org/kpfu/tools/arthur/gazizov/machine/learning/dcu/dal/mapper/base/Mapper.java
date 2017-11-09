package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.base;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.Model;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
public interface Mapper<T extends Model, E> {
  T mapToModel(E entity);

  E mapToEntity(T model);
}
