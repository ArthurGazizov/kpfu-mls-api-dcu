package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.test;

import org.junit.Assert;
import org.junit.Test;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.client.DcuClient;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetElementDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.support.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 27/11/2017.
 */
@Sql(
        scripts = "classpath:clear.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)
public class DataSetElementControllerTest extends AbstractTest {
  @Autowired
  private DcuClient dcuClient;

  @Test
  public void testCrud() {
    final DataSetDto toSaveDataSetDto = generateDataSet();

    final DataSetDto dataSetDto = dcuClient.saveDataSet(toSaveDataSetDto);

    final DataSetElementDto toSave = generateDataSetElement(dataSetDto);
    final DataSetElementDto saved = dcuClient.saveDataSetElement(toSave);

    checkForNotNull(saved);
    assertEquals(toSave, saved, false);

    final DataSetElementDto dataSetElement = dcuClient.getDataSetElement(saved.getId());
    checkForNotNull(dataSetElement);
    assertEquals(saved, dataSetElement, true);

    dataSetElement.setImageId(ThreadLocalRandom.current().nextLong());
    final DataSetElementDto updated = dcuClient.updateDataSetElement(dataSetElement);
    checkForNotNull(updated);
    assertEquals(dataSetElement, updated, true);
    checkBaseDtoPatchOrUpdateMetaInfo(dataSetElement, updated);

    for (int i = 0; i < 10; i++) {
      dcuClient.saveDataSetElement(generateDataSetElement(dataSetDto));
    }
    final List<DataSetElementDto> all = dcuClient.findAllDataSetElements();
    Assert.assertEquals(11, all.size());

    final PageResponse<DataSetElementDto> page = dcuClient.pageDataSetElements(4, 5);
    Assert.assertEquals(11, page.getTotal().intValue());
    Assert.assertEquals(4, page.getData().size());
    Assert.assertEquals(5, page.getOffset().intValue());


    final DataSetDto other = dcuClient.saveDataSet(generateDataSet());
    for (int i = 0; i < 5; i++) {
      dcuClient.saveDataSetElement(generateDataSetElement(other));
    }
    final Integer count = dcuClient.elementsCountInDataSet(other.getId());
    Assert.assertEquals(5, count.intValue());

    final PageResponse<DataSetElementDto> dataSetElementDtoPageResponse = dcuClient.pageDataSetElements(dataSetDto.getId(), 5, 10);
    Assert.assertEquals(11, dataSetElementDtoPageResponse.getTotal().intValue());
    Assert.assertEquals(1, dataSetElementDtoPageResponse.getData().size());
    Assert.assertEquals(10, dataSetElementDtoPageResponse.getOffset().intValue());
  }

  private void assertEquals(DataSetElementDto expected, DataSetElementDto found, boolean assertId) {
    Assert.assertEquals(expected.getDatasetId(), found.getDatasetId());
    Assert.assertEquals(expected.getImageId(), found.getImageId());
    if (assertId) {
      Assert.assertEquals(expected.getId(), found.getId());
    }
  }

  private void checkForNotNull(DataSetElementDto dataSetElementDto) {
    checkBaseDtoForNotNull(dataSetElementDto);
    Assert.assertNotNull(dataSetElementDto.getId());
    Assert.assertNotNull(dataSetElementDto.getDatasetId());
    Assert.assertNotNull(dataSetElementDto.getImageId());
  }
}
