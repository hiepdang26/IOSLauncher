package androidx.work;

import android.content.Context;
import defpackage.aw;
import defpackage.az1;
import defpackage.bo;
import defpackage.do0;
import defpackage.ii0;
import defpackage.io0;
import defpackage.jf1;
import defpackage.jp;
import defpackage.kp;
import defpackage.m90;
import defpackage.nf1;
import defpackage.np1;
import defpackage.p02;
import defpackage.qg0;
import defpackage.qm0;
import defpackage.r1;
import defpackage.si0;
import defpackage.xt;

/* JADX INFO: loaded from: classes.dex */
public abstract class CoroutineWorker extends io0 {
    public final ii0 k;
    public final nf1 l;
    public final xt m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        qg0.l(context, "appContext");
        qg0.l(workerParameters, "params");
        this.k = new ii0();
        nf1 nf1Var = new nf1();
        this.l = nf1Var;
        nf1Var.addListener(new r1(this, 8), (jf1) ((qm0) getTaskExecutor()).a);
        this.m = aw.a;
    }

    public abstract Object a();

    @Override // defpackage.io0
    public final do0 getForegroundInfoAsync() {
        ii0 ii0Var = new ii0();
        xt xtVar = this.m;
        xtVar.getClass();
        bo boVarA = m90.a(az1.E(xtVar, ii0Var));
        si0 si0Var = new si0(ii0Var);
        np1.B(boVarA, new jp(si0Var, this, null));
        return si0Var;
    }

    @Override // defpackage.io0
    public final void onStopped() {
        super.onStopped();
        this.l.cancel(false);
    }

    @Override // defpackage.io0
    public final do0 startWork() {
        xt xtVar = this.m;
        xtVar.getClass();
        np1.B(m90.a(p02.s(xtVar, this.k)), new kp(this, null));
        return this.l;
    }
}
