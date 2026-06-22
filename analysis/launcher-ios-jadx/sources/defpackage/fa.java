package defpackage;

import java.util.logging.Level;

/* JADX INFO: loaded from: classes.dex */
public final class fa implements Runnable {
    public final v21 g = new v21(6);
    public final r00 h;
    public volatile boolean i;

    public fa(r00 r00Var) {
        this.h = r00Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        y11 y11VarU;
        while (true) {
            try {
                try {
                    y11VarU = this.g.u();
                } catch (InterruptedException e) {
                    this.h.p.t(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e);
                    this.i = false;
                    return;
                }
                if (y11VarU == null) {
                    synchronized (this) {
                        y11VarU = this.g.t();
                        if (y11VarU == null) {
                            this.i = false;
                            this.i = false;
                            return;
                        }
                        this.h.p.t(Level.WARNING, Thread.currentThread().getName() + " was interruppted", e);
                        this.i = false;
                        return;
                    }
                }
                this.h.c(y11VarU);
            } catch (Throwable th) {
                this.i = false;
                throw th;
            }
        }
    }
}
