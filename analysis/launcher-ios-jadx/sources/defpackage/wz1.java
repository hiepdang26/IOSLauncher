package defpackage;

import com.luutinhit.launcher6.Workspace;
import com.luutinhit.launcher6.t;

/* JADX INFO: loaded from: classes.dex */
public final class wz1 implements Runnable {
    public final /* synthetic */ u11 g;
    public final /* synthetic */ long h;
    public final /* synthetic */ long i;
    public final /* synthetic */ qh0 j;
    public final /* synthetic */ Workspace k;

    public wz1(Workspace workspace, u11 u11Var, long j, long j2, qh0 qh0Var) {
        this.k = workspace;
        this.g = u11Var;
        this.h = j;
        this.i = j2;
        this.j = qh0Var;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Workspace workspace = this.k;
        workspace.C0 = true;
        t tVar = workspace.S0;
        int[] iArr = workspace.G0;
        qh0 qh0Var = this.j;
        tVar.addPendingItem(this.g, this.h, this.i, iArr, qh0Var.m, qh0Var.n);
    }
}
