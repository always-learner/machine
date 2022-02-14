package com.ascode.qrcodegenerator.services.qrcode;

import com.ascode.qrcodegenerator.exceptions.UnableToGenerateQRCode;

/**
 * Shyam Sharma
 *
 * This interface will have the generateQrCode functionality
 */
public interface QRCodeGenerator {

    /**
     * Method will be responsible for generating QR code using the given parameter
     *
     */
    void generateQrCode() throws UnableToGenerateQRCode;
}
