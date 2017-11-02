package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 02.11.17.
 */
public abstract class BaseDto implements Dto {
  protected  MetaInfoDto metaInfoDto;
  public MetaInfoDto getMetaInfoDto() {
    return metaInfoDto;
  }
}
