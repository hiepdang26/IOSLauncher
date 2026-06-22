package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class ap1 extends zo1 {
    public final /* synthetic */ e9 g;
    public final /* synthetic */ bp1 h;

    public ap1(bp1 bp1Var, e9 e9Var) {
        this.h = bp1Var;
        this.g = e9Var;
    }

    @Override // defpackage.vo1
    public final void d(xo1 xo1Var) {
        ((ArrayList) this.g.get(this.h.h)).remove(xo1Var);
        xo1Var.u(this);
    }
}
