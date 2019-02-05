package com.ua.news.data.network.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.ua.news.di.ApiInfo;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class ApiHeader {

    @Expose
    @SerializedName("api_key")
    private String mApiKey;

    @Inject
    public ApiHeader(@ApiInfo String apiKey) {
        mApiKey = apiKey;

    }

    public String getApiKey() {
        return mApiKey;
    }

    public void setApiKey(String apiKey) {
        mApiKey = apiKey;
    }
}