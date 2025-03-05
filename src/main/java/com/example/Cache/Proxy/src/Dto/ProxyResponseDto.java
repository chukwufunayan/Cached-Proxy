package com.example.Cache.Proxy.src.Dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class ProxyResponseDto {

    @NonNull
    private String response;
    private long timeStamp;

    public ProxyResponseDto of(String response, long timeStamp){
        ProxyResponseDto proxyResponseDto = new ProxyResponseDto();
        proxyResponseDto.setResponse(response);
        proxyResponseDto.setTimeStamp(timeStamp);
        return proxyResponseDto;
    }

}
