package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.TagDao;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.exception.KpfuMlsDcuError;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.TagModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.support.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class TagServiceImpl implements TagService {
  @Autowired
  private TagDao tagDao;

  @Override
  public TagModel get(Long id) {
    return Optional.of(id)
            .map(tagDao::find)
            .orElseThrow(KpfuMlsDcuError.TAG_NOT_FOUND::exception);
  }

  @Override
  public TagModel save(TagModel tagModel) {
    return tagDao.save(tagModel);
  }

  @Override
  public TagModel update(TagModel tagModel) {
    return tagDao.update(tagModel);
  }

  @Override
  public TagModel patch(TagModel tagModel) {
    final TagModel model = Optional.ofNullable(tagDao.find(tagModel.getId()))
            .orElseThrow(KpfuMlsDcuError.TAG_NOT_FOUND::exception);
    if (Objects.nonNull(tagModel.getCode())) {
      model.setCode(tagModel.getCode());
    }
    if (Objects.nonNull(tagModel.getName())) {
      model.setName(tagModel.getName());
    }
    return tagDao.update(model);
  }

  @Override
  public void delete(Long id) {
    tagDao.delete(id);
  }

  @Override
  public TagModel restore(Long id) {
    tagDao.restore(id);
    return get(id);
  }

  @Override
  public List<TagModel> findAll() {
    return StreamSupport.stream(tagDao.findAll().spliterator(), false)
            .collect(Collectors.toList());
  }

  @Override
  public PageModel<TagModel> findAll(Integer limit, Integer offset) {
    return tagDao.findAll(limit, offset);
  }
}
