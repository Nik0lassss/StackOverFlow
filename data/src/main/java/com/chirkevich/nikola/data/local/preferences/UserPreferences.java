package com.chirkevich.nikola.data.local.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.chirkevich.nikola.data.utils.SharedPreferencesHelper;

public class UserPreferences {

    private final static String USER_PREFERENCES_FILE = "user_profile";

    private final static String EXPIRED = "expired";

    private SharedPreferencesHelper preferencesHelper;
    private SharedPreferences preferences;

    public UserPreferences(Context context) {
        preferences = context.getSharedPreferences(USER_PREFERENCES_FILE, Context.MODE_PRIVATE);
        preferencesHelper = new SharedPreferencesHelper(preferences);
    }

    public void setTokenExpired(Integer expired) {
        preferencesHelper.putInt(EXPIRED, expired);
    }

    public Integer getTokenExpired() {
        return preferencesHelper.getInt(EXPIRED);
    }
}
