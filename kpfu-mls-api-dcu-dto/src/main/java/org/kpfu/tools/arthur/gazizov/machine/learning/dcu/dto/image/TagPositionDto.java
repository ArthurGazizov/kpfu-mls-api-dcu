package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.common.Dto;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class TagPositionDto implements Dto {
  @ApiModelProperty(
          notes = "Tag id"
          , name = "tagId"
          , example = "374682763"
          , readOnly = true)
  @JsonProperty("tagId")
  private Long tagId;

  @ApiModelProperty(
          notes = "Bounding box"
          , name = "boundingBox"
          , readOnly = true)
  @JsonProperty("boundingBox")
  private BoundingBoxDto boundingBox;

  public Long getTagId() {
    return tagId;
  }

  public void setTagId(Long tagId) {
    this.tagId = tagId;
  }

  public BoundingBoxDto getBoundingBox() {
    return boundingBox;
  }

  public void setBoundingBox(BoundingBoxDto boundingBox) {
    this.boundingBox = boundingBox;
  }

  public static final class Builder {
    private Long tagId;
    private BoundingBoxDto boundingBox;

    private Builder() {
    }

    public static Builder aTagPositionDto() {
      return new Builder();
    }

    public Builder tagId(Long tagId) {
      this.tagId = tagId;
      return this;
    }

    public Builder boundingBox(BoundingBoxDto boundingBox) {
      this.boundingBox = boundingBox;
      return this;
    }

    public TagPositionDto build() {
      TagPositionDto tagPositionDto = new TagPositionDto();
      tagPositionDto.setTagId(tagId);
      tagPositionDto.setBoundingBox(boundingBox);
      return tagPositionDto;
    }
  }
}
