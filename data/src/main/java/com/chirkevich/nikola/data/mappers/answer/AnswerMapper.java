package com.chirkevich.nikola.data.mappers.answer;


import com.chirkevich.nikola.data.internet.model.answer.AnswerRemoteResponse;
import com.chirkevich.nikola.domain.models.answer.Answer;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper
public interface AnswerMapper {

    Answer toAnswer(AnswerRemoteResponse answerRemote);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<Answer> toAnswers(List<AnswerRemoteResponse> answerRemotes);
}
