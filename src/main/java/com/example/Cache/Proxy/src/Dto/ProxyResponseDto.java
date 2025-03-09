package com.example.Cache.Proxy.src.Dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.stereotype.Component;

@Getter
@Setter
@AllArgsConstructor
public class ProxyResponseDto {
    @NonNull
    private int responseCode;
    @NonNull
    private String response;
    @JsonIgnore
    private long timeStamp;

}
