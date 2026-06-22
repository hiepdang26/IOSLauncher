package defpackage;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public final class xb extends lm {
    public final /* synthetic */ int b;
    public final int c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xb(fn fnVar, int i) {
        super(fnVar);
        this.b = i;
        switch (i) {
            case 2:
                qg0.l(fnVar, "tracker");
                super(fnVar);
                this.c = 7;
                break;
            case 3:
                qg0.l(fnVar, "tracker");
                super(fnVar);
                this.c = 7;
                break;
            case 4:
                qg0.l(fnVar, "tracker");
                super(fnVar);
                this.c = 9;
                break;
            default:
                qg0.l(fnVar, "tracker");
                this.c = 6;
                break;
        }
    }

    @Override // defpackage.lm
    public final int a() {
        switch (this.b) {
        }
        return this.c;
    }

    @Override // defpackage.lm
    public final boolean b(lz1 lz1Var) {
        switch (this.b) {
            case 0:
                return lz1Var.j.b;
            case 1:
                return lz1Var.j.d;
            case 2:
                return lz1Var.j.a == 2;
            case 3:
                int i = lz1Var.j.a;
                return i == 3 || (Build.VERSION.SDK_INT >= 30 && i == 6);
            default:
                return lz1Var.j.e;
        }
    }

    @Override // defpackage.lm
    public final boolean c(Object obj) {
        switch (this.b) {
            case 2:
                fx0 fx0Var = (fx0) obj;
                qg0.l(fx0Var, "value");
                int i = Build.VERSION.SDK_INT;
                boolean z = fx0Var.a;
                if (i < 26 ? z : z && fx0Var.b) {
                }
                break;
            case 3:
                fx0 fx0Var2 = (fx0) obj;
                qg0.l(fx0Var2, "value");
                if (!fx0Var2.a || fx0Var2.c) {
                }
                break;
        }
        return !((Boolean) obj).booleanValue();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public xb(yb ybVar) {
        super(ybVar);
        this.b = 1;
        qg0.l(ybVar, "tracker");
        this.c = 5;
    }
}
