package defpackage;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public abstract class u00 extends v00 implements ju {
    public static final AtomicReferenceFieldUpdater l = AtomicReferenceFieldUpdater.newUpdater(u00.class, Object.class, "_queue");
    public static final AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(u00.class, Object.class, "_delayed");
    public static final AtomicIntegerFieldUpdater n = AtomicIntegerFieldUpdater.newUpdater(u00.class, "_isCompleted");
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    /* JADX WARN: Code restructure failed: missing block: B:29:0x004a, code lost:
    
        defpackage.ys.o.H(r6);
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004f, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void H(java.lang.Runnable r6) {
        /*
            r5 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = defpackage.u00.l
            java.lang.Object r1 = r0.get(r5)
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r2 = defpackage.u00.n
            int r2 = r2.get(r5)
            if (r2 == 0) goto Lf
            goto L4a
        Lf:
            if (r1 != 0) goto L20
        L11:
            r1 = 0
            boolean r1 = r0.compareAndSet(r5, r1, r6)
            if (r1 == 0) goto L19
            goto L66
        L19:
            java.lang.Object r1 = r0.get(r5)
            if (r1 == 0) goto L11
            goto L0
        L20:
            boolean r2 = r1 instanceof defpackage.qp0
            r3 = 1
            if (r2 == 0) goto L46
            r2 = r1
            qp0 r2 = (defpackage.qp0) r2
            int r4 = r2.a(r6)
            if (r4 == 0) goto L66
            if (r4 == r3) goto L34
            r0 = 2
            if (r4 == r0) goto L4a
            goto L0
        L34:
            qp0 r2 = r2.c()
        L38:
            boolean r3 = r0.compareAndSet(r5, r1, r2)
            if (r3 == 0) goto L3f
            goto L0
        L3f:
            java.lang.Object r3 = r0.get(r5)
            if (r3 == r1) goto L38
            goto L0
        L46:
            wg1 r2 = defpackage.e42.c
            if (r1 != r2) goto L50
        L4a:
            ys r0 = defpackage.ys.o
            r0.H(r6)
            return
        L50:
            qp0 r2 = new qp0
            r4 = 8
            r2.<init>(r4, r3)
            r3 = r1
            java.lang.Runnable r3 = (java.lang.Runnable) r3
            r2.a(r3)
            r2.a(r6)
        L60:
            boolean r3 = r0.compareAndSet(r5, r1, r2)
            if (r3 == 0) goto L74
        L66:
            java.lang.Thread r6 = r5.E()
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            if (r0 == r6) goto L73
            java.util.concurrent.locks.LockSupport.unpark(r6)
        L73:
            return
        L74:
            java.lang.Object r3 = r0.get(r5)
            if (r3 == r1) goto L60
            goto L0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.u00.H(java.lang.Runnable):void");
    }

    public final long I() {
        x8 x8Var = this.k;
        if (((x8Var == null || x8Var.isEmpty()) ? Long.MAX_VALUE : 0L) != 0) {
            Object obj = l.get(this);
            if (obj == null) {
            } else if (obj instanceof qp0) {
                long j = qp0.f.get((qp0) obj);
                if (((int) (1073741823 & j)) != ((int) ((j & 1152921503533105152L) >> 30))) {
                    return 0L;
                }
            } else if (obj == e42.c) {
            }
            return Long.MAX_VALUE;
        }
        return 0L;
    }

    public final boolean J() {
        x8 x8Var = this.k;
        if (x8Var != null ? x8Var.isEmpty() : true) {
            Object obj = l.get(this);
            if (obj != null) {
                if (obj instanceof qp0) {
                    long j = qp0.f.get((qp0) obj);
                    return ((int) (1073741823 & j)) == ((int) ((j & 1152921503533105152L) >> 30));
                }
                if (obj == e42.c) {
                }
            }
            return true;
        }
        return false;
    }

    public final long K() {
        Runnable runnable;
        if (G()) {
            return 0L;
        }
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l;
            Object obj = atomicReferenceFieldUpdater.get(this);
            runnable = null;
            if (obj == null) {
                break;
            }
            if (!(obj instanceof qp0)) {
                if (obj != e42.c) {
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, null)) {
                        if (atomicReferenceFieldUpdater.get(this) != obj) {
                            break;
                        }
                    }
                    runnable = (Runnable) obj;
                    break loop0;
                }
                break;
            }
            qp0 qp0Var = (qp0) obj;
            Object objD = qp0Var.d();
            if (objD != qp0.g) {
                runnable = (Runnable) objD;
                break;
            }
            qp0 qp0VarC = qp0Var.c();
            while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, qp0VarC) && atomicReferenceFieldUpdater.get(this) == obj) {
            }
        }
        if (runnable == null) {
            return I();
        }
        runnable.run();
        return 0L;
    }

    @Override // defpackage.v00
    public void shutdown() {
        on1.a.set(null);
        n.set(this, 1);
        loop0: while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l;
            Object obj = atomicReferenceFieldUpdater.get(this);
            wg1 wg1Var = e42.c;
            if (obj != null) {
                if (!(obj instanceof qp0)) {
                    if (obj != wg1Var) {
                        qp0 qp0Var = new qp0(8, true);
                        qp0Var.a((Runnable) obj);
                        while (!atomicReferenceFieldUpdater.compareAndSet(this, obj, qp0Var)) {
                            if (atomicReferenceFieldUpdater.get(this) != obj) {
                                break;
                            }
                        }
                        break loop0;
                    }
                    break;
                }
                ((qp0) obj).b();
                break;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, wg1Var)) {
                if (atomicReferenceFieldUpdater.get(this) != null) {
                    break;
                }
            }
            break loop0;
        }
        while (K() <= 0) {
        }
        System.nanoTime();
    }

    @Override // defpackage.cp
    public final void z(yo yoVar, Runnable runnable) {
        H(runnable);
    }
}
