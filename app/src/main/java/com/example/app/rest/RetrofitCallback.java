package com.example.app.rest;


import android.util.Log;

import com.example.app.base.AppConstants;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RetrofitCallback<T> implements AppConstants, Callback<T> {
    private static final String TAG = RetrofitCallback.class.getSimpleName();

    @Override
    public void onResponse(Call<T> call, Response<T> response) {
        int statusCode = response.code();
        if (response.body() == null || !response.isSuccessful()) {
            String message = null;
            try {
                message = response.errorBody().string();
                Log.e(TAG, "onSuccess Retrofit failure callback response... " + message + " code ---> " + statusCode + " isSuccess ---> " + response.isSuccessful());
                if (statusCode == 404 || statusCode == 500 || message.isEmpty()) {
                    onFailureCallback(call, null, response);
                    return;
                }

                /*JSONObject jsonObject = new JSONObject(message);*/
                //TODO HANGLE THE ERROR MESSAGE ACCORDING TO THE RESPONSE LIKE BELOW
                /*if (jsonObject.has("code")){
                    String code = jsonObject.optString("code");
                    if (code.equalsIgnoreCase(ERRORCODE_UNABLE_TO_EXTRACT_JWT_CLAIM) || code.equalsIgnoreCase(ERRORCODE_TOKEN_EXPIRED)){
                        Log.e("onExpired retrofit callback response........................................... ");
                        onExpiredCallback(call, response);
                        return;
                    }
                   *//* if (jsonObject.has("message")){
                        message = jsonObject.optString("message");
                    }*//*
                }*/

            } catch (Exception e) {
                e.printStackTrace();
            }
            onFailureCallback(call, message, response);
            return;
        }

        String responseString="";
        try{
            if (response.body() instanceof  ResponseBody) {
                ResponseBody body = (ResponseBody) response.body();
                responseString = body.string();
            }
            Log.e(TAG, "onSuccess Retrofit callback response... " + responseString + " code ---> " + statusCode + " isSuccess ---> " + response.isSuccessful());
            onSuccessCallback(call, responseString, response);

        } catch (IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public void onFailure(Call<T> call, Throwable t) {
        String message = null;
        try {
            message = t.getMessage();
            Log.e(TAG, "onFailure Retrofit callback message... " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        onFailureCallback(call, message, null);
    }

    public void onSuccessCallback(Call<T> call, String content, Response<T> response) {
    }

    public void onFailureCallback(Call<T> call, String message, Response<T> response) {
    }

    public void onExpiredCallback(Call<T> call, Response<T> response) {
    }

}
