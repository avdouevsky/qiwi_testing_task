package com.mshvdvskgmail.qiwi_testing_task.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mshvdvskgmail.qiwi_testing_task.R;
import com.mshvdvskgmail.qiwi_testing_task.adapter.NameListAdapter;
import com.mshvdvskgmail.qiwi_testing_task.network.REST;
import com.mshvdvskgmail.qiwi_testing_task.network.model.UsersWrapper;
import com.mshvdvskgmail.qiwi_testing_task.network.model.User;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private final static String TAG = MainActivity.class.toString();
    private TextView tvMain;
    private ImageView imageView;
    private RecyclerView rv;

    private NameListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvMain = (TextView) findViewById(R.id.test);
        imageView = (ImageView) findViewById(R.id.activity_main_image_send);
        rv = (RecyclerView) findViewById(R.id.activity_main_rv_recycler);

        adapter = new NameListAdapter(getApplicationContext());
        rv.setAdapter(adapter);
        LinearLayoutManager lm = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(lm);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                REST.getInstance().getUsers().enqueue(new Callback<UsersWrapper<User>>() {
                    @Override
                    public void onResponse(Call<UsersWrapper<User>> call, Response<UsersWrapper<User>> response) {
                        if (response.isSuccessful()) {
                            UsersWrapper<User> users = response.body();
                            adapter.setData(users.getUsers());
                        } else {
                            Log.d("QuestionsCallback", "Code: " + response.code() + " Message: " + response.message());
                        }
                    }

                    @Override
                    public void onFailure(Call<UsersWrapper<User>> call, Throwable t) {
                        Log.d(TAG, "error = "+t.toString());
                        call.toString();
                        tvMain.setText(call.toString());
                    }
                });
            }
        });
    }

}
