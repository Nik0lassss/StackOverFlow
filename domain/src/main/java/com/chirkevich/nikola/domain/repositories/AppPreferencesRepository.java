package com.chirkevich.nikola.domain.repositories;

import java.util.Date;

import io.reactivex.Completable;

public interface AppPreferencesRepository {
    Date getLastUpdateSitesDate();

    Completable setLastUpdateSitesDate(Date date);

    Integer getLastLoadedSitesPage();

    void setLastLoadedSitesPage(Integer page);

    Boolean isHasMoreSitePages();

    void setIsHasMoreSitePages(Boolean isHasMore);

    Integer pageSize();

    void setPageSize(Integer size);
}
