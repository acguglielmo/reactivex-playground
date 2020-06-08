package com.acguglielmo.reactivexplayground;

import static java.util.Arrays.asList;

import io.reactivex.rxjava3.core.Observable;

public class TestingReactivex {

    public Observable<String> fromStringConstant() {

        return Observable.just("Hello world!");

    }
    
    public Observable<String> fromIterable() {

        return Observable.fromIterable( asList("Hello", "world", "!") );

    }
    
}
