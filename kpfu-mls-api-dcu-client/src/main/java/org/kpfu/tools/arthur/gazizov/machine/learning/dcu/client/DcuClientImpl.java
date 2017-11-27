package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.client;

import org.apache.log4j.Logger;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetElementDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.TagDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.image.MetaImageInfoDto;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.support.PageResponse;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 25/11/2017.
 */
public class DcuClientImpl implements DcuClient {
  private static final String COMMON = "/v1/dcu";
  private static final String DATASET = "/dataset";
  private static final String DATASET_ELEMENT = "/element";
  private static final String DATASET_ID = "{id}";
  private static final String DATASET_ELEMENT_ID = "{id}";
  private static final String TAG_ID = "{id}";
  private static final String ALL = "/all";
  private static final String PAGE = "/page";
  private static final String TAG = "/tag";
  private static final String META_IMAGE_INFO = "/meta/image";
  private static final String META_IMAGE_INFO_ID = "{id}";

  private static final String POST_DATASET = COMMON + DATASET;
  private static final String PUT_DATASET = COMMON + DATASET;
  private static final String PATCH_DATASET = COMMON + DATASET;
  private static final String GET_DATASET = COMMON + DATASET + "/" + DATASET_ID;
  private static final String GET_ALL_DATASET = COMMON + DATASET + ALL;
  private static final String GET_PAGE_DATASET = COMMON + DATASET + PAGE;

  private static final String POST_DATASET_ELEMENT = COMMON + DATASET + DATASET_ELEMENT;
  private static final String PUT_DATASET_ELEMENT = COMMON + DATASET + DATASET_ELEMENT;
  private static final String PATCH_DATASET_ELEMENT = COMMON + DATASET + DATASET_ELEMENT;
  private static final String GET_DATASET_ELEMENT = COMMON + DATASET + DATASET_ELEMENT + "/" + DATASET_ELEMENT_ID;
  private static final String GET_ALL_DATASET_ELEMENT = COMMON + DATASET + DATASET_ELEMENT + ALL;
  private static final String GET_PAGE_DATASET_ELEMENT = COMMON + DATASET + DATASET_ELEMENT + PAGE;

  private static final String POST_TAG = COMMON + TAG;
  private static final String PUT_TAG = COMMON + TAG;
  private static final String PATCH_TAG = COMMON + TAG;
  private static final String GET_TAG = COMMON + TAG + "/" + TAG_ID;
  private static final String GET_ALL_TAGS = COMMON + TAG + ALL;
  private static final String GET_PAGE_TAGS = COMMON + TAG + PAGE;

  private static final String POST_META_IMAGE_INFO = COMMON + META_IMAGE_INFO;
  private static final String PUT_META_IMAGE_INFO = COMMON + META_IMAGE_INFO;
  private static final String PATCH_META_IMAGE_INFO = COMMON + META_IMAGE_INFO;
  private static final String GET_META_IMAGE_INFO = COMMON + META_IMAGE_INFO + "/" + META_IMAGE_INFO_ID;
  private static final String GET_ALL_META_IMAGE_INFOS = COMMON + META_IMAGE_INFO + ALL;
  private static final String GET_PAGE_META_IMAGE_INFOS = COMMON + META_IMAGE_INFO + PAGE;

  private final static Logger logger = Logger.getLogger(DcuClientImpl.class);
  private final String serverUrl;
  private final RestTemplate restTemplate;
  private final HttpHeaders headers;

  private DcuClientImpl(String serverUrl, RestTemplate restTemplate, HttpHeaders headers) {
    this.serverUrl = serverUrl;
    this.restTemplate = restTemplate;
    this.headers = headers;
    initHeaders();
  }

  private DcuClientImpl(Builder builder) {
    this(builder.serverUrl, builder.restTemplate, builder.headers);
  }

  private void initHeaders() {
    headers.add("Content-Type", "application/json");
    headers.add("Accept", "*/*");
  }


