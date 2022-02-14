package com.ascode.qrcodegenerator.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "qrcode")
public class QRCodeConfig {

    private String qrContent;
    private int width;
    private int height;
    private String filePath;

    public QRCodeConfig() {
    }

    public QRCodeConfig(final String qrContent, int width, int height, final String filePath) {
        this.qrContent = qrContent;
        this.width = width;
        this.height = height;
        this.filePath = filePath;
    }

    public String getQrContent() {
        return qrContent;
    }

    public void setQrContent(String qrContent) {
        this.qrContent = qrContent;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
