package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class wi0 extends q9 {
    public final ti0 b;
    public px0 c;
    public final /* synthetic */ xi0 d;
    public final /* synthetic */ cf0 e;

    public wi0(ti0 ti0Var, xi0 xi0Var, cf0 cf0Var) {
        this.d = xi0Var;
        this.e = cf0Var;
        this.b = ti0Var;
    }

    @Override // defpackage.q9
    public final void b(Object obj, Object obj2) {
        np0 np0Var = (np0) obj;
        boolean z = obj2 == null;
        ti0 ti0Var = this.b;
        Object obj3 = z ? ti0Var : this.c;
        if (obj3 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = np0.g;
            while (!atomicReferenceFieldUpdater.compareAndSet(np0Var, this, obj3)) {
                if (atomicReferenceFieldUpdater.get(np0Var) != this) {
                    return;
                }
            }
            if (z) {
                px0 px0Var = this.c;
                qg0.h(px0Var);
                ti0Var.h(px0Var);
            }
        }
    }

    @Override // defpackage.q9
    public final wg1 c(Object obj) {
        if (this.d.z() == this.e) {
            return null;
        }
        return hs0.b;
    }
}
