package com.adMaroc.Tecdoc.Security.payload.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResetPasswordRequest {

    private String username;
    private String password;

}
