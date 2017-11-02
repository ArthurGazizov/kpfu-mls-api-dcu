package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.factory;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.base.Converter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.Dto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.Model;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 03.11.17.
 */
public interface ConverterFactory {
  <E extends Model, T extends Dto> Converter<? super E, ? super T> getConverter(Class<? extends E> modelClass, Class<? extends T> dtoClass);
}

