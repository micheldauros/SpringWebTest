package com.yy.springboottest02.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Date;

@Component
public class JwtUtil {
    private static final String secretKey="Unevensea856";
    private static final long EXPIRE=7*60*60*24;

    public static String getJwtToken(String id){
        String  token= Jwts.builder()
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .claim("id",id)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
        return token;

    }

    public static boolean checkToken(String jwtToken) {
        if(StringUtils.isEmpty(jwtToken)) return false;
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean checkToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("token");
        return checkToken(jwtToken);
    }

    public static String getUserIdByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("token");
        if(StringUtils.isEmpty(jwtToken)) return "";
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken);
        Claims claims = claimsJws.getBody();
        return (String)claims.get("id");
    }
}
