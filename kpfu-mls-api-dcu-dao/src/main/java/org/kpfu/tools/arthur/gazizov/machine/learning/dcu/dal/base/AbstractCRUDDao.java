package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.base;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Result;
import org.jooq.SelectQuery;
import org.jooq.SelectSelectStep;
import org.jooq.Table;
import org.jooq.UpdatableRecord;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dal.mapper.base.Mapper;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.exception.KpfuMlsDcuError;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.EntityModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.support.PageModel;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
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
  public PageModel<E> findAll(Integer limit, Integer offset) {
    return search(Collections.emptyList(), limit, offset);
  }

  @Override
  public PageModel<E> search(List<Condition> conditions, Integer limit, Integer offset) {
    final SelectQuery<Record> selectQuery = getDslContext().selectQuery();
    selectQuery.addConditions(conditions);
    final SelectSelectStep<Record1<Integer>> selectOne = getDslContext().selectOne();
    selectOne.where(conditions);
    selectOne.from(table());
    selectQuery.addFrom(table());
    selectQuery.addSelect(selectFields());
    if (Objects.nonNull(limit)) {
      if (Objects.nonNull(offset)) {
        selectQuery.addLimit(offset, limit);
      } else {
        selectQuery.addLimit(limit);
      }
    }
    final Result<Record> fetch = selectQuery.fetch();
    final List<E> data = fetch.stream()
            .map(mapper()::mapToModel)
            .collect(Collectors.toList());
    return PageModel.Builder.<E>aPageModel()
            .data(data)
            .offset(offset)
            .total(selectOne.execute())
            .build();
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
