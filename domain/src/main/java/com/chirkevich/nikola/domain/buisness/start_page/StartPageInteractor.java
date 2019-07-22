package com.chirkevich.nikola.domain.buisness.start_page;

import io.reactivex.Single;

public interface StartPageInteractor {
    Single<Boolean> isLogged();
}
