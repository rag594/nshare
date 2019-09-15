package com.ra.tools.anyshare.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;

@RedisHash("User")
public class User implements Serializable {

    @NotBlank(message = "Please provide proper email")
    private String email;

    @NotBlank(message = "Please provide the password")
    @JsonIgnore
    private String password;
    private List<Link> links;

    public User(@NotBlank(message = "Please provide proper email") String email, List<Link> links) {
        this.email = email;
        this.links = links;
    }

    public List<Link> getLinks() {
        return links;
    }

    public void setLinks(List<Link> links) {
        this.links = links;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
