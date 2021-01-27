package com.adMaroc.Tecdoc.Security.Services.Implementations;

import com.adMaroc.Tecdoc.Security.Exceptions.AlreadyLoggedException;
import com.adMaroc.Tecdoc.Security.Exceptions.InternalServerException;
import com.adMaroc.Tecdoc.Security.Models.JwtConfig;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.stream.Collectors;

@Service
@Slf4j
public class JwtTokenManager {

    @Autowired
    private final JwtConfig jwtConfig;

    public JwtTokenManager(JwtConfig jwtConfig) {
        this.jwtConfig = jwtConfig;
    }

    public String generateToken(Authentication authentication) {

        Long now = System.currentTimeMillis();
        return Jwts.builder()
                .setSubject(authentication.getName())
                .claim("authorities", authentication.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .setIssuedAt(new Date(now))
                .setExpiration(new Date(now + jwtConfig.getExpiration() * 1000))  // in milliseconds
                .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret().getBytes())
                .compact();
    }

    public Claims getClaimsFromJWT(String token) {
        return Jwts.parser()
                .setSigningKey(jwtConfig.getSecret().getBytes())
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String authToken,Date lastLogged) throws  InternalServerException{
        try {
            Jwts.parser()
                    .setSigningKey(jwtConfig.getSecret().getBytes())
                    .parseClaimsJws(authToken);

            Date issuedAT = Jwts.parser()
                    .setSigningKey(jwtConfig.getSecret().getBytes())
                    .parseClaimsJws(authToken).getBody().getIssuedAt();

            if(issuedAT.before(lastLogged))
                throw new AlreadyLoggedException("Already Logged");

            return true;
        }catch(AlreadyLoggedException ex){
            throw new AlreadyLoggedException(ex.getMessage());
        }
        catch (SignatureException ex) {
            throw new InternalServerException("Invalid JWT signature");
        } catch (MalformedJwtException ex) {
            throw new InternalServerException("Invalid JWT token");
        } catch (ExpiredJwtException ex) {
            throw new InternalServerException("Expired JWT token");
        } catch (UnsupportedJwtException ex) {
            throw new InternalServerException("Unsupported JWT token");
        } catch (IllegalArgumentException ex) {
            throw new InternalServerException("JWT claims string is empty.");
        }
    }
}