package com.example.security.jjwt.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.UUID;

/**
 * TokenJwtUtils
 *
 * @author: admin
 * @create: 2022/03/19 23:36
 */
@Slf4j
public class TokenJwtUtils {
    private static final Key key;

    private static final KeyPair keyPair;

    private static final PrivateKey privateKey;

    private static final PublicKey publicKey;


    static {
        key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        keyPair = Keys.keyPairFor(SignatureAlgorithm.RS256); //or RS384, RS512, PS256, PS384, PS512, ES256, ES384, ES512
        privateKey = keyPair.getPrivate();
        publicKey = keyPair.getPublic();
    }

    /**
     * 生成token
     * header + claims + 签名
     *
     * @return token
     */
    public static String generateToken() {
        log.info("++++generateToke privateKey :{}", privateKey);
        // 设置了 .setClaims(claims) 已这个我为主
//        claims.setSubject("jxq");
        String token = Jwts.builder()
                .signWith(privateKey)
                .setIssuer("me")
                .setAudience("you")
//                .setExpiration(expiration) //a java.util.Date
//                .setNotBefore(notBefore) //a java.util.Date
//                .setIssuedAt(new Date()) // for example, now
                .setId(UUID.randomUUID().toString()) //just an example id
                .setSubject("Joe")
//                .setClaims(claims)
                .compact();

        log.info("+++++token: {}", token);
        return token;
    }

    public static String parseToken(String token) {
        log.info("++++++parseToken publicKey :{}", publicKey);
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(publicKey)
                .build()
                .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }

    /**
     * 生成token
     * header + claims + 签名
     *
     * @return
     */
    public static String generateHS256Token(Key key) {
        String token = Jwts.builder()
                .signWith(key)
                .setSubject("Joe")
                .compact();
        log.info("+++++token: {}", token);
        return token;
    }


    public static String parseHS256Token(String token, Key key) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token).getBody();
        return claims.getSubject();
    }
}
