package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class n extends hg0 {
    @Override // defpackage.hg0
    public final boolean c(p pVar, k kVar, k kVar2) {
        synchronized (pVar) {
            try {
                if (pVar.h != kVar) {
                    return false;
                }
                pVar.h = kVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.hg0
    public final boolean d(p pVar, Object obj, Object obj2) {
        synchronized (pVar) {
            try {
                if (pVar.g != obj) {
                    return false;
                }
                pVar.g = obj2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.hg0
    public final boolean e(p pVar, o oVar, o oVar2) {
        synchronized (pVar) {
            try {
                if (pVar.i != oVar) {
                    return false;
                }
                pVar.i = oVar2;
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.hg0
    public final void y(o oVar, o oVar2) {
        oVar.b = oVar2;
    }

    @Override // defpackage.hg0
    public final void z(o oVar, Thread thread) {
        oVar.a = thread;
    }
}
