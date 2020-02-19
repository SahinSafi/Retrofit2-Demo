package com.cyberwith.retrofit2.network;

import com.cyberwith.retrofit2.models.ServerResponse;
import com.cyberwith.retrofit2.models.User;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NetworkCall implements MyApiService {
    @Override
    public void userValidityCheck(final User userLoginCredential, final ResponseCallback<String> callback) {
        RetrofitApiInterface retrofitApiInterface = RetrofitApiClient.getClient().create(RetrofitApiInterface.class);
        Call<ServerResponse> call = retrofitApiInterface.getUserValidity(userLoginCredential);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                ServerResponse serverResponse = response.body();
                if (serverResponse != null){
                    if (serverResponse.isSuccess()){
                        callback.onSuccess(serverResponse.getMessage());
                    }else {
                        callback.onError(new Exception(serverResponse.getMessage()));
                    }
                }else {
                    callback.onError(new Exception(response.message()));
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                callback.onError(t);
            }
        });
    }

    @Override
    public void getJokeFromServer(String userId, final ResponseCallback<String> callback) {

        RetrofitApiInterface retrofitApiInterface = RetrofitApiClient.getClient().create(RetrofitApiInterface.class);
        Call<ServerResponse> call = retrofitApiInterface.getJoke(userId);

        call.enqueue(new Callback<ServerResponse>() {
            @Override
            public void onResponse(Call<ServerResponse> call, Response<ServerResponse> response) {
                ServerResponse serverResponse = response.body();
                if (serverResponse != null){
                    if (serverResponse.isSuccess()){
                        callback.onSuccess(serverResponse.getMessage());
                    }else {
                        callback.onError(new Exception(serverResponse.getMessage()));
                    }
                }else {
                    callback.onError(new Exception(response.message()));
                }
            }

            @Override
            public void onFailure(Call<ServerResponse> call, Throwable t) {
                callback.onError(new Exception(t));
            }
        });

    }
}
