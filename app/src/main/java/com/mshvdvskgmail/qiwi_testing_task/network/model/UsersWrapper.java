package com.mshvdvskgmail.qiwi_testing_task.network.model;

import com.mshvdvskgmail.qiwi_testing_task.network.model.User;

import java.util.List;

/**
 * Created by mshvdvsk on 29/05/2017.
 */

public class UsersWrapper<T> {
    private List<T> users;

    public List<T> getUsers(){
       return users;
    }
}
