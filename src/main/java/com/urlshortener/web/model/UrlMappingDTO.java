package com.urlshortener.web.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UrlMappingDTO {
  private String shortUrl;
  private String longUrl;
  private Long clicks;
}