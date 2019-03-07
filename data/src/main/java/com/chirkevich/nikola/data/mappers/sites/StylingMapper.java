package com.chirkevich.nikola.data.mappers.sites;


import com.chirkevich.nikola.data.internet.model.sites.StylingResponse;
import com.chirkevich.nikola.domain.models.sites.Styling;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper
public interface StylingMapper {

    Styling toStyling(StylingResponse stylingResponse);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<Styling> toStylings(List<StylingResponse> stylingResponses);

}
