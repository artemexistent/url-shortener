package com.urlshortener.web;

import com.urlshortener.data.UrlMappingModel;
import com.urlshortener.service.UrlMappingService;
import com.urlshortener.web.converter.UrlMappingDTOConverter;
import com.urlshortener.web.model.UrlMappingDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/short-urls")
public class UrlMappingController {

  private final UrlMappingService urlMappingService;
  private final UrlMappingDTOConverter converter;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public UrlMappingDTO createShortUrl(@RequestParam String url) {
    log.error("!!!!!{}", url);
    UrlMappingModel savedUrlMapping = urlMappingService.save(url);
    return converter.toDto(savedUrlMapping);
  }
}