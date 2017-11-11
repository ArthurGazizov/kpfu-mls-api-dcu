package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.Model;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
public interface CRUDService<T extends Model> {
  T get(Long id);

  T save(T t);

  T update(T t);

  T patch(T t);

  void delete(Long id);

  T restore(Long id);

  List<T> findAll();
}
