package defpackage;

import android.os.Handler;

/* JADX INFO: loaded from: classes.dex */
public final class g3 implements Runnable {
    public long g;
    public boolean h;
    public my0 j;
    public boolean k = false;
    public final Handler i = new Handler();

    public final void a() {
        this.g = 0L;
        this.k = false;
    }

    public final void b(long j) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.k = true;
        long j2 = j + jCurrentTimeMillis;
        this.g = j2;
        if (this.h) {
            return;
        }
        this.i.postDelayed(this, j2 - jCurrentTimeMillis);
        this.h = true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.h = false;
        if (this.g != 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = this.g;
            if (j > jCurrentTimeMillis) {
                this.i.postDelayed(this, Math.max(0L, j - jCurrentTimeMillis));
                this.h = true;
                return;
            }
            this.k = false;
            my0 my0Var = this.j;
            if (my0Var != null) {
                my0Var.p(this);
            }
        }
    }
}
