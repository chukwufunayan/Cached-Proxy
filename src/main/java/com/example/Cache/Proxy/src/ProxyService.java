package com.example.Cache.Proxy.src;
import com.example.Cache.Proxy.src.Constant.RequestMethod;

import com.example.Cache.Proxy.WebRequestService;
import com.example.Cache.Proxy.src.Dto.ProxyRequestDto;
import com.example.Cache.Proxy.src.Dto.ProxyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ServerErrorException;

import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProxyService {

    final Cache cache;

    public ProxyResponseDto process(ProxyRequestDto proxyRequestDto) throws Exception {
        final String requestMethod = proxyRequestDto.getMethod().toUpperCase();
        final String requestUrl = proxyRequestDto.getUrl();
        final String requestBody = (proxyRequestDto.getRequestBody() != null ? proxyRequestDto.getRequestBody() : "");
        final String cacheKey;

        if (!RequestMethod.requestMethodMap.containsKey(requestMethod)){
            throw new Exception("only Get request method are allowed");
        }

        cacheKey = requestMethod + requestUrl + requestBody;

        Optional<ProxyResponseDto> cachedResponse = cache.getCachedValue(cacheKey);

      if(cachedResponse.isEmpty()){
          return processRequest(proxyRequestDto, cacheKey);
      }
      return cachedResponse.get();
    }

    private ProxyResponseDto processRequest(ProxyRequestDto proxyRequestDto, String cacheKey) throws Exception {
        System.out.println("processing Request");
       try {
           ProxyResponseDto requestResponse = WebRequestService.processRequest(proxyRequestDto.getUrl());

           if(requestResponse.getResponseCode() == 200)
               cache.setCachedValue(cacheKey,requestResponse);

           return requestResponse;
        }
       catch (Exception e){
           System.out.println("Error occurred while processing request: " + e.getMessage());
           throw new Exception(e);
       }
    }
}
