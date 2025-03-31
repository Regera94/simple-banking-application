package com.gerald.accounts.dto;

import org.springframework.http.HttpStatus;

public record ResponseDto(
        HttpStatus responseCode,
        String message
) {
}
