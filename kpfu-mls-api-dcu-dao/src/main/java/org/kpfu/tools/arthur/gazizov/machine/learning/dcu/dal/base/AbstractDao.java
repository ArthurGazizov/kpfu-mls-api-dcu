package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.base;

import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
public abstract class AbstractDao {
  @Autowired
  private DSLContext dslContext;

  @PostConstruct
  public void configure() {
    if (dslContext.configuration().dialect() != SQLDialect.POSTGRES) {
      dslContext.configuration().set(SQLDialect.POSTGRES);
    }
  }

  public DSLContext getDslContext() {
    return dslContext;
  }
}
