package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.rich;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.base.BaseDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.meta.MetaInfoDto;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class RichMetaImageInfoDto extends BaseDto implements RichDto {
  @ApiModelProperty(
          notes = "The database meta image info ID"
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
          , name = "tagPositionsDto"
          , readOnly = true)

  @JsonProperty("tagPositionsDto")
  private RichTagPositionsDto tagPositionsDto;

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

  public RichTagPositionsDto getTagPositionsDto() {
    return tagPositionsDto;
  }

  public void setTagPositionsDto(RichTagPositionsDto tagPositionsDto) {
    this.tagPositionsDto = tagPositionsDto;
  }

  public static final class Builder {
    protected MetaInfoDto metaInfoDto;

    private Long id;

    private Long imageId;

    private RichTagPositionsDto tagPositionsDto;

    private Builder() {
    }

    public static Builder aRichMetaImageInfoDto() {
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

    public Builder imageId(Long imageId) {
      this.imageId = imageId;
      return this;
    }

    public Builder tagPositionsDto(RichTagPositionsDto tagPositionsDto) {
      this.tagPositionsDto = tagPositionsDto;
      return this;
    }

    public RichMetaImageInfoDto build() {
      RichMetaImageInfoDto richMetaImageInfoDto = new RichMetaImageInfoDto();
      richMetaImageInfoDto.setId(id);
      richMetaImageInfoDto.setMetaInfoDto(metaInfoDto);
      richMetaImageInfoDto.setImageId(imageId);
      richMetaImageInfoDto.setTagPositionsDto(tagPositionsDto);
      return richMetaImageInfoDto;
    }
  }
}
