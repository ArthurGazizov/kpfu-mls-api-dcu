package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.base;

import org.jooq.Field;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.UpdatableRecord;

import java.io.Serializable;
import java.util.List;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
public abstract class AbstractCRUDDao<I extends Serializable, R extends UpdatableRecord<R>> extends AbstractDao implements CRUDDao<I, R> {
  private final Field<I> idField = this.idField();

  protected abstract Table<R> table();


  @SuppressWarnings("unchecked")
  protected Field<I> idField() {
    List<TableField<R, ?>> primaryKeyFields = this.table().getPrimaryKey().getFields();
    if (primaryKeyFields.size() > 1) {
      throw new IllegalStateException("More than one field in primary key is not allowed");
    } else {
      return (Field) primaryKeyFields.get(0);
    }
  }

  protected Field<?>[] selectFields() {
    return this.table().fields();
  }

}
