package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.inference;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.common.Dto;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 24/11/2017.
 */
public class TagValueDto implements Dto {
  @ApiModelProperty(
          notes = "Tag id"
          , name = "tagId"
          , example = "374682763"
          , readOnly = true)
  @JsonProperty("tagId")
  private Long tagId;

  @ApiModelProperty(
          notes = "Probability"
          , name = "probability"
          , example = "0.01"
          , readOnly = true)
  @JsonProperty("probability")
  private Double probability;

  public Long getTagId() {
    return tagId;
  }

  public Double getProbability() {
    return probability;
  }

  public static final class Builder {
    private Long tagId;
    private Double probability;

    private Builder() {
    }

    public static Builder aTagValueDto() {
      return new Builder();
    }

    public Builder tagId(Long tagId) {
      this.tagId = tagId;
      return this;
    }

    public Builder probability(Double probability) {
      this.probability = probability;
      return this;
    }

    public TagValueDto build() {
      TagValueDto tagValueDto = new TagValueDto();
      tagValueDto.probability = this.probability;
      tagValueDto.tagId = this.tagId;
      return tagValueDto;
    }
  }
}
