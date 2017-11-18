package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.rich;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.BaseEntityModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.MetaInfoModel;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class RichDataSetModel extends BaseEntityModel implements RichModel {
  private String name;
  private List<RichDataSetElementModel> richDataSetElement;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<RichDataSetElementModel> getRichDataSetElement() {
    return richDataSetElement;
  }

  public void setRichDataSetElement(List<RichDataSetElementModel> richDataSetElement) {
    this.richDataSetElement = richDataSetElement;
  }

  public static final class Builder {
    protected MetaInfoModel metaInfoModel;
    protected Long id;
    protected Boolean isDeleted;
    private String name;
    private List<RichDataSetElementModel> richDataSetElement;

    private Builder() {
    }

    public static Builder aRichDataSetModel() {
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

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder richDataSetElement(List<RichDataSetElementModel> richDataSetElement) {
      this.richDataSetElement = richDataSetElement;
      return this;
    }

    public RichDataSetModel build() {
      RichDataSetModel richDataSetModel = new RichDataSetModel();
      richDataSetModel.setMetaInfoModel(metaInfoModel);
      richDataSetModel.setId(id);
      richDataSetModel.setName(name);
      richDataSetModel.setRichDataSetElement(richDataSetElement);
      richDataSetModel.isDeleted = this.isDeleted;
      return richDataSetModel;
    }
  }
}
