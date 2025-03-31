package com.gerald.accounts.dto;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorResponseDto(
        HttpStatus errorCode,
        String errorMessage,
        String apiPath,
        LocalDateTime localDateTime
) {
}
