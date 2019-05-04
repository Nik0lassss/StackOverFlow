package com.chirkevich.nikola.data.mappers.sites;

import com.chirkevich.nikola.data.internet.model.sites.SiteItemResponse;
import com.chirkevich.nikola.data.internet.model.sites.SitesResponse;
import com.chirkevich.nikola.data.local.database.entities.sites.SiteEntity;
import com.chirkevich.nikola.domain.models.sites.Sites;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper
public interface SitesMapper {

    Sites toSites(SitesResponse sitesResponse);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<Sites> toSitesFromResponse(List<SitesResponse> sitesResponses);

    Sites toSites(SiteEntity siteEntity);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<Sites> toSiteFromEntity(List<SiteEntity> siteEntities);

}
