package com.tech.activqmq.consumer;

import java.util.Arrays;
import java.util.List;

/**
 * Created by jingxingqiang on 2020/3/10 23:51
 */
public class miain {

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("11", "222");
        strings.forEach(o -> o.getBytes());
    }
}
