package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.common.Dto;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class PointDto implements Dto {
  @ApiModelProperty(
          notes = "X"
          , name = "x"
          , example = "78"
          , readOnly = true)
  @JsonProperty("x")
  private Integer x;

  @ApiModelProperty(
          notes = "Y"
          , name = "y"
          , example = "78"
          , readOnly = true)
  @JsonProperty("y")
  private Integer y;

  public Integer getX() {
    return x;
  }

  public Integer getY() {
    return y;
  }

  public void setX(Integer x) {
    this.x = x;
  }

  public void setY(Integer y) {
    this.y = y;
  }

  public static final class Builder {
    private Integer x;
    private Integer y;

    private Builder() {
    }

    public static Builder aPointDto() {
      return new Builder();
    }

    public Builder x(Integer x) {
      this.x = x;
      return this;
    }

    public Builder y(Integer y) {
      this.y = y;
      return this;
    }

    public PointDto build() {
      PointDto pointDto = new PointDto();
      pointDto.y = this.y;
      pointDto.x = this.x;
      return pointDto;
    }
  }
}
