package com.urlshortener.repository;

import com.urlshortener.data.Click;
import com.urlshortener.data.UrlMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClickRepository extends JpaRepository<Click, Long> {
  Optional<Click> findByUrlMapping(UrlMapping urlMapping);
}