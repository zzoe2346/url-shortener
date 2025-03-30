package com.urlshortener.shorten.service;

import com.urlshortener.shorten.client.PersistenceClient;
import com.urlshortener.shorten.dto.ShortenRequest;
import com.urlshortener.shorten.dto.ShortenResponse;
import com.urlshortener.shorten.exception.OverLimitException;
import com.urlshortener.shorten.util.ShortUrlGenerator;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;

import java.util.concurrent.atomic.AtomicInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;

@MockitoSettings
class ShortenServiceTest {
    @Mock
    private ShortUrlGenerator shortUrlGenerator;
    @Mock
    private PersistenceClient persistenceClient;
    @Mock
    private AtomicInteger counter;
    @InjectMocks
    private ShortenService shortenService;

    @Test
    void shouldCreateShortUrl() {
        //given
        ShortenRequest shortenRequest = new ShortenRequest("originalUrl");
        int currentCount = 1;
        given(counter.getAndIncrement()).willReturn(currentCount);
        given(shortUrlGenerator.generateShortUrl(currentCount)).willReturn("shortUrl");

        //when
        ShortenResponse response = shortenService.createShortUrl(shortenRequest);

        //then
        assertThat(response.shortUrl()).isEqualTo("shortUrl");
    }

    @Test
    void throwExceptionWhenOverLimit() {
        //given
        int LIMIT = 916_132_831;
        ShortenRequest shortenRequest = new ShortenRequest("originalUrl");
        int currentCount = LIMIT + 1;
        given(counter.getAndIncrement()).willReturn(currentCount);

        //when then
        assertThatThrownBy(() -> shortenService.createShortUrl(shortenRequest)).isInstanceOf(OverLimitException.class);
    }
}
