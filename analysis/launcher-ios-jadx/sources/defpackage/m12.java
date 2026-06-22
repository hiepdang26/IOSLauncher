package defpackage;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes.dex */
public final class m12 extends y02 {
    public final qm1 b;

    public m12(qm1 qm1Var) {
        super(4);
        this.b = qm1Var;
    }

    @Override // defpackage.y02
    public final boolean a(v02 v02Var) {
        if (v02Var.l.get(null) == null) {
            return false;
        }
        throw new ClassCastException();
    }

    @Override // defpackage.y02
    public final v20[] b(v02 v02Var) {
        if (v02Var.l.get(null) == null) {
            return null;
        }
        throw new ClassCastException();
    }

    @Override // defpackage.y02
    public final void c(Status status) {
        this.b.b(new v5(status));
    }

    @Override // defpackage.y02
    public final void d(RuntimeException runtimeException) {
        this.b.b(runtimeException);
    }

    @Override // defpackage.y02
    public final void e(v02 v02Var) throws DeadObjectException {
        try {
            h(v02Var);
        } catch (DeadObjectException e) {
            c(y02.g(e));
            throw e;
        } catch (RemoteException e2) {
            c(y02.g(e2));
        } catch (RuntimeException e3) {
            this.b.b(e3);
        }
    }

    public final void h(v02 v02Var) {
        if (v02Var.l.remove(null) != null) {
            throw new ClassCastException();
        }
        qm1 qm1Var = this.b;
        Boolean bool = Boolean.FALSE;
        od2 od2Var = qm1Var.a;
        synchronized (od2Var.a) {
            try {
                if (od2Var.c) {
                    return;
                }
                od2Var.c = true;
                od2Var.e = bool;
                od2Var.b.g(od2Var);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.y02
    public final /* bridge */ /* synthetic */ void f(oz1 oz1Var, boolean z) {
    }
}
