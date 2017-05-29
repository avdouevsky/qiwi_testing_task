package com.mshvdvskgmail.qiwi_testing_task.network;


import com.mshvdvskgmail.qiwi_testing_task.network.model.User;

import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mshvdvsk on 29/05/2017.
 */

public class REST implements IService {

    private final static REST instance = new REST();
    private IService service;
    private Retrofit retrofit;

    public REST() {
        retrofit = new Retrofit.Builder()
                .baseUrl(IService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(IService.class);



    }

    public static REST getInstance() {
        return instance;
    }


    @Override
    public Call<ResultWrapper<User>> getUsers() {
        return service.getUsers();
    }
}
