package com.martinc.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;
import java.util.Map;

@Getter
@AllArgsConstructor
@ControllerAdvice
@Builder
@NoArgsConstructor
public class ErrorMessage {

    private int statusCode;
    private String message;
    private String description;
    private LocalDateTime timeStamp;
    private Map<String,String> details;

}
