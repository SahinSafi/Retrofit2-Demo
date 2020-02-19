package com.cyberwith.retrofit2.network;

public interface ResponseCallback<T> {

    void onSuccess(T data);
    void onError(Throwable th);
}
