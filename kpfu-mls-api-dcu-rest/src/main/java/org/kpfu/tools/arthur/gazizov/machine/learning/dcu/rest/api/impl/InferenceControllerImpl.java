package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.api.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.ErrorDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.inference.InferenceDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.InferenceProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.api.interfaces.InferenceController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 24/11/2017.
 */
@Controller
@RequestMapping(value = "/v1/dcu/inference/", produces = {APPLICATION_JSON_VALUE})
@Api(value = "InferenceController", description = "The InferenceController API")
public class InferenceControllerImpl implements InferenceController {
  @Autowired
  private InferenceProcessor inferenceProcessor;

  @ApiOperation(
          value = "Make inference ", notes = "", response = InferenceDto.class,
          consumes = "multipart/form-data, application/json, application/octet-stream",
          produces = "application/json")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = InferenceDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/{dataSetId}/make",
          consumes = {"multipart/form-data", "application/json", "application/octet-stream"},
          produces = "application/json",
          method = RequestMethod.POST)
  @Override
  public ResponseEntity<InferenceDto> makeInference(@ApiParam(value = "dataSetId", required = true)
                                                    @PathVariable("dataSetId") Long dataSetId,
                                                    @ApiParam(value = "file detail", name = "multipartFile", required = true, type = "file")
                                                    @RequestPart(value = "multipartFile", required = true) MultipartFile multipartFile) {
    return inferenceProcessor.makeInference(dataSetId, multipartFile);
  }
}
