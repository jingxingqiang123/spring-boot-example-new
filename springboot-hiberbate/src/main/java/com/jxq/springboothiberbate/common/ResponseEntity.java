package com.jxq.springboothiberbate.common;

import java.util.Objects;

/**
 * Created by jingxingqiang on 2019/12/1 10:33
 */
public class ResponseEntity {

    private Integer code;
    private String status;
    private Object result;

    public ResponseEntity() {
    }
    public ResponseEntity( Object result) {
        this.code = code;
        this.status = status;
        this.result = result;
    }
    public ResponseEntity(Integer code, String status, Object result) {
        this.code = code;
        this.status = status;
        this.result = result;
    }
    public ResponseEntity ok(Integer code, String status, Object result){
        this.code = 200;
        this.status="success";
        return new ResponseEntity(code,status,result);
    }

    public ResponseEntity ok( Object result){

        return new ResponseEntity(null,null,result);
    }
    public ResponseEntity fail(Integer code, String status, Object result){
        return new ResponseEntity(code,status,result);
    }
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
