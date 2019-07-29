package com.chirkevich.nikola.data.local.database.dao.site;

import android.util.Log;

import com.chirkevich.nikola.data.internet.model.sites.SiteItemResponse;
import com.chirkevich.nikola.data.local.database.AppDatabase;
import com.chirkevich.nikola.data.local.database.entities.sites.SiteItemEntity;
import com.chirkevich.nikola.data.mappers.sites.SiteItemMapper;
import com.chirkevich.nikola.data.mappers.sites.SitesMapper;
import com.chirkevich.nikola.domain.models.sites.SiteItem;

import org.mapstruct.factory.Mappers;

import java.util.List;

public class SiteItemDataSource {

    private SiteItemDao siteItemDao;
    private SitesMapper sitesMapper = Mappers.getMapper(SitesMapper.class);
    private SiteItemMapper siteItemMapper = Mappers.getMapper(SiteItemMapper.class);
    private AppDatabase appDatabase;

    public SiteItemDataSource(SiteItemDao siteItemDao, AppDatabase appDatabase) {
        this.siteItemDao = siteItemDao;
        this.appDatabase = appDatabase;
    }

    public List<SiteItem> getSites() {
        List<SiteItemEntity> siteItemEntities = siteItemDao.getSites();
        return siteItemMapper.toSiteListFromEntity(siteItemEntities);
    }

    public void saveSite(SiteItemResponse siteItemResponse) {
        siteItemDao.save(siteItemMapper.toSiteItemEntity(siteItemResponse));
    }

    public void saveSitesResponse(List<SiteItemResponse> siteItemResponses) {
        for (SiteItemResponse siteItemResponse : siteItemResponses)
            saveSite(siteItemResponse);
    }


    public void saveSite(SiteItem siteItem) {
        siteItemDao.save(siteItemMapper.toSiteItemEntity(siteItem));
    }

    public void saveSites(List<SiteItem> SiteItems) {
        appDatabase.runInTransaction(() -> {
            Log.d(SiteItemDataSource.class.getCanonicalName(), "saveSites");
            for (SiteItem siteItem : SiteItems)
                saveSite(siteItem);
        });
    }

    public void deleteAllSites() {
        Log.d(SiteItemDataSource.class.getCanonicalName(), "deleteAllSites");
        siteItemDao.delete();
    }

    public List<SiteItem> getSites(int offset, int limit) {
        List<SiteItemEntity> sites = siteItemDao.getSites(offset, limit);
        return siteItemMapper.toSiteListFromEntity(sites);
    }

    public List<SiteItem> getSites(int offset, int limit, String filter) {
        List<SiteItemEntity> sites = siteItemDao.getSites(offset, limit, filter);
        return siteItemMapper.toSiteListFromEntity(sites);
    }
}
