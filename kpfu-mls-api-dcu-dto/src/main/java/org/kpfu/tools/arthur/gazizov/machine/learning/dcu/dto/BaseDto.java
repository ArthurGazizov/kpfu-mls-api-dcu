package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 02.11.17.
 */
public abstract class BaseDto implements Dto {
  @ApiModelProperty(
          notes = "Meta Info"
          , name = "metaInfoDto")
  @JsonProperty("metaInfoDto")
  protected MetaInfoDto metaInfoDto;

  public MetaInfoDto getMetaInfoDto() {
    return metaInfoDto;
  }

  public void setMetaInfoDto(MetaInfoDto metaInfoDto) {
    this.metaInfoDto = metaInfoDto;
  }
}
