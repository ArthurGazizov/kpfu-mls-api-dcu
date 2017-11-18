package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.rich;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class RichTagPositionsDto implements RichDto {
  @ApiModelProperty(
          notes = "Data"
          , name = "data"
          , readOnly = true)
  @JsonProperty("data")
  private List<RichTagPositionDto> data;

  public List<RichTagPositionDto> getData() {
    return data;
  }

  public void setData(List<RichTagPositionDto> data) {
    this.data = data;
  }

  public static final class Builder {
    private List<RichTagPositionDto> data;

    private Builder() {
    }

    public static Builder aRichTagPositionsDto() {
      return new Builder();
    }

    public Builder data(List<RichTagPositionDto> data) {
      this.data = data;
      return this;
    }

    public RichTagPositionsDto build() {
      RichTagPositionsDto richTagPositionsDto = new RichTagPositionsDto();
      richTagPositionsDto.setData(data);
      return richTagPositionsDto;
    }
  }
}
