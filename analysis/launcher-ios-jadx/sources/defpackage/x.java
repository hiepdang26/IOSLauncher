package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class x extends hs0 {
    public final AtomicReferenceFieldUpdater h;
    public final AtomicReferenceFieldUpdater i;
    public final AtomicReferenceFieldUpdater j;
    public final AtomicReferenceFieldUpdater k;
    public final AtomicReferenceFieldUpdater l;

    public x(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
        this.h = atomicReferenceFieldUpdater;
        this.i = atomicReferenceFieldUpdater2;
        this.j = atomicReferenceFieldUpdater3;
        this.k = atomicReferenceFieldUpdater4;
        this.l = atomicReferenceFieldUpdater5;
    }

    @Override // defpackage.hs0
    public final boolean e(a0 a0Var, w wVar, w wVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.k;
            if (atomicReferenceFieldUpdater.compareAndSet(a0Var, wVar, wVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(a0Var) == wVar);
        return false;
    }

    @Override // defpackage.hs0
    public final boolean f(a0 a0Var, Object obj, Object obj2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.l;
            if (atomicReferenceFieldUpdater.compareAndSet(a0Var, obj, obj2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(a0Var) == obj);
        return false;
    }

    @Override // defpackage.hs0
    public final boolean g(a0 a0Var, z zVar, z zVar2) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        do {
            atomicReferenceFieldUpdater = this.j;
            if (atomicReferenceFieldUpdater.compareAndSet(a0Var, zVar, zVar2)) {
                return true;
            }
        } while (atomicReferenceFieldUpdater.get(a0Var) == zVar);
        return false;
    }

    @Override // defpackage.hs0
    public final void p(z zVar, z zVar2) {
        this.i.lazySet(zVar, zVar2);
    }

    @Override // defpackage.hs0
    public final void q(z zVar, Thread thread) {
        this.h.lazySet(zVar, thread);
    }
}
