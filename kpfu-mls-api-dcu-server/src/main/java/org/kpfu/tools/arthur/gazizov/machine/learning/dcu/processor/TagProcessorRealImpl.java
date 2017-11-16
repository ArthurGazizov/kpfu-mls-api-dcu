package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.TagConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.base.Converter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.TagDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.TagModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.base.AbstractCRUDProcessorImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.TagProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.CRUDService;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Service("tagProcessorRealImpl")
public class TagProcessorRealImpl extends AbstractCRUDProcessorImpl<TagDto, TagModel> implements TagProcessor {
  @Autowired
  private TagService tagService;

  @Autowired
  private TagConverter tagConverter;

  @Override
  public CRUDService<TagModel> crudService() {
    return tagService;
  }

  @Override
  public Converter<TagModel, TagDto> converter() {
    return tagConverter;
  }
}
