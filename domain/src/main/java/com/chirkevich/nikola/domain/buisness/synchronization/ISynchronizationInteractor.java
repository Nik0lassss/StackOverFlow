package com.chirkevich.nikola.domain.buisness.synchronization;

import com.chirkevich.nikola.domain.models.answer.Items;

import java.util.Date;

import io.reactivex.Single;

public interface ISynchronizationInteractor {
    void synchronize();

    Single<Items> getAnswers(Integer page,
                             Date todate,
                             Date max,
                             Integer pagesize,
                             String order,
                             String sort,
                             Date fromdate,
                             Date min,
                             String site);
}
