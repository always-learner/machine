package com.ascode.qrcodegenerator.controller;

import com.ascode.qrcodegenerator.exceptions.UnableToGenerateQRCode;
import com.ascode.qrcodegenerator.services.qrcode.QRCodeGenerator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/qrcode")
public class QRCodeController {

    private final QRCodeGenerator qrCodeGenerator;

    public QRCodeController(QRCodeGenerator qrCodeGenerator){
        this.qrCodeGenerator = qrCodeGenerator;
    }

    @GetMapping(value = "/generate")
    public ResponseEntity<Object> generateQRCode() throws UnableToGenerateQRCode {
        qrCodeGenerator.generateQrCode();
        return ResponseEntity.ok().build();
    }
}
