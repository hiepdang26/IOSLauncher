package defpackage;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class dx0 extends lm {
    public final int b;

    static {
        qg0.k(ka0.r("NetworkMeteredCtrlr"), "tagWithPrefix(\"NetworkMeteredCtrlr\")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dx0(fn fnVar) {
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
        return lz1Var.j.a == 5;
    }

    @Override // defpackage.lm
    public final boolean c(Object obj) {
        fx0 fx0Var = (fx0) obj;
        qg0.l(fx0Var, "value");
        int i = Build.VERSION.SDK_INT;
        boolean z = fx0Var.a;
        if (i >= 26) {
            return (z && fx0Var.c) ? false : true;
        }
        ka0.j().getClass();
        return !z;
    }
}
