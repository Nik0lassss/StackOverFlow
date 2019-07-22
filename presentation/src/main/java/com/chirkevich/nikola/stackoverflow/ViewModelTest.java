package com.chirkevich.nikola.stackoverflow;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.chirkevich.nikola.domain.buisness.synchronization.SynchronizationInteractor;
import com.chirkevich.nikola.domain.models.answer.Items;

import java.util.Date;

import io.reactivex.Single;

public class ViewModelTest extends AndroidViewModel {

    private SynchronizationInteractor synchronizationInteractor;

    public ViewModelTest(@NonNull Application application, SynchronizationInteractor synchronizationInteractor) {
        super(application);
        this.synchronizationInteractor = synchronizationInteractor;
    }

    public Single<Items> getItems(Integer page,
                                  Date todate,
                                  Date max,
                                  Integer pagesize,
                                  String order,
                                  String sort,
                                  Date fromdate,
                                  Date min,
                                  String site) {
        return synchronizationInteractor.getAnswers(page,
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
