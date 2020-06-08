package com.acguglielmo.reactivexplayground;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import org.junit.jupiter.api.Test;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.observers.TestObserver;

public class TestingReactivexTest {

    private TestingReactivex instance = new TestingReactivex();

    @Test
    public void fromStringConstantTest() throws Exception {

        final Observable<String> observable = instance.fromStringConstant();

        final TestObserver<String> testObserver = TestObserver.create();

        observable.subscribe(testObserver);

        testObserver.assertComplete();

        testObserver.assertNoErrors();

        testObserver.assertValues("Hello world!");

    }

    @Test
    public void fromIterableTest() throws Exception {

        final Observable<String> observable = instance.fromIterable();

        assertThat(observable, notNullValue());

        final TestObserver<String> testObserver = TestObserver.create();

        testObserver.assertNotComplete();

        testObserver.assertNoErrors();

        testObserver.assertValueCount(0);

        observable.subscribe(testObserver);

        testObserver.assertComplete();

        testObserver.assertNoErrors();

        testObserver.assertValues("Hello", "world", "!");

    }

}
