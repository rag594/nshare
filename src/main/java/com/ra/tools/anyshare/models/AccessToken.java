package com.ra.tools.anyshare.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccessToken {
    @JsonProperty
    private String accessToken;

    public AccessToken() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public AccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
