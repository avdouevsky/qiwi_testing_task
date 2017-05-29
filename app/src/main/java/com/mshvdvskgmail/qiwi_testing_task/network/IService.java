package com.mshvdvskgmail.qiwi_testing_task.network;

import com.mshvdvskgmail.qiwi_testing_task.network.model.User;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mshvdvsk on 29/05/2017.
 */

public interface IService {
    String BASE_URL = "https://w.qiwi.com/mobile/testtask/index.json";

    @GET()
    Call<ResultWrapper<User>> getUsers();
}
