package com.ra.tools.anyshare.models;

public class ErrorResponse {
    String errorMsg;

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public ErrorResponse() {
    }

    public ErrorResponse(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
