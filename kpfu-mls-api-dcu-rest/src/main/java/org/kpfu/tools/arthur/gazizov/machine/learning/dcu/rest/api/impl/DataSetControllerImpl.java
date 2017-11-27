package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.api.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.ErrorDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.support.PageResponse;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.base.CRUDProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.DataSetProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.api.interfaces.DataSetController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 10.11.17.
 */
@Controller
@RequestMapping(value = "/v1/dcu", produces = {APPLICATION_JSON_VALUE})
@Api(value = "DataSetController", description = "The DataSetController API")
public class DataSetControllerImpl implements DataSetController {
  @Autowired
  private DataSetProcessor dataSetProcessor;

  @ApiOperation(value = "Get Dataset", notes = "", response = DataSetDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = DataSetDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/dataset/{id}",
          produces = {"application/json"},
          method = RequestMethod.GET)
  @Override
  public ResponseEntity<DataSetDto> get(@ApiParam(value = "id", required = true)
                                        @PathVariable("id") Long id) {
    return DataSetController.super.get(id);
  }

  @ApiOperation(value = "Save Dataset", notes = "", response = DataSetDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 201, message = "", response = DataSetDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/dataset",
          produces = {"application/json"},
          method = RequestMethod.POST)
  @Override
  public ResponseEntity<DataSetDto> save(@ApiParam(value = "dataSetDto", required = true)
                                         @RequestBody DataSetDto dataSetDto) {
    return DataSetController.super.save(dataSetDto);
  }

  @ApiOperation(value = "Update Dataset", notes = "", response = DataSetDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = DataSetDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/dataset",
          produces = {"application/json"},
          method = RequestMethod.PUT)
  @Override
  public ResponseEntity<DataSetDto> update(@ApiParam(value = "dataSetDto", required = true)
                                           @RequestBody DataSetDto dataSetDto) {
    return DataSetController.super.update(dataSetDto);
  }

  @ApiOperation(value = "Patch Dataset", notes = "", response = DataSetDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = DataSetDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/dataset",
          produces = {"application/json"},
          method = RequestMethod.PATCH)
  @Override
  public ResponseEntity<DataSetDto> patch(@ApiParam(value = "dataSetDto", required = true)
                                          @RequestBody DataSetDto dataSetDto) {
    return DataSetController.super.patch(dataSetDto);
  }

  @ApiOperation(value = "Delete Dataset", notes = "")
  @ApiResponses(value = {
          @ApiResponse(code = 201, message = ""),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/dataset/{id}",
          produces = {"application/json"},
          method = RequestMethod.DELETE)
  @Override
  public ResponseEntity<Void> delete(@ApiParam(value = "id", required = true)
                                     @PathVariable("id") Long id) {
    return DataSetController.super.delete(id);
  }

  @ApiOperation(value = "Get all Datasets", notes = "", response = List.class)
  @ApiResponses(value = {
          @ApiResponse(code = 201, message = "", response = List.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/dataset/all",
          produces = {"application/json"},
          method = RequestMethod.GET)
  @Override
  public ResponseEntity<List<DataSetDto>> findAll() {
    return DataSetController.super.findAll();
  }

  @ApiOperation(value = "Get pageDataSets Datasets", notes = "", response = PageResponse.class)
  @ApiResponses(value = {
          @ApiResponse(code = 201, message = "", response = PageResponse.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/dataset/page",
          produces = {"application/json"},
          method = RequestMethod.GET)
  @Override
  public ResponseEntity<PageResponse<DataSetDto>> page(@ApiParam(value = "limit", required = true)
                                                          @RequestParam(value = "limit", required = true) Integer limit,
                                                       @ApiParam(value = "offset", required = false)
                                                          @RequestParam(value = "offset", required = false) Integer offset) {
    return DataSetController.super.page(limit, offset);
  }

  @Override
  public CRUDProcessor<DataSetDto> processor() {
    return dataSetProcessor;
  }
}
