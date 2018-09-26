package com.chirkevich.nikola.data.mappers;

import com.chirkevich.nikola.data.internet.model.answer.OwnerRemote;
import com.chirkevich.nikola.domain.models.Owner;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper
public interface OwnerMapper {
    Owner toOwner(OwnerRemote ownerRemote);


    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<Owner> toOwners(List<OwnerRemote> owners);
}
