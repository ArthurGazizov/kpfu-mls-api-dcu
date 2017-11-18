package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.rich;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.BaseEntityModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.MetaInfoModel;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class RichMetaImageInfoModel extends BaseEntityModel implements RichModel {
  private Long imageId;
  private RichTagPositions richTagPositions;

  public Long getImageId() {
    return imageId;
  }

  public void setImageId(Long imageId) {
    this.imageId = imageId;
  }

  public RichTagPositions getRichTagPositions() {
    return richTagPositions;
  }

  public void setRichTagPositions(RichTagPositions richTagPositions) {
    this.richTagPositions = richTagPositions;
  }

  public static final class Builder {
    protected MetaInfoModel metaInfoModel;
    protected Long id;
    protected Boolean isDeleted;
    private Long imageId;
    private RichTagPositions richTagPositions;

    private Builder() {
    }

    public static Builder aReachMetaImageInfoModel() {
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

    public Builder richTagPositions(RichTagPositions richTagPositions) {
      this.richTagPositions = richTagPositions;
      return this;
    }

    public RichMetaImageInfoModel build() {
      RichMetaImageInfoModel richMetaImageInfoModel = new RichMetaImageInfoModel();
      richMetaImageInfoModel.setMetaInfoModel(metaInfoModel);
      richMetaImageInfoModel.setId(id);
      richMetaImageInfoModel.setImageId(imageId);
      richMetaImageInfoModel.setRichTagPositions(richTagPositions);
      richMetaImageInfoModel.isDeleted = this.isDeleted;
      return richMetaImageInfoModel;
    }
  }
}
