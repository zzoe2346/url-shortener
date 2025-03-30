package com.urlshortener.persistence.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "단축 URL을 찾을 수 없습니다.")
public class ShortUrlNotFoundException extends RuntimeException {

}
