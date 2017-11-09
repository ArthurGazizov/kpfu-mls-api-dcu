package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.DataSetDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.exception.KpfuMlsDcuError;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.MetaInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    return dataSetDao.update(model);
  }

  @Override
  public void delete(Long id) {
    final DataSetModel dataSetModel = Optional.ofNullable(dataSetDao.get(id))
            .orElseThrow(KpfuMlsDcuError.DATA_SET_NOT_FOUND::exception);

    dataSetModel.setDeleted(true);
    final MetaInfoModel metaInfoEntity = dataSetModel.getMetaInfoModel();
    metaInfoEntity.setDeletedTs(LocalDateTime.now());
  }

  @Override
  public DataSetModel restore(Long id) {
    return null;
  }
}
