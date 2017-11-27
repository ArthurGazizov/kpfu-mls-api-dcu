package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service;

import org.jooq.tools.StringUtils;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.MetaImageInfoDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.exception.KpfuMlsDcuError;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image.MetaImageInfoModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.support.PageModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.fs.FsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Service
public class MetaImageInfoServiceImpl implements MetaImageInfoService {
  @Autowired
  private MetaImageInfoDao metaImageInfoDao;

  @Autowired
  private FsService fsService;

  @Override
  public MetaImageInfoModel upload(MultipartFile file, MetaImageInfoModel metaImageInfoModel) {
    final Long imageId = saveFile(file);
    metaImageInfoModel.setImageId(imageId);
    if (StringUtils.isEmpty(metaImageInfoModel.getOriginalFilename()) && !StringUtils.isEmpty(file.getOriginalFilename())) {
      metaImageInfoModel.setOriginalFilename(file.getOriginalFilename());
    }
    return metaImageInfoDao.save(metaImageInfoModel);
  }

  @Override
  public MetaImageInfoModel findByImageId(Long imageId) {
    return Optional.of(imageId)
            .map(metaImageInfoDao::findByImageId)
            .orElseThrow(KpfuMlsDcuError.META_IMAGE_INFO_NOT_FOUND::exception);
  }

  @Override
  public MetaImageInfoModel get(Long id) {
    return Optional.of(id)
            .map(metaImageInfoDao::find)
            .orElseThrow(KpfuMlsDcuError.META_IMAGE_INFO_NOT_FOUND::exception);
  }

  @Override
  public MetaImageInfoModel save(MetaImageInfoModel metaImageInfoModel) {
    return metaImageInfoDao.save(metaImageInfoModel);
  }

  @Override
  public MetaImageInfoModel update(MetaImageInfoModel metaImageInfoModel) {
    return metaImageInfoDao.update(metaImageInfoModel);
  }

  @Override
  public MetaImageInfoModel patch(MetaImageInfoModel metaImageInfoModel) {
    final MetaImageInfoModel fromDb = Optional.of(metaImageInfoModel.getId())
            .map(metaImageInfoDao::find)
            .orElseThrow(KpfuMlsDcuError.META_IMAGE_INFO_NOT_FOUND::exception);
    if (Objects.nonNull(metaImageInfoModel.getImageId())) {
      fromDb.setImageId(metaImageInfoModel.getImageId());
    }
    if (Objects.nonNull(metaImageInfoModel.getOriginalFilename())) {
      fromDb.setOriginalFilename(metaImageInfoModel.getOriginalFilename());
    }
    if (Objects.nonNull(metaImageInfoModel.getTagPositions())) {
      fromDb.setTagPositions(metaImageInfoModel.getTagPositions());
    }
    return metaImageInfoDao.update(fromDb);
  }

  @Override
  public void delete(Long id) {
    throw new UnsupportedOperationException();
  }

  @Override
  public MetaImageInfoModel restore(Long id) {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<MetaImageInfoModel> findAll() {
    return StreamSupport.stream(metaImageInfoDao.findAll().spliterator(), false).collect(Collectors.toList());
  }

  @Override
  public PageModel<MetaImageInfoModel> findAll(Integer limit, Integer offset) {
    return metaImageInfoDao.findAll(limit, offset);
  }

  private Long saveFile(MultipartFile multipartFile) {
    return fsService.saveImage(multipartFile);
  }
}
