package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.test;

import org.junit.Assert;
import org.junit.Test;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.client.DcuClient;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 25/11/2017.
 */
@Sql(
        scripts = "classpath:clear.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)
public class DataSetCrudTest extends AbstractTest {
  @Autowired
  private DcuClient dcuClient;

  @Test
  public void testCrud() {
    final DataSetDto toSave = generateDataSet();

    final DataSetDto saved = dcuClient.save(toSave);
    checkForNotNull(saved);
    assertEquals(toSave, saved, false);

    final DataSetDto dataSetDto = dcuClient.get(saved.getId());
    checkForNotNull(dataSetDto);
    assertEquals(saved, dataSetDto, true);

    dataSetDto.setName(randomName());
    final DataSetDto update = dcuClient.update(dataSetDto);
    checkForNotNull(update);
    assertEquals(dataSetDto, update, true);
    checkBaseDtoPatchOrUpdateMetaInfo(dataSetDto, update);
  }

  private void assertEquals(DataSetDto expected, DataSetDto found, boolean assertId) {
    Assert.assertEquals(expected.getName(), found.getName());
    if (assertId) {
      Assert.assertEquals(expected.getId(), found.getId());
    }
  }

  private void checkForNotNull(DataSetDto dataSetDto) {
    checkBaseDtoForNotNull(dataSetDto);
    Assert.assertNotNull(dataSetDto.getId());
    Assert.assertNotNull(dataSetDto.getName());
  }
}
