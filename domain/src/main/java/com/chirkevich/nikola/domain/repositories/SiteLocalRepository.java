package com.chirkevich.nikola.domain.repositories;

import com.chirkevich.nikola.domain.models.sites.Sites;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface SiteLocalRepository {

    Completable saveSite(Sites sites);

    Single<List<Sites>> getSites();

}