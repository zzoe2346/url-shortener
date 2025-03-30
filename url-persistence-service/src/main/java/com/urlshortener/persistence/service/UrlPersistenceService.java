package com.urlshortener.persistence.service;

import com.urlshortener.persistence.domain.ShortUrl;
import com.urlshortener.persistence.dto.UrlPersistenceRequest;
import com.urlshortener.persistence.dto.UrlPersistenceResponse;
import com.urlshortener.persistence.exception.ShortUrlNotFoundException;
import com.urlshortener.persistence.repository.ShortUrlRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UrlPersistenceService {
    private final ShortUrlRepository shortUrlRepository;

    /**
     *
     * @param urlPersistenceRequest DB에 저장할 originalURL, shortURL에 관한 파라미터
     */
    public void saveOriginalUrlAndShortUrl(UrlPersistenceRequest urlPersistenceRequest) {
        ShortUrl shortUrl = new ShortUrl(urlPersistenceRequest.originalUrl(), urlPersistenceRequest.shortUrl());
        shortUrlRepository.save(shortUrl);
    }

    /**
     *
     * @param shortUrl 서비스에서 만든 단축 URL
     * @return shortUrl에 대응되는 originalUrl 응답
     */
    public UrlPersistenceResponse getOriginalUrl(String shortUrl) {
        ShortUrl shortUrlEntity = shortUrlRepository.findByShortUrl(shortUrl)
                .orElseThrow(ShortUrlNotFoundException::new);
        return new UrlPersistenceResponse(shortUrlEntity.getOriginalUrl());
    }
}
