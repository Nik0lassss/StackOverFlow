package com.chirkevich.nikola.domain.buisness.site_page;

import com.chirkevich.nikola.domain.models.sites.SiteItem;
import com.chirkevich.nikola.domain.models.sites.Sites;
import com.chirkevich.nikola.domain.models.sites.state.LoadingState;
import com.chirkevich.nikola.domain.models.sites.state.NetworkState;
import com.chirkevich.nikola.domain.models.utils.Pair;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface SitePageInteractor {

    Single<List<SiteItem>> getSites(Integer page, Integer pageSize, String filter);

    Completable loadSites(Integer page, Integer pageSize);

    Observable<NetworkState> getLoadingState();
}
