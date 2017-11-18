package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.rich;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class RichTagPositions implements RichModel {
  private List<RichTagPosition> data;

  public List<RichTagPosition> getData() {
    return data;
  }

  public void setData(List<RichTagPosition> data) {
    this.data = data;
  }

  public static final class Builder {
    private List<RichTagPosition> data;

    private Builder() {
    }

    public static Builder aRichTagPositions() {
      return new Builder();
    }

    public Builder data(List<RichTagPosition> data) {
      this.data = data;
      return this;
    }

    public RichTagPositions build() {
      RichTagPositions richTagPositions = new RichTagPositions();
      richTagPositions.setData(data);
      return richTagPositions;
    }
  }
}
