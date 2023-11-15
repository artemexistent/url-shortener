package com.urlshortener.service;

import ch.qos.logback.core.testUtil.RandomUtil;
import com.urlshortener.config.UrlMappingProperties;
import com.urlshortener.data.UrlMapping;
import com.urlshortener.data.UrlMappingModel;
import com.urlshortener.repository.UrlMappingRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrlMappingService {

  private final UrlMappingRepository repository;
  private final UrlMappingProperties properties;

  public UrlMappingModel save(String url) {
    final var urlMappingOptional = repository.findByOriginalUrl(url);
    if (urlMappingOptional.isPresent()) {
      return updateOld(urlMappingOptional.get());
    }
    return createNew(url);
  }

  private UrlMappingModel updateOld(UrlMapping urlMapping) {
    urlMapping.setUpdatedAt(LocalDateTime.now());
    repository.save(urlMapping);
    return UrlMappingModel.builder()
        .originalUrl(urlMapping.getOriginalUrl())
        .shortUrl(properties.getHost() + "/" + urlMapping.getShortUrl())
        .clicks(0L)
        .createdAt(urlMapping.getCreatedAt())
        .updatedAt(urlMapping.getUpdatedAt())
        .build();
  }

  private UrlMappingModel createNew(String url) {
    final var newUrl = RandomStringUtils.randomAlphanumeric(properties.getLength());
    final var urlMapping = new UrlMapping();
    urlMapping.setOriginalUrl(url);
    urlMapping.setShortUrl(newUrl);
    urlMapping.setCreatedAt(LocalDateTime.now());
    urlMapping.setUpdatedAt(LocalDateTime.now());
    repository.save(urlMapping);
    return UrlMappingModel.builder()
        .originalUrl(urlMapping.getOriginalUrl())
        .shortUrl(properties.getHost() + "/" + urlMapping.getShortUrl())
        .clicks(0L)
        .createdAt(urlMapping.getCreatedAt())
        .updatedAt(urlMapping.getUpdatedAt())
        .build();
  }

}