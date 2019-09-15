package com.ra.tools.anyshare.service;

import com.google.gson.Gson;
import com.ra.tools.anyshare.models.SignupResponse;
import com.ra.tools.anyshare.models.User;
import com.ra.tools.anyshare.utils.Constants;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.asynchttpclient.AsyncHttpClient;;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import static org.asynchttpclient.Dsl.asyncHttpClient;

@Service
public class AuthService {


    private AsyncHttpClient asyncHttpClient;
    private CloseableHttpClient httpClient;

    public AuthService() {
        this.asyncHttpClient = asyncHttpClient();
        this.httpClient = HttpClients.createDefault();
    }

    public HttpResponse signInUser(User user) throws Exception {
        Gson gson = new Gson();

        HttpPost httpPost = new HttpPost(Constants.AUTHENTICATION_URL);
        httpPost.addHeader("app_key", System.getenv("APP_SECRET"));
        httpPost.addHeader("Content-Type", "application/json");

        StringEntity stringEntity = new StringEntity(gson.toJson(user));
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);

        return httpClient.execute(httpPost);
    }

    public HttpResponse signUpUser(User user) throws Exception {
        Gson gson = new Gson();

        HttpPost httpPost = new HttpPost(Constants.SIGNUP_URL);
        httpPost.addHeader("app_key", System.getenv("APP_SECRET"));
        httpPost.addHeader("Content-Type", "application/json");

        StringEntity stringEntity = new StringEntity(gson.toJson(user));
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);

        return httpClient.execute(httpPost);
    }

    public HttpResponse verifyAccessToken(String accessToken) throws Exception {
        Gson gson = new Gson();

        HttpPost httpPost = new HttpPost(Constants.VERIFY_URL);
        httpPost.addHeader("app_key", System.getenv("APP_SECRET"));
        httpPost.addHeader("Content-Type", "application/json");

        Map<String, String> accessTokenMap = new HashMap<>();
        accessTokenMap.put("accessToken", accessToken);
        StringEntity stringEntity = new StringEntity(gson.toJson(accessTokenMap));
        stringEntity.setContentType("application/json");
        httpPost.setEntity(stringEntity);

        return httpClient.execute(httpPost);
    }

}
