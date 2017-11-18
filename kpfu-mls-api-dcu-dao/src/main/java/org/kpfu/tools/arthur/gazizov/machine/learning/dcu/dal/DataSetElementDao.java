package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.base.CRUDDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetElementModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.support.PageModel;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 12.11.17.
 */
public interface DataSetElementDao extends CRUDDao<Long, DataSetElementModel> {
  PageModel<DataSetElementModel> searchByDataSetId(Long dataSetId, Integer limit, Integer offset);

  List<DataSetElementModel> searchByDataSetId(Long dataSetId);

  Integer elementsCountInDataSet(Long dataSetId);
}
