package com.example.app.callbacks;

public interface DaoResponse<T> {
    void onSuccess(String message);
    void onSuccess(T item, String message);
    void onFailure(String errorMessage);
}
