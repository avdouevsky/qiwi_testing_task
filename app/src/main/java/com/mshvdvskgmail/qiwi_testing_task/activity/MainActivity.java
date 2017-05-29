package com.mshvdvskgmail.qiwi_testing_task.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mshvdvskgmail.qiwi_testing_task.R;
import com.mshvdvskgmail.qiwi_testing_task.network.REST;
import com.mshvdvskgmail.qiwi_testing_task.network.model.User;


import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        callApi();
    }

    public void callApi(){
        List<User> users = new ArrayList<>();
        REST.getInstance().getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

            }

        });
    }


}
