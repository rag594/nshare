package com.ra.tools.anyshare.models;

import javax.validation.constraints.NotBlank;

public class Link {
    @NotBlank(message = "Please provide the link")
    private String url;

    public Link(String URL) {
        this.url = URL;
    }

    public Link() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
