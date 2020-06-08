package com.acguglielmo.reactivexplayground;

import static io.reactivex.rxjava3.core.Observable.error;
import static io.reactivex.rxjava3.core.Observable.just;
import static java.util.Arrays.asList;

import io.reactivex.rxjava3.core.Observable;

public class TestingReactivex {

    public Observable<String> fromStringConstant() {

        return just("Hello world!");

    }

    public Observable<String> fromIterable() {

        return Observable.fromIterable( asList("Hello", "world", "!") );

    }

    public Observable<String> withErrorOnly() {

        return error( new RuntimeException("error in Observable!") ) ;

    }

}
