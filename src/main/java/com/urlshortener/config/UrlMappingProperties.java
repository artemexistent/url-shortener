package com.urlshortener.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "mapping")
public class UrlMappingProperties {
  String host;
  Integer length;
}
