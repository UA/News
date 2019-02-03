package com.ua.news.utils.api;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class AuthenticationInterceptor implements Interceptor {

    private String authToken;

    public AuthenticationInterceptor(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request orginal = chain.request();
        Request.Builder builder = orginal.newBuilder().header("Authorization", authToken);
        Request request = builder.build();
        return chain.proceed(request);
    }
}

