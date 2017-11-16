package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 14.11.17.
 */
public class TagModel extends BaseEntityModel {
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

    public static Builder aTagModel() {
      return new Builder();
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder code(String code) {
      this.code = code;
      return this;
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

    public TagModel build() {
      TagModel tagModel = new TagModel();
      tagModel.setName(name);
      tagModel.setCode(code);
      tagModel.setMetaInfoModel(metaInfoModel);
      tagModel.setId(id);
      tagModel.isDeleted = this.isDeleted;
      return tagModel;
    }
  }
}
