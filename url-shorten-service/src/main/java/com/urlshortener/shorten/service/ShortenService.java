package com.urlshortener.shorten.service;

import com.urlshortener.shorten.client.PersistenceClient;
import com.urlshortener.shorten.dto.ShortenRequest;
import com.urlshortener.shorten.dto.ShortenResponse;
import com.urlshortener.shorten.dto.UrlSaveRequest;
import com.urlshortener.shorten.util.ShortUrlGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicInteger;

@Service
@RequiredArgsConstructor
public class ShortenService {
    private final ShortUrlGenerator shortUrlGenerator;
    private final PersistenceClient persistenceClient;
    private final AtomicInteger counter;

    private static final int LIMIT = 916_132_831;

    public ShortenResponse createShortUrl(ShortenRequest shortenRequest) {
        int currentCount = counter.getAndIncrement();
        if (currentCount >= LIMIT) throw new RuntimeException();

        String shortUrl = shortUrlGenerator.generateShortUrl(currentCount);

        persistenceClient.save(new UrlSaveRequest(shortenRequest.originalUrl(), shortUrl));

        return new ShortenResponse(shortUrl);
    }
}
