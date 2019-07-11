package com.chirkevich.nikola.domain.models.security;

public class Token {

    private String accessToken;
    private Integer expire;

    public Token(String accessToken, Integer expire) {
        this.accessToken = accessToken;
        this.expire = expire;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpire() {
        return expire;
    }

    public void setExpire(Integer expire) {
        this.expire = expire;
    }
}
