package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.Future;

/* JADX INFO: loaded from: classes.dex */
public interface do0 extends Future {
    void addListener(Runnable runnable, Executor executor);
}
