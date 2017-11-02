package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.factory;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.annotation.Conversion;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.base.Converter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.Dto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 03.11.17.
 */
@Component
public class ConverterFactoryImpl implements ConverterFactory {
  private final Map<ClassKey<? extends Model, ? extends Dto>, Converter<? extends Model, ? extends Dto>> map;

  public ConverterFactoryImpl(List<Converter<? extends Model, ? extends Dto>> converters) {
    this.map = new HashMap<>();
    converters.forEach(c -> {
      Conversion conversion = c.getClass().getAnnotation(Conversion.class);
      this.map.put(ClassKey.of(conversion.model(), conversion.dto()), c);
    });
  }

  @Override
  @SuppressWarnings("unchecked")
  public <E extends Model, T extends Dto> Converter<E, T> getConverter(Class<? extends E> modelClass, Class<? extends T> dtoClass) {
    return (Converter<E, T>) map.get(ClassKey.of(modelClass, dtoClass));
  }

  private static class ClassKey<E extends Model, T extends Dto> {
    private Class<E> modelClass;
    private Class<T> dtoClass;

    private ClassKey(Class<E> modelClass, Class<T> dtoClass) {
      this.modelClass = modelClass;
      this.dtoClass = dtoClass;
    }

    static <E extends Model, T extends Dto> ClassKey<E, T> of(Class<E> modelClass, Class<T> dtoClass) {
      return new ClassKey<>(modelClass, dtoClass);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      ClassKey<?, ?> classKey = (ClassKey<?, ?>) o;

      if (modelClass != null ? !modelClass.equals(classKey.modelClass) : classKey.modelClass != null) return false;
      return dtoClass != null ? dtoClass.equals(classKey.dtoClass) : classKey.dtoClass == null;
    }

    @Override
    public int hashCode() {
      int result = modelClass != null ? modelClass.hashCode() : 0;
      result = 31 * result + (dtoClass != null ? dtoClass.hashCode() : 0);
      return result;
    }
  }
}
