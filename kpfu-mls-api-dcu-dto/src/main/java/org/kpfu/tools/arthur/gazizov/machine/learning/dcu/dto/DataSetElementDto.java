package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.base.BaseDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.meta.MetaInfoDto;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 11.11.17.
 */
public class DataSetElementDto extends BaseDto {
  @ApiModelProperty(
          notes = "The database generated data set element ID"
          , name = "id"
          , example = "123456"
          , readOnly = true)

  @JsonProperty("id")
  private Long id;

  @ApiModelProperty(
          notes = "Image id"
          , name = "imageId"
          , example = "2345692")
  @JsonProperty("imageId")
  private Long imageId;

  @ApiModelProperty(
          notes = "Dataset id"
          , name = "datasetId"
          , example = "2345692")
  @JsonProperty("datasetId")
  private Long datasetId;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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
    protected MetaInfoDto metaInfoDto;

    private Long id;
    private Long imageId;
    private Long datasetId;

    private Builder() {
    }

    public static Builder aDataSetElementDto() {
      return new Builder();
    }

    public Builder metaInfoDto(MetaInfoDto metaInfoDto) {
      this.metaInfoDto = metaInfoDto;
      return this;
    }

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder imageId(Long imageId) {
      this.imageId = imageId;
      return this;
    }

    public Builder datasetId(Long datasetId) {
      this.datasetId = datasetId;
      return this;
    }

    public DataSetElementDto build() {
      DataSetElementDto dataSetElementDto = new DataSetElementDto();
      dataSetElementDto.setMetaInfoDto(metaInfoDto);
      dataSetElementDto.setId(id);
      dataSetElementDto.setImageId(imageId);
      dataSetElementDto.setDatasetId(datasetId);
      return dataSetElementDto;
    }
  }
}
