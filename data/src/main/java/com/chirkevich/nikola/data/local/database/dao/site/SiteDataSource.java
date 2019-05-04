package com.chirkevich.nikola.data.local.database.dao.site;

import com.chirkevich.nikola.data.mappers.sites.SitesMapper;
import com.chirkevich.nikola.domain.models.sites.Sites;

import org.mapstruct.factory.Mappers;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public class SiteDataSource {

    private SiteDao siteDao;
    private SitesMapper sitesMapper = Mappers.getMapper(SitesMapper.class);


    public SiteDataSource(SiteDao siteDao) {
        this.siteDao = siteDao;
    }

    public Single<List<Sites>> getSites() {
        return siteDao.getSites()
                .map(sitesMapper::toSiteFromEntity);
    }


    public Completable saveSite(Sites sites) {
        return Completable.fromRunnable(() -> saveSite(sites));
    }

}
