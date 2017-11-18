package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.rich;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.image.pojo.BoundingBox;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
public class RichTagPosition implements RichModel {
  private RichTagModel richTagModel;
  private BoundingBox boundingBox;

  public RichTagModel getRichTagModel() {
    return richTagModel;
  }

  public void setRichTagModel(RichTagModel richTagModel) {
    this.richTagModel = richTagModel;
  }

  public BoundingBox getBoundingBox() {
    return boundingBox;
  }

  public void setBoundingBox(BoundingBox boundingBox) {
    this.boundingBox = boundingBox;
  }

  public static final class Builder {
    private RichTagModel richTagModel;
    private BoundingBox boundingBox;

    private Builder() {
    }

    public static Builder aRichTagPosition() {
      return new Builder();
    }

    public Builder richTagModel(RichTagModel richTagModel) {
      this.richTagModel = richTagModel;
      return this;
    }

    public Builder boundingBox(BoundingBox boundingBox) {
      this.boundingBox = boundingBox;
      return this;
    }

    public RichTagPosition build() {
      RichTagPosition richTagPosition = new RichTagPosition();
      richTagPosition.setRichTagModel(richTagModel);
      richTagPosition.setBoundingBox(boundingBox);
      return richTagPosition;
    }
  }
}
