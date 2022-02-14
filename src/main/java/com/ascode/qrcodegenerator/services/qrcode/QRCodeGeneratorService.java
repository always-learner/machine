package com.ascode.qrcodegenerator.services.qrcode;

import com.ascode.qrcodegenerator.configs.QRCodeConfig;
import com.ascode.qrcodegenerator.exceptions.UnableToGenerateQRCode;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

/**
 * This class will be responsible for generating the QR code using given content.
 */
@Service
public class QRCodeGeneratorService implements QRCodeGenerator {

    /**
     * Logger
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(QRCodeGenerator.class);

    /**
     * qr code config
     */
    private final QRCodeConfig qrCodeConfig;

    /**
     * constructor
     * @param qrCodeConfig {@link QRCodeConfig}
     */
    public QRCodeGeneratorService(final QRCodeConfig qrCodeConfig){
        this.qrCodeConfig  = Objects.requireNonNull(qrCodeConfig, "Unable to load QR code config");
    }

    /**
     * Below method will generate QR code using the given parameters
     */
    @Override
    public void generateQrCode() throws UnableToGenerateQRCode {
        try {
            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeConfig.getQrContent(), BarcodeFormat.QR_CODE, qrCodeConfig.getWidth(), qrCodeConfig.getHeight());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            MatrixToImageWriter.writeToStream(bitMatrix, "PNG", byteArrayOutputStream);
            try (FileOutputStream fos = new FileOutputStream(qrCodeConfig.getFilePath()+"/QR.png")) {
                fos.write(byteArrayOutputStream.toByteArray());
            }
        } catch (WriterException | IOException e) {
            LOGGER.error(e.getMessage(), e);
            throw new UnableToGenerateQRCode("Error while generating QR code"+e.getMessage(), 204);
        }
    }
}
