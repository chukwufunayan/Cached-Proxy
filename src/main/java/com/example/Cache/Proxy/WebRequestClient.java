package com.example.Cache.Proxy;

import com.example.Cache.Proxy.src.Constant.RequestMethod;
import com.example.Cache.Proxy.src.Dto.ProxyResponseDto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

//todo: add postProxyRequest logic
public class WebRequestClient {

   public static ProxyResponseDto processRequest(String url) throws Exception {
       return getProxyRequest(url);
    }

    private static ProxyResponseDto getProxyRequest(String webUrl) throws Exception{
            URL url = new URL(webUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(RequestMethod.GET.getMethod());
            connection.getResponseCode();
            BufferedReader reader;
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } else {
                reader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            }

            String responseBody = responseBuilder(reader);

            return new ProxyResponseDto(responseCode, responseBody, now());

    }

    private static String responseBuilder(BufferedReader reader) throws IOException {

        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line).append("\n");
        }

        reader.close();
        return response.toString();

    }

    private static long now(){
        return System.currentTimeMillis();
    }
}
