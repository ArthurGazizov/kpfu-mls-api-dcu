package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.base;

import org.jooq.Condition;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.Model;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.support.PageModel;

import java.io.Serializable;
import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
public interface CRUDDao<I extends Serializable, E extends Model> {
  E save(E e);

  Iterable<E> save(Iterable<E> iterable);

  E update(E e);

  void delete(E e);

  void delete(I id);

  void deleteAll();

  void deleteAll(Iterable<I> iterable);

  Iterable<E> findAll();

  Iterable<E> findAll(Iterable<I> iterable);

  PageModel<E> findAll(Integer limit, Integer offset);

  PageModel<E> search(List<Condition> conditions, Integer limit, Integer offset);

  long count();

  boolean exist(I id);

  E find(I id);

  E restore(I id);
}
