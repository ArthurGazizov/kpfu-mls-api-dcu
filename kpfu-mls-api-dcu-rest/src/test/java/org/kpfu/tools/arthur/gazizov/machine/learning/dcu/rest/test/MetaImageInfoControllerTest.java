package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.test;

import org.junit.Assert;
import org.junit.Test;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.client.DcuClient;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.TagDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image.MetaImageInfoDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image.TagPositionDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image.TagPositionsDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.support.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 28/11/2017.
 */
@Sql(
        scripts = "classpath:clear.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)
public class MetaImageInfoControllerTest extends AbstractTest {
  @Autowired
  private DcuClient dcuClient;

  @Test
  public void testCrud() {
    final TagDto tagDto = dcuClient.saveTag(generateTag());
    final List<TagDto> tags = Collections.singletonList(tagDto);

    final MetaImageInfoDto toSave = generateMetaImageInfo(tags);

    final MetaImageInfoDto saved = dcuClient.saveMetaImageInfo(toSave);
    checkForNotNull(saved);
    assertEquals(toSave, saved, false);

    final MetaImageInfoDto metaImageInfo = dcuClient.getMetaImageInfo(saved.getId());
    checkForNotNull(metaImageInfo);
    assertEquals(saved, metaImageInfo, true);

    metaImageInfo.setImageId(ThreadLocalRandom.current().nextLong());
    metaImageInfo.setOriginalFilename(randomName());

    final MetaImageInfoDto updateMetaImageInfo = dcuClient.updateMetaImageInfo(metaImageInfo);
    checkForNotNull(updateMetaImageInfo);
    assertEquals(metaImageInfo, updateMetaImageInfo, true);

    for (int i = 0; i < 10; i++) {
      dcuClient.saveMetaImageInfo(generateMetaImageInfo(tags));
    }
    final List<MetaImageInfoDto> allMetaImageInfos = dcuClient.findAllMetaImageInfos();
    Assert.assertEquals(11, allMetaImageInfos.size());

    final PageResponse<MetaImageInfoDto> metaImageInfoDtoPageResponse = dcuClient.pageMetaImageInfos(4, 8);
    Assert.assertEquals(11, metaImageInfoDtoPageResponse.getTotal().intValue());
    Assert.assertEquals(8, metaImageInfoDtoPageResponse.getOffset().intValue());
    Assert.assertEquals(3, metaImageInfoDtoPageResponse.getData().size());
  }

  private void assertEquals(MetaImageInfoDto expected, MetaImageInfoDto found, boolean assertId) {
    Assert.assertEquals(expected.getImageId(), found.getImageId());
    Assert.assertEquals(expected.getOriginalFilename(), found.getOriginalFilename());
    assertEquals(expected.getTagPositionsDto(), found.getTagPositionsDto());
    if (assertId) {
      Assert.assertEquals(expected.getId(), found.getId());
    }
  }

  private void assertEquals(TagPositionsDto expected, TagPositionsDto found) {
    final List<TagPositionDto> expectedData = expected.getData();
    final List<TagPositionDto> foundData = found.getData();
    Assert.assertEquals(expectedData.size(), foundData.size());
  }

  private void checkForNotNull(MetaImageInfoDto metaImageInfoDto) {
    checkBaseDtoForNotNull(metaImageInfoDto);
    Assert.assertNotNull(metaImageInfoDto.getId());
    Assert.assertNotNull(metaImageInfoDto.getImageId());
    Assert.assertNotNull(metaImageInfoDto.getOriginalFilename());
    Assert.assertNotNull(metaImageInfoDto.getTagPositionsDto());
  }
}
