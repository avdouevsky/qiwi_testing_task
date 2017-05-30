package com.mshvdvskgmail.qiwi_testing_task.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.mshvdvskgmail.qiwi_testing_task.R;
import com.mshvdvskgmail.qiwi_testing_task.network.model.Account;
import com.mshvdvskgmail.qiwi_testing_task.network.model.BalanceWrapper;
import com.mshvdvskgmail.qiwi_testing_task.network.model.User;

import java.util.Currency;
import java.util.Locale;

/**
 * Created by mshvd_000 on 30.05.2017.
 */

public class AccountItemView extends FrameLayout {
    private TextView tvSum;
    private TextView tvIcon;
    private TextView tvName;
    private Locale myLocale;
    private Currency symbol;

    public AccountItemView(Context context) {
        this(context, null);
    }

    public AccountItemView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AccountItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        buildUI();
    }

    private void buildUI(){
        FrameLayout.inflate(getContext(), R.layout.recycler_account_list_item, this);
        tvSum = (TextView) findViewById(R.id.recycler_item_name_tv_sum);
        tvIcon = (TextView) findViewById(R.id.currency_icon);
        tvName = (TextView) findViewById(R.id.currency_name);
    }

    public void setData(Account account){
        myLocale = new Locale("ru","RU");
        if (account.getCurrency().equals("KZT")){
            tvSum.setText(account.getAmount());
            tvIcon.setText("\u20B8");
        } else if (account.getCurrency().equals("RUB")) {
            tvSum.setText(account.getAmount());
            symbol = Currency.getInstance(account.getCurrency());
            tvName.setText(symbol.getSymbol(myLocale));
        } else {
            tvSum.setText(account.getAmount());
            symbol = Currency.getInstance(account.getCurrency());
            tvIcon.setText(symbol.getSymbol(myLocale));
        }
    }

//    if (response.isSuccessful()) {
//        BalanceWrapper<Account> balance = response.body();
//        balance.getBalance();
//        if(balance!=null){
//            balance.getBalance().get(0);
//            String temp = "";
//
//            Locale myLocale = new Locale("ru","RU");
////                    Currency symbol = Currency.getInstance("GBP");
////                    pound.getSymbol(myLocale);
//
////                    adapter.setData(questions.users);
//            for (int i = 0; i < balance.getBalance().size(); i++){
//                Account a = balance.getBalance().get(i);
//
//                if (a.getCurrency().equals("KZT")){
//                    temp+=a.getAmount()+" "+ new String("1 909 993" + "\u20B8");
//                } else {
//                    Currency symbol = Currency.getInstance(a.getCurrency());
//                    temp+=a.getAmount()+" "+ symbol.getSymbol(myLocale);
//                }
//            }
//            tv.setText(temp);
//        }
//    } else {
//        Log.d(TAG, "Code: " + response.code() + " Message: " + response.message());
//    }

}
