package com.employees.info.spring.core.util;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

@Slf4j
@Component
public class ApiCaller {

    public JSONObject sendGetRequest(String baseUrl, String serviceKey, HashMap<String, String> parameters) {
        int responseCode;
        var data = new JSONObject();
        String utf_8 = String.valueOf(StandardCharsets.UTF_8);
        log.info("serviceKey => " + serviceKey);
        try {
            var urlBuilder = new StringBuilder(baseUrl);
            appendUrlByBuilder(urlBuilder, "?", URLEncoder.encode("serviceKey", utf_8), "=", serviceKey);
            appendUrlByBuilder(urlBuilder, "&", URLEncoder.encode("_type", utf_8), "=", URLEncoder.encode("json", utf_8));
            parameters.forEach((key, value) -> {
                log.info("parameters => " + key + " : " + value);
                try {
                    appendUrlByBuilder(urlBuilder, "&", URLEncoder.encode(key, utf_8), "=", value);
                } catch (UnsupportedEncodingException e) {
                    throw new RuntimeException(e);
                }
            });

            URL url = new URL(urlBuilder.toString());

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Content-type", "application/json");
            conn.connect();

            InputStreamReader inputStreamReader = new InputStreamReader(conn.getInputStream());
            JSONParser jsonParser = new JSONParser();
            data = (JSONObject) jsonParser.parse(inputStreamReader);

            responseCode = conn.getResponseCode();
            log.info("Response Code : " + responseCode);
        } catch (IOException | ParseException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    private static void appendUrlByBuilder(StringBuilder urlBuilder, String param1, String param2, String param3, String param4) throws UnsupportedEncodingException {
        urlBuilder.append(param1)
                .append(param2)
                .append(param3)
                .append(param4);
    }

//    public static void main(String[] args) {
//        ApiCaller apiCaller = new ApiCaller();
//
//        System.out.println("//===== GET REQUEST =====//");
//        var map = new HashMap<String, String>();
//        map.put("numOfRows", "10");
//        map.put("pageNo", "1");
//        map.put("MobileOS", "IOS");
//        map.put("MobileApp", "AppTest");
//        JSONObject data = apiCaller.sendGetRequest("https://apis.data.go.kr/B551011/PhotoGalleryService1/galleryList1", serviceKey, map);
//        System.out.println("The Data from Server: " + data);
//    }
}
