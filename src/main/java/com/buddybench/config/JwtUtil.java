package com.buddybench.config;

import com.buddybench.utils.UsersDetailsImpl;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.Serializable;

import java.util.Date;

@Component
public class JwtUtil implements Serializable {
    private static final long serialVersionUID = 1L;

    private static final Logger logger = LoggerFactory.getLogger(JwtUtil.class);


    @Value("${com.buddybench.jwtSecret}")
    private String jwtSecret;

    @Value("${com.buddybench.jwtExpirationMs}")
    private int jwtExpirationMs;


    public String generateJwtTokenUser(Authentication authentication) {
        UsersDetailsImpl custPrincipal = (UsersDetailsImpl) authentication.getPrincipal();
        return Jwts.builder().setSubject((custPrincipal.getUsername())).setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
    }
    public String getUserNameFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public Date getUserIATFromJwtToken(String token) {
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getIssuedAt();
    }


    public boolean validateJwtToken(String httpOptions) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(httpOptions);
            return true;
        } catch (SignatureException e) {
            logger.error("Invalid JWT signature: {}", e.getMessage());
        } catch (MalformedJwtException e) {
            logger.error("Invalid JWT token: {}", e.getMessage());
        } catch (ExpiredJwtException e) {
            logger.error("JWT token is expired: {}", e.getMessage());
        } catch (UnsupportedJwtException e) {
            logger.error("JWT token is unsupported: {}", e.getMessage());
        } catch (IllegalArgumentException e) {
            logger.error("JWT claims string is empty: {}", e.getMessage());
        }
        return false;
    }

}
