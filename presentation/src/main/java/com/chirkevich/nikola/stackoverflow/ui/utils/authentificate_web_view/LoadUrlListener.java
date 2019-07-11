package com.chirkevich.nikola.stackoverflow.ui.utils.authentificate_web_view;

import com.chirkevich.nikola.domain.models.security.Token;

public interface LoadUrlListener {

    void onLoadToken(Token token);

    void onErrorLoadToken(String message);
}
