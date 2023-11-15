package com.urlshortener.data;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UrlMappingModel {
  private String shortUrl;
  private String originalUrl;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private Long clicks;
  private String password;
}
