package com.chirkevich.nikola.data.mappers;

import com.chirkevich.nikola.data.internet.model.answer.ItemsRemote;
import com.chirkevich.nikola.domain.models.Items;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper
public interface ItemMapper {

    Items toItem(ItemsRemote itemsRemote);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<Items> toItems(List<ItemsRemote> itemsRemotes);
}
