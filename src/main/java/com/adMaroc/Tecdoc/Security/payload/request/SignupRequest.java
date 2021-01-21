package com.adMaroc.Tecdoc.Security.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Set;

@Data
@AllArgsConstructor
public class SignupRequest {

        private String name;

        private String username;

        private String email;

        private String password;

}

