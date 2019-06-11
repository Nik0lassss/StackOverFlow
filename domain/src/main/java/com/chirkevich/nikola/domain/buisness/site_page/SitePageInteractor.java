package com.chirkevich.nikola.domain.buisness.site_page;

import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.domain.models.sites.Sites;
import com.chirkevich.nikola.domain.repositories.SitesRemoteRepository;

import java.util.List;

import io.reactivex.Observable;
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

    private List<SiteItem> load(Integer page, Integer pageSize, String siteName) {
        return sitesRemoteRepository.getSites(page, pageSize)
                .flatMap(sites -> Single.fromCallable(sites::getItems))
                .flatMapObservable(Observable::fromIterable)
                .filter(siteItem -> siteItem.getName().toLowerCase().contains(siteName.toLowerCase()))
                .toList()
                .blockingGet();
    }

}
