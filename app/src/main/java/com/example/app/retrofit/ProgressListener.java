package com.example.app.retrofit;

public interface ProgressListener {
    void update(long bytesRead, long contentLength, boolean done);
  }