package com.adMaroc.Tecdoc.Security.payload.request;

import lombok.Data;


@Data
public class LoginRequest {
    private String username;

    private String password;
}
