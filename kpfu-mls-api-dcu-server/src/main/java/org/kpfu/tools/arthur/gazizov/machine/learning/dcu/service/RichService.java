package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.rich.RichDataSetModel;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public interface RichService {
  RichDataSetModel loadReachDataSet(Long dataSetId);
}
