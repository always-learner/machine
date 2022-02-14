package com.ascode.qrcodegenerator.exceptions;

public class UnableToGenerateQRCode extends Exception {

    private String message;
    private int code;

    public UnableToGenerateQRCode() {
        super();
    }

    public UnableToGenerateQRCode(final String message, int code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
