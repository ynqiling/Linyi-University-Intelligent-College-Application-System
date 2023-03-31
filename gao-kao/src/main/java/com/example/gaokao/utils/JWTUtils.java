package com.example.gaokao.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.compression.CompressionCodecs;
import org.springframework.util.StringUtils;

import java.util.Date;
/*
token生成工具
* */
public class JWTUtils {
    //token过期时间:ms单位
   // private static long tokenExpiration = 24*60*60*1000;
    //签名秘钥
    private static String tokenSignKey = "123456";
/*
根据字符串生成token
* */
    public static String createToken(Integer userId, String userName) {
        String token = Jwts.builder()
                .setSubject("GaoKao-USER")
                //设置过期时间，当前时间过后多少ms
                //.setExpiration(new Date(System.currentTimeMillis() + tokenExpiration))
                .claim("userId", userId)
                .claim("userName", userName)
                .signWith(SignatureAlgorithm.HS512, tokenSignKey)
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }
    /*
    根据token获取用户id
    */
    public static Long getUserId(String token) {
        if(StringUtils.isEmpty(token)) return null;
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        Integer userId = (Integer)claims.get("userId");
        return userId.longValue();
    }
    //根据token获取用户名
    public static String getUserName(String token) {
        if(StringUtils.isEmpty(token)) return "";
        Jws<Claims> claimsJws
                = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String)claims.get("userName");
    }
    public static void main(String[] args) {
        String token = JWTUtils.createToken(1, "55");
        System.out.println(token);
        System.out.println(JWTUtils.getUserId(token));
        System.out.println(JWTUtils.getUserName(token));
    }
}