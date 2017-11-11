package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.base;

import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Table;
import org.jooq.UpdatableRecord;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.base.Mapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.exception.KpfuMlsDcuError;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.EntityModel;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 09.11.17.
 */
public abstract class AbstractCRUDDao<E extends EntityModel, R extends UpdatableRecord<R>> extends AbstractDao implements CRUDDao<Long, E> {

  protected abstract Table<R> table();

  protected Field<?>[] selectFields() {
    return this.table().fields();
  }

  @Override
  public E save(E e) {
    final R entity = mapper().mapToEntity(e);
    final R saved = getDslContext()
            .insertInto(table())
            .set(entity)
            .returning()
            .fetchOne();
    return mapper().mapToModel(saved);
  }

  @Override
  public Iterable<E> save(Iterable<E> iterable) {
    return StreamSupport.stream(iterable.spliterator(), false)
            .map(this::save)
            .collect(Collectors.toList());
  }

  @Override
  public E update(E e) {
    final R entity = mapper().mapToEntity(e);
    final int executed = getDslContext().update(table())
            .set(entity)
            .where(idField().eq(e.getId()))
            .execute();
    if (executed == 0) {
      throw new RuntimeException();
    }
    return find(e.getId());
  }

  @Override
  public void delete(E e) {
    delete(e.getId());
  }

  @Override
  public void delete(Long id) {
    getDslContext().deleteFrom(table()).where(idField().eq(id)).execute();
  }

  @Override
  public void deleteAll() {
    StreamSupport.stream(findAll().spliterator(), false)
            .map(EntityModel::getId)
            .forEach(this::delete);
  }

  @Override
  public void deleteAll(Iterable<Long> iterable) {
    StreamSupport.stream(iterable.spliterator(), false)
            .forEach(this::delete);
  }

  @Override
  public Iterable<E> findAll() {
    return getDslContext()
            .select(selectFields())
            .from(table())
            .fetch()
            .stream()
            .map(r -> mapper().mapToModel(r))
            .collect(Collectors.toList());
  }

  @Override
  public Iterable<E> findAll(Iterable<Long> iterable) {
    final Set<Long> ids = StreamSupport.stream(iterable.spliterator(), false)
            .collect(Collectors.toSet());
    return getDslContext()
            .select(selectFields())
            .from(table())
            .where(idField().in(ids))
            .fetch()
            .stream()
            .map(r -> mapper().mapToModel(r))
            .collect(Collectors.toList());
  }

  @Override
  public long count() {
    return getDslContext()
            .fetchCount(table());
  }

  @Override
  public boolean exist(Long id) {
    return getDslContext()
            .fetchExists(
                    getDslContext()
                            .selectOne()
                            .from(table())
                            .where(idField().eq(id))
            );
  }

  @Override
  public E find(Long id) {
    final Record record = getDslContext()
            .select(selectFields())
            .from(table())
            .where(idField().eq(id))
            .fetchOne();
    return mapper().mapToModel(record);
  }

  @Override
  public E restore(Long id) {
    throw KpfuMlsDcuError.UNSUPPORTED_OPERATION.exception("Restore operation does't support");
  }

  protected abstract Mapper<E, R> mapper();

  protected abstract Field<Long> idField();
}
