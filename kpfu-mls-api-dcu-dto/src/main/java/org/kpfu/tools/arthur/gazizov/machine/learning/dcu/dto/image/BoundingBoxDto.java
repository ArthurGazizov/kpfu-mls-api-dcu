package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.common.Dto;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class BoundingBoxDto implements Dto {
  @ApiModelProperty(
          notes = "List of points"
          , name = "points"
          , readOnly = true)
  @JsonProperty("points")
  private List<PointDto> points;

  public List<PointDto> getPoints() {
    return points;
  }

  public void setPoints(List<PointDto> points) {
    this.points = points;
  }

  public static final class Builder {
    private List<PointDto> points;

    private Builder() {
    }

    public static Builder aBoundingBoxDto() {
      return new Builder();
    }

    public Builder points(List<PointDto> points) {
      this.points = points;
      return this;
    }

    public BoundingBoxDto build() {
      BoundingBoxDto boundingBoxDto = new BoundingBoxDto();
      boundingBoxDto.setPoints(points);
      return boundingBoxDto;
    }
  }
}
