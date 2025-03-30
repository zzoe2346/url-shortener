package com.urlshortener.persistence.dto;

public record UrlPersistenceRequest(String originalUrl, String shortUrl) {
}
