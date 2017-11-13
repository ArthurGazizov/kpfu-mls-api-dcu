package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 11.11.17.
 */
public class DataSetElementModel extends BaseEntityModel {
  private Long datasetId;
  private Long imageId;

  public Long getImageId() {
    return imageId;
  }

  public void setImageId(Long imageId) {
    this.imageId = imageId;
  }

  public Long getDatasetId() {
    return datasetId;
  }

  public void setDatasetId(Long datasetId) {
    this.datasetId = datasetId;
  }

  public static final class Builder {
    protected MetaInfoModel metaInfoModel;
    protected Long id;
    protected Boolean isDeleted;
    private Long datasetId;
    private Long imageId;

    private Builder() {
    }

    public static Builder aDataSetElementModel() {
      return new Builder();
    }

    public Builder datasetId(Long datasetId) {
      this.datasetId = datasetId;
      return this;
    }

    public Builder metaInfoModel(MetaInfoModel metaInfoModel) {
      this.metaInfoModel = metaInfoModel;
      return this;
    }

    public Builder imageId(Long imageId) {
      this.imageId = imageId;
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

    public DataSetElementModel build() {
      DataSetElementModel dataSetElementModel = new DataSetElementModel();
      dataSetElementModel.setDatasetId(datasetId);
      dataSetElementModel.setMetaInfoModel(metaInfoModel);
      dataSetElementModel.setImageId(imageId);
      dataSetElementModel.setId(id);
      dataSetElementModel.isDeleted = this.isDeleted;
      return dataSetElementModel;
    }
  }
}
