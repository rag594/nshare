package com.ra.tools.anyshare.models;

public class SignInResponse {
    private String token;
    private String success;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public SignInResponse() {
    }

    public SignInResponse(String token, String success) {
        this.token = token;
        this.success = success;
    }
}
