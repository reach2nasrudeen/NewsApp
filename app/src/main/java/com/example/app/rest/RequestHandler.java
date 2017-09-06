package com.example.app.rest;

import okhttp3.ResponseBody;
import retrofit2.Call;

public interface RequestHandler {

    void onSuccess(Call<ResponseBody> call, String content);

    void onFailure(Call<ResponseBody> call, Throwable t, String message, int code);

    void onExpired(Call<ResponseBody> call, int errorCode);
}
