package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model;

import java.time.LocalDateTime;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 03.11.17.
 */
public class MetaInfoModel implements Model {
  private LocalDateTime createdTs;
  private LocalDateTime updatedTs;
  private LocalDateTime deletedTs;

  public LocalDateTime getCreatedTs() {
    return createdTs;
  }

  public LocalDateTime getUpdatedTs() {
    return updatedTs;
  }

  public LocalDateTime getDeletedTs() {
    return deletedTs;
  }

  public static final class Builder {
    private LocalDateTime createdTs;
    private LocalDateTime updatedTs;
    private LocalDateTime deletedTs;

    private Builder() {
    }

    public static Builder aMetaInfoEntity() {
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

    public Builder deletedTs(LocalDateTime deletedTs) {
      this.deletedTs = deletedTs;
      return this;
    }

    public MetaInfoModel build() {
      MetaInfoModel metaInfoEntity = new MetaInfoModel();
      metaInfoEntity.deletedTs = this.deletedTs;
      metaInfoEntity.updatedTs = this.updatedTs;
      metaInfoEntity.createdTs = this.createdTs;
      return metaInfoEntity;
    }
  }
}
