package com.chirkevich.nikola.data.internet;

import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class InterceptManager {

    private Subject<String> redirectsCallsSubject = PublishSubject.create();

    public Observable<String> getRedirectsCalls() {
        return redirectsCallsSubject;
    }

    public void callRedirect(String reditectUrl) {
        this.redirectsCallsSubject.onNext(reditectUrl);
    }
}
