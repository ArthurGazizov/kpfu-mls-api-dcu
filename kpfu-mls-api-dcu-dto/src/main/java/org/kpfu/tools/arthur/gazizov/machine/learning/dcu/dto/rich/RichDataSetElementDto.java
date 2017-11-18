package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.rich;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.base.BaseDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.meta.MetaInfoDto;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class RichDataSetElementDto extends BaseDto implements RichDto {
  @ApiModelProperty(
          notes = "The database generated data set element ID"
          , name = "id"
          , example = "123456"
          , readOnly = true)

  @JsonProperty("id")
  private Long id;

  @ApiModelProperty(
          notes = "The meta image info"
          , name = "richMetaImageInfoDto"
          , readOnly = true)

  @JsonProperty("richMetaImageInfoDto")
  private RichMetaImageInfoDto richMetaImageInfoDto;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public RichMetaImageInfoDto getRichMetaImageInfoDto() {
    return richMetaImageInfoDto;
  }

  public void setRichMetaImageInfoDto(RichMetaImageInfoDto richMetaImageInfoDto) {
    this.richMetaImageInfoDto = richMetaImageInfoDto;
  }

  public static final class Builder {
    protected MetaInfoDto metaInfoDto;

    private Long id;

    private RichMetaImageInfoDto richMetaImageInfoDto;

    private Builder() {
    }

    public static Builder aRichDataSetElementDto() {
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

    public Builder richMetaImageInfoDto(RichMetaImageInfoDto richMetaImageInfoDto) {
      this.richMetaImageInfoDto = richMetaImageInfoDto;
      return this;
    }

    public RichDataSetElementDto build() {
      RichDataSetElementDto richDataSetElementDto = new RichDataSetElementDto();
      richDataSetElementDto.setId(id);
      richDataSetElementDto.setMetaInfoDto(metaInfoDto);
      richDataSetElementDto.setRichMetaImageInfoDto(richMetaImageInfoDto);
      return richDataSetElementDto;
    }
  }
}
