package com.mshvdvskgmail.qiwi_testing_task.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.mshvdvskgmail.qiwi_testing_task.activity.UserActivity;
import com.mshvdvskgmail.qiwi_testing_task.network.model.Account;
import com.mshvdvskgmail.qiwi_testing_task.view.AccountItemView;
import com.mshvdvskgmail.qiwi_testing_task.view.NameItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mshvd_000 on 30.05.2017.
 */

public class BalanceAdapter extends RecyclerView.Adapter<BalanceAdapter.ViewHolder> {
    private Context context;
    private List<Account> accounts;

    public BalanceAdapter(Context context) {
        this.context = context;
        accounts = new ArrayList<>();
    }

    public void setData(@Nullable List<Account> accounts){
        this.accounts = accounts;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(new AccountItemView(context));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.getView().setData(accounts.get(position));
    }

    @Override
    public int getItemCount() {
        if (accounts==null){
            return 0;
        } else return accounts.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        public AccountItemView getView(){
            return (AccountItemView) itemView;
        }
    }
}

