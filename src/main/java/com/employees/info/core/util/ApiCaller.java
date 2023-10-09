package com.employees.info.core.util;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;

@Slf4j
public class ApiCaller {

    public static JSONObject sendGetRequest(String baseUrl, String serviceKey, HashMap<String, String> parameters) {
        int responseCode;
        var data = new JSONObject();
        String utf_8 = String.valueOf(StandardCharsets.UTF_8);
        log.info("serviceKey => " + serviceKey);
        try {
            var urlBuilder = new StringBuilder(baseUrl);
            urlBuilder.append("?")
                    .append(URLEncoder.encode("serviceKey", utf_8))
                    .append("=")
                    .append(serviceKey); /* Service Key */
            urlBuilder.append("&")
                    .append(URLEncoder.encode("_type", utf_8))
                    .append("=")
                    .append(URLEncoder.encode("json", utf_8));
            parameters.forEach((key, value) -> {
                log.info("parameters => " + key + " : " + value);
                try {
                    urlBuilder.append("&")
                        .append(URLEncoder.encode(key, utf_8))
                        .append("=")
                        .append(value); /* Service Key */
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
