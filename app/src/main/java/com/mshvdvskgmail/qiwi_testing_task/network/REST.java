package com.mshvdvskgmail.qiwi_testing_task.network;


import com.mshvdvskgmail.qiwi_testing_task.network.model.Account;
import com.mshvdvskgmail.qiwi_testing_task.network.model.BalanceWrapper;
import com.mshvdvskgmail.qiwi_testing_task.network.model.UsersWrapper;
import com.mshvdvskgmail.qiwi_testing_task.network.model.User;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Path;

/**
 * Created by mshvdvsk on 29/05/2017.
 */

public class REST implements IService {

    private final static REST instance = new REST();
    private IService service;
    private Retrofit retrofit;

    public REST() {
        retrofit = new Retrofit.Builder()
                .baseUrl("https://w.qiwi.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        service = retrofit.create(IService.class);
    }

    public static REST getInstance() {
        return instance;
    }


    @Override
    public Call<UsersWrapper<User>> getUsers() {
        return service.getUsers();
    }

    @Override
    public Call<BalanceWrapper<Account>> getBalance(@Path("id") String name) {
        return service.getBalance(name);
    }
}
