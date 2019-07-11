package com.chirkevich.nikola.domain.buisness.synchronization;

import com.chirkevich.nikola.domain.models.answer.Items;
import com.chirkevich.nikola.domain.repositories.AnswerRemoteRepository;
import com.chirkevich.nikola.domain.repositories.SiteLocalRepository;
import com.chirkevich.nikola.domain.repositories.SitesRemoteRepository;

import java.util.Date;

import io.reactivex.Single;

public class SynchronizationInteractor implements ISynchronizationInteractor {

    private AnswerRemoteRepository answerRemoteRepository;
    private SiteLocalRepository siteLocalRepository;
    private SitesRemoteRepository sitesRemoteRepository;

    public SynchronizationInteractor(AnswerRemoteRepository answerRemoteRepository,
                                     SiteLocalRepository siteLocalRepository,
                                     SitesRemoteRepository sitesRemoteRepository) {
        this.answerRemoteRepository = answerRemoteRepository;
        this.siteLocalRepository = siteLocalRepository;
        this.sitesRemoteRepository = sitesRemoteRepository;
    }

    @Override
    public void synchronize() {
        sitesRemoteRepository.getSites(0, 20)
                .flatMapCompletable(siteLocalRepository::saveSite)
                .subscribe();
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
