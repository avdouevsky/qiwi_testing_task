package com.mshvdvskgmail.qiwi_testing_task.network;

import com.mshvdvskgmail.qiwi_testing_task.network.model.Account;
import com.mshvdvskgmail.qiwi_testing_task.network.model.BalanceWrapper;
import com.mshvdvskgmail.qiwi_testing_task.network.model.UsersWrapper;
import com.mshvdvskgmail.qiwi_testing_task.network.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by mshvdvsk on 29/05/2017.
 */

public interface IService {
    String BASE_URL = "https://w.qiwi.com/mobile/testtask/index.json";

    @GET("mobile/testtask/index.json")
    Call<UsersWrapper<User>> getUsers();

    @GET("mobile/testtask/users/{id}/index.json")
    Call<BalanceWrapper<Account>> getBalance(@Path("id") String id);
}
