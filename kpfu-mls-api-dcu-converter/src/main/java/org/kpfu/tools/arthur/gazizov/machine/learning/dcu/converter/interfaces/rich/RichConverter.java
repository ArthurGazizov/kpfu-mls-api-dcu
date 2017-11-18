package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.rich;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.base.Converter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.common.Dto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.Model;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public interface RichConverter<E extends Model, T extends Dto> extends Converter<E, T> {
  @Override
  default E convert(T dto) {
    throw new UnsupportedOperationException();
  }
}
