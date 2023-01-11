package com.zerobase.user.exception;


import static org.hibernate.tool.schema.SchemaToolingLogging.LOGGER;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ControllerAdvice {
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<String> handleBusinessException(CustomException customException) {
        LOGGER.info(customException.getErrorMessage());
        return ResponseEntity.status(customException.getErrorCode().ordinal())
                .body(customException.getErrorMessage());
    }
}
