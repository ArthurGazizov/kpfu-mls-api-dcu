package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 02.11.17.
 */
public class DataSetDto extends BaseDto {
  private Long id;
  private String name;

  public Long getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public static final class Builder {
    protected MetaInfoDto metaInfoDto;
    private Long id;
    private String name;

    private Builder() {
    }

    public static Builder aDataSetDto() {
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

    public DataSetDto build() {
      DataSetDto dataSetDto = new DataSetDto();
      dataSetDto.name = this.name;
      dataSetDto.id = this.id;
      dataSetDto.metaInfoDto = this.metaInfoDto;
      return dataSetDto;
    }
  }
}
