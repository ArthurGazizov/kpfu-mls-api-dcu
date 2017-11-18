package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetElementModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.TagModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image.MetaImageInfoModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image.pojo.TagPositions;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.rich.RichMetaImageInfoModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.rich.RichDataSetElementModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.rich.RichDataSetModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.rich.RichTagModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.rich.RichTagPosition;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.rich.RichTagPositions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Service
public class RichServiceImpl implements RichService {
  @Autowired
  private DataSetService dataSetService;

  @Autowired
  private DataSetElementService dataSetElementService;

  @Autowired
  private MetaImageInfoService metaImageInfoService;

  @Autowired
  private TagService tagService;

  @Override
  public RichDataSetModel loadReachDataSet(Long dataSetId) {
    final DataSetModel dataSetModel = dataSetService.get(dataSetId);
    final List<DataSetElementModel> dataSetElementModels = dataSetElementService.searchByDataSetId(dataSetId);
    final Map<Long, MetaImageInfoModel> mapElementImageInfo = dataSetElementModels.stream().collect(Collectors.toMap(e -> e.getId(), e -> metaImageInfoService.findByImageId(e.getImageId())));

    final List<RichDataSetElementModel> richDataSetElementModels = dataSetElementModels.stream()
            .map(dataSetElementModel -> RichDataSetElementModel.Builder
                    .aRichDataSetElementModel()
                    .id(dataSetElementModel.getId())
                    .isDeleted(dataSetElementModel.getDeleted())
                    .metaInfoModel(dataSetElementModel.getMetaInfoModel())
                    .reachMetaImageInfoModel(
                            Optional.of(mapElementImageInfo.get(dataSetElementModel.getId()))
                                    .map(mi ->
                                            RichMetaImageInfoModel.Builder
                                                    .aReachMetaImageInfoModel()
                                                    .id(mi.getId())
                                                    .imageId(mi.getImageId())
                                                    .isDeleted(mi.getDeleted())
                                                    .metaInfoModel(mi.getMetaInfoModel())
                                                    .richTagPositions(richTagPositions(mi.getTagPositions()))
                                                    .build()
                                    ).orElse(null))
                    .build()
            )
            .collect(Collectors.toList());

    return RichDataSetModel.Builder.aRichDataSetModel()
            .id(dataSetModel.getId())
            .name(dataSetModel.getName())
            .isDeleted(dataSetModel.getDeleted())
            .metaInfoModel(dataSetModel.getMetaInfoModel())
            .richDataSetElement(richDataSetElementModels)
            .build();
  }


  private RichTagPositions richTagPositions(TagPositions positions) {
    return RichTagPositions.Builder
            .aRichTagPositions()
            .data(
                    positions.getData().stream()
                            .map(p ->
                                    RichTagPosition.Builder.aRichTagPosition()
                                            .boundingBox(p.getBoundingBox())
                                            .richTagModel(richTagModel(tagService.get(p.getTagId())))
                                            .build()
                            ).collect(Collectors.toList())
            ).build();
  }

  private RichTagModel richTagModel(TagModel tagModel) {
    return RichTagModel.Builder.aRichTagModel()
            .id(tagModel.getId())
            .code(tagModel.getCode())
            .name(tagModel.getName())
            .metaInfoModel(tagModel.getMetaInfoModel())
            .isDeleted(tagModel.getDeleted())
            .build();
  }
}
