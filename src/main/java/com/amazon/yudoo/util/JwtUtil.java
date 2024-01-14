package com.amazon.yudoo.util;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt_secret}")
    private String jwtSecret;

    @Value("${jwt_expire}")
    private Integer jwtExpiration;

    public String generateToken(String subject){
        return Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, jwtSecret)
                .setExpiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .compact();
    }

    public String getTokenSubject(String token){
        return Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean isJwtTokenValid(String token){
        try {
            Jwts.parser()
                    .setSigningKey(jwtSecret)
                    .parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            throw new RuntimeException("Invalid JWT token");
        }catch (ExpiredJwtException e){
            throw new RuntimeException("JWT token is expired");
        }catch (UnsupportedJwtException e){
            throw new RuntimeException("JWT token is unsupported");
        }catch (IllegalArgumentException e){
            throw new RuntimeException("JWT token is invalid");
        }catch (SignatureException e){
            throw new RuntimeException("JWT signature is not match");
        }
    }
}
