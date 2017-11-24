package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.api.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.ErrorDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image.MetaImageInfoDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.support.PageResponse;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.exception.KpfuMlsDcuError;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.base.CRUDProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.processor.interfaces.MetaImageInfoProcessor;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.rest.api.interfaces.MetaImageInfoController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 16.11.17.
 */
@Controller
@RequestMapping(value = "/v1/dcu/meta/", produces = {APPLICATION_JSON_VALUE})
@Api(value = "MetaImageInfoController", description = "The MetaImageInfoController API")
public class MetaImageInfoControllerImpl implements MetaImageInfoController {
  @Autowired
  private MetaImageInfoProcessor metaImageInfoProcessor;

  @Autowired
  private ObjectMapper objectMapper;

  @ApiOperation(value = "Get meta image info", notes = "", response = MetaImageInfoDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = MetaImageInfoDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/image/{id}",
          produces = {"application/json"},
          method = RequestMethod.GET)
  @Override
  public ResponseEntity<MetaImageInfoDto> get(@ApiParam(value = "id", required = true)
                                              @PathVariable("id") Long id) {
    return MetaImageInfoController.super.get(id);
  }

  @ApiOperation(value = "Save meta image info", notes = "", response = MetaImageInfoDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 201, message = "", response = MetaImageInfoDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/image",
          produces = {"application/json"},
          method = RequestMethod.POST)
  @Override
  public ResponseEntity<MetaImageInfoDto> save(@ApiParam(value = "metaImageInfoDto", required = true)
                                               @RequestBody MetaImageInfoDto metaImageInfoDto) {
    return MetaImageInfoController.super.save(metaImageInfoDto);
  }

  @ApiOperation(value = "Update meta image info", notes = "", response = MetaImageInfoDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = MetaImageInfoDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/image",
          produces = {"application/json"},
          method = RequestMethod.PUT)
  @Override
  public ResponseEntity<MetaImageInfoDto> update(@ApiParam(value = "metaImageInfoDto", required = true)
                                                 @RequestBody MetaImageInfoDto metaImageInfoDto) {
    return MetaImageInfoController.super.update(metaImageInfoDto);
  }

  @ApiOperation(value = "Update meta image info", notes = "", response = MetaImageInfoDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = MetaImageInfoDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/image",
          produces = {"application/json"},
          method = RequestMethod.PATCH)
  @Override
  public ResponseEntity<MetaImageInfoDto> patch(@ApiParam(value = "metaImageInfoDto", required = true)
                                                @RequestBody MetaImageInfoDto metaImageInfoDto) {
    return MetaImageInfoController.super.patch(metaImageInfoDto);
  }

  @ApiOperation(value = "Delete image meta info", notes = "")
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = ""),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/image/{id}",
          produces = {"application/json"},
          method = RequestMethod.DELETE)
  @Override
  public ResponseEntity<Void> delete(@ApiParam(value = "id", required = true)
                                     @PathVariable("id") Long id) {
    return MetaImageInfoController.super.delete(id);
  }

  @ApiOperation(value = "Get all meta image info's", notes = "", response = List.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = List.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/image/all",
          produces = {"application/json"},
          method = RequestMethod.GET)
  @Override
  public ResponseEntity<List<MetaImageInfoDto>> findAll() {
    return MetaImageInfoController.super.findAll();
  }

  @ApiOperation(value = "Get page meta image info's", notes = "", response = PageResponse.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = PageResponse.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/image/page",
          produces = {"application/json"},
          method = RequestMethod.GET)
  @Override
  public ResponseEntity<PageResponse<MetaImageInfoDto>> findAll(@ApiParam(value = "limit", required = true)
                                                                @RequestParam(value = "limit", required = true) Integer limit,
                                                                @ApiParam(value = "offset", required = false)
                                                                @RequestParam(value = "offset", required = false) Integer offset) {
    return MetaImageInfoController.super.findAll(limit, offset);
  }

  @Override
  public CRUDProcessor<MetaImageInfoDto> processor() {
    return metaImageInfoProcessor;
  }

  @ApiOperation(
          value = "Upload meta image info", notes = "", response = MetaImageInfoDto.class,
          consumes = "multipart/form-data, application/json, application/octet-stream",
          produces = "application/json")
  @ApiResponses(value = {
          @ApiResponse(code = 201, message = "", response = MetaImageInfoDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/image/upload",
          consumes = {"multipart/form-data", "application/json", "application/octet-stream"},
          produces = "application/json",
          method = RequestMethod.POST)
  @Override
  public ResponseEntity<MetaImageInfoDto> upload(
          @ApiParam(value = "file detail", name = "multipartFile", required = true, type = "file")
          @RequestPart(value = "multipartFile", required = true) MultipartFile multipartFile,
          @ApiParam(value = "metaImageInfoDtoAsString", required = true)
          @RequestPart(value = "metaImageInfoDtoAsString", required = true) String metaImageInfoDtoAsString) {

    MetaImageInfoDto metaImageInfoDto = null;
    try {
      metaImageInfoDto = objectMapper.treeToValue(objectMapper.readTree(metaImageInfoDtoAsString), MetaImageInfoDto.class);
    } catch (IOException e) {
      throw KpfuMlsDcuError.INCORRECT_META_IMAGE_INFO_FORMAT.exception(e);
    }
    return metaImageInfoProcessor.upload(multipartFile, metaImageInfoDto);
  }

  @ApiOperation(value = "Get meta image info by image id", notes = "", response = MetaImageInfoDto.class)
  @ApiResponses(value = {
          @ApiResponse(code = 200, message = "", response = MetaImageInfoDto.class),
          @ApiResponse(code = 400, message = "Bad request", response = ErrorDto.class),
          @ApiResponse(code = 401, message = "Unauthorized", response = ErrorDto.class),
          @ApiResponse(code = 403, message = "Access Denied/Forbidden", response = ErrorDto.class),
          @ApiResponse(code = 500, message = "Something exceptional happened", response = ErrorDto.class)
  })
  @RequestMapping(
          value = "/image/findByImageId",
          produces = {"application/json"},
          method = RequestMethod.GET)
  @Override
  public ResponseEntity<MetaImageInfoDto> findByImageId(@ApiParam(value = "imageId", required = true)
                                                        @RequestParam("imageId") Long imageId) {
    return metaImageInfoProcessor.findByImageId(imageId);
  }
}
