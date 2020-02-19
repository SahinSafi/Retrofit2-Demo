package com.cyberwith.retrofit2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.cyberwith.retrofit2.models.User;
import com.cyberwith.retrofit2.network.MyApiService;
import com.cyberwith.retrofit2.network.NetworkCall;
import com.cyberwith.retrofit2.network.ResponseCallback;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getData(){
        User user = new User();
        user.setPassword("1234");
        user.setUserId("1234");

        MyApiService myApiService = new NetworkCall();
        myApiService.userValidityCheck(user, new ResponseCallback<String>() {
            @Override
            public void onSuccess(String data) {
                Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(Throwable th) {
                Toast.makeText(getApplicationContext(), th.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
