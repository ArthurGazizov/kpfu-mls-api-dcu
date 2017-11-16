package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 14.11.17.
 */
public class TagDto extends BaseDto {
  @ApiModelProperty(
          notes = "The database generated tag ID"
          , name = "id"
          , example = "123456"
          , readOnly = true)

  @JsonProperty("id")
  private Long id;

  @ApiModelProperty(
          notes = "Tag name"
          , name = "name"
          , example = "example name")
  @JsonProperty("name")
  private String name;

  @ApiModelProperty(
          notes = "Tag code"
          , name = "code"
          , example = "ESP0")
  @JsonProperty("code")
  private String code;

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

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public static final class Builder {
    protected MetaInfoDto metaInfoDto;

    private Long id;
    private String name;
    private String code;

    private Builder() {
    }

    public static Builder aTagDto() {
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

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder code(String code) {
      this.code = code;
      return this;
    }

    public TagDto build() {
      TagDto tagDto = new TagDto();
      tagDto.setMetaInfoDto(metaInfoDto);
      tagDto.id = this.id;
      tagDto.name = this.name;
      tagDto.code = this.code;
      return tagDto;
    }
  }
}
