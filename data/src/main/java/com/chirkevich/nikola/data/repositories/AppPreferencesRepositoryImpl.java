package com.chirkevich.nikola.data.repositories;

import com.chirkevich.nikola.data.local.preferences.AppPreferences;
import com.chirkevich.nikola.domain.repositories.AppPreferencesRepository;

import java.util.Date;

import io.reactivex.Completable;

public class AppPreferencesRepositoryImpl implements AppPreferencesRepository {

    private AppPreferences appPreferences;

    public AppPreferencesRepositoryImpl(AppPreferences appPreferences) {
        this.appPreferences = appPreferences;
    }

    @Override
    public Date getLastUpdateSitesDate() {
        return appPreferences.getLastSitesUpdateDate();
    }

    @Override
    public Completable setLastUpdateSitesDate(Date date) {
        return Completable.fromRunnable(() -> appPreferences.setLastSitesUpdateDate(date));
    }

    @Override
    public Integer getLastLoadedSitesPage() {
        return appPreferences.getLastLoadedSitesPage();
    }

    @Override
    public void setLastLoadedSitesPage(Integer page) {
        appPreferences.setLastLoadedSitesPage(page);
    }

    @Override
    public Boolean isHasMoreSitePages() {
        return appPreferences.isHasMoreSitePages();
    }

    @Override
    public void setIsHasMoreSitePages(Boolean isHasMore) {
        appPreferences.setIsHasMoreSitePages(isHasMore);
    }

    @Override
    public Integer pageSize() {
        return appPreferences.getPageSize();
    }

    @Override
    public void setPageSize(Integer size) {
        appPreferences.setPageSize(size);
    }
}
