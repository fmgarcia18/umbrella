package com.fmgarcia.umbrella.advice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    @Builder.Default
    private LocalDate timestamp = LocalDate.now();
    private String message;
    private String details;
    private String errorCode;
    private Integer statusCode;
}
