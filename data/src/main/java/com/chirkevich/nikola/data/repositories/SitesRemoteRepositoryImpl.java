package com.chirkevich.nikola.data.repositories;

import com.chirkevich.nikola.data.internet.client.StackOverFlowService;
import com.chirkevich.nikola.data.mappers.sites.SiteItemMapper;
import com.chirkevich.nikola.data.mappers.sites.SitesMapper;
import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.domain.models.sites.Sites;
import com.chirkevich.nikola.domain.repositories.SitesRemoteRepository;


import org.mapstruct.factory.Mappers;

import io.reactivex.Scheduler;
import io.reactivex.Single;

public class SitesRemoteRepositoryImpl implements SitesRemoteRepository {

    private StackOverFlowService stackOverFlowService;
    private Scheduler scheduler;
    private SitesMapper sitesMapper = Mappers.getMapper(SitesMapper.class);

    public SitesRemoteRepositoryImpl(StackOverFlowService stackOverFlowService, Scheduler scheduler) {
        this.stackOverFlowService = stackOverFlowService;
        this.scheduler = scheduler;
    }

    @Override
    public Single<Sites> getSites(Integer page, Integer pageSize) {
        return stackOverFlowService.getSites(page, pageSize)
                .subscribeOn(scheduler)
                .map(sitesMapper::toSites);
    }
}
