package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.base;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.meta.MetaInfoDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.common.Dto;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 02.11.17.
 */
public abstract class BaseDto implements Dto {
  @ApiModelProperty(
          notes = "Meta Info"
          , name = "metaInfoDto"
          , readOnly = true)
  @JsonProperty("metaInfoDto")
  protected MetaInfoDto metaInfoDto;

  public MetaInfoDto getMetaInfoDto() {
    return metaInfoDto;
  }

  public void setMetaInfoDto(MetaInfoDto metaInfoDto) {
    this.metaInfoDto = metaInfoDto;
  }
}
