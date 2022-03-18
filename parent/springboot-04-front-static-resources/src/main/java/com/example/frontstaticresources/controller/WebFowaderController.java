package com.example.frontstaticresources.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * WebFowaderController
 *
 * @author: admin
 * @create: 2022/03/14 22:53
 */
@RestController
@RequestMapping("/console")
public class WebFowaderController {
    private RestTemplate restTemplate = new RestTemplate();

    @RequestMapping(value = "/{version}/{api}/**")
    public ResponseEntity<Object> api(@PathVariable("version") String version, @PathVariable("api") String api,
                                      HttpServletRequest request, HttpEntity httpEntity) {
        String requestURI = request.getRequestURI();
        ResponseEntity<Object> objectResponseEntity = restTemplate.postForEntity(requestURI, httpEntity, Object.class);
        return objectResponseEntity;
    }
}
