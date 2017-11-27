package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.test;

import org.junit.Assert;
import org.junit.Test;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.client.DcuClient;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.TagDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.support.PageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 28/11/2017.
 */
@Sql(
        scripts = "classpath:clear.sql",
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
)
public class TagControllerTest extends AbstractTest {
  @Autowired
  private DcuClient dcuClient;

  @Test
  public void testCrud() {
    final TagDto toSave = generateTag();
    final TagDto saved = dcuClient.saveTag(toSave);

    checkForNotNull(saved);
    assertEquals(toSave, saved, false);

    final TagDto tagDto = dcuClient.getTag(saved.getId());
    checkForNotNull(tagDto);
    assertEquals(saved, tagDto, true);

    tagDto.setCode(randomName());
    tagDto.setName(randomName());

    final TagDto updateTag = dcuClient.updateTag(tagDto);
    checkForNotNull(updateTag);
    assertEquals(tagDto, updateTag, true);

    for (int i = 0; i < 10; i++) {
      dcuClient.saveTag(generateTag());
    }

    final List<TagDto> allTags = dcuClient.findAllTags();
    Assert.assertEquals(11, allTags.size());

    final PageResponse<TagDto> tagDtoPageResponse = dcuClient.pageTags(7, 5);
    Assert.assertEquals(11, tagDtoPageResponse.getTotal().intValue());
    Assert.assertEquals(5, tagDtoPageResponse.getOffset().intValue());
    Assert.assertEquals(6, tagDtoPageResponse.getData().size());
  }

  private void assertEquals(TagDto expected, TagDto found, boolean assertId) {
    Assert.assertEquals(expected.getCode(), found.getCode());
    Assert.assertEquals(expected.getName(), found.getName());
    if (assertId) {
      Assert.assertEquals(expected.getId(), found.getId());
    }
  }

  private void checkForNotNull(TagDto tagDto) {
    checkBaseDtoForNotNull(tagDto);
    Assert.assertNotNull(tagDto.getId());
    Assert.assertNotNull(tagDto.getCode());
    Assert.assertNotNull(tagDto.getName());
  }
}
