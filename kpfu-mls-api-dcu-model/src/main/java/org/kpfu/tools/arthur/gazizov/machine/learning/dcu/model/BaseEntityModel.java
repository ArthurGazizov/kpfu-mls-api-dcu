package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 03.11.17.
 */
public abstract class BaseEntityModel implements EntityModel {
  protected MetaInfoModel metaInfoModel;
  protected Long id;
  protected Boolean isDeleted;

  public MetaInfoModel getMetaInfoModel() {
    return metaInfoModel;
  }

  public void setMetaInfoModel(MetaInfoModel metaInfoModel) {
    this.metaInfoModel = metaInfoModel;
  }

  @Override
  public Long getId() {
    return id;
  }

  @Override
  public void setId(Long id) {
    this.id = id;
  }

  public Boolean getDeleted() {
    return isDeleted;
  }

  public void setDeleted(Boolean deleted) {
    isDeleted = deleted;
  }
}
