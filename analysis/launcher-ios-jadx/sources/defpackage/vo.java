package defpackage;

import java.util.concurrent.CancellationException;

/* JADX INFO: loaded from: classes.dex */
public final class vo extends jj0 implements o70 {
    public final /* synthetic */ vf g;
    public final /* synthetic */ hu h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public vo(vf vfVar, hu huVar) {
        super(1);
        this.g = vfVar;
        this.h = huVar;
    }

    @Override // defpackage.o70
    public final Object invoke(Object obj) throws Throwable {
        cf0 cf0Var;
        Throwable th = (Throwable) obj;
        vf vfVar = this.g;
        if (th == null) {
            Object objZ = this.h.z();
            if (objZ instanceof cf0) {
                throw new IllegalStateException("This job has not completed yet");
            }
            if (objZ instanceof uk) {
                throw ((uk) objZ).a;
            }
            df0 df0Var = objZ instanceof df0 ? (df0) objZ : null;
            if (df0Var != null && (cf0Var = df0Var.a) != null) {
                objZ = cf0Var;
            }
            vfVar.d = true;
            xf xfVar = vfVar.b;
            if (xfVar != null) {
                wf wfVar = xfVar.h;
                wfVar.getClass();
                if (objZ == null) {
                    objZ = a0.m;
                }
                if (a0.l.f(wfVar, null, objZ)) {
                    a0.b(wfVar);
                    vfVar.a = null;
                    vfVar.b = null;
                    vfVar.c = null;
                }
            }
        } else if (th instanceof CancellationException) {
            vfVar.d = true;
            xf xfVar2 = vfVar.b;
            if (xfVar2 != null && xfVar2.h.cancel(true)) {
                vfVar.a = null;
                vfVar.b = null;
                vfVar.c = null;
            }
        } else {
            vfVar.d = true;
            xf xfVar3 = vfVar.b;
            if (xfVar3 != null && xfVar3.h.h(th)) {
                vfVar.a = null;
                vfVar.b = null;
                vfVar.c = null;
            }
        }
        return zp1.a;
    }
}
