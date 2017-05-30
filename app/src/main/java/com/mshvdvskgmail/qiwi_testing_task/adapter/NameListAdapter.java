package com.mshvdvskgmail.qiwi_testing_task.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.mshvdvskgmail.qiwi_testing_task.R;
import com.mshvdvskgmail.qiwi_testing_task.activity.UserActivity;
import com.mshvdvskgmail.qiwi_testing_task.network.model.User;
import com.mshvdvskgmail.qiwi_testing_task.view.NameItemView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mshvd_000 on 29.05.2017.
 */

public class NameListAdapter extends RecyclerView.Adapter<NameListAdapter.ViewHolder> {
    private Context context;
    private List<User> users;

    public NameListAdapter(Context context) {
        this.context = context;
        users = new ArrayList<>();
    }

    public void setData(@Nullable List<User> users){
        this.users = users;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(new NameItemView(context));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.getView().setData(users.get(position));
        holder.getView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, UserActivity.class);
                intent.putExtra("id", users.get(position).getId());
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(View itemView) {
            super(itemView);
        }

        public NameItemView getView(){
            return (NameItemView) itemView;
        }
    }
}
