package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.MetaImageInfoDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.exception.KpfuMlsDcuError;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image.MetaImageInfoModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.support.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
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

  @Override
  public MetaImageInfoModel upload(MultipartFile file, MetaImageInfoModel metaImageInfoModel) {
    final Long imageId = saveFile(file);
    metaImageInfoModel.setImageId(imageId);
    return metaImageInfoDao.save(metaImageInfoModel);
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
    // TODO: 16.11.17 implement me
    return metaImageInfoDao.update(metaImageInfoModel);
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
    // TODO: 16.11.17 use kpfu-mls-fs-client to upload
    return (long) Math.abs(ThreadLocalRandom.current().nextInt());
  }
}
