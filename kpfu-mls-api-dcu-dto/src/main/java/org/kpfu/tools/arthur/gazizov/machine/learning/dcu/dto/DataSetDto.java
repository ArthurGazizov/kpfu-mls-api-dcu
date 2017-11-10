package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 02.11.17.
 */
public class DataSetDto extends BaseDto {
  @ApiModelProperty(
          notes = "The database generated data set ID"
          , name = "id"
          , example = "123456"
          , readOnly = true)

  @JsonProperty("id")
  private Long id;

  @ApiModelProperty(
          notes = "Data set name"
          , name = "name"
          , example = "example name")
  @JsonProperty("name")
  private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public static final class Builder {
    protected MetaInfoDto metaInfoDto;
    private Long id;
    private String name;

    private Builder() {
    }

    public static Builder aDataSetDto() {
      return new Builder();
    }

    public Builder id(Long id) {
      this.id = id;
      return this;
    }

    public Builder metaInfoDto(MetaInfoDto metaInfoDto) {
      this.metaInfoDto = metaInfoDto;
      return this;
    }

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public DataSetDto build() {
      DataSetDto dataSetDto = new DataSetDto();
      dataSetDto.name = this.name;
      dataSetDto.id = this.id;
      dataSetDto.metaInfoDto = this.metaInfoDto;
      return dataSetDto;
    }
  }
}
