package com.urlshortener.shorten.service;

import com.urlshortener.shorten.dto.ShortenRequest;
import com.urlshortener.shorten.dto.ShortenResponse;
import com.urlshortener.shorten.util.ShortUrlGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShortenService {
//    @Value("${url.short.key}")
//    Integer key;

    private final ShortUrlGenerator shortUrlGenerator;

    public ShortenResponse createShortUrl(ShortenRequest shortenRequest) {
        //Id 생성

        //저장

        //응답
        return new ShortenResponse(shortUrl);
    }
}
