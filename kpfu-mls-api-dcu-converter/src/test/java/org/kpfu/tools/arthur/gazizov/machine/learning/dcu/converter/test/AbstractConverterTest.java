package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.config.ConverterConfig;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.factory.ConverterFactory;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.base.Converter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.Dto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 03.11.17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ConverterConfig.class)
public abstract class AbstractConverterTest {
  @Autowired
  private ConverterFactory converterFactory;

  @Test
  public void testConvertModelToDto() {
    final Model model = generateModel();
    final Dto converted = getConverter().convert(model);
    checkModelToDtoConversion(model, converted);
  }

  @Test
  public void testConvertDtoToModel() {
    final Dto dto = generateDto();
    final Model converted = getConverter().convert(dto);
    checkDtoToModelConversion(dto, converted);
  }



  private Converter<? super Model, ? super Dto> getConverter() {
    return converterFactory.getConverter(model(), dto());
  }


  protected abstract Class<? extends Model> model();

  protected abstract Class<? extends Dto> dto();

  protected abstract Dto generateDto();

  protected abstract Model generateModel();

  protected abstract void checkModelToDtoConversion(Model model, Dto converted);

  protected abstract void checkDtoToModelConversion(Dto dto, Model converted);
}
