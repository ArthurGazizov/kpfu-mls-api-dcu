package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.rich;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.BaseEntityModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.MetaInfoModel;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class RichDataSetElementModel extends BaseEntityModel implements RichModel {
  private RichMetaImageInfoModel richMetaImageInfoModel;

  public RichMetaImageInfoModel getRichMetaImageInfoModel() {
    return richMetaImageInfoModel;
  }

  public void setRichMetaImageInfoModel(RichMetaImageInfoModel richMetaImageInfoModel) {
    this.richMetaImageInfoModel = richMetaImageInfoModel;
  }

  public static final class Builder {
    protected MetaInfoModel metaInfoModel;
    protected Long id;
    protected Boolean isDeleted;
    private RichMetaImageInfoModel richMetaImageInfoModel;

    private Builder() {
    }

    public static Builder aRichDataSetElementModel() {
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

    public Builder reachMetaImageInfoModel(RichMetaImageInfoModel richMetaImageInfoModel) {
      this.richMetaImageInfoModel = richMetaImageInfoModel;
      return this;
    }

    public RichDataSetElementModel build() {
      RichDataSetElementModel richDataSetElementModel = new RichDataSetElementModel();
      richDataSetElementModel.setMetaInfoModel(metaInfoModel);
      richDataSetElementModel.setId(id);
      richDataSetElementModel.setRichMetaImageInfoModel(richMetaImageInfoModel);
      richDataSetElementModel.isDeleted = this.isDeleted;
      return richDataSetElementModel;
    }
  }
}
