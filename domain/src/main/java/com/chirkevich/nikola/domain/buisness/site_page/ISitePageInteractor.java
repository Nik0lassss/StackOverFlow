package com.chirkevich.nikola.domain.buisness.site_page;

import com.chirkevich.nikola.domain.models.sites.Sites;

import io.reactivex.Single;

public interface ISitePageInteractor {

    Single<Sites> getSites(Integer page, Integer pageSize);
}
