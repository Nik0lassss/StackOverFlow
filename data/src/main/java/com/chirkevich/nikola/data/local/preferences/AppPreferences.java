package com.chirkevich.nikola.data.local.preferences;

import android.content.Context;
import android.content.SharedPreferences;

import com.chirkevich.nikola.data.mappers.common.TimeMapper;
import com.chirkevich.nikola.data.utils.SharedPreferencesHelper;

import java.util.Date;

import io.reactivex.Completable;

public class AppPreferences {
    private final static String APP_PREFERENCES_FILE = "app_preference";
    private final static String LAST_SITES_UPDATE_DATE_KEY = "last_sites_update_key";
    private final static String LAST_LOADED_SITE_PAGE_KEY = "last_loaded_site_page_key";
    private final static String IS_HAS_MORE_SITE_PAGES_KEY = "is_has_more_site_pages_key";
    private final static String PAGE_SIZE_KEY = "page_size_key";
    private final static Integer DEFAULT_PAGE_SIZE = 20;
    private SharedPreferencesHelper preferencesHelper;
    private SharedPreferences preferences;

    private TimeMapper timeMapper = new TimeMapper();


    public AppPreferences(Context context) {
        preferences = context.getSharedPreferences(APP_PREFERENCES_FILE, Context.MODE_PRIVATE);
        preferencesHelper = new SharedPreferencesHelper(preferences);
    }

    public void setLastSitesUpdateDate(Date date) {
        long time = timeMapper.toLong(date);
        preferencesHelper.putLong(LAST_SITES_UPDATE_DATE_KEY, time);
    }

    public Date getLastSitesUpdateDate() {
        long time = preferencesHelper.getLong(LAST_SITES_UPDATE_DATE_KEY);
        return timeMapper.toDate(time);
    }


    public Integer getLastLoadedSitesPage() {
        return preferencesHelper.getInt(LAST_LOADED_SITE_PAGE_KEY, 1);
    }

    public void setLastLoadedSitesPage(Integer page) {
        preferencesHelper.putInt(LAST_LOADED_SITE_PAGE_KEY, page);
    }

    public Boolean isHasMoreSitePages() {
        return preferencesHelper.getBoolean(IS_HAS_MORE_SITE_PAGES_KEY, true);
    }

    public void setIsHasMoreSitePages(Boolean isHasMore) {
        preferencesHelper.putBoolean(IS_HAS_MORE_SITE_PAGES_KEY, isHasMore);
    }

    public Integer getPageSize() {
        return preferencesHelper.getInt(PAGE_SIZE_KEY, DEFAULT_PAGE_SIZE);
    }

    public void setPageSize(Integer size) {
        preferencesHelper.putInt(PAGE_SIZE_KEY, size);
    }
}
