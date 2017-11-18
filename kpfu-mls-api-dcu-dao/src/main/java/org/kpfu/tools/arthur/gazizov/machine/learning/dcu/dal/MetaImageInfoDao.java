package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.base.CRUDDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image.MetaImageInfoModel;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public interface MetaImageInfoDao extends CRUDDao<Long, MetaImageInfoModel> {
  MetaImageInfoModel findByImageId(Long imageId);
}
