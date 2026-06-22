package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes.dex */
public final class pd1 extends AtomicReference implements Callable, cw {
    public static final FutureTask i;
    public static final FutureTask j;
    public final Runnable g;
    public Thread h;

    static {
        n4 n4Var = m90.b;
        i = new FutureTask(n4Var, null);
        j = new FutureTask(n4Var, null);
    }

    public pd1(Runnable runnable) {
        this.g = runnable;
    }

    public final void a(Future future) {
        Future future2;
        do {
            future2 = (Future) get();
            if (future2 == i) {
                return;
            }
            if (future2 == j) {
                future.cancel(this.h != Thread.currentThread());
                return;
            }
        } while (!compareAndSet(future2, future));
    }

    @Override // defpackage.cw
    public final void b() {
        FutureTask futureTask;
        Future future = (Future) get();
        if (future == i || future == (futureTask = j) || !compareAndSet(future, futureTask) || future == null) {
            return;
        }
        future.cancel(this.h != Thread.currentThread());
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        FutureTask futureTask = i;
        this.h = Thread.currentThread();
        try {
            this.g.run();
            return null;
        } finally {
            lazySet(futureTask);
            this.h = null;
        }
    }
}
