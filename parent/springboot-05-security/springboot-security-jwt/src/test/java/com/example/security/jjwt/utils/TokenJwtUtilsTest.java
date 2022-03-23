package com.example.security.jjwt.utils;

import com.example.security.jjwt.bean.UserBo;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.Key;


@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TokenJwtUtilsTest {
    @Test
    public void generateEasyToken() {
        Key secretKey = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        log.info("+++++++=secretKey :{}", secretKey);
        String token = TokenJwtUtils.generateHS256Token(secretKey);
        Assert.assertNotNull("token is null", token);
        log.info("++++++token:{}", token);
        String subject = TokenJwtUtils.parseHS256Token(token, secretKey);
        Assert.assertEquals("Joe", subject);
    }

    @Test
    public void contextLoads() {
        String token = TokenJwtUtils.generateToken();
        Assert.assertNotNull("token is null", token);
        log.info("++++++token:{}", token);
        UserBo userBoFromToken = TokenJwtUtils.getUserBoFromToken(token);
        Assert.assertTrue(userBoFromToken.getRole().stream().anyMatch((roleBo -> roleBo.getId() == 1)));
    }

    @Test
    public void getClaims() {
        String token = TokenJwtUtils.generateToken();
        Assert.assertNotNull("token is null", token);
        log.info("++++++token: {}", token);
        Claims claims = TokenJwtUtils.getClaims(token);
        Assert.assertNotNull(claims);
        Assert.assertEquals("me", claims.get("iss"));
        Assert.assertEquals("you", claims.get("aud"));
        Assert.assertEquals("Joe", claims.get("sub"));
        Assert.assertEquals(32, String.valueOf(claims.get("jti")).replaceAll("-","").length());
        log.info("++++++claims: {}", claims);
    }

}
