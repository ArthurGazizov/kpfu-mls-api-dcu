package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetElementModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.support.PageModel;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 12.11.17.
 */
public interface DataSetElementService extends CRUDService<DataSetElementModel> {
  PageModel<DataSetElementModel> searchByDataSetId(Long dataSetId, Integer limit, Integer offset);

  List<DataSetElementModel> searchByDataSetId(Long dataSetId);

  Integer elementsCountInDataSet(Long dataSetId);
}
