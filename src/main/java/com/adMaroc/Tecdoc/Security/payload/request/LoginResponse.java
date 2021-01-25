package com.adMaroc.Tecdoc.Security.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse extends BaseResponse{
    private String secretImageUri;
}
