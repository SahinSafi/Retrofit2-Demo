package com.cyberwith.retrofit2.network;

import com.cyberwith.retrofit2.models.User;

public interface MyApiService {

    void userValidityCheck(User userLoginCredential, ResponseCallback<String> callback);
    void getJokeFromServer(String userId, ResponseCallback<String> callback);
}
