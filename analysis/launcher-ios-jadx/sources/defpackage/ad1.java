package defpackage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes.dex */
public final class ad1 extends AtomicLong implements ThreadFactory {
    public final String g;
    public final int h;
    public final boolean i;

    public ad1(String str) {
        this(false, str, 5);
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        String str = this.g + '-' + incrementAndGet();
        Thread o9Var = this.i ? new o9(runnable, str) : new Thread(runnable, str);
        o9Var.setPriority(this.h);
        o9Var.setDaemon(true);
        return o9Var;
    }

    @Override // java.util.concurrent.atomic.AtomicLong
    public final String toString() {
        return uo.k(new StringBuilder("RxThreadFactory["), this.g, "]");
    }

    public ad1(boolean z, String str, int i) {
        this.g = str;
        this.h = i;
        this.i = z;
    }
}
