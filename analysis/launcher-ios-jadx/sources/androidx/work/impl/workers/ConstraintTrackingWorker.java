package androidx.work.impl.workers;

import android.content.Context;
import android.os.Build;
import androidx.work.WorkerParameters;
import defpackage.do0;
import defpackage.hn;
import defpackage.io0;
import defpackage.ka0;
import defpackage.lz1;
import defpackage.nf1;
import defpackage.qg0;
import defpackage.qy0;
import defpackage.r1;
import defpackage.rn;
import defpackage.sn;

/* JADX INFO: loaded from: classes.dex */
public final class ConstraintTrackingWorker extends io0 implements qy0 {
    public final WorkerParameters k;
    public final Object l;
    public volatile boolean m;
    public final nf1 n;
    public io0 o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        qg0.l(context, "appContext");
        qg0.l(workerParameters, "workerParameters");
        this.k = workerParameters;
        this.l = new Object();
        this.n = new nf1();
    }

    @Override // defpackage.qy0
    public final void b(lz1 lz1Var, sn snVar) {
        qg0.l(snVar, "state");
        ka0 ka0VarJ = ka0.j();
        int i = hn.a;
        lz1Var.toString();
        ka0VarJ.getClass();
        if (snVar instanceof rn) {
            synchronized (this.l) {
                this.m = true;
            }
        }
    }

    @Override // defpackage.io0
    public final void onStopped() {
        super.onStopped();
        io0 io0Var = this.o;
        if (io0Var == null || io0Var.isStopped()) {
            return;
        }
        io0Var.stop(Build.VERSION.SDK_INT >= 31 ? getStopReason() : 0);
    }

    @Override // defpackage.io0
    public final do0 startWork() {
        getBackgroundExecutor().execute(new r1(this, 6));
        nf1 nf1Var = this.n;
        qg0.k(nf1Var, "future");
        return nf1Var;
    }
}
