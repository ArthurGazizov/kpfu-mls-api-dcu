package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.rich;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.base.BaseDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.meta.MetaInfoDto;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class RichDataSetDto extends BaseDto implements RichDto {
  @ApiModelProperty(
          notes = "The database generated data set ID"
          , name = "id"
          , example = "123456"
          , readOnly = true)

  @JsonProperty("id")
  private Long id;

  @ApiModelProperty(
          notes = "Data set name"
          , name = "name"
          , example = "example name"
          , readOnly = true)
  @JsonProperty("name")
  private String name;

  @ApiModelProperty(
          notes = "Data set elements"
          , name = "richDataSetElementDtos"
          , readOnly = true)
  @JsonProperty("richDataSetElementDtos")
  private List<RichDataSetElementDto> richDataSetElementDtos;

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

  public List<RichDataSetElementDto> getRichDataSetElementDtos() {
    return richDataSetElementDtos;
  }

  public void setRichDataSetElementDtos(List<RichDataSetElementDto> richDataSetElementDtos) {
    this.richDataSetElementDtos = richDataSetElementDtos;
  }

  public static final class Builder {
    protected MetaInfoDto metaInfoDto;

    private Long id;
    private String name;
    private List<RichDataSetElementDto> richDataSetElementDtos;

    private Builder() {
    }

    public static Builder aRichDataSetDto() {
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

    public Builder richDataSetElementDtos(List<RichDataSetElementDto> richDataSetElementDtos) {
      this.richDataSetElementDtos = richDataSetElementDtos;
      return this;
    }

    public RichDataSetDto build() {
      RichDataSetDto richDataSetDto = new RichDataSetDto();
      richDataSetDto.setId(id);
      richDataSetDto.setMetaInfoDto(metaInfoDto);
      richDataSetDto.setName(name);
      richDataSetDto.setRichDataSetElementDtos(richDataSetElementDtos);
      return richDataSetDto;
    }
  }
}
