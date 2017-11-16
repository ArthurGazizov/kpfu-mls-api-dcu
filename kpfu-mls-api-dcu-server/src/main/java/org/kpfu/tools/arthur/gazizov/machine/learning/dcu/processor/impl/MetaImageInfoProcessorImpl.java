package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.impl;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image.MetaImageInfoDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.support.PageResponse;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.MetaImageInfoProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Service
@Primary
public class MetaImageInfoProcessorImpl implements MetaImageInfoProcessor {
  @Autowired
  @Qualifier("metaImageInfoProcessorProxyImpl")
  private MetaImageInfoProcessor metaImageInfoProcessor;

  @Override
  public ResponseEntity<MetaImageInfoDto> upload(MultipartFile multipartFile, MetaImageInfoDto metaImageInfoDto) {
    return metaImageInfoProcessor.upload(multipartFile, metaImageInfoDto);
  }

  @Override
  public ResponseEntity<MetaImageInfoDto> get(Long id) {
    return metaImageInfoProcessor.get(id);
  }

  @Override
  public ResponseEntity<MetaImageInfoDto> save(MetaImageInfoDto metaImageInfoDto) {
    return metaImageInfoProcessor.save(metaImageInfoDto);
  }

  @Override
  public ResponseEntity<MetaImageInfoDto> update(MetaImageInfoDto metaImageInfoDto) {
    return metaImageInfoProcessor.update(metaImageInfoDto);
  }

  @Override
  public ResponseEntity<MetaImageInfoDto> patch(MetaImageInfoDto metaImageInfoDto) {
    return metaImageInfoProcessor.patch(metaImageInfoDto);
  }

  @Override
  public ResponseEntity<Void> delete(Long id) {
    return metaImageInfoProcessor.delete(id);
  }

  @Override
  public ResponseEntity<MetaImageInfoDto> restore(Long id) {
    return metaImageInfoProcessor.restore(id);
  }

  @Override
  public ResponseEntity<List<MetaImageInfoDto>> findAll() {
    return metaImageInfoProcessor.findAll();
  }

  @Override
  public ResponseEntity<PageResponse<MetaImageInfoDto>> findAll(Integer limit, Integer offset) {
    return metaImageInfoProcessor.findAll(limit, offset);
  }
}
