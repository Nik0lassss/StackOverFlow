package com.chirkevich.nikola.data.mappers;


import com.chirkevich.nikola.data.internet.model.answer.AnswerRemote;
import com.chirkevich.nikola.domain.models.Answer;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper
public interface AnswerMapper {

    Answer toAnswer(AnswerRemote answerRemote);

    @IterableMapping(nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
    List<Answer> toAnswers(List<AnswerRemote> answerRemotes);
}
