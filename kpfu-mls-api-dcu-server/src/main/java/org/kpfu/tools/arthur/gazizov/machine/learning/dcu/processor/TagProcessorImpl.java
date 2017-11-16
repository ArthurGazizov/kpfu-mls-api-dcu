package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.TagDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.TagProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Service
@Primary
public class TagProcessorImpl implements TagProcessor {
  @Autowired
  @Qualifier("tagProcessorProxyImpl")
  private TagProcessor tagProcessor;

  @Override
  public ResponseEntity<TagDto> get(Long id) {
    return tagProcessor.get(id);
  }

  @Override
  public ResponseEntity<TagDto> save(TagDto tagDto) {
    return tagProcessor.save(tagDto);
  }

  @Override
  public ResponseEntity<TagDto> update(TagDto tagDto) {
    return tagProcessor.update(tagDto);
  }

  @Override
  public ResponseEntity<TagDto> patch(TagDto tagDto) {
    return tagProcessor.patch(tagDto);
  }

  @Override
  public ResponseEntity<Void> delete(Long id) {
    return tagProcessor.delete(id);
  }

  @Override
  public ResponseEntity<TagDto> restore(Long id) {
    return tagProcessor.restore(id);
  }

  @Override
  public ResponseEntity<List<TagDto>> findAll() {
    return tagProcessor.findAll();
  }
}
