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
          , name = "tagPositions")
  @JsonProperty("tagPositions")
  private TagPositionsDto tagPositionsDto;

  @ApiModelProperty(
          notes = "Original filename"
          , name = "originalFilename")
  @JsonProperty("originalFilename")
  private String originalFilename;


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

  public String getOriginalFilename() {
    return originalFilename;
  }

  public void setOriginalFilename(String originalFilename) {
    this.originalFilename = originalFilename;
  }

  public static final class Builder {
    protected MetaInfoDto metaInfoDto;

    private Long id;

    private Long imageId;
    private TagPositionsDto tagPositionsDto;
    private String originalFilename;

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

    public Builder originalFilename(String originalFilename) {
      this.originalFilename = originalFilename;
      return this;
    }

    public MetaImageInfoDto build() {
      MetaImageInfoDto metaImageInfoDto = new MetaImageInfoDto();
      metaImageInfoDto.setMetaInfoDto(metaInfoDto);
      metaImageInfoDto.setId(id);
      metaImageInfoDto.setImageId(imageId);
      metaImageInfoDto.setTagPositionsDto(tagPositionsDto);
      metaImageInfoDto.setOriginalFilename(originalFilename);
      return metaImageInfoDto;
    }
  }
}
