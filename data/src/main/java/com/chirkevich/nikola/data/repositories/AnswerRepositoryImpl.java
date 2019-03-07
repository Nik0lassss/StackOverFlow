package com.chirkevich.nikola.data.repositories;

import com.chirkevich.nikola.data.internet.client.StackOverFlowService;

import com.chirkevich.nikola.data.mappers.answer.AnswerItemMapper;
import com.chirkevich.nikola.domain.models.answer.Items;
import com.chirkevich.nikola.domain.repositories.AnswerRemoteRepository;

import org.mapstruct.factory.Mappers;

import java.util.Date;

import io.reactivex.Scheduler;
import io.reactivex.Single;

public class AnswerRepositoryImpl implements AnswerRemoteRepository {

    private StackOverFlowService stackOverFlowService;
    private Scheduler scheduler;
    private AnswerItemMapper answerItemMapper = Mappers.getMapper(AnswerItemMapper.class);

    public AnswerRepositoryImpl(Scheduler scheduler,
                                StackOverFlowService stackOverFlowService) {
        this.scheduler = scheduler;
        this.stackOverFlowService = stackOverFlowService;
    }

    @Override
    public Single<Items> getAnswers(Integer page,
                                    Date todate,
                                    Date max,
                                    Integer pagesize,
                                    String order,
                                    String sort,
                                    Date fromdate,
                                    Date min,
                                    String site) {
        return stackOverFlowService.getAnswers(page, todate, max, pagesize, order, sort, fromdate, min, site)
                .subscribeOn(scheduler)
                .map(answerItemMapper::toItem);
    }
}
