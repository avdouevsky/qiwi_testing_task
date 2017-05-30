package com.mshvdvskgmail.qiwi_testing_task.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.mshvdvskgmail.qiwi_testing_task.R;
import com.mshvdvskgmail.qiwi_testing_task.network.model.User;

/**
 * Created by mshvd_000 on 29.05.2017.
 */

public class NameItemView extends FrameLayout{
    private TextView tvName;

    public NameItemView(Context context) {
        this(context, null);
    }

    public NameItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NameItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        buildUI();
    }

    private void buildUI(){
        FrameLayout.inflate(getContext(), R.layout.recycler_name_list_item, this);
        tvName = (TextView) findViewById(R.id.recycler_item_name_tv_name);

    }

    public void setData(User user){
        tvName.setText(user.getName());
    }

}
