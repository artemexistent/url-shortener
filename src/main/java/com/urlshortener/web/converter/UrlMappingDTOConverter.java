package com.urlshortener.web.converter;

import com.urlshortener.data.UrlMappingModel;
import com.urlshortener.web.model.UrlMappingDTO;
import org.springframework.stereotype.Component;

@Component
public class UrlMappingDTOConverter implements Converter<UrlMappingDTO, UrlMappingModel> {
  public UrlMappingDTO toDto(UrlMappingModel urlMapping) {
    return UrlMappingDTO.builder()
        .shortUrl(urlMapping.getShortUrl())
        .longUrl(urlMapping.getOriginalUrl())
        .clicks(0L)
        .build();
  }

  public UrlMappingModel toModel(UrlMappingDTO urlMappingDTO) {
    return UrlMappingModel.builder()
        .build();
  }
}