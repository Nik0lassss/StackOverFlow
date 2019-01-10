package com.chirkevich.nikola.stackoverflow.ui.utils.authentificate_web_view;

public interface LoadUrlListener {

    void onLoadToken(String token);

    void onErrorLoadToken(String message);
}
