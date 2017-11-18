package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.real;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.base.Converter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.image.MetaImageInfoDtoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image.MetaImageInfoDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image.MetaImageInfoModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.base.AbstractCRUDProcessorImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.MetaImageInfoProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.CRUDService;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.MetaImageInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Service("metaImageInfoProcessorRealImpl")
public class MetaImageInfoProcessorRealImpl extends AbstractCRUDProcessorImpl<MetaImageInfoDto, MetaImageInfoModel> implements MetaImageInfoProcessor {
  @Autowired
  private MetaImageInfoService metaImageInfoService;

  @Autowired
  private MetaImageInfoDtoConverter metaImageInfoDtoConverter;

  @Override
  public CRUDService<MetaImageInfoModel> crudService() {
    return metaImageInfoService;
  }

  @Override
  public Converter<MetaImageInfoModel, MetaImageInfoDto> converter() {
    return metaImageInfoDtoConverter;
  }

  @Override
  public ResponseEntity<MetaImageInfoDto> upload(MultipartFile multipartFile, MetaImageInfoDto metaImageInfoDto) {
    final MetaImageInfoModel imageInfoModel = converter().convert(metaImageInfoDto);
    final MetaImageInfoModel uploaded = metaImageInfoService.upload(multipartFile, imageInfoModel);
    final MetaImageInfoDto dto = converter().convert(uploaded);
    return new ResponseEntity<>(dto, HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<MetaImageInfoDto> findByImageId(Long imageId) {
    final MetaImageInfoModel finded = metaImageInfoService.findByImageId(imageId);
    final MetaImageInfoDto dto = converter().convert(finded);
    return ResponseEntity.ok(dto);
  }
}
