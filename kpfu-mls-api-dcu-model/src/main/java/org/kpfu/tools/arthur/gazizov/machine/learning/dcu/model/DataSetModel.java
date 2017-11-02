package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 03.11.17.
 */
public class DataSetModel extends BaseModel {
  private Long id;
  private String name;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public static final class Builder {
    protected MetaInfoModel metaInfoEntity;
    private Long id;
    private String name;

    private Builder() {
    }

    public static Builder aDataSetEntity() {
      return new Builder();
    }

    public Builder metaInfoEntity(MetaInfoModel metaInfoEntity) {
      this.metaInfoEntity = metaInfoEntity;
      return this;
    }

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public DataSetModel build() {
      DataSetModel dataSetEntity = new DataSetModel();
      dataSetEntity.metaInfoEntity = this.metaInfoEntity;
      dataSetEntity.name = this.name;
      dataSetEntity.id = this.id;
      return dataSetEntity;
    }
  }
}
