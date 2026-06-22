package defpackage;

import android.os.SystemClock;

/* JADX INFO: loaded from: classes.dex */
public abstract class z82 implements Runnable {
    public final long g;
    public final long h;
    public final boolean i;
    public final /* synthetic */ r92 j;

    public z82(r92 r92Var, boolean z) {
        this.j = r92Var;
        r92Var.b.getClass();
        this.g = System.currentTimeMillis();
        r92Var.b.getClass();
        this.h = SystemClock.elapsedRealtime();
        this.i = z;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        r92 r92Var = this.j;
        if (r92Var.f) {
            b();
            return;
        }
        try {
            a();
        } catch (Exception e) {
            r92Var.a(e, false, this.i);
            b();
        }
    }

    public void b() {
    }
}
