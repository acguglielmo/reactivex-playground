package com.acguglielmo.reactivexplayground;

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

        final TestObserver<String> testObserver = TestObserver.create();

        testObserver.assertNotComplete();

        testObserver.assertNoErrors();

        testObserver.assertValueCount(0);

        observable.subscribe(testObserver);

        testObserver.assertComplete();

        testObserver.assertNoErrors();

        testObserver.assertValues("Hello", "world", "!");

    }

    @Test
    public void withErrorTest() {

        final Observable<String> observable = instance.withErrorOnly();

        final TestObserver<String> testObserver = TestObserver.create();

        observable.subscribe(testObserver);

        testObserver.assertNotComplete();

        testObserver.assertError(RuntimeException.class);

    }

}
