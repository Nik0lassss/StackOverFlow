package com.chirkevich.nikola.domain.repositories;

import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.domain.models.sites.Sites;

import io.reactivex.Single;

public interface SitesRemoteRepository {
    Single<Sites> getSites(Integer page,
                           Integer pageSize);
    Single<Sites> getAllSites();
}
