package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetModel;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
public interface DataSetService {
  DataSetModel get(Long id);

  DataSetModel save(DataSetModel model);

  DataSetModel update(DataSetModel model);

  DataSetModel patch(DataSetModel model);

  void delete(Long id);

  DataSetModel restore(Long id);
}
