package retrofit2;

import defpackage.ia1;
import defpackage.yn1;

/* JADX INFO: loaded from: classes.dex */
public interface Call<T> extends Cloneable {
    void cancel();

    Call<T> clone();

    void enqueue(Callback<T> callback);

    Response<T> execute();

    boolean isCanceled();

    boolean isExecuted();

    ia1 request();

    yn1 timeout();
}
