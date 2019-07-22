package com.chirkevich.nikola.domain.buisness.site_page;

import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.domain.models.sites.Sites;
import com.chirkevich.nikola.domain.models.utils.Pair;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public interface SitePageInteractor {

    Single<List<SiteItem>> getSites(Integer page, Integer pageSize);

    Completable loadSites(Integer page, Integer pageSize);

}
