package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.base;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.EntityModel;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
public interface BaseDao<T extends EntityModel> {
  T save(T model);

  T update(T model);

  void delete(T model);

  void restore(Long id);

  T get(Long id);

  void delete(Long id);
}
