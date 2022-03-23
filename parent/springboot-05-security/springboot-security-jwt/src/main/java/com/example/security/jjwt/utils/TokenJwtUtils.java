package com.example.security.jjwt.utils;

import com.example.security.jjwt.bean.UserBo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.jackson.io.JacksonDeserializer;
import io.jsonwebtoken.jackson.io.JacksonSerializer;
import io.jsonwebtoken.lang.Maps;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.security.Key;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * TokenJwtUtils
 *
 * @author: admin
 * @create: 2022/03/19 23:36
 */
@Slf4j
public class TokenJwtUtils {
    private static final String USER = "user";

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
        UserBo.RoleBo roleBo = UserBo.RoleBo.builder()
                .id(1)
                .name("system")
                .build();
        UserBo userBo = UserBo
                .builder()
                .id("dsdsd11")
                .passwordVesion("0")
                .role(Collections.singletonList(roleBo)).build();
        Map<String, Object> claims = new HashMap<>();
        claims.put(USER, userBo);
        String token = Jwts
                .builder()
                .serializeToJsonWith(new JacksonSerializer(new ObjectMapper()))
                .setClaims(claims)
                .setIssuer("me")
                .setAudience("you")
                .setId(UUID.randomUUID().toString()) //just an example id
                .setSubject("Joe")
                .signWith(privateKey)
                .compact();
        log.info("+++++token: {}", token);
        return token;
    }

    public static UserBo getUserBoFromToken(String token) {
        log.info("++++++parseToken publicKey :{}", publicKey);
        UserBo userBo = Jwts.parserBuilder()
                .deserializeJsonWith(new JacksonDeserializer(Maps.of(USER, UserBo.class).build()))
                .setSigningKey(publicKey)
                .build()
                .parseClaimsJws(token).getBody()
                .get(USER, UserBo.class);
        return userBo;
    }

    public static Claims getClaims(String token) {
        log.info("++++++parseToken publicKey :{}", publicKey);
        return Jwts.parserBuilder()
                .deserializeJsonWith(new JacksonDeserializer(Maps.of(USER, UserBo.class).build()))
                .setSigningKey(publicKey)
                .build()
                .parseClaimsJws(token).getBody();
    }


//    private static String buildUserBo() {
//        UserBo.RoleBo system = UserBo.RoleBo.builder().id(1).name("system").build();
//        UserBo userBo = UserBo.builder().id("1").role(Collections.singletonList(system)).build();
//        ObjectMapper objectMapper = new ObjectMapper();
//        try {
//            return objectMapper.writeValueAsString(userBo);
//        } catch (JsonProcessingException exception) {
//            log.error("exception", exception);
//        }
//        return StringUtils.EMPTY;
//    }


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
