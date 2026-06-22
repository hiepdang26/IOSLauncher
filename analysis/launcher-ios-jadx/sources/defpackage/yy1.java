package defpackage;

import androidx.work.impl.WorkDatabase;

/* JADX INFO: loaded from: classes.dex */
public final class yy1 {
    public final qm0 a;
    public final s31 b;
    public final mz1 c;

    static {
        ka0.r("WMFgUpdater");
    }

    public yy1(WorkDatabase workDatabase, s31 s31Var, qm0 qm0Var) {
        this.b = s31Var;
        this.a = qm0Var;
        this.c = workDatabase.u();
    }
}
