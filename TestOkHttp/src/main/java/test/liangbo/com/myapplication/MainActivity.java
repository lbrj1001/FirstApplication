package test.liangbo.com.myapplication;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.util.Log;

        import rx.Observable;
        import rx.Observer;
        import rx.Scheduler;
        import rx.Subscriber;
        import rx.android.schedulers.AndroidSchedulers;
        import rx.functions.Action0;
        import rx.functions.Action1;
        import rx.functions.Func1;
        import rx.schedulers.Schedulers;

        import static rx.Observable.*;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Subscriber<String> subscriber = new Subscriber<String>() {

            @Override
            public void onCompleted() {
                Log.e("tag","completed"+Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(String s) {
                Log.e("Tag",s);
            }
        };
        Person p1=new Person("LiangBo");
        Person p2=new Person("LiangJun");
        Person p3=new Person("LiangLei");
        Person[] test={p1,p2,p3};
        Observable observable = Observable
                .from(test)
                .map(new Func1<Person,String>() {
                    @Override
                    public String call(Person o) {
                        return o.getName();
                    }
                })
                .flatMap(new Func1<String, Observable<?>>() {
                    @Override
                    public Observable<?> call(String s) {
                        return null;
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        observable.subscribe(subscriber);//直接绑定
    }
}
