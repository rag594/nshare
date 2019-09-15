package com.ra.tools.anyshare.models;

public class JWTDecodeBody {
    private String email;
    private String _id;
    private String app_key;
    private long iat;
    private long exp;

    public JWTDecodeBody() {
    }

    public JWTDecodeBody(String email, String _id, String app_key, long iat, long exp) {
        this.email = email;
        this._id = _id;
        this.app_key = app_key;
        this.iat = iat;
        this.exp = exp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getApp_key() {
        return app_key;
    }

    public void setApp_key(String app_key) {
        this.app_key = app_key;
    }

    public long getIat() {
        return iat;
    }

    public void setIat(long iat) {
        this.iat = iat;
    }

    public long getExp() {
        return exp;
    }

    public void setExp(long exp) {
        this.exp = exp;
    }
}
