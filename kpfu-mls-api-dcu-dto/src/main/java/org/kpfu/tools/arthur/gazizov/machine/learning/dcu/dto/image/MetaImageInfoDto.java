package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.base.BaseDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.meta.MetaInfoDto;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class MetaImageInfoDto extends BaseDto {
  @ApiModelProperty(
          notes = "The database generated bounding box ID"
          , name = "id"
          , example = "123456"
          , readOnly = true)

  @JsonProperty("id")
  private Long id;

  @ApiModelProperty(
          notes = "Image ID"
          , name = "imageId"
          , example = "123456"
          , readOnly = true)

  @JsonProperty("imageId")
  private Long imageId;

  @ApiModelProperty(
          notes = "Tag positions"
          , name = "tagPositions")
  @JsonProperty("tagPositions")
  private TagPositionsDto tagPositionsDto;

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

  public TagPositionsDto getTagPositionsDto() {
    return tagPositionsDto;
  }

  public void setTagPositionsDto(TagPositionsDto tagPositionsDto) {
    this.tagPositionsDto = tagPositionsDto;
  }

  public static final class Builder {
    protected MetaInfoDto metaInfoDto;

    private Long id;

    private Long imageId;
    private TagPositionsDto tagPositionsDto;

    private Builder() {
    }

    public static Builder aMetaImageDto() {
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

    public Builder tagPositionsDto(TagPositionsDto tagPositionsDto) {
      this.tagPositionsDto = tagPositionsDto;
      return this;
    }

    public MetaImageInfoDto build() {
      MetaImageInfoDto metaImageInfoDto = new MetaImageInfoDto();
      metaImageInfoDto.setMetaInfoDto(metaInfoDto);
      metaImageInfoDto.tagPositionsDto = this.tagPositionsDto;
      metaImageInfoDto.id = this.id;
      metaImageInfoDto.imageId = this.imageId;
      return metaImageInfoDto;
    }
  }
}
