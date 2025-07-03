package com.example.oscarlin.utils;

import com.example.oscarlin.domain.User;
import io.jsonwebtoken.*;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.util.Date;

public class JWTUtils {
    private static long TIME=1000*5;//token有效期，以毫秒为单位所以此处为5s
    private static String SIGNATURE="2786";//私钥
    public static String createToken(User user){
        JwtBuilder jwtBuilder= Jwts.builder();
        String jwtToken=jwtBuilder
                .setHeaderParam("oscar","lin23")
                .setHeaderParam("typ","jwt")
                .setExpiration(new Date(System.currentTimeMillis()+8640000))
                .signWith(SignatureAlgorithm.HS256,SIGNATURE)
                .compact();
        return jwtToken;
    }
    public static boolean checkToken(String token){
        if (token==null){
            return false;
        }
        try{
            Jws<Claims> claimsJws=Jwts.parser().setSigningKey(SIGNATURE).parseClaimsJws(token);
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
