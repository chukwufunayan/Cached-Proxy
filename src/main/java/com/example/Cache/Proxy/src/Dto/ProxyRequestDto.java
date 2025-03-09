package com.example.Cache.Proxy.src.Dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
public class ProxyRequestDto {
     @NonNull
     private String method;
     @NonNull
     private String url;
     private String requestBody;
}
