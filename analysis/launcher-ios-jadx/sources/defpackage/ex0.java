package defpackage;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class ex0 extends lm {
    public final int b;

    static {
        qg0.k(ka0.r("NetworkNotRoamingCtrlr"), "tagWithPrefix(\"NetworkNotRoamingCtrlr\")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ex0(fn fnVar) {
        super(fnVar);
        qg0.l(fnVar, "tracker");
        this.b = 7;
    }

    @Override // defpackage.lm
    public final int a() {
        return this.b;
    }

    @Override // defpackage.lm
    public final boolean b(lz1 lz1Var) {
        return lz1Var.j.a == 4;
    }

    @Override // defpackage.lm
    public final boolean c(Object obj) {
        fx0 fx0Var = (fx0) obj;
        qg0.l(fx0Var, "value");
        int i = Build.VERSION.SDK_INT;
        boolean z = fx0Var.a;
        if (i >= 24) {
            return (z && fx0Var.d) ? false : true;
        }
        ka0.j().getClass();
        return !z;
    }
}
