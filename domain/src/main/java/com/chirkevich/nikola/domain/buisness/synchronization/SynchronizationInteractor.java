package com.chirkevich.nikola.domain.buisness.synchronization;

import com.chirkevich.nikola.domain.models.Items;
import com.chirkevich.nikola.domain.repositories.AnswerRemoteRepository;

import java.util.Date;

import io.reactivex.Single;

public class SynchronizationInteractor implements ISynchronizationInteractor {

    private AnswerRemoteRepository answerRemoteRepository;

    public SynchronizationInteractor(AnswerRemoteRepository answerRemoteRepository) {
        this.answerRemoteRepository = answerRemoteRepository;
    }

    @Override
    public void synchronizate() {

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
        return answerRemoteRepository.getAnswers(page,
                todate,
                max,
                pagesize,
                order,
                sort,
                fromdate,
                min,
                site);
    }
}
