package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.test;

import org.junit.Assert;
import org.junit.Test;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.client.DcuClient;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.support.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 25/11/2017.
 */
@Sql(
        scripts = "classpath:clear.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)
public class DataSetControllerTest extends AbstractTest {
  @Autowired
  private DcuClient dcuClient;

  @Test
  public void testCrud() {
    final DataSetDto toSave = generateDataSet();

    final DataSetDto saved = dcuClient.saveDataSet(toSave);
    checkForNotNull(saved);
    assertEquals(toSave, saved, false);

    final DataSetDto dataSetDto = dcuClient.getDataSet(saved.getId());
    checkForNotNull(dataSetDto);
    assertEquals(saved, dataSetDto, true);

    dataSetDto.setName(randomName());
    final DataSetDto update = dcuClient.updateDataSet(dataSetDto);
    checkForNotNull(update);
    assertEquals(dataSetDto, update, true);
    checkBaseDtoPatchOrUpdateMetaInfo(dataSetDto, update);

    for (int i = 0; i < 10; i++) {
      dcuClient.saveDataSet(generateDataSet());
    }
    final List<DataSetDto> all = dcuClient.findAllDataSets();
    Assert.assertEquals(11, all.size());

    final PageResponse<DataSetDto> page = dcuClient.pageDataSets(10, 5);
    Assert.assertEquals(11, page.getTotal().intValue());
    Assert.assertEquals(6, page.getData().size());
    Assert.assertEquals(5, page.getOffset().intValue());
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
