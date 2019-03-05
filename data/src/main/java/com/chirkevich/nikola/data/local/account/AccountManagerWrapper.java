package com.chirkevich.nikola.data.local.account;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.util.Log;

import com.chirkevich.nikola.data.R;

public class AccountManagerWrapper {

    private AccountManager am;
    private Context context;
    private static final String TOKEN_KEY = "token_key";
    private static final String USER_NAME = "stackOverFlowApp";
    private static final String PASSOWRD = "pass";

    public AccountManagerWrapper(Context context) {
        this.context = context;
        this.am = AccountManager.get(context);
    }

    public String getToken() {
        Account[] accounts = am.getAccountsByType(context.getString(R.string.account_type));
        if (accounts.length > 0) {
            Account account = accounts[0];
            return am.getUserData(account, TOKEN_KEY);
        }
        return null;
    }

    public void putToken(String token) {
        Account account = new Account(USER_NAME, context.getString(R.string.account_type));
        am.addAccountExplicitly(account, PASSOWRD, null);
        am.setUserData(account, TOKEN_KEY, token);
    }

}
