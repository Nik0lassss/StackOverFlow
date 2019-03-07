package com.chirkevich.nikola.data.mappers.answer;

import com.chirkevich.nikola.data.internet.model.answer.OwnerRemoteResponse;
import com.chirkevich.nikola.domain.models.answer.Owner;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper
public interface OwnerMapper {
    Owner toOwner(OwnerRemoteResponse ownerRemote);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<Owner> toOwners(List<OwnerRemoteResponse> owners);
}
