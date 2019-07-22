package com.chirkevich.nikola.stackoverflow.di.app;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthorizedNetworkScope {
}
