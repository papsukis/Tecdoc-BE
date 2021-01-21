package com.adMaroc.Tecdoc.Security.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class JwtAuthenticationResponse {
    @NonNull
    private String accessToken;

}
