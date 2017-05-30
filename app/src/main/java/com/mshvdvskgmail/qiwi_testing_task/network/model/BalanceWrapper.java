package com.mshvdvskgmail.qiwi_testing_task.network.model;

import java.util.List;

/**
 * Created by mshvd_000 on 30.05.2017.
 */

public class BalanceWrapper <T> {
    private String result_code;
    private String errorMessage;
    private List<T> balances;

    public String getResultCode() {
        return result_code;
    }

    public String getErrorMessage(){
        return errorMessage;
    }

    public List<T> getBalance(){
        return balances;
    }
}
