package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.test;

import org.junit.Assert;
import org.junit.Test;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.DataSetDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.MetaInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
@Sql(
        scripts = "classpath:clear.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)

public class DataSetDaoTest extends AbstractDaoTest {
  @Autowired
  private DataSetDao dataSetDao;

  @Test
  public void testCRUD() {
    final DataSetModel dataSetModel = generateDataSet();
    final DataSetModel saved = dataSetDao.save(dataSetModel);
    Assert.assertNotNull(saved.getId());
    Assert.assertEquals(dataSetModel.getName(), saved.getName());
    Assert.assertFalse(saved.getDeleted());
    final MetaInfoModel metaInfoModel = saved.getMetaInfoModel();
    Assert.assertNotNull(metaInfoModel);
    Assert.assertNotNull(metaInfoModel.getCreatedTs());
    Assert.assertNotNull(metaInfoModel.getUpdatedTs());
    Assert.assertNull(metaInfoModel.getDeletedTs());

    final DataSetModel find = dataSetDao.find(saved.getId());
    Assert.assertEquals(saved.getId(), find.getId());
    Assert.assertEquals(saved.getName(), find.getName());
    Assert.assertEquals(saved.getDeleted(), find.getDeleted());
    final MetaInfoModel findMetaInfo = find.getMetaInfoModel();
    Assert.assertNotNull(findMetaInfo);
    Assert.assertEquals(metaInfoModel.getCreatedTs(), findMetaInfo.getCreatedTs());
    Assert.assertEquals(metaInfoModel.getUpdatedTs(), findMetaInfo.getUpdatedTs());
    Assert.assertEquals(metaInfoModel.getDeletedTs(), findMetaInfo.getDeletedTs());

    find.setName(UUID.randomUUID().toString());
    final DataSetModel update = dataSetDao.update(find);
    Assert.assertEquals(find.getId(), update.getId());
    Assert.assertNotEquals(saved.getName(), update.getName());
    Assert.assertEquals(saved.getDeleted(), update.getDeleted());
    Assert.assertEquals(find.getName(), update.getName());
    final MetaInfoModel updateMetaInfoModel = update.getMetaInfoModel();
    Assert.assertNotNull(updateMetaInfoModel);
    Assert.assertEquals(metaInfoModel.getCreatedTs(), updateMetaInfoModel.getCreatedTs());
    Assert.assertNotEquals(metaInfoModel.getUpdatedTs(), updateMetaInfoModel.getUpdatedTs());
    Assert.assertEquals(metaInfoModel.getDeletedTs(), updateMetaInfoModel.getDeletedTs());

    final long count = dataSetDao.count();
    Assert.assertTrue(1 == count);
    final List<DataSetModel> all = StreamSupport.stream(dataSetDao.findAll().spliterator(), false).collect(Collectors.toList());
    Assert.assertTrue(1 == all.size());

    dataSetDao.delete(saved.getId());
    Assert.assertTrue(0 == dataSetDao.count());
  }
}
