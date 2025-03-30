package com.urlshortener.shorten.client;

import com.urlshortener.shorten.dto.UrlSaveRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.PostExchange;

public interface PersistenceClient {
    @PostExchange("/api/persistence")
    void save(@RequestBody UrlSaveRequest urlSaveRequest);
}
