package com.chirkevich.nikola.domain.buisness.user;

import com.chirkevich.nikola.domain.buisness.authentification.AuthentificationInteractorImpl;
import com.chirkevich.nikola.domain.models.user.Profile;
import com.chirkevich.nikola.domain.repositories.UserLocalRepository;
import com.chirkevich.nikola.domain.repositories.UserRemoteRepository;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

public class UserInteractor implements IUserInteractor {

    private static final String KEY = "Uh9ICKQttSRRr8GDDQ27rA((";


    private UserRemoteRepository userRemoteRepository;
    private UserLocalRepository userLocalRepository;
    private AuthentificationInteractorImpl authentificationInteractor;

    public UserInteractor(UserRemoteRepository userRemoteRepository,
                          UserLocalRepository userLocalRepository,
                          AuthentificationInteractorImpl authentificationInteractor) {
        this.userRemoteRepository = userRemoteRepository;
        this.userLocalRepository = userLocalRepository;
        this.authentificationInteractor = authentificationInteractor;
    }

    @Override
    public Single<List<Profile>> loadProfile() {
        return authentificationInteractor.getToken()
                .flatMap(token -> userRemoteRepository.getProfile(token.getAccessToken(), KEY));
    }

    @Override
    public Completable saveProfiles(List<Profile> profiles) {
        return userLocalRepository.saveProfiles(profiles);
    }

    @Override
    public Single<List<Profile>> getProfiles() {
        return userLocalRepository.getProfiles();
    }

    @Override
    public Single<List<Profile>> syncAndGetProfiles() {
        return loadProfile()
                .flatMapCompletable(userLocalRepository::saveProfiles)
                .andThen(userLocalRepository.getProfiles());
    }

    @Override
    public Completable syncProfiles() {
        return loadProfile()
                .flatMapCompletable(userLocalRepository::saveProfiles);
    }


}
