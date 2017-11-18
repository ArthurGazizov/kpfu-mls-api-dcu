package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.rich;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image.BoundingBoxDto;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class RichTagPositionDto implements RichDto {
  @ApiModelProperty(
          notes = "Tag"
          , name = "tag"
          , readOnly = true)
  @JsonProperty("tag")
  private RichTagDto tag;

  @ApiModelProperty(
          notes = "Bounding box"
          , name = "boundingBox"
          , readOnly = true)
  @JsonProperty("boundingBox")
  private BoundingBoxDto boundingBox;

  public RichTagDto getTag() {
    return tag;
  }

  public void setTag(RichTagDto tag) {
    this.tag = tag;
  }

  public BoundingBoxDto getBoundingBox() {
    return boundingBox;
  }

  public void setBoundingBox(BoundingBoxDto boundingBox) {
    this.boundingBox = boundingBox;
  }

  public static final class Builder {
    private RichTagDto tag;
    private BoundingBoxDto boundingBox;

    private Builder() {
    }

    public static Builder aRichTagPositionDto() {
      return new Builder();
    }

    public Builder tag(RichTagDto tag) {
      this.tag = tag;
      return this;
    }

    public Builder boundingBox(BoundingBoxDto boundingBox) {
      this.boundingBox = boundingBox;
      return this;
    }

    public RichTagPositionDto build() {
      RichTagPositionDto richTagPositionDto = new RichTagPositionDto();
      richTagPositionDto.setTag(tag);
      richTagPositionDto.setBoundingBox(boundingBox);
      return richTagPositionDto;
    }
  }
}
