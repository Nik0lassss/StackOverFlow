package com.chirkevich.nikola.domain.buisness.site_page;

import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.domain.models.sites.Sites;
import com.chirkevich.nikola.domain.models.utils.Pair;
import com.chirkevich.nikola.domain.repositories.SitesRemoteRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Single;

public class SitePageInteractor implements ISitePageInteractor {

    private SitesRemoteRepository sitesRemoteRepository;
    private int sizeLoading = 0;


    public SitePageInteractor(SitesRemoteRepository sitesRemoteRepository) {
        this.sitesRemoteRepository = sitesRemoteRepository;
    }

    @Override
    public Single<Sites> getSites(Integer page, Integer pageSize) {
        return sitesRemoteRepository.getSites(page, pageSize);
    }

    @Override
    public Single<Pair<Integer, List<SiteItem>>> getSites(Integer page, Integer pageSize, String siteName) {
        ArrayList<SiteItem> mergeLoadsites = new ArrayList<>();
        int lastLoadPage = page;


        while (sizeLoading < pageSize) {
            Sites siteItems = null;
            try {
                siteItems = load(page, pageSize);
            } catch (Exception e) {
                System.out.println(e.toString());
                break;
            }
            if (siteItems != null) {
                sizeLoading += siteItems.getItems().size();
                mergeLoadsites.addAll(siteItems.getItems());
                lastLoadPage++;
            }
        }
        sizeLoading = 0;
//        while (sizeLoading <= pageSize) {
//        sitesRemoteRepository.getSites(appendPage, pageSize)
////                    .flatMap(sites -> Single.fromCallable(sites::getItems))
////                    .flatMapObservable(Observable::fromIterable)
////                    .filter(siteItem -> siteItem.getName().toLowerCase().contains(siteName.toLowerCase()))
////                    .toList()
//                .doOnSuccess(sites -> {
//                    mergeLoadsites.addAll(sites.getItems());
//                    sizeLoading += sites.getItems().size();
//                    appendPage++;
//                })
//                .subscribe();
//        }
        return Single.just(new Pair<>(lastLoadPage, mergeLoadsites));
    }

    private Sites load(Integer page, Integer pageSize) {
        return sitesRemoteRepository.getSites(page, pageSize).blockingGet();
    }

}
