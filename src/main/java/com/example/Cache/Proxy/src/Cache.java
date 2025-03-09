package com.example.Cache.Proxy.src;

import com.example.Cache.Proxy.src.Dto.ProxyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class Cache {
    private final long MAX_TIME_LIMIT = 60000;
    private final HashMap<String,ProxyResponseDto> cache = new HashMap<>();


    public Optional<ProxyResponseDto> getCachedValue(String key){

        Optional<ProxyResponseDto> cachedValue= Optional.ofNullable(cache.get(key));

        if(cachedValue.isPresent()){

           long cachedTimeLength = (now() - cachedValue.get().getTimeStamp());
           if(cachedTimeLength > MAX_TIME_LIMIT){
               cache.remove(key);
               return Optional.empty();
           }
        }

        return cachedValue;
    }

    public void setCachedValue(String key,ProxyResponseDto proxyResponseDto){
        cache.put(key,proxyResponseDto);
    }



    private long now(){
        return System.currentTimeMillis();
    }
}
