package com.urlshortener.shorten.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ShortUrlGenerator {
    private static final char[] BASE62_CHARS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final int TARGET_ENCODED_LENGTH = 5;

    @Value("${shorturl.prefix}")
    private String PREFIX;

    /**
     * Short URL을 생성합니다.
     *
     * @param number 인코딩할 숫자
     * @return PREFIX(2자) + 인코딩결과(5자), PREFIX는 개발자가 환경 변수로 설정합니다.
     */
    public String generateShortUrl(int number) {
        return PREFIX + encodeToBase62(number);
    }

    /**
     * 숫자를 지정된 길이의 Base62 문자열로 인코딩합니다. 길이는 5
     * 길이가 부족하면 앞쪽에 '0'으로 패딩합니다.
     *
     * @param number 인코딩할 숫자
     * @return 패딩된 Base62 문자열 (5자리)
     */
    private String encodeToBase62(int number) {
        StringBuilder sb = new StringBuilder();

        while (number > 0) {
            sb.append(BASE62_CHARS[number % BASE62_CHARS.length]);
            number /= BASE62_CHARS.length;
        }

        while (sb.length() < TARGET_ENCODED_LENGTH) {
            sb.append("0");
        }

        return sb.reverse().toString();
    }
}
