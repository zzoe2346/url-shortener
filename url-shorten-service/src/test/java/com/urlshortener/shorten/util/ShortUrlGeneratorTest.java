package com.urlshortener.shorten.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.test.util.ReflectionTestUtils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@MockitoSettings
class ShortUrlGeneratorTest {
    @InjectMocks
    private ShortUrlGenerator shortUrlGenerator;

    @BeforeEach
    void setUp() {
        ReflectionTestUtils.setField(shortUrlGenerator, "PREFIX", "ZZ");
    }

    @Nested
    class shortUrlGenerateTest {
        @Test
        void when_0() {
            //given
            int count = 0;

            //when
            String shortUrl = shortUrlGenerator.generateShortUrl(count);

            //then
            assertThat(shortUrl).isEqualTo("ZZ00000");
            assertThat(shortUrl.length()).isEqualTo(7);
        }

        @Test
        void when_1() {
            //given
            int count = 1;

            //when
            String shortUrl = shortUrlGenerator.generateShortUrl(count);

            //then
            assertThat(shortUrl).isEqualTo("ZZ00001");
            assertThat(shortUrl.length()).isEqualTo(7);
        }

        @Test
        void when_62() {
            //given
            int count = 62;

            //when
            String shortUrl = shortUrlGenerator.generateShortUrl(count);

            //then
            assertThat(shortUrl).isEqualTo("ZZ00010");
            assertThat(shortUrl.length()).isEqualTo(7);
        }

        @Test
        void when_916_132_831_At_Limit() {
            //given
            int LIMIT = 916_132_831;
            int count = LIMIT;

            //when
            String shortUrl = shortUrlGenerator.generateShortUrl(count);
            System.out.println(shortUrl);

            //then
            assertThat(shortUrl).isEqualTo("ZZZZZZZ");
            assertThat(shortUrl.length()).isEqualTo(7);
        }

        @Test
        void when_916_132_832_Over_Limit() {
            //given
            //int LIMIT = 916_132_831;
            int LIMIT = 916_132_832;
            int count = LIMIT;

            //when
            String shortUrl = shortUrlGenerator.generateShortUrl(count);
            System.out.println(shortUrl);
            //then
            assertThat(shortUrl).isEqualTo("ZZ100000");
            assertThat(shortUrl.length()).isEqualTo(8);
        }
    }
}
