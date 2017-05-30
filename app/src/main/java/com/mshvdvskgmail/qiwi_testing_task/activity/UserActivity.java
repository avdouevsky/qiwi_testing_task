package com.mshvdvskgmail.qiwi_testing_task.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.mshvdvskgmail.qiwi_testing_task.R;
import com.mshvdvskgmail.qiwi_testing_task.adapter.BalanceAdapter;
import com.mshvdvskgmail.qiwi_testing_task.network.REST;
import com.mshvdvskgmail.qiwi_testing_task.network.model.Account;
import com.mshvdvskgmail.qiwi_testing_task.network.model.BalanceWrapper;

import java.util.Currency;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.media.CamcorderProfile.get;
import static com.mshvdvskgmail.qiwi_testing_task.R.id.test;

/**
 * Created by mshvd_000 on 30.05.2017.
 */

public class UserActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.toString();
    private TextView tv;
    private RecyclerView rv;
    private BalanceAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(test);
        rv = (RecyclerView) findViewById(R.id.activity_main_rv_recycler);
        adapter = new BalanceAdapter(getApplicationContext());
        rv.setAdapter(adapter);
        LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(lm);


        Intent intent = getIntent();
        String id = intent.getStringExtra("id");

        REST.getInstance().getBalance(id).enqueue(new Callback<BalanceWrapper<Account>>() {
            @Override
            public void onResponse(Call<BalanceWrapper<Account>> call, Response <BalanceWrapper<Account>> response) {
                if (response.isSuccessful()) {
                    BalanceWrapper<Account> balance = response.body();
                    if (balance.getResultCode().equals("0")){
                        adapter.setData(balance.getBalance());
                    } else {
                        Log.d(TAG, "error "+balance.getResultCode() + " and message is " + balance.getErrorMessage());
                        // TODO: 30.05.2017 выводить ошибку пользователю 
                    }
                } else {
                    Log.d(TAG, "Code: " + response.code() + " Message: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<BalanceWrapper<Account>> call, Throwable t) {
                Log.d(TAG, "error = "+t.toString());
                tv.setText(call.toString());
            }
        });

//        private void

//        tv = (TextView) findViewById(test);
//        tv.setText(id);

    }

}
