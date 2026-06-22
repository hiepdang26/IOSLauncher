package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class y extends hs0 {
    @Override // defpackage.hs0
    public final boolean e(a0 a0Var, w wVar, w wVar2) {
        synchronized (a0Var) {
            try {
                if (a0Var.h != wVar) {
                    return false;
                }
                a0Var.h = wVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.hs0
    public final boolean f(a0 a0Var, Object obj, Object obj2) {
        synchronized (a0Var) {
            try {
                if (a0Var.g != obj) {
                    return false;
                }
                a0Var.g = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.hs0
    public final boolean g(a0 a0Var, z zVar, z zVar2) {
        synchronized (a0Var) {
            try {
                if (a0Var.i != zVar) {
                    return false;
                }
                a0Var.i = zVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.hs0
    public final void p(z zVar, z zVar2) {
        zVar.b = zVar2;
    }

    @Override // defpackage.hs0
    public final void q(z zVar, Thread thread) {
        zVar.a = thread;
    }
}
