package defpackage;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* JADX INFO: loaded from: classes.dex */
public final class qd1 extends AtomicReferenceArray implements Runnable, Callable, cw {
    public static final Object h = new Object();
    public static final Object i = new Object();
    public static final Object j = new Object();
    public static final Object k = new Object();
    public final Object g;

    public qd1(Runnable runnable, el elVar) {
        super(3);
        this.g = runnable;
        lazySet(0, elVar);
    }

    public final void a(Future future) {
        Object obj;
        do {
            obj = get(1);
            if (obj == k) {
                return;
            }
            if (obj == i) {
                future.cancel(false);
                return;
            } else if (obj == j) {
                future.cancel(true);
                return;
            }
        } while (!compareAndSet(1, obj, future));
    }

    @Override // defpackage.cw
    public final void b() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Object obj5;
        while (true) {
            Object obj6 = get(1);
            obj = k;
            if (obj6 == obj || obj6 == (obj4 = i) || obj6 == (obj5 = j)) {
                break;
            }
            boolean z = get(2) != Thread.currentThread();
            if (z) {
                obj4 = obj5;
            }
            if (compareAndSet(1, obj6, obj4)) {
                if (obj6 != null) {
                    ((Future) obj6).cancel(z);
                }
            }
        }
        do {
            obj2 = get(0);
            if (obj2 == obj || obj2 == (obj3 = h) || obj2 == null) {
                return;
            }
        } while (!compareAndSet(0, obj2, obj3));
        ((el) obj2).d(this);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        run();
        return null;
    }

    /* JADX WARN: Type inference failed for: r8v2, types: [java.lang.Object, java.lang.Runnable] */
    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        boolean zCompareAndSet;
        Object obj2;
        Object obj3 = j;
        Object obj4 = i;
        Object obj5 = h;
        Object obj6 = k;
        lazySet(2, Thread.currentThread());
        try {
            this.g.run();
        } finally {
            try {
            } catch (Throwable th) {
                do {
                    if (obj == obj4 || obj == obj3) {
                        break;
                    }
                } while (!zCompareAndSet);
            }
        }
        lazySet(2, null);
        Object obj7 = get(0);
        if (obj7 != obj5 && compareAndSet(0, obj7, obj6) && obj7 != null) {
            ((el) obj7).d(this);
        }
        do {
            obj2 = get(1);
            if (obj2 == obj4 || obj2 == obj3) {
                return;
            }
        } while (!compareAndSet(1, obj2, obj6));
    }
}
