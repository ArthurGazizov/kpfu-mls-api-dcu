package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.rich;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.base.BaseDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.meta.MetaInfoDto;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class RichTagDto extends BaseDto implements RichDto {
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

    public static Builder aRichTagDto() {
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

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder code(String code) {
      this.code = code;
      return this;
    }

    public RichTagDto build() {
      RichTagDto richTagDto = new RichTagDto();
      richTagDto.setId(id);
      richTagDto.setMetaInfoDto(metaInfoDto);
      richTagDto.setName(name);
      richTagDto.setCode(code);
      return richTagDto;
    }
  }
}
