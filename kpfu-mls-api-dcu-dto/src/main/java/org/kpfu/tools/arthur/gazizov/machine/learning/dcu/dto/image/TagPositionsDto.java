package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.common.Dto;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class TagPositionsDto implements Dto {
  @ApiModelProperty(
          notes = "Tag Positions"
          , name = "data"
          , readOnly = true)
  @JsonProperty("data")
  private List<TagPositionDto> data;

  public List<TagPositionDto> getData() {
    return data;
  }

  public void setData(List<TagPositionDto> data) {
    this.data = data;
  }

  public static final class Builder {
    private List<TagPositionDto> data;

    private Builder() {
    }

    public static Builder aTagPositionsDto() {
      return new Builder();
    }

    public Builder data(List<TagPositionDto> data) {
      this.data = data;
      return this;
    }

    public TagPositionsDto build() {
      TagPositionsDto tagPositionsDto = new TagPositionsDto();
      tagPositionsDto.data = this.data;
      return tagPositionsDto;
    }
  }
}
