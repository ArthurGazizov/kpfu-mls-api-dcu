package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.DataSetDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.exception.KpfuMlsDcuError;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
@Service
public class DataSetServiceImpl implements DataSetService {
  @Autowired
  private DataSetDao dataSetDao;

  @Override
  public DataSetModel get(Long id) {
    return Optional.of(id)
            .map(dataSetDao::get)
            .orElseThrow(KpfuMlsDcuError.DATA_SET_NOT_FOUND::exception);
  }

  @Override
  public DataSetModel save(DataSetModel model) {
    return dataSetDao.save(model);
  }

  @Override
  public DataSetModel update(DataSetModel model) {
    return dataSetDao.update(model);
  }

  @Override
  public DataSetModel patch(DataSetModel model) {
    final DataSetModel dataSetModel = Optional.ofNullable(dataSetDao.get(model.getId()))
            .orElseThrow(KpfuMlsDcuError.DATA_SET_NOT_FOUND::exception);
    if (StringUtils.hasText(model.getName())) {
      dataSetModel.setName(model.getName());
    }
    return dataSetDao.update(dataSetModel);
  }

  @Override
  public void delete(Long id) {
    dataSetDao.delete(id);
  }

  @Override
  public DataSetModel restore(Long id) {
    dataSetDao.restore(id);
    return get(id);
  }
}
