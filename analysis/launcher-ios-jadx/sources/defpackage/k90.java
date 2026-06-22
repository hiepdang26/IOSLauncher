package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class k90 extends Thread {
    public volatile boolean g = true;
    public final Object h = new Object();
    public Runnable i = null;
    public final /* synthetic */ l90 j;

    public k90(l90 l90Var) {
        this.j = l90Var;
    }

    public final void a(Runnable runnable) {
        synchronized (this.h) {
            this.i = runnable;
        }
        b();
    }

    public final void b() {
        this.j.P.set(true);
        synchronized (this.j.i) {
            this.j.i.notifyAll();
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Runnable runnable;
        try {
            l90.c(this.j);
            l90.d(this.j);
            long jNanoTime = System.nanoTime();
            while (this.g) {
                synchronized (this.h) {
                    runnable = this.i;
                    this.i = null;
                }
                if (runnable != null) {
                    runnable.run();
                    this.j.O.set(true);
                }
                if (this.j.P.getAndSet(false)) {
                    l90.b(this.j);
                    jNanoTime = System.nanoTime();
                } else {
                    long jNanoTime2 = 16666667 - (System.nanoTime() - jNanoTime);
                    if (jNanoTime2 > 0) {
                        try {
                            Thread.sleep(Math.min(10L, jNanoTime2 / 1000000));
                        } catch (InterruptedException unused) {
                        }
                    } else {
                        Thread.sleep(1L);
                    }
                }
            }
            try {
                l90.a(this.j);
            } catch (Throwable unused2) {
            }
        } catch (Throwable th) {
            try {
                l90.a(this.j);
            } catch (Throwable unused3) {
            }
            throw th;
        }
    }
}
