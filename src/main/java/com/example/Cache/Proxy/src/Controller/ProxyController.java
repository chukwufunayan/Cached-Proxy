package com.example.Cache.Proxy.src.Controller;

import com.example.Cache.Proxy.src.Dto.ProxyRequestDto;
import com.example.Cache.Proxy.src.Dto.ProxyResponseDto;
import com.example.Cache.Proxy.src.ProxyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController("/")
public class ProxyController {

    private final ProxyService proxyService;

    @PostMapping("/")
    public ProxyResponseDto proxy(@RequestBody ProxyRequestDto proxyRequestDto) throws Exception {
        return proxyService.process(proxyRequestDto);
    }
}
