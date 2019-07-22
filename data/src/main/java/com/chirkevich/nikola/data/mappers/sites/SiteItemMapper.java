package com.chirkevich.nikola.data.mappers.sites;

import com.chirkevich.nikola.data.internet.model.sites.SiteItemResponse;
import com.chirkevich.nikola.data.internet.model.sites.SitesResponse;
import com.chirkevich.nikola.data.local.database.entities.sites.SiteItemEntity;
import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.domain.models.sites.Sites;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper
public interface SiteItemMapper {

    SiteItemEntity toSiteItemEntity(SiteItem siteItem);

    SiteItemEntity toSiteItemEntity(SiteItemResponse siteItemResponse);


    SiteItem toSiteItem(SiteItemResponse siteItemResponse);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<SiteItem> toSiteItems(List<SiteItemResponse> siteItemResponses);


    SiteItem toSiteFromEntity(SiteItemEntity siteItemEntity);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<SiteItem> toSiteListFromEntity(List<SiteItemEntity> siteItemEntities);
}
