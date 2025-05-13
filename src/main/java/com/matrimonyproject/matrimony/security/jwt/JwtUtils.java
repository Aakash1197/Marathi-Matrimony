package com.matrimonyproject.matrimony.security.jwt;

import com.matrimonyproject.matrimony.security.service.UserDetailsImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.stream.Collectors;

@Component
public class JwtUtils {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    @Value("${spring.app.jwtSecret}")
    private String jwtSecret;
    @Value("${spring.app.jwtExpirationMs}")
    private int jwtExpirationInMs;
    @Value("${spring.app.jwtCookieName}")
    private String jwtCookie;

    public String getJwtFromCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                logger.info("Cookie: " + cookie.getName() + " = " + cookie.getValue());
            }
        }
        Cookie cookie = WebUtils.getCookie(request,jwtCookie);
        return cookie != null ? cookie.getValue() : null;

    }

        public ResponseCookie generateJwtCookie(UserDetailsImpl userDetails) {
        String jwt=generateTokenFromUserName(userDetails);
        return ResponseCookie.from(jwtCookie,jwt)
              /*  //for development
                 secure(false)*/
               /* For production
                .secure(true)*/
                .secure(true)
                .sameSite("Lax")
                .maxAge(jwtExpirationInMs/1000)
                .httpOnly(true)
                .path("/matrimony-app/api")
                .secure(false)
                .build();

    }

    public ResponseCookie generateJwtCleanCookie() {
        return ResponseCookie.from(jwtCookie,null)
                .path("/matrimony-app/api")
                .build();

    }

    public String generateTokenFromUserName(UserDetails userDetails) {
        String userName=userDetails.getUsername();

        return Jwts.builder()
                .subject(userName)
                .claim("roles",userDetails.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList()))
                .claim("username",userDetails.getUsername())
                .issuedAt(new Date())
                .expiration(new Date((new Date()).getTime() + jwtExpirationInMs))
                .signWith(key())
                .compact();
    }

    public String getUserNameFromJwtToken(String token) {
        logger.info("getUserNameFromJwtToken()    :"+Jwts.parser()
                .verifyWith((SecretKey) key())
                .build().parseSignedClaims(token)
                .getPayload().getSubject());
        return Jwts.parser()
                .verifyWith((SecretKey) key())
                .build().parseSignedClaims(token)
                .getPayload().getSubject();
    }

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public boolean validateJwtToken(String authToken) {
        try {
            System.out.println("Validate");
            Jwts.parser().verifyWith((SecretKey) key()).build().parseSignedClaims(authToken);
            return true;
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
