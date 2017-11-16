package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.BaseEntityModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.MetaInfoModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image.pojo.TagPositions;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class MetaImageInfoModel extends BaseEntityModel {
  private Long imageId;
  private TagPositions tagPositions;

  public Long getImageId() {
    return imageId;
  }

  public void setImageId(Long imageId) {
    this.imageId = imageId;
  }

  public TagPositions getTagPositions() {
    return tagPositions;
  }

  public void setTagPositions(TagPositions tagPositions) {
    this.tagPositions = tagPositions;
  }

  public static final class Builder {
    protected MetaInfoModel metaInfoModel;
    protected Long id;
    protected Boolean isDeleted;
    private Long imageId;
    private TagPositions tagPositions;

    private Builder() {
    }

    public static Builder aMetaImageModel() {
      return new Builder();
    }

    public Builder metaInfoModel(MetaInfoModel metaInfoModel) {
      this.metaInfoModel = metaInfoModel;
      return this;
    }

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder isDeleted(Boolean isDeleted) {
      this.isDeleted = isDeleted;
      return this;
    }

    public Builder imageId(Long imageId) {
      this.imageId = imageId;
      return this;
    }

    public Builder tagPositions(TagPositions tagPositions) {
      this.tagPositions = tagPositions;
      return this;
    }

    public MetaImageInfoModel build() {
      MetaImageInfoModel metaImageInfoModel = new MetaImageInfoModel();
      metaImageInfoModel.setMetaInfoModel(metaInfoModel);
      metaImageInfoModel.setId(id);
      metaImageInfoModel.setImageId(imageId);
      metaImageInfoModel.setTagPositions(tagPositions);
      metaImageInfoModel.isDeleted = this.isDeleted;
      return metaImageInfoModel;
    }
  }
}
