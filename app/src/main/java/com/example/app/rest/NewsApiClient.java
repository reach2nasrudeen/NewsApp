package com.example.app.rest;


import com.example.app.base.WebServiceURL;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class NewsApiClient {

    private static Retrofit retrofit = null;

    public NewsApiClient() {
    }

    public NewsApiInterface getClientInterface() {
        if (retrofit == null) {
            OkHttpClient defaultHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)) // Print details of every request through retrofit.
                    .connectTimeout(60, TimeUnit.SECONDS)
                    .retryOnConnectionFailure(true)
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(WebServiceURL.BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .client(defaultHttpClient)
                    .build();
        }
        return retrofit.create(NewsApiInterface.class);
    }

}
