package defpackage;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class xf implements do0 {
    public final WeakReference g;
    public final wf h = new wf(this);

    public xf(vf vfVar) {
        this.g = new WeakReference(vfVar);
    }

    @Override // defpackage.do0
    public final void addListener(Runnable runnable, Executor executor) {
        this.h.addListener(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        vf vfVar = (vf) this.g.get();
        boolean zCancel = this.h.cancel(z);
        if (zCancel && vfVar != null) {
            vfVar.a = null;
            vfVar.b = null;
            vfVar.c.i(null);
        }
        return zCancel;
    }

    @Override // java.util.concurrent.Future
    public final Object get() {
        return this.h.get();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.h.g instanceof u;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.h.isDone();
    }

    public final String toString() {
        return this.h.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) {
        return this.h.get(j, timeUnit);
    }
}
