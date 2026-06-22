package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class ri0 extends jj0 implements o70 {
    public final /* synthetic */ int g;
    public final /* synthetic */ Object h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ri0(Object obj, int i) {
        super(1);
        this.g = i;
        this.h = obj;
    }

    @Override // defpackage.o70
    public final Object invoke(Object obj) {
        switch (this.g) {
            case 0:
                Throwable th = (Throwable) obj;
                si0 si0Var = (si0) this.h;
                if (th == null) {
                    if (!si0Var.g.isDone()) {
                        throw new IllegalArgumentException("Failed requirement.");
                    }
                } else if (th instanceof CancellationException) {
                    si0Var.g.cancel(true);
                } else {
                    nf1 nf1Var = si0Var.g;
                    Throwable cause = th.getCause();
                    if (cause != null) {
                        th = cause;
                    }
                    nf1Var.j(th);
                }
                return zp1.a;
            default:
                zp1 zp1Var = zp1.a;
                ((gg) this.h).resumeWith(zp1Var);
                return zp1Var;
        }
    }
}
