package com.urlshortener.web.converter;

import com.urlshortener.data.UrlMapping;
import com.urlshortener.web.model.UrlMappingDTO;

public interface Converter<D, M> {
  D toDto(M urlMapping);
  M toModel(D urlMapping);
}
