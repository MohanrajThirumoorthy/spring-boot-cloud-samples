@Grab("io.reactivex:rxjava:1.0.1")

import rx.Subscriber
import rx.Observer

/**
 * Created by mohan on 3/30/15.
 */

println "**** Reactive -- Start Program ****"

long start = System.currentTimeMillis()

fetchWikipediaArticleAsynchronously("Tiger", "Elephant", "Horse", "Lion", "Cat", "Dog")
        .subscribe({ println "--- Article ---\n" + it.substring(0, 125)})


//test()

println "------------------------------------"
println "Time " + (System.currentTimeMillis() - start)
println "------------------------------------"



println "**** Reactive -- End Program ****"


def fetchWikipediaArticleAsynchronously(String... wikipediaArticleNames) {
    return rx.Observable.create({ rx.Observer<String> observer ->
        Thread.start {
            for(articleName in wikipediaArticleNames) {
                observer.onNext(new URL("http://en.wikipedia.org/wiki/"+articleName).getText().substring(0,125));
            }
            observer.onCompleted();
        }
        return rx.subscriptions.Subscriptions.empty();
    });
}

def test(){
    rx.Observable<String> s1 = getResponse1("Tiger");
    rx.Observable<String> s2 = getResponse2("Elephant");

    rx.Observable.merge(s1, s2)
        .subscribe(new Subscriber<String>() {
        @Override
        void onCompleted() {
            println "Completed"
        }

        @Override
        void onError(Throwable throwable) {

        }

        @Override
        void onNext(String s) {
            println "Response --> ${s}"
        }
    })
}


def rx.Observable<String> getResponse1(String text1) {
    return rx.Observable.create( {rx.Observer<String> subscriber ->
        Thread.start {
            subscriber.onNext(new URL("http://en.wikipedia.org/wiki/" + text1).getText().substring(0,125));
        }
        subscriber.onCompleted();
    });
}

def rx.Observable<String> getResponse2(String text2) {
    return rx.Observable.create( {rx.Observer<String> subscriber ->
        while(!subscriber.isUnsubscribed()) {
            subscriber.onNext(new URL("http://en.wikipedia.org/wiki/" + text2).getText().substring(0,125));
        }
        subscriber.onCompleted();
    });
}

