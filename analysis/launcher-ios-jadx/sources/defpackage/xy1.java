package defpackage;

import android.content.Context;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class xy1 implements Runnable {
    public static final /* synthetic */ int m = 0;
    public final nf1 g = new nf1();
    public final Context h;
    public final lz1 i;
    public final io0 j;
    public final yy1 k;
    public final qm0 l;

    static {
        ka0.r("WorkForegroundRunnable");
    }

    public xy1(Context context, lz1 lz1Var, io0 io0Var, yy1 yy1Var, qm0 qm0Var) {
        this.h = context;
        this.i = lz1Var;
        this.j = io0Var;
        this.k = yy1Var;
        this.l = qm0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!this.i.q || Build.VERSION.SDK_INT >= 31) {
            this.g.i(null);
            return;
        }
        nf1 nf1Var = new nf1();
        qm0 qm0Var = this.l;
        ((dz1) qm0Var.d).execute(new wc(this, nf1Var, 26));
        nf1Var.addListener(new el0(this, nf1Var, 14), (dz1) qm0Var.d);
    }
}
