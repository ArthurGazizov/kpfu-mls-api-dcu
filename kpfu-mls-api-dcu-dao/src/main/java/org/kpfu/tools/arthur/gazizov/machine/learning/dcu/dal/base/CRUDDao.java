package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.base;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.Model;

import java.io.Serializable;

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

  long count();

  boolean exist(I id);

  E find(I id);

  E restore(I id);
}
