package com.urlshortener.shorten.controller;

import com.urlshortener.shorten.dto.ShortenRequest;
import com.urlshortener.shorten.dto.ShortenResponse;
import com.urlshortener.shorten.service.ShortenService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ShortenController {
    private final ShortenService shortenService;

    @PostMapping("/api/shorten")
    @ResponseStatus(HttpStatus.CREATED)
    public ShortenResponse generateShortUrl(@RequestBody ShortenRequest shortenRequest) {
        return shortenService.createShortUrl(shortenRequest);
    }
}
