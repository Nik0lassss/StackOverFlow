package com.chirkevich.nikola.data.repositories;

import com.chirkevich.nikola.data.internet.client.StackOverFlowService;

import com.chirkevich.nikola.data.internet.model.answer.ItemsRemote;
import com.chirkevich.nikola.data.mappers.ItemMapper;
import com.chirkevich.nikola.domain.models.Items;
import com.chirkevich.nikola.domain.repositories.AnswerRemoteRepository;

import org.mapstruct.factory.Mappers;

import java.util.Date;

import io.reactivex.Scheduler;
import io.reactivex.Single;
import io.reactivex.functions.Function;

public class AnswerRepositoryImpl implements AnswerRemoteRepository {

    private StackOverFlowService stackOverFlowService;
    private Scheduler scheduler;
    private ItemMapper itemMapper = Mappers.getMapper(ItemMapper.class);

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
                .map(itemMapper::toItem);
    }
}
