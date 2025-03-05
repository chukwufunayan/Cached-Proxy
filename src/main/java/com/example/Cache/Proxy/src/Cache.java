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

    //todo: move to an enum or constant
    private final long MAX_TIME_LIMIT = 60000;
    private final ProxyResponseDto proxyResponseDto;
    private final HashMap<String,ProxyResponseDto> cache = new HashMap<>();


    public Optional<ProxyResponseDto> getCachedValue(String key){

        Optional<ProxyResponseDto> cachedValue= Optional.ofNullable(cache.get(key));

        if(cachedValue.isPresent()){

           if(now() - cachedValue.get().getTimeStamp() > MAX_TIME_LIMIT){
               cache.remove(key);
               return Optional.empty();
           }
        }

        return cachedValue;
    }



    private long now(){
        return System.currentTimeMillis();
    }
}
