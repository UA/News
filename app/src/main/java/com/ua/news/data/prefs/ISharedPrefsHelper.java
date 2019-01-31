package com.ua.news.data.prefs;

public interface ISharedPrefsHelper {

    void clear();

    void putEmail(String email);

    String getEmail();

    boolean getLoggedInMode();

    void setLoggedInMode(boolean loggedIn);
}
