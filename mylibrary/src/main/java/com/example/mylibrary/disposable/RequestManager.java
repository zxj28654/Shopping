package com.example.mylibrary.disposable;

import io.reactivex.disposables.Disposable;

public interface RequestManager {
    void add (String tag, Disposable disposable);

    void remove(String tag);

     void cancle(String tag);

     void cancleaAll();
}
