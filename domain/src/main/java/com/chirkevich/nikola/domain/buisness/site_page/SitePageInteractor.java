package com.chirkevich.nikola.domain.buisness.site_page;

import com.chirkevich.nikola.domain.models.sites.Sites;
import com.chirkevich.nikola.domain.repositories.SitesRemoteRepository;

import io.reactivex.Single;

public class SitePageInteractor implements ISitePageInteractor {

    private SitesRemoteRepository sitesRemoteRepository;


    public SitePageInteractor(SitesRemoteRepository sitesRemoteRepository) {
        this.sitesRemoteRepository = sitesRemoteRepository;
    }

    @Override
    public Single<Sites> getSites(Integer page, Integer pageSize) {
        return sitesRemoteRepository.getSites(page, pageSize);
    }

}
