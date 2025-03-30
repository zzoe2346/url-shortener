package com.urlshortener.shorten.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "이 스프링 앱의 Short URL 생성 제한수(916,132,831)가 초과했습니다. 다른 PREFIX를 가진 스프링 앱을 실행해 주세요.")
public class OverLimitException extends RuntimeException {
}
