package com.chirkevich.nikola.stackoverflow;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.chirkevich.nikola.domain.buisness.synchronization.ISynchronizationInteractor;
import com.chirkevich.nikola.domain.models.answer.Items;

import java.util.Date;

import io.reactivex.Single;

public class ViewModelTest extends AndroidViewModel {

    private ISynchronizationInteractor synchronizationInteractor;

    public ViewModelTest(@NonNull Application application, ISynchronizationInteractor synchronizationInteractor) {
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
