package com.chirkevich.nikola.data.repositories;

import android.util.Log;

import com.chirkevich.nikola.data.internet.client.StackOverFlowService;
import com.chirkevich.nikola.data.internet.model.sites.SiteItemResponse;
import com.chirkevich.nikola.data.internet.model.sites.SitesResponse;
import com.chirkevich.nikola.data.local.database.dao.site.SiteItemDataSource;
import com.chirkevich.nikola.data.mappers.sites.SitesMapper;
import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.domain.repositories.AppPreferencesRepository;
import com.chirkevich.nikola.domain.repositories.SiteLocalRepository;

import org.junit.Before;
import org.junit.Test;
import org.mapstruct.factory.Mappers;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

import static org.junit.Assert.*;

public class SiteLocalRepositoryImplTest {

    private StackOverFlowService stackOverFlowService = Mockito.mock(StackOverFlowService.class);
    private AppPreferencesRepository appPreferencesRepository = Mockito.mock(AppPreferencesRepository.class);

    private SiteItemDataSource siteItemDataSource = Mockito.mock(SiteItemDataSource.class);


    private SiteLocalRepository siteLocalRepository = new SiteLocalRepositoryImpl(siteItemDataSource, stackOverFlowService, appPreferencesRepository, Schedulers.trampoline());

    @Before
    public void setUpBefore() {
        List<SiteItem> empty = new ArrayList<>();
        List<SiteItem> siteItems = getItems(20);
        List<SiteItem> siteItemsLast = getItems(15);
        Mockito.when(siteItemDataSource.getSites(0, 20)).thenReturn(empty, siteItems);
        Mockito.when(siteItemDataSource.getSites(60, 20)).thenReturn(empty, siteItems);
        Mockito.when(siteItemDataSource.getSites(80, 20)).thenReturn(empty, siteItems);
        Mockito.when(appPreferencesRepository.getLastLoadedSitesPage()).thenReturn(1, 2, 3, 4, 5, 6, 7);
        Mockito.when(appPreferencesRepository.pageSize()).thenReturn(20);
        Mockito.when(stackOverFlowService.getSites(1, 20)).thenReturn(getSiteResponse(20, true));
        Mockito.when(stackOverFlowService.getSites(2, 20)).thenReturn(getSiteResponse(20, true));
        Mockito.when(stackOverFlowService.getSites(3, 20)).thenReturn(getSiteResponse(20, true));
        Mockito.when(stackOverFlowService.getSites(4, 20)).thenReturn(getSiteResponse(20, true));
        Mockito.when(stackOverFlowService.getSites(5, 20)).thenReturn(getSiteResponse(20, true));
        Mockito.when(stackOverFlowService.getSites(6, 20)).thenReturn(getSiteResponse(20, true));
        Mockito.when(stackOverFlowService.getSites(7, 20)).thenReturn(getSiteResponse(20, false));
    }

    @Test
    public void getSites() {

        siteLocalRepository.getSites(0, 60)
                .test()
                .assertComplete();

        siteLocalRepository.getSites(60, 20)
                .test()
                .assertComplete();

        siteLocalRepository.getSites(80, 20)
                .test()
                .assertComplete();


    }

    private List<SiteItem> getItems(int size) {
        List<SiteItem> siteItems = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            SiteItem siteItem = new SiteItem();
            siteItems.add(siteItem);
        }
        return siteItems;
    }


    private Single<SitesResponse> getSiteResponse(int size, boolean isHasMore) {
        SitesResponse sitesResponse = generateResponse(size);
        sitesResponse.setHasMore(isHasMore);
        return Single.just(sitesResponse);
    }

    private SitesResponse generateResponse(int size) {
        SitesResponse sitesResponse = new SitesResponse();
        List<SiteItemResponse> siteItemResponses = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            SiteItemResponse siteItemResponse = new SiteItemResponse();
            siteItemResponses.add(siteItemResponse);
        }
        sitesResponse.setSiteItems(siteItemResponses);
        return sitesResponse;
    }
}