package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.annotation;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.common.Dto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.Model;
import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 03.11.17.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Component
public @interface Conversion {
  Class<? extends Model> model();

  Class<? extends Dto> dto();
}
