package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.test;

import org.junit.Assert;
import org.junit.Test;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.DataSetDao;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
public class DataSetDaoTest extends AbstractDaoTest {
  @Autowired
  private DataSetDao dataSetDao;

  @Test
  public void test() {
    Assert.assertNotNull(dataSetDao);
  }
}
