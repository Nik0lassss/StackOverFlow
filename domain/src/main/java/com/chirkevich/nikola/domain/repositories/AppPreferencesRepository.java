package com.chirkevich.nikola.domain.repositories;

import java.util.Date;

import io.reactivex.Completable;

public interface AppPreferencesRepository {
    Date getLastUpdateSitesDate();

    Completable setLastUpdateSitesDate(Date date);

    Integer getLastLoadedSitesPage();

    Completable setLastLoadedSitesPage(Integer page);

    Boolean isHasMoreSitePages();

    Completable setIsHasMoreSitePages(Boolean isHasMore);
}
