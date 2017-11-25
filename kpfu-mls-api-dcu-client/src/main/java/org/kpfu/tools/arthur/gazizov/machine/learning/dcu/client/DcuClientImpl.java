package org.kpfu.tools.arthur.gazizov.machine.learning.dcu.client;

import org.apache.log4j.Logger;
import org.kpfu.tools.arthur.gazizov.machine.learning.dcu.dto.DataSetDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.Objects;

/**
 * @author Arthur Gazizov (Cinarra Systems)
 * Created on 25/11/2017.
 */
public class DcuClientImpl implements DcuClient {
  private static final String COMMON = "/v1/dcu/";
  private static final String DATASET = "/dataset";
  private static final String DATASET_ID = "{id}";
  private static final String POST_DATASET = COMMON + DATASET;
  private static final String PUT_DATASET = COMMON + DATASET;
  private static final String GET_DATASET = COMMON + DATASET + "/" + DATASET_ID;

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
  public DataSetDto save(DataSetDto dataSetDto) {
    final String url = serverUrl + POST_DATASET;
    final HttpEntity<DataSetDto> dataSetDtoHttpEntity = new HttpEntity<>(dataSetDto, headers);
    final ResponseEntity<DataSetDto> response = restTemplate.exchange(url, HttpMethod.POST, dataSetDtoHttpEntity, DataSetDto.class);
    return response.getBody();
  }

  @Override
  public DataSetDto get(Long dataSetId) {
    final String url =  serverUrl + GET_DATASET.replace(DATASET_ID, String.valueOf(dataSetId));
    final ResponseEntity<DataSetDto> response = restTemplate.getForEntity(url, DataSetDto.class);
    return response.getBody();
  }

  @Override
  public DataSetDto update(DataSetDto dataSetDto) {
    final String url = serverUrl + PUT_DATASET;
    final HttpEntity<DataSetDto> dataSetDtoHttpEntity = new HttpEntity<>(dataSetDto, headers);
    final ResponseEntity<DataSetDto> response = restTemplate.exchange(url, HttpMethod.PUT, dataSetDtoHttpEntity, DataSetDto.class);
    return response.getBody();
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
