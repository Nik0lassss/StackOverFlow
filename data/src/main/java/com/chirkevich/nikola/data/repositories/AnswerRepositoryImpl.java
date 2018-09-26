package com.chirkevich.nikola.data.repositories;

import com.chirkevich.nikola.data.internet.client.StackOverFlowService;

import com.chirkevich.nikola.data.mappers.ItemMapper;
import com.chirkevich.nikola.domain.models.Items;
import com.chirkevich.nikola.domain.repositories.AnswerRemoteRepository;

import org.mapstruct.factory.Mappers;

import java.util.Date;

import io.reactivex.Single;

public class AnswerRepositoryImpl implements AnswerRemoteRepository {

    private StackOverFlowService stackOverFlowService;
    private ItemMapper itemMapper = Mappers.getMapper(ItemMapper.class);

    public AnswerRepositoryImpl(StackOverFlowService stackOverFlowService) {
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
        return Single.just(itemMapper.toItem(stackOverFlowService.getAnswers(page, todate, max, pagesize, order, sort, fromdate, min, site)));
    }
}
