package com.urlshortener.persistence.controller;

import com.urlshortener.persistence.dto.UrlPersistenceRequest;
import com.urlshortener.persistence.dto.UrlPersistenceResponse;
import com.urlshortener.persistence.service.UrlPersistenceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/persistence")
public class UrlPersistenceController {
    private final UrlPersistenceService urlPersistenceService;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void saveOriginalUrlAndShortUrl(@RequestBody UrlPersistenceRequest urlPersistenceRequest) {
        urlPersistenceService.saveOriginalUrlAndShortUrl(urlPersistenceRequest);
    }

    @GetMapping("/{shortUrl}")
    @ResponseStatus(HttpStatus.OK)
    public UrlPersistenceResponse getOriginalUrl(@PathVariable String shortUrl) {
        return urlPersistenceService.getOriginalUrl(shortUrl);
    }
}
