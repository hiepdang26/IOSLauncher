package defpackage;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public final class l12 extends y02 {
    public final ld b;
    public final qm1 c;
    public final iy d;

    public l12(int i, ld ldVar, qm1 qm1Var, iy iyVar) {
        super(i);
        this.c = qm1Var;
        this.b = ldVar;
        this.d = iyVar;
        if (i == 2 && ldVar.a) {
            throw new IllegalArgumentException("Best-effort write calls cannot pass methods that should auto-resolve missing features.");
        }
    }

    @Override // defpackage.y02
    public final boolean a(v02 v02Var) {
        return this.b.a;
    }

    @Override // defpackage.y02
    public final v20[] b(v02 v02Var) {
        return (v20[]) this.b.c;
    }

    @Override // defpackage.y02
    public final void c(Status status) {
        this.d.getClass();
        this.c.b(status.i != null ? new cb1(status) : new v5(status));
    }

    @Override // defpackage.y02
    public final void d(RuntimeException runtimeException) {
        this.c.b(runtimeException);
    }

    @Override // defpackage.y02
    public final void e(v02 v02Var) throws DeadObjectException {
        qm1 qm1Var = this.c;
        try {
            ld ldVar = this.b;
            ((z91) ((ld) ldVar.d).c).e(v02Var.h, qm1Var);
        } catch (DeadObjectException e) {
            throw e;
        } catch (RemoteException e2) {
            c(y02.g(e2));
        } catch (RuntimeException e3) {
            qm1Var.b(e3);
        }
    }

    @Override // defpackage.y02
    public final void f(oz1 oz1Var, boolean z) {
        Boolean boolValueOf = Boolean.valueOf(z);
        Map map = (Map) oz1Var.i;
        qm1 qm1Var = this.c;
        map.put(qm1Var, boolValueOf);
        q11 q11Var = new q11(oz1Var, qm1Var, 28, false);
        od2 od2Var = qm1Var.a;
        od2Var.getClass();
        od2Var.b.f(new b82(sm1.a, q11Var));
        od2Var.k();
    }
}
