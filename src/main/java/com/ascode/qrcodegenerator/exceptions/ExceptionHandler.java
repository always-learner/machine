package com.ascode.qrcodegenerator.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(UnableToGenerateQRCode.class)
    public ResponseEntity handleUnableGenerateQrCodeException(){
        return ResponseEntity
                .internalServerError().build();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity handleAllException(){
        return ResponseEntity
                .internalServerError().build();
    }

}
