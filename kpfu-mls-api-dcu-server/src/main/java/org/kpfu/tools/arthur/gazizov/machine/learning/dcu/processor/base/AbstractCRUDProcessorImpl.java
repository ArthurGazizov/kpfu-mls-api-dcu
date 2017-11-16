package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.base;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.base.Converter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.common.Dto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.support.PageResponse;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.Model;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.support.PageModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.CRUDService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
public abstract class AbstractCRUDProcessorImpl<T extends Dto, M extends Model> implements CRUDProcessor<T> {
  @Override
  public ResponseEntity<T> get(Long id) {
    final M m = crudService().get(id);
    final T dto = converter().convert(m);
    return ResponseEntity.ok(dto);
  }

  @Override
  public ResponseEntity<T> save(T t) {
    final M model = converter().convert(t);
    final M saved = crudService().save(model);
    final T dto = converter().convert(saved);
    return new ResponseEntity<>(dto, HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<T> update(T t) {
    final M model = converter().convert(t);
    final M saved = crudService().update(model);
    final T dto = converter().convert(saved);
    return ResponseEntity.ok(dto);
  }

  @Override
  public ResponseEntity<T> patch(T t) {
    final M model = converter().convert(t);
    final M saved = crudService().patch(model);
    final T dto = converter().convert(saved);
    return ResponseEntity.ok(dto);
  }

  @Override
  public ResponseEntity<Void> delete(Long id) {
    crudService().delete(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @Override
  public ResponseEntity<T> restore(Long id) {
    final M restored = crudService().restore(id);
    final T dto = converter().convert(restored);
    return ResponseEntity.ok(dto);
  }

  @Override
  public ResponseEntity<List<T>> findAll() {
    final List<M> all = crudService().findAll();
    final List<T> dto = all.stream()
            .map(m -> converter().convert(m))
            .collect(Collectors.toList());
    return ResponseEntity.ok(dto);
  }

  @Override
  public ResponseEntity<PageResponse<T>> findAll(Integer limit, Integer offset) {
    final PageModel<M> pageModel = crudService().findAll(limit, offset);
    final PageResponse<T> pageResponse = PageResponse.Builder.<T>aPageResponse()
            .data(pageModel.getData().stream()
                    .map(m -> converter().convert(m))
                    .collect(Collectors.toList()))
            .offset(Optional.ofNullable(pageModel.getOffset()).orElse(0))
            .total(pageModel.getTotal())
            .build();
    return ResponseEntity.ok(pageResponse);
  }

  public abstract CRUDService<M> crudService();

  public abstract Converter<M, T> converter();
}
