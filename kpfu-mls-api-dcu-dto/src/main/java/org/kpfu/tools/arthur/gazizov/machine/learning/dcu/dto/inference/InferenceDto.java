package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.inference;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.common.Dto;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 24/11/2017.
 */
public class InferenceDto implements Dto {
  private List<TagValueDto> tagValues;

  public List<TagValueDto> getTagValues() {
    return tagValues;
  }

  public void setTagValues(List<TagValueDto> tagValues) {
    this.tagValues = tagValues;
  }

  public static final class Builder {
    private List<TagValueDto> tagValues;

    private Builder() {
    }

    public static Builder anInferenceDto() {
      return new Builder();
    }

    public Builder tagValues(List<TagValueDto> tagValues) {
      this.tagValues = tagValues;
      return this;
    }

    public InferenceDto build() {
      InferenceDto inferenceDto = new InferenceDto();
      inferenceDto.setTagValues(tagValues);
      return inferenceDto;
    }
  }
}
