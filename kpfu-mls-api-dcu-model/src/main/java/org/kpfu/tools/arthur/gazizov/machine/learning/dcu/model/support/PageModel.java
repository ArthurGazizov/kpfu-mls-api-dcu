package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.support;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.Model;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class PageModel<M extends Model> {
  private List<M> data;
  private Integer total;
  private Integer offset;

  public List<M> getData() {
    return data;
  }

  public Integer getTotal() {
    return total;
  }

  public Integer getOffset() {
    return offset;
  }

  public static final class Builder<M extends Model> {
    private List<M> data;
    private Integer total;
    private Integer offset;

    private Builder() {
    }

    public static <M extends Model> Builder<M> aPageModel() {
      return new Builder<>();
    }

    public Builder<M> data(List<M> data) {
      this.data = data;
      return this;
    }

    public Builder<M> total(Integer total) {
      this.total = total;
      return this;
    }

    public Builder<M> offset(Integer offset) {
      this.offset = offset;
      return this;
    }

    public PageModel<M> build() {
      PageModel<M> pageModel = new PageModel<>();
      pageModel.total = this.total;
      pageModel.offset = this.offset;
      pageModel.data = this.data;
      return pageModel;
    }
  }
}
