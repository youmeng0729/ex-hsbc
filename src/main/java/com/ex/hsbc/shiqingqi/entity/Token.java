package com.ex.hsbc.shiqingqi.entity;

import java.time.LocalDateTime;

/**
 * @author Cliff
 */
public class Token {
    private String value;
    private LocalDateTime tokenTime;

    public LocalDateTime getTokenTime() {
        return tokenTime;
    }

    public Token setTokenTime(LocalDateTime tokenTime) {
        this.tokenTime = tokenTime;
        return this;
    }

    public String getValue() {
        return value;
    }

    public Token setValue(String value) {
        this.value = value;
        return this;
    }

}