  @Override
  public DataSetDto saveDataSet(DataSetDto dataSetDto) {
    final String url = serverUrl + POST_DATASET;
    final HttpEntity<DataSetDto> dataSetDtoHttpEntity = new HttpEntity<>(dataSetDto, headers);
    final ResponseEntity<DataSetDto> response = restTemplate.exchange(url, HttpMethod.POST, dataSetDtoHttpEntity, DataSetDto.class);
    return response.getBody();
  }

  @Override
  public DataSetDto getDataSet(Long dataSetId) {
    final String url = serverUrl + GET_DATASET.replace(DATASET_ID, String.valueOf(dataSetId));
    final ResponseEntity<DataSetDto> response = restTemplate.getForEntity(url, DataSetDto.class);
    return response.getBody();
  }

  @Override
  public DataSetDto updateDataSet(DataSetDto dataSetDto) {
    final String url = serverUrl + PUT_DATASET;
    final HttpEntity<DataSetDto> dataSetDtoHttpEntity = new HttpEntity<>(dataSetDto, headers);
    final ResponseEntity<DataSetDto> response = restTemplate.exchange(url, HttpMethod.PUT, dataSetDtoHttpEntity, DataSetDto.class);
    return response.getBody();
  }

  @Override
  public DataSetDto patchDataSet(DataSetDto dataSetDto) {
    final String url = serverUrl + PATCH_DATASET;
    final HttpEntity<DataSetDto> dataSetDtoHttpEntity = new HttpEntity<>(dataSetDto, headers);
    final ResponseEntity<DataSetDto> response = restTemplate.exchange(url, HttpMethod.PATCH, dataSetDtoHttpEntity, DataSetDto.class);
    return response.getBody();
  }

