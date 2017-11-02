package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.config;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.factory.ConverterFactory;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.factory.ConverterFactoryImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.MetaInfoConverterImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.base.Converter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.Dto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.Model;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 03.11.17.
 */
@Configuration
public class ConverterConfig {
  @Bean
  public ConverterFactory converterFactory(List<Converter<? extends Model, ? extends Dto>> converters) {
    return new ConverterFactoryImpl(converters);
  }

  @Bean
  public Converter metaInfoConverter() {
    return new MetaInfoConverterImpl();
  }
}
