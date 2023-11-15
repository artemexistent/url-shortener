package com.urlshortener.service;

import com.urlshortener.data.UrlMappingModel;
import com.urlshortener.repository.UrlMappingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlService {

  private final UrlMappingRepository repository;

  public UrlMappingModel get(String url) {
    final var urlMappingOptional = repository.findByShortUrl(url);
    if (urlMappingOptional.isPresent()) {
      final var urlMapping = urlMappingOptional.get();
      return UrlMappingModel.builder()
          .originalUrl(urlMapping.getOriginalUrl())
          .shortUrl(urlMapping.getShortUrl())
          .clicks(0L)
          .createdAt(urlMapping.getCreatedAt())
          .updatedAt(urlMapping.getUpdatedAt())
          .build();
    }
    return null;
  }
}