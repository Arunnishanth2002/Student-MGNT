package com.example.student.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {

    //  Strong key (must be >= 32 chars)
    private final Key key = Keys.hmacShaKeyFor(
            "myverystrongsecretkeymyverystrongsecretkey".getBytes()
    );

    // 🔹 Generate Token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(key)   //  Correct
                .compact();
    }

    // 🔹 Extract Username
    public String extractUsername(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)   //  Correct
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }
}