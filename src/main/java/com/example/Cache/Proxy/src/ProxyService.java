package com.example.Cache.Proxy.src;

import com.example.Cache.Proxy.src.Dto.ProxyRequestDto;
import com.example.Cache.Proxy.src.Dto.ProxyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProxyService {

    final ProxyResponseDto proxyResponseDto;
    final Cache cache;

    public ProxyResponseDto process(ProxyRequestDto proxyRequestDto){

        Optional<ProxyResponseDto> cachedResponse = cache.getCachedValue(proxyRequestDto.getUrl());

        return cachedResponse.orElse(processRequest(proxyRequestDto.getUrl()));
    }

    private ProxyResponseDto processRequest(String url) {
        //get url response then set cache

        return null;
    }
}
