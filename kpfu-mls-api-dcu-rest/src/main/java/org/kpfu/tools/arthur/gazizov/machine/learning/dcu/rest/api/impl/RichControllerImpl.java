package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.api.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.ErrorDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.rich.RichDataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.RichProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.api.interfaces.RichController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Controller
@RequestMapping(value = "/v1/dcu/", produces = {APPLICATION_JSON_VALUE})
@Api(value = "RichController", description = "The RichController API")
public class RichControllerImpl implements RichController {
  @Autowired
  private RichProcessor richProcessor;

  @ApiOperation(value = "Get Dataset", notes = "", response = RichDataSetDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = RichDataSetDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/dataset/{id}/rich",
          produces = {"application/json"},
          method = RequestMethod.GET)
  @Override
  public ResponseEntity<RichDataSetDto> loadReachDataSet(@ApiParam(value = "id", required = true)
                                                         @PathVariable("id") Long id) {
    return richProcessor.loadReachDataSet(id);
  }
}
