package com.chirkevich.nikola.data.mappers.answer;

import com.chirkevich.nikola.data.internet.model.answer.AnswerItemsRemoteResponse;
import com.chirkevich.nikola.domain.models.answer.Items;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper
public interface AnswerItemMapper {

    Items toItem(AnswerItemsRemoteResponse answerItemsRemote);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<Items> toItems(List<AnswerItemsRemoteResponse> answerItemsRemotes);
}
