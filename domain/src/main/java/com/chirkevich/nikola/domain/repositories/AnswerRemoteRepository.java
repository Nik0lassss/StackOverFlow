package com.chirkevich.nikola.domain.repositories;

import com.chirkevich.nikola.domain.models.Items;

import java.util.Date;

import io.reactivex.Single;

public interface AnswerRemoteRepository {
    Single<Items> getAnswers( Integer page,
                              Date todate,
                              Date max,
                              Integer pagesize,
                              String order,
                              String sort,
                              Date fromdate,
                              Date min,
                              String site);
}
