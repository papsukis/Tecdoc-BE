package com.adMaroc.Tecdoc.Security.payload.request;

import lombok.Data;

@Data
public class VerifyCodeRequest {
    private String username;
    private String code;
}