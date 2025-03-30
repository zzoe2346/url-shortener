package com.urlshortener.shorten.dto;

public record UrlSaveRequest(String originalUrl, String shortUrl) {
}
