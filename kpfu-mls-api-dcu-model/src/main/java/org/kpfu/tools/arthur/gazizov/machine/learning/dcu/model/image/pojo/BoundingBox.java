package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image.pojo;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.Model;

import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class BoundingBox implements Model {
  private List<Point> points;

  public List<Point> getPoints() {
    return points;
  }

  public void setPoints(List<Point> points) {
    this.points = points;
  }

  public static final class Builder {
    private List<Point> points;

    private Builder() {
    }

    public static Builder aBoundingBox() {
      return new Builder();
    }

    public Builder points(List<Point> points) {
      this.points = points;
      return this;
    }

    public BoundingBox build() {
      BoundingBox boundingBox = new BoundingBox();
      boundingBox.setPoints(points);
      return boundingBox;
    }
  }
}
