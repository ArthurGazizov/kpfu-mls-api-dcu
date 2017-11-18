package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.config;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.factory.ConverterFactory;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.factory.ConverterFactoryImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.DataSetConverterImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.DataSetElementConverterImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.MetaInfoConverterImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.TagConverterImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.image.MetaImageInfoDtoConverterImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.image.support.BoundingBoxDtoConverterImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.image.support.PointDtoConverterImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.image.support.TagPositionDtoConverterImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.image.support.TagPositionsDtoConverterImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.rich.RichDataSetConverterImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.rich.RichDataSetElementConverterImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.rich.RichMetaImageInfoConverterImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.rich.RichTagConverterImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.rich.RichTagPositionConverterImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.impl.rich.RichTagPositionsConverterImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.DataSetConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.DataSetElementConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.MetaInfoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.TagConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.base.Converter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.image.MetaImageInfoDtoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.image.support.BoundingBoxDtoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.image.support.PointDtoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.image.support.TagPositionDtoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.image.support.TagPositionsDtoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.rich.RichDataSetConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.rich.RichDataSetElementConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.rich.RichMetaImageInfoConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.rich.RichTagConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.rich.RichTagPositionConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.rich.RichTagPositionsConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.common.Dto;
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
  public MetaInfoConverter metaInfoConverter() {
    return new MetaInfoConverterImpl();
  }

  @Bean
  public DataSetConverter dataSetConverter() {
    return new DataSetConverterImpl();
  }

  @Bean
  public DataSetElementConverter dataSetElementConverter() {
    return new DataSetElementConverterImpl();
  }

  @Bean
  public TagConverter tagConverter() {
    return new TagConverterImpl();
  }

  @Bean
  public PointDtoConverter pointDtoConverter() {
    return new PointDtoConverterImpl();
  }

  @Bean
  public BoundingBoxDtoConverter boundingBoxDtoConverter() {
    return new BoundingBoxDtoConverterImpl();
  }

  @Bean
  public TagPositionDtoConverter tagPositionDtoConverter() {
    return new TagPositionDtoConverterImpl();
  }

  @Bean
  public TagPositionsDtoConverter tagPositionsDtoConverter() {
    return new TagPositionsDtoConverterImpl();
  }

  @Bean
  public MetaImageInfoDtoConverter metaImageDtoConverter() {
    return new MetaImageInfoDtoConverterImpl();
  }

  @Bean
  public RichTagConverter richTagConverter() {
    return new RichTagConverterImpl();
  }

  @Bean
  public RichTagPositionConverter richTagPositionConverter() {
    return new RichTagPositionConverterImpl();
  }

  @Bean
  public RichTagPositionsConverter richTagPositionsConverter() {
    return new RichTagPositionsConverterImpl();
  }

  @Bean
  public RichMetaImageInfoConverter richMetaImageInfoConverter() {
    return new RichMetaImageInfoConverterImpl();
  }

  @Bean
  public RichDataSetElementConverter richDataSetElementConverter() {
    return new RichDataSetElementConverterImpl();
  }

  @Bean
  public RichDataSetConverter richDataSetConverter() {
    return new RichDataSetConverterImpl();
  }
}
