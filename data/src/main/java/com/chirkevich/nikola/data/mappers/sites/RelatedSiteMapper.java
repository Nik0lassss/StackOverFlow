package com.chirkevich.nikola.data.mappers.sites;


import com.chirkevich.nikola.data.internet.model.sites.RelatedSiteResponse;
import com.chirkevich.nikola.domain.models.sites.RelatedSite;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper
public interface RelatedSiteMapper {

    RelatedSite toRelatedSite(RelatedSiteResponse relatedSiteResponse);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<RelatedSite> toRelatesSites(List<RelatedSiteResponse> relatedSiteResponses);

}
