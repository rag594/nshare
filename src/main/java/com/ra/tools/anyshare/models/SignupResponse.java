package com.ra.tools.anyshare.models;

import org.hibernate.validator.constraints.NotEmpty;

public class SignupResponse {
    private String success;
    private String email;

    public SignupResponse() {
    }

    public SignupResponse(String success, String email) {
        this.success = success;
        this.email = email;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
