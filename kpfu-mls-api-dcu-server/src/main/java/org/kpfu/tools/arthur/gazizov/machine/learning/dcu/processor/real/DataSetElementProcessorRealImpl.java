package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.real;

import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.DataSetElementConverter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.converter.interfaces.base.Converter;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetElementDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.support.PageResponse;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.DataSetElementModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.model.support.PageModel;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.base.AbstractCRUDProcessorImpl;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.DataSetElementProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.CRUDService;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.service.DataSetElementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 12.11.17.
 */
@Service("dataSetElementProcessorRealImpl")
public class DataSetElementProcessorRealImpl extends AbstractCRUDProcessorImpl<DataSetElementDto, DataSetElementModel> implements DataSetElementProcessor {
  @Autowired
  private DataSetElementService dataSetElementService;

  @Autowired
  private DataSetElementConverter dataSetElementConverter;

  @Override
  public CRUDService<DataSetElementModel> crudService() {
    return dataSetElementService;
  }

  @Override
  public Converter<DataSetElementModel, DataSetElementDto> converter() {
    return dataSetElementConverter;
  }

  @Override
  public ResponseEntity<PageResponse<DataSetElementDto>> searchByDataSetId(Long dataSetId, Integer limit, Integer offset) {
    final PageModel<DataSetElementModel> byDataSetId = dataSetElementService.searchByDataSetId(dataSetId, limit, offset);
    final PageResponse<DataSetElementDto> pageResponse = PageResponse.Builder.<DataSetElementDto>aPageResponse()
            .total(byDataSetId.getTotal())
            .offset(byDataSetId.getOffset())
            .data(byDataSetId.getData().stream().map(m -> dataSetElementConverter.convert(m)).collect(Collectors.toList()))
            .build();
    return ResponseEntity.ok(pageResponse);
  }

  @Override
  public ResponseEntity<Integer> elementsCountInDataSet(Long dataSetId) {
    final Integer count = dataSetElementService.elementsCountInDataSet(dataSetId);
    return ResponseEntity.ok(count);
  }
}
