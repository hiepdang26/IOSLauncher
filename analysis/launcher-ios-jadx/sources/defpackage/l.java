package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class l extends hg0 {
    public final AtomicReferenceFieldUpdater l;
    public final AtomicReferenceFieldUpdater m;
    public final AtomicReferenceFieldUpdater n;
    public final AtomicReferenceFieldUpdater o;
    public final AtomicReferenceFieldUpdater p;

    public l(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.l = atomicReferenceFieldUpdater;
        this.m = atomicReferenceFieldUpdater2;
        this.n = atomicReferenceFieldUpdater3;
        this.o = atomicReferenceFieldUpdater4;
        this.p = atomicReferenceFieldUpdater5;
    }

    @Override // defpackage.hg0
    public final boolean c(p pVar, k kVar, k kVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.o;
            if (atomicReferenceFieldUpdater.compareAndSet(pVar, kVar, kVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(pVar) == kVar);
        return false;
    }

    @Override // defpackage.hg0
    public final boolean d(p pVar, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.p;
            if (atomicReferenceFieldUpdater.compareAndSet(pVar, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(pVar) == obj);
        return false;
    }

    @Override // defpackage.hg0
    public final boolean e(p pVar, o oVar, o oVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.n;
            if (atomicReferenceFieldUpdater.compareAndSet(pVar, oVar, oVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(pVar) == oVar);
        return false;
    }

    @Override // defpackage.hg0
    public final void y(o oVar, o oVar2) {
        this.m.lazySet(oVar, oVar2);
    }

    @Override // defpackage.hg0
    public final void z(o oVar, Thread thread) {
        this.l.lazySet(oVar, thread);
    }
}
