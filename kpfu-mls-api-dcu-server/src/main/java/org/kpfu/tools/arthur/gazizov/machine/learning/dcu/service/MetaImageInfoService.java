package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image.MetaImageInfoModel;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public interface MetaImageInfoService extends CRUDService<MetaImageInfoModel> {
  MetaImageInfoModel upload(MultipartFile file, MetaImageInfoModel metaImageInfoModel);
}
