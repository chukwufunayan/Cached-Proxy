package com.example.Cache.Proxy.src.Controller;

import com.example.Cache.Proxy.src.Dto.ProxyRequestDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
public class ProxyController {

    ProxyRequestDto proxyRequestDto;

    private ProxyController(ProxyRequestDto proxyRequestDto){
        this.proxyRequestDto = proxyRequestDto;
    }

    @PostMapping("/")
    public String proxy( @RequestBody ProxyRequestDto proxyRequestDto){
        System.out.println(proxyRequestDto.getUrl());
        return proxyRequestDto.getUrl();
    }
}
