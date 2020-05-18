package com.app.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class TokenResponse implements Serializable {

    private final String token;

}
