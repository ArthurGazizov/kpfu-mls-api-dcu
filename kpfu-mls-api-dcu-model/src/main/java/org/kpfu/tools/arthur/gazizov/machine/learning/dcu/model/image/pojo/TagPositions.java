package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image.pojo;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.Model;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class TagPositions implements Model {
  private List<TagPosition> data;

  public List<TagPosition> getData() {
    return data;
  }

  public void setData(List<TagPosition> data) {
    this.data = data;
  }

  public static final class Builder {
    private List<TagPosition> data;

    private Builder() {
    }

    public static Builder aTagPositions() {
      return new Builder();
    }

    public Builder data(List<TagPosition> data) {
      this.data = data;
      return this;
    }

    public TagPositions build() {
      TagPositions tagPositions = new TagPositions();
      tagPositions.setData(data);
      return tagPositions;
    }
  }
}
