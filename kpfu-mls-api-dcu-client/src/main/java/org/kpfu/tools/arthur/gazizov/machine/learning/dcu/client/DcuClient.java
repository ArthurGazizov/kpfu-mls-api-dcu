package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.client;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetElementDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.TagDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image.MetaImageInfoDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.support.PageResponse;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 25/11/2017.
 */
public interface DcuClient {
  DataSetDto saveDataSet(DataSetDto dataSetDto);

  DataSetDto getDataSet(Long dataSetId);

  DataSetDto updateDataSet(DataSetDto dataSetDto);

  DataSetDto patchDataSet(DataSetDto dataSetDto);

  List<DataSetDto> findAllDataSets();

  PageResponse<DataSetDto> pageDataSets(Integer limit, Integer offset);

  DataSetElementDto saveDataSetElement(DataSetElementDto dataSetElementDto);

  DataSetElementDto getDataSetElement(Long dataSetElementId);

  DataSetElementDto updateDataSetElement(DataSetElementDto dataSetElementDto);

  DataSetElementDto patchDataSetElement(DataSetElementDto dataSetElementDto);

  List<DataSetElementDto> findAllDataSetElements();

  PageResponse<DataSetElementDto> pageDataSetElements(Integer limit, Integer offset);

  Integer elementsCountInDataSet(Long dataSetId);

  PageResponse<DataSetElementDto> pageDataSetElements(Long dataSetId, Integer limit, Integer offset);

  TagDto saveTag(TagDto tagDto);

  TagDto getTag(Long tagId);

  TagDto updateTag(TagDto tagDto);

  TagDto patchTag(TagDto tagDto);

  List<TagDto> findAllTags();

  PageResponse<TagDto> pageTags(Integer limit, Integer offset);

  MetaImageInfoDto saveMetaImageInfo(MetaImageInfoDto metaImageInfoDto);

  MetaImageInfoDto getMetaImageInfo(Long metaImageInfoId);

  MetaImageInfoDto updateMetaImageInfo(MetaImageInfoDto metaImageInfoDto);

  MetaImageInfoDto patchMetaImageInfo(MetaImageInfoDto metaImageInfoDto);

  List<MetaImageInfoDto> findAllMetaImageInfos();

  PageResponse<MetaImageInfoDto> pageMetaImageInfos(Integer limit, Integer offset);
}
