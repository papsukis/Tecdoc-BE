package com.adMaroc.Tecdoc.Security.payload.request;

import lombok.Data;

@Data
public class BaseResponse {
    private boolean ok;

    BaseResponse(){
        this.ok=true;
    }
}
