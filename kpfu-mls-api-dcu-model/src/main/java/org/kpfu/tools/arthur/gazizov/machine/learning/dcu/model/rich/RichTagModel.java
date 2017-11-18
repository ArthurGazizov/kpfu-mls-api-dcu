package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.rich;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.BaseEntityModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.MetaInfoModel;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class RichTagModel extends BaseEntityModel implements RichModel {
  private String name;
  private String code;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public static final class Builder {
    protected MetaInfoModel metaInfoModel;
    protected Long id;
    protected Boolean isDeleted;
    private String name;
    private String code;

    private Builder() {
    }

    public static Builder aRichTagModel() {
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

    public Builder code(String code) {
      this.code = code;
      return this;
    }

    public RichTagModel build() {
      RichTagModel richTagModel = new RichTagModel();
      richTagModel.setMetaInfoModel(metaInfoModel);
      richTagModel.setId(id);
      richTagModel.setName(name);
      richTagModel.setCode(code);
      richTagModel.isDeleted = this.isDeleted;
      return richTagModel;
    }
  }
}
