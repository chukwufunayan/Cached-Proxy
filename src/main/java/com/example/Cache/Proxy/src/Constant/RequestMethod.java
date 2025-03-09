package com.example.Cache.Proxy.src.Constant;

import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public enum RequestMethod {
    GET("GET");

    private final String method;

    public static final HashMap<String,RequestMethod> requestMethodMap= new HashMap<>();

    RequestMethod(String method){
        this.method = method;
    }

    static {
        Arrays.stream(RequestMethod.values()).forEach((requestMethod)->{
            requestMethodMap.put(requestMethod.getMethod(),requestMethod);
        });
    };

    public String getMethod() {
        return method;
    }
}
