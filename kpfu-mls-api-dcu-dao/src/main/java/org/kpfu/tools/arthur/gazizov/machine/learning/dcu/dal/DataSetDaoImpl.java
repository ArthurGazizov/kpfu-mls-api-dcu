package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.MetaInfoModel;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
// TODO: 09.11.17 implement
@Repository
public class DataSetDaoImpl implements DataSetDao {
  private final Map<Long, DataSetModel> storage = new HashMap<>();

  @Override
  public DataSetModel save(DataSetModel model) {
    Long id = null;
    while (id == null || storage.containsKey(id)) {
      id = 1L * Math.abs(ThreadLocalRandom.current().nextInt());
    }
    model.setId(id);
    final MetaInfoModel metaInfoModel = MetaInfoModel.Builder.aMetaInfoEntity()
            .createdTs(LocalDateTime.now().minusDays(1L))
            .updatedTs(LocalDateTime.now())
            .build();
    model.setMetaInfoModel(metaInfoModel);
    storage.put(id, model);
    return storage.get(id);
  }

  @Override
  public DataSetModel update(DataSetModel model) {
    final DataSetModel dataSetModel = storage.get(model.getId());
    if (dataSetModel == null) {
      return dataSetModel;
    }
    dataSetModel.setName(model.getName());
    dataSetModel.getMetaInfoModel().setUpdatedTs(LocalDateTime.now());
    return dataSetModel;
  }

  @Override
  public void delete(DataSetModel model) {
    delete(model.getId());
  }

  @Override
  public void restore(Long id) {

  }

  @Override
  public DataSetModel get(Long id) {
    return storage.get(id);
  }

  @Override
  public void delete(Long id) {
    storage.remove(id);
  }
}
