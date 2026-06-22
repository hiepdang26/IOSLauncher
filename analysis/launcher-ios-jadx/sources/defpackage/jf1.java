package defpackage;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes.dex */
public final class jf1 implements Executor {
    public final ExecutorService h;
    public Runnable i;
    public final ArrayDeque g = new ArrayDeque();
    public final Object j = new Object();

    public jf1(ExecutorService executorService) {
        this.h = executorService;
    }

    public final boolean a() {
        boolean z;
        synchronized (this.j) {
            z = !this.g.isEmpty();
        }
        return z;
    }

    public final void b() {
        Runnable runnable = (Runnable) this.g.poll();
        this.i = runnable;
        if (runnable != null) {
            this.h.execute(runnable);
        }
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        synchronized (this.j) {
            try {
                this.g.add(new el0(this, runnable, 9, false));
                if (this.i == null) {
                    b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
