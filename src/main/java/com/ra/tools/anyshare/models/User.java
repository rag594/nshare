package com.ra.tools.anyshare.models;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("User")
public class User implements Serializable {

    private String id;
    private String username;
    private String email;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
