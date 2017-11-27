package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.api.impl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.ErrorDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.TagDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.support.PageResponse;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.base.CRUDProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.TagProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.api.interfaces.TagController;
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
 * Created on 16.11.17.
 */
@Controller
@RequestMapping(value = "/v1/dcu/", produces = {APPLICATION_JSON_VALUE})
@Api(value = "TagController", description = "The TagController API")
public class TagControllerImpl implements TagController {
  @Autowired
  private TagProcessor tagProcessor;


  @ApiOperation(value = "Get tag", notes = "", response = TagDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = TagDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/tag/{id}",
          produces = {"application/json"},
          method = RequestMethod.GET)
  @Override
  public ResponseEntity<TagDto> get(@ApiParam(value = "id", required = true)
                                    @PathVariable("id") Long id) {
    return TagController.super.get(id);
  }

  @ApiOperation(value = "Save tag", notes = "", response = TagDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 201, message = "", response = TagDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/tag",
          produces = {"application/json"},
          method = RequestMethod.POST)
  @Override
  public ResponseEntity<TagDto> save(@ApiParam(value = "tagDto", required = true)
                                     @RequestBody TagDto tagDto) {
    return TagController.super.save(tagDto);
  }

  @ApiOperation(value = "Update tag", notes = "", response = TagDto.class, code = 200)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = TagDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/tag",
          produces = {"application/json"},
          method = RequestMethod.PUT)
  @Override
  public ResponseEntity<TagDto> update(@ApiParam(value = "tagDto", required = true)
                                       @RequestBody TagDto tagDto) {
    return TagController.super.update(tagDto);
  }

  @ApiOperation(value = "Patch tag", notes = "", response = TagDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 201, message = "", response = TagDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/tag",
          produces = {"application/json"},
          method = RequestMethod.PATCH)
  @Override
  public ResponseEntity<TagDto> patch(@ApiParam(value = "tagDto", required = true)
                                      @RequestBody TagDto tagDto) {
    return TagController.super.patch(tagDto);
  }

  @ApiOperation(value = "Delete tag", notes = "")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = ""),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/tag/{id}",
          produces = {"application/json"},
          method = RequestMethod.DELETE)
  @Override
  public ResponseEntity<Void> delete(@ApiParam(value = "id", required = true)
                                     @PathVariable("id") Long id) {
    return TagController.super.delete(id);
  }

  @ApiOperation(value = "Get all tags", notes = "", response = List.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = List.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/tag/all",
          produces = {"application/json"},
          method = RequestMethod.GET)
  @Override
  public ResponseEntity<List<TagDto>> findAll() {
    return TagController.super.findAll();
  }

  @ApiOperation(value = "Get pageDataSets tags", notes = "", response = PageResponse.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = PageResponse.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/tag/page",
          produces = {"application/json"},
          method = RequestMethod.GET)
  @Override
  public ResponseEntity<PageResponse<TagDto>> page(@ApiParam(value = "limit", required = true)
                                                      @RequestParam(value = "limit", required = true) Integer limit,
                                                   @ApiParam(value = "offset", required = false)
                                                      @RequestParam(value = "offset", required = false) Integer offset) {
    return TagController.super.page(limit, offset);
  }

  @Override
  public CRUDProcessor<TagDto> processor() {
    return tagProcessor;
  }
}
