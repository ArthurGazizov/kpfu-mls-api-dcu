package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 03.11.17.
 */
public class DataSetModel extends BaseEntityModel {
  private String name;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static final class Builder {
    protected MetaInfoModel metaInfoModel;
    protected Long id;
    protected Boolean isDeleted;
    private String name;

    private Builder() {
    }

    public static Builder aDataSetModel() {
      return new Builder();
    }

    public Builder name(String name) {
      this.name = name;
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

    public DataSetModel build() {
      DataSetModel dataSetModel = new DataSetModel();
      dataSetModel.setName(name);
      dataSetModel.setMetaInfoModel(metaInfoModel);
      dataSetModel.setId(id);
      dataSetModel.isDeleted = this.isDeleted;
      return dataSetModel;
    }
  }
}
