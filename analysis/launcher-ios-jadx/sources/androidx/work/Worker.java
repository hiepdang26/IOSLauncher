package androidx.work;

import android.content.Context;
import defpackage.do0;
import defpackage.el0;
import defpackage.fl0;
import defpackage.ho0;
import defpackage.io0;
import defpackage.nf1;
import defpackage.o50;

/* JADX INFO: loaded from: classes.dex */
public abstract class Worker extends io0 {
    public nf1 k;

    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public abstract ho0 doWork();

    public o50 getForegroundInfo() {
        throw new IllegalStateException("Expedited WorkRequests require a Worker to provide an implementation for \n `getForegroundInfo()`");
    }

    @Override // defpackage.io0
    public do0 getForegroundInfoAsync() {
        nf1 nf1Var = new nf1();
        getBackgroundExecutor().execute(new el0(this, nf1Var, 15));
        return nf1Var;
    }

    @Override // defpackage.io0
    public final do0 startWork() {
        this.k = new nf1();
        getBackgroundExecutor().execute(new fl0(this, 21));
        return this.k;
    }
}
