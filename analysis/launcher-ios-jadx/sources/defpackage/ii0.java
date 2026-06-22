package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class ii0 extends xi0 {
    public final boolean i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ii0() {
        super(true);
        boolean z = true;
        C(null);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = xi0.h;
        bi biVar = (bi) atomicReferenceFieldUpdater.get(this);
        ci ciVar = biVar instanceof ci ? (ci) biVar : null;
        if (ciVar == null) {
            z = false;
            break;
        }
        xi0 xi0VarL = ciVar.l();
        while (!xi0VarL.x()) {
            bi biVar2 = (bi) atomicReferenceFieldUpdater.get(xi0VarL);
            ci ciVar2 = biVar2 instanceof ci ? (ci) biVar2 : null;
            if (ciVar2 == null) {
                z = false;
                break;
            }
            xi0VarL = ciVar2.l();
        }
        this.i = z;
    }

    @Override // defpackage.xi0
    public final boolean x() {
        return this.i;
    }
}
