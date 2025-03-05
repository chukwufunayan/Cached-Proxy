package com.example.Cache.Proxy.src.Dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ProxyRequestDto {
     @NonNull
     private String url;
}
