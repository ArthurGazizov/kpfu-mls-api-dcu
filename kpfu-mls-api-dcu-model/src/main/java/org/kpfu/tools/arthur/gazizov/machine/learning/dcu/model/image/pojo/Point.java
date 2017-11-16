package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image.pojo;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.Model;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class Point implements Model{
  private Integer x;
  private Integer y;

  public Integer getX() {
    return x;
  }

  public void setX(Integer x) {
    this.x = x;
  }

  public Integer getY() {
    return y;
  }

  public void setY(Integer y) {
    this.y = y;
  }

  public static final class Builder {
    private Integer x;
    private Integer y;

    private Builder() {
    }

    public static Builder aPoint() {
      return new Builder();
    }

    public Builder x(Integer x) {
      this.x = x;
      return this;
    }

    public Builder y(Integer y) {
      this.y = y;
      return this;
    }

    public Point build() {
      Point point = new Point();
      point.setX(x);
      point.setY(y);
      return point;
    }
  }
}
