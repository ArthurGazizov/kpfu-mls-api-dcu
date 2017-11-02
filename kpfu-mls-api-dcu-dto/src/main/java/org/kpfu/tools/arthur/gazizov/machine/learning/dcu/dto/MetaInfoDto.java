package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto;

import java.time.LocalDateTime;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 02.11.17.
 */
public class MetaInfoDto implements Dto {
  private LocalDateTime createdTs;
  private LocalDateTime updatedTs;

  public LocalDateTime getCreatedTs() {
    return createdTs;
  }

  public LocalDateTime getUpdatedTs() {
    return updatedTs;
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
