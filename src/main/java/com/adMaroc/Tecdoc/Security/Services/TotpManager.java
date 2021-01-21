package com.adMaroc.Tecdoc.Security.Services;

public interface TotpManager {
    public String generateSecret();
    public boolean verifyCode(String code, String secret);
    public String getUriForImage(String secret,String username);
}