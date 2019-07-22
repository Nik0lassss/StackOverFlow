package com.chirkevich.nikola.stackoverflow.utils.text;


import android.support.annotation.Nullable;

public class TextUtils {

    /**
     * copied from android package for using in non-device specific layers
     */
    public static boolean equals(CharSequence a, CharSequence b) {
        if (a == b) return true;
        int length;
        if (a != null && b != null && (length = a.length()) == b.length()) {
            if (a instanceof String && b instanceof String) {
                return a.equals(b);
            } else {
                for (int i = 0; i < length; i++) {
                    if (a.charAt(i) != b.charAt(i)) return false;
                }
                return true;
            }
        }
        return false;
    }

    /**
     * copied from android package for using in non-device specific layers
     */
    public static boolean isEmpty(CharSequence s) {
        return s == null || s.length() == 0;
    }

    public static String emptyIfNull(@Nullable String str) {
        return str == null ? "" : str;
    }

    //oauth2://mrmobile/v1/authorization#access_token=aab6118993c009530a1bb4d9f728a51b53c0d508&expires_in=3600&token_type=Bearer&scope=phone&state=state
    public static String between(String source, String start, String end) {
        int startIndex = indexOfEnd(source, start);
        int endIndex = source.indexOf(end, startIndex);
        if (endIndex == -1) {
            endIndex = source.length();
        }
        return source.substring(startIndex, endIndex);
    }

    public static String getUrlArgument(String source, String argName) {
        return between(source, argName, "&");
    }

    public static int indexOfEnd(String text, String source) {
        return text.indexOf(source) + source.length();
    }
}
