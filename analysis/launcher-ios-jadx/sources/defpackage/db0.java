package defpackage;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class db0 implements Runnable, cw {
    public final Handler g;
    public final Runnable h;

    public db0(Handler handler, Runnable runnable) {
        this.g = handler;
        this.h = runnable;
    }

    @Override // defpackage.cw
    public final void b() {
        this.g.removeCallbacks(this);
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.h.run();
        } catch (Throwable th) {
            e42.m(th);
        }
    }
}
