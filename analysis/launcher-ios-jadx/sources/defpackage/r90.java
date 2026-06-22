package defpackage;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class r90 implements ThreadFactory {
    public final p1 g;
    public final String h;
    public final ka0 i;
    public final boolean j;
    public final AtomicInteger k;

    public r90(p1 p1Var, String str, boolean z) {
        ka0 ka0Var = ka0.j;
        this.k = new AtomicInteger();
        this.g = p1Var;
        this.h = str;
        this.i = ka0Var;
        this.j = z;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        w1 w1Var = new w1(this, runnable, 20, false);
        this.g.getClass();
        o9 o9Var = new o9(w1Var);
        o9Var.setName("glide-" + this.h + "-thread-" + this.k.getAndIncrement());
        return o9Var;
    }
}
