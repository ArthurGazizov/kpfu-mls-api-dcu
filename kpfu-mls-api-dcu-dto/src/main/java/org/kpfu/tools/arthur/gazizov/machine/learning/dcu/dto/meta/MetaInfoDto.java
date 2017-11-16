package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.meta;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.common.Dto;

import java.time.LocalDateTime;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 02.11.17.
 */
public class MetaInfoDto implements Dto {
  @ApiModelProperty(
          notes = "created timestamp"
          , name = "createdTs"
          , example = "2017-11-08T06:41:51.853"
          , readOnly = true)
  @JsonProperty("createdTs")
  private LocalDateTime createdTs;

  @ApiModelProperty(
          notes = "updated timestamp"
          , name = "updatedTs"
          , example = "2017-11-08T06:41:51.853"
          , readOnly = true)
  @JsonProperty("updatedTs")
  private LocalDateTime updatedTs;

  public LocalDateTime getCreatedTs() {
    return createdTs;
  }

  public void setCreatedTs(LocalDateTime createdTs) {
    this.createdTs = createdTs;
  }

  public LocalDateTime getUpdatedTs() {
    return updatedTs;
  }

  public void setUpdatedTs(LocalDateTime updatedTs) {
    this.updatedTs = updatedTs;
  }

  public static final class Builder {
    private LocalDateTime createdTs;
    private LocalDateTime updatedTs;

    private Builder() {
    }

    public static Builder aMetaInfoDto() {
      return new Builder();
    }

    public Builder createdTs(LocalDateTime createdTs) {
      this.createdTs = createdTs;
      return this;
    }

    public Builder updatedTs(LocalDateTime updatedTs) {
      this.updatedTs = updatedTs;
      return this;
    }

    public MetaInfoDto build() {
      MetaInfoDto metaInfoDto = new MetaInfoDto();
      metaInfoDto.updatedTs = this.updatedTs;
      metaInfoDto.createdTs = this.createdTs;
      return metaInfoDto;
    }
  }
}
