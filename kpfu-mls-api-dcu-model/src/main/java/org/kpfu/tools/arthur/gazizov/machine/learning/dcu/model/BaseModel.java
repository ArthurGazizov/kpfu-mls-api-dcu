package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 03.11.17.
 */
public abstract class BaseModel implements Model {
  protected MetaInfoModel metaInfoEntity;

  public MetaInfoModel getMetaInfoEntity() {
    return metaInfoEntity;
  }
}
