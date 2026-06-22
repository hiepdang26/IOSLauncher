package defpackage;

import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class si0 implements do0 {
    public final nf1 g = new nf1();

    public si0(ii0 ii0Var) {
        ii0Var.D(new ri0(this, 0));
    }

    @Override // defpackage.do0
    public final void addListener(Runnable runnable, Executor executor) {
        this.g.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        return this.g.cancel(z);
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.g.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.g.g instanceof h;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.g.isDone();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return this.g.get(j, timeUnit);
    }
}
