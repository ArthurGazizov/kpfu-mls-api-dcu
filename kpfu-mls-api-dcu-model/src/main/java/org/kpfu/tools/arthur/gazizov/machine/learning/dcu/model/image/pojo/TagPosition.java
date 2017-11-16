package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image.pojo;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.Model;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class TagPosition implements Model {
  private Long tagId;
  private BoundingBox boundingBox;

  public Long getTagId() {
    return tagId;
  }

  public void setTagId(Long tagId) {
    this.tagId = tagId;
  }

  public BoundingBox getBoundingBox() {
    return boundingBox;
  }

  public void setBoundingBox(BoundingBox boundingBox) {
    this.boundingBox = boundingBox;
  }

  public static final class Builder {
    private Long tagId;
    private BoundingBox boundingBox;

    private Builder() {
    }

    public static Builder aTagPosition() {
      return new Builder();
    }

    public Builder tagId(Long tagId) {
      this.tagId = tagId;
      return this;
    }

    public Builder boundingBox(BoundingBox boundingBox) {
      this.boundingBox = boundingBox;
      return this;
    }

    public TagPosition build() {
      TagPosition tagPosition = new TagPosition();
      tagPosition.setTagId(tagId);
      tagPosition.setBoundingBox(boundingBox);
      return tagPosition;
    }
  }
}
