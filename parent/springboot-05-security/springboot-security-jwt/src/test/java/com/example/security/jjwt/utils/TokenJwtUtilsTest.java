package com.example.security.jjwt.utils;

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


    // eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2UifQ.FRCHWlgIP_2FcKLLDsjhI1DT6uEL5_EvuxhpGOAMigw
    @Test
    public void contextLoads() {
        String token = TokenJwtUtils.generateToken();
        Assert.assertNotNull("token is null", token);
        log.info("++++++token:{}", token);
        String subject = TokenJwtUtils.parseToken(token);
        Assert.assertEquals("Joe", subject);
    }
}
