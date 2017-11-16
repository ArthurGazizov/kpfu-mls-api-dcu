package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.support;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.common.Dto;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class PageResponse<D extends Dto> implements Dto {
  private List<D> data;
  private Integer offset;
  private Integer total;

  public List<D> getData() {
    return data;
  }

  public Integer getOffset() {
    return offset;
  }

  public Integer getTotal() {
    return total;
  }

  public static final class Builder<D extends Dto> {
    private List<D> data;
    private Integer offset;
    private Integer total;

    private Builder() {
    }

    public static <D extends Dto> Builder<D> aPageResponse() {
      return new Builder<>();
    }

    public Builder<D> data(List<D> data) {
      this.data = data;
      return this;
    }

    public Builder<D> offset(Integer offset) {
      this.offset = offset;
      return this;
    }

    public Builder<D> total(Integer total) {
      this.total = total;
      return this;
    }

    public PageResponse<D> build() {
      PageResponse<D> pageResponse = new PageResponse<>();
      pageResponse.offset = this.offset;
      pageResponse.data = this.data;
      pageResponse.total = this.total;
      return pageResponse;
    }
  }
}