  @Override
  public List<DataSetDto> findAllDataSets() {
    final String url = serverUrl + GET_ALL_DATASET;
    final ResponseEntity<List<DataSetDto>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<DataSetDto>>() {
    });
    return responseEntity.getBody();
  }

  @Override
  public PageResponse<DataSetDto> pageDataSets(Integer limit, Integer offset) {
    final String url = serverUrl + GET_PAGE_DATASET;
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("limit", limit)
            .queryParam("offset", offset);
    final ResponseEntity<PageResponse<DataSetDto>> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<PageResponse<DataSetDto>>() {
    });
    return responseEntity.getBody();
  }

  @Override
  public DataSetElementDto saveDataSetElement(DataSetElementDto dataSetElementDto) {
    final String url = serverUrl + POST_DATASET_ELEMENT;
    final HttpEntity<DataSetElementDto> dataSetElementDtoHttpEntity = new HttpEntity<>(dataSetElementDto, headers);
    final ResponseEntity<DataSetElementDto> response = restTemplate.exchange(url, HttpMethod.POST, dataSetElementDtoHttpEntity, DataSetElementDto.class);
    return response.getBody();
  }

  @Override
  public DataSetElementDto getDataSetElement(Long dataSetElementId) {
    final String url = serverUrl + GET_DATASET_ELEMENT.replace(DATASET_ELEMENT_ID, String.valueOf(dataSetElementId));
    final ResponseEntity<DataSetElementDto> response = restTemplate.getForEntity(url, DataSetElementDto.class);
    return response.getBody();
  }

  @Override
  public DataSetElementDto updateDataSetElement(DataSetElementDto dataSetElementDto) {
    final String url = serverUrl + PUT_DATASET_ELEMENT;
    final HttpEntity<DataSetElementDto> dataSetElementDtoHttpEntity = new HttpEntity<>(dataSetElementDto, headers);
    final ResponseEntity<DataSetElementDto> response = restTemplate.exchange(url, HttpMethod.PUT, dataSetElementDtoHttpEntity, DataSetElementDto.class);
    return response.getBody();
  }

  @Override
  public DataSetElementDto patchDataSetElement(DataSetElementDto dataSetElementDto) {
    final String url = serverUrl + PATCH_DATASET_ELEMENT;
    final HttpEntity<DataSetElementDto> dataSetElementDtoHttpEntity = new HttpEntity<>(dataSetElementDto, headers);
    final ResponseEntity<DataSetElementDto> response = restTemplate.exchange(url, HttpMethod.PATCH, dataSetElementDtoHttpEntity, DataSetElementDto.class);
    return response.getBody();
  }

  @Override
  public List<DataSetElementDto> findAllDataSetElements() {
    final String url = serverUrl + GET_ALL_DATASET_ELEMENT;
    final ResponseEntity<List<DataSetElementDto>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<DataSetElementDto>>() {
    });
    return responseEntity.getBody();
  }

  @Override
  public PageResponse<DataSetElementDto> pageDataSetElements(Integer limit, Integer offset) {
    final String url = serverUrl + GET_PAGE_DATASET_ELEMENT;
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("limit", limit)
            .queryParam("offset", offset);
    final ResponseEntity<PageResponse<DataSetElementDto>> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<PageResponse<DataSetElementDto>>() {
    });
    return responseEntity.getBody();
  }

  @Override
  public Integer elementsCountInDataSet(Long dataSetId) {
    final UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(serverUrl)
            .path(COMMON)
            .pathSegment("dataset")
            .pathSegment(String.valueOf(dataSetId))
            .pathSegment("elements")
            .pathSegment("count");
    final ResponseEntity<Integer> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, Integer.class);
    return responseEntity.getBody();
  }

  @Override
  public PageResponse<DataSetElementDto> pageDataSetElements(Long dataSetId, Integer limit, Integer offset) {
    final UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(serverUrl)
            .path(COMMON)
            .pathSegment("dataset")
            .pathSegment(String.valueOf(dataSetId))
            .pathSegment("elements")
            .queryParam("limit", limit)
            .queryParam("offset", offset);
    final ResponseEntity<PageResponse<DataSetElementDto>> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<PageResponse<DataSetElementDto>>() {
    });
    return responseEntity.getBody();
  }

  @Override
  public TagDto saveTag(TagDto tagDto) {
    final String url = serverUrl + POST_TAG;
    final HttpEntity<TagDto> tagDtoHttpEntity = new HttpEntity<>(tagDto, headers);
    final ResponseEntity<TagDto> response = restTemplate.exchange(url, HttpMethod.POST, tagDtoHttpEntity, TagDto.class);
    return response.getBody();
  }

  @Override
  public TagDto getTag(Long tagId) {
    final String url = serverUrl + GET_TAG.replace(TAG_ID, String.valueOf(tagId));
    final ResponseEntity<TagDto> response = restTemplate.getForEntity(url, TagDto.class);
    return response.getBody();
  }

  @Override
  public TagDto updateTag(TagDto tagDto) {
    final String url = serverUrl + PUT_TAG;
    final HttpEntity<TagDto> tagDtoHttpEntity = new HttpEntity<>(tagDto, headers);
    final ResponseEntity<TagDto> response = restTemplate.exchange(url, HttpMethod.PUT, tagDtoHttpEntity, TagDto.class);
    return response.getBody();
  }

  @Override
  public TagDto patchTag(TagDto tagDto) {
    final String url = serverUrl + PATCH_TAG;
    final HttpEntity<TagDto> tagDtoHttpEntity = new HttpEntity<>(tagDto, headers);
    final ResponseEntity<TagDto> response = restTemplate.exchange(url, HttpMethod.PATCH, tagDtoHttpEntity, TagDto.class);
    return response.getBody();
  }

  @Override
  public List<TagDto> findAllTags() {
    final String url = serverUrl + GET_ALL_TAGS;
    final ResponseEntity<List<TagDto>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<TagDto>>() {
    });
    return responseEntity.getBody();
  }

  @Override
  public PageResponse<TagDto> pageTags(Integer limit, Integer offset) {
    final String url = serverUrl + GET_PAGE_TAGS;
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("limit", limit)
            .queryParam("offset", offset);
    final ResponseEntity<PageResponse<TagDto>> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<PageResponse<TagDto>>() {
    });
    return responseEntity.getBody();
  }

  @Override
  public MetaImageInfoDto saveMetaImageInfo(MetaImageInfoDto metaImageInfoDto) {
    final String url = serverUrl + POST_META_IMAGE_INFO;
    final HttpEntity<MetaImageInfoDto> metaImageInfoDtoHttpEntity = new HttpEntity<>(metaImageInfoDto, headers);
    final ResponseEntity<MetaImageInfoDto> response = restTemplate.exchange(url, HttpMethod.POST, metaImageInfoDtoHttpEntity, MetaImageInfoDto.class);
    return response.getBody();
  }

  @Override
  public MetaImageInfoDto getMetaImageInfo(Long metaImageInfoId) {
    final String url = serverUrl + GET_META_IMAGE_INFO.replace(META_IMAGE_INFO_ID, String.valueOf(metaImageInfoId));
    final ResponseEntity<MetaImageInfoDto> response = restTemplate.getForEntity(url, MetaImageInfoDto.class);
    return response.getBody();
  }

  @Override
  public MetaImageInfoDto updateMetaImageInfo(MetaImageInfoDto metaImageInfoDto) {
    final String url = serverUrl + PUT_META_IMAGE_INFO;
    final HttpEntity<MetaImageInfoDto> metaImageInfoDtoHttpEntity = new HttpEntity<>(metaImageInfoDto, headers);
    final ResponseEntity<MetaImageInfoDto> response = restTemplate.exchange(url, HttpMethod.PUT, metaImageInfoDtoHttpEntity, MetaImageInfoDto.class);
    return response.getBody();
  }

  @Override
  public MetaImageInfoDto patchMetaImageInfo(MetaImageInfoDto metaImageInfoDto) {
    final String url = serverUrl + PATCH_META_IMAGE_INFO;
    final HttpEntity<MetaImageInfoDto> metaImageInfoDtoHttpEntity = new HttpEntity<>(metaImageInfoDto, headers);
    final ResponseEntity<MetaImageInfoDto> response = restTemplate.exchange(url, HttpMethod.PATCH, metaImageInfoDtoHttpEntity, MetaImageInfoDto.class);
    return response.getBody();
  }

  @Override
  public List<MetaImageInfoDto> findAllMetaImageInfos() {
    final String url = serverUrl + GET_ALL_META_IMAGE_INFOS;
    final ResponseEntity<List<MetaImageInfoDto>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<MetaImageInfoDto>>() {
    });
    return responseEntity.getBody();
  }

  @Override
  public PageResponse<MetaImageInfoDto> pageMetaImageInfos(Integer limit, Integer offset) {
    final String url = serverUrl + GET_PAGE_META_IMAGE_INFOS;
    UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
            .queryParam("limit", limit)
            .queryParam("offset", offset);
    final ResponseEntity<PageResponse<MetaImageInfoDto>> responseEntity = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, null, new ParameterizedTypeReference<PageResponse<MetaImageInfoDto>>() {
    });
    return responseEntity.getBody();
  }

  public static final class Builder {
    private String serverUrl;
    private RestTemplate restTemplate;
    private HttpHeaders headers;

    private Builder() {
    }

    public static Builder aFsClientImpl() {
      return new Builder();
    }

    public Builder serverUrl(String serverUrl) {
      this.serverUrl = serverUrl;
      return this;
    }

    public Builder restTemplate(RestTemplate restTemplate) {
      this.restTemplate = restTemplate;
      return this;
    }

    public Builder headers(HttpHeaders headers) {
      this.headers = headers;
      return this;
    }

    public DcuClientImpl build() {
      // TODO: 25/11/2017 refactor this shit
      if (Objects.isNull(restTemplate)) {
        restTemplate = new RestTemplate();
        restTemplate.setInterceptors(Collections.singletonList((request, body, execution) -> {
          // TODO: 25/11/2017 actuate logger
          logger.error(request.getURI());
          logger.error(new String(body));
          return execution.execute(request, body);
        }));
        restTemplate.getMessageConverters()
                .add(new MappingJackson2HttpMessageConverter());
      }
      if (Objects.isNull(headers)) {
        headers = new HttpHeaders();
      }
      return new DcuClientImpl(this);
    }
  }

}
