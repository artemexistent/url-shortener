package com.urlshortener.web;

import com.urlshortener.data.UrlMappingModel;
import com.urlshortener.service.UrlMappingService;
import com.urlshortener.service.UrlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.FOUND;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping
public class UrlController {

  private final UrlService urlService;

  @GetMapping("/{url}")
  public ResponseEntity<String> getUrl(@PathVariable String url) {
    log.error("url {}", url);
    UrlMappingModel urlMapping = urlService.get(url);
    if (urlMapping == null || urlMapping.getOriginalUrl() == null) {
      return ResponseEntity.notFound()
          .build();
    }
    return ResponseEntity.status(FOUND)
        .header("Location", urlMapping.getOriginalUrl())
        .build();
  }

}