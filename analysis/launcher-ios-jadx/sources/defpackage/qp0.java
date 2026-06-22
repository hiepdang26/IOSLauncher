package defpackage;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public final class qp0 {
    public static final AtomicReferenceFieldUpdater e = AtomicReferenceFieldUpdater.newUpdater(qp0.class, Object.class, "_next");
    public static final AtomicLongFieldUpdater f = AtomicLongFieldUpdater.newUpdater(qp0.class, "_state");
    public static final wg1 g = new wg1("REMOVE_FROZEN", 1);
    private volatile Object _next;
    private volatile long _state;
    public final int a;
    public final boolean b;
    public final int c;
    public final AtomicReferenceArray d;

    public qp0(int i, boolean z) {
        this.a = i;
        this.b = z;
        int i2 = i - 1;
        this.c = i2;
        this.d = new AtomicReferenceArray(i);
        if (i2 > 1073741823) {
            throw new IllegalStateException("Check failed.");
        }
        if ((i & i2) != 0) {
            throw new IllegalStateException("Check failed.");
        }
    }

    public final int a(Runnable runnable) {
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = f;
            long j = atomicLongFieldUpdater.get(this);
            if ((3458764513820540928L & j) != 0) {
                return (2305843009213693952L & j) != 0 ? 2 : 1;
            }
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            int i3 = this.c;
            if (((i2 + 2) & i3) == (i & i3)) {
                return 1;
            }
            AtomicReferenceArray atomicReferenceArray = this.d;
            if (!this.b && atomicReferenceArray.get(i2 & i3) != null) {
                int i4 = this.a;
                if (i4 < 1024 || ((i2 - i) & 1073741823) > (i4 >> 1)) {
                    return 1;
                }
            } else if (atomicLongFieldUpdater.compareAndSet(this, j, ((-1152921503533105153L) & j) | (((long) ((i2 + 1) & 1073741823)) << 30))) {
                atomicReferenceArray.set(i2 & i3, runnable);
                qp0 qp0VarC = this;
                while ((atomicLongFieldUpdater.get(qp0VarC) & 1152921504606846976L) != 0) {
                    qp0VarC = qp0VarC.c();
                    AtomicReferenceArray atomicReferenceArray2 = qp0VarC.d;
                    int i5 = qp0VarC.c & i2;
                    Object obj = atomicReferenceArray2.get(i5);
                    if ((obj instanceof pp0) && ((pp0) obj).a == i2) {
                        atomicReferenceArray2.set(i5, runnable);
                    } else {
                        qp0VarC = null;
                    }
                    if (qp0VarC == null) {
                        return 0;
                    }
                }
                return 0;
            }
        }
    }

    public final boolean b() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j;
        do {
            atomicLongFieldUpdater = f;
            j = atomicLongFieldUpdater.get(this);
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, 2305843009213693952L | j));
        return true;
    }

    public final qp0 c() {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j;
        qp0 qp0Var;
        while (true) {
            atomicLongFieldUpdater = f;
            j = atomicLongFieldUpdater.get(this);
            if ((j & 1152921504606846976L) != 0) {
                qp0Var = this;
                break;
            }
            long j2 = 1152921504606846976L | j;
            qp0Var = this;
            if (atomicLongFieldUpdater.compareAndSet(qp0Var, j, j2)) {
                j = j2;
                break;
            }
        }
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = e;
            qp0 qp0Var2 = (qp0) atomicReferenceFieldUpdater.get(this);
            if (qp0Var2 != null) {
                return qp0Var2;
            }
            qp0 qp0Var3 = new qp0(qp0Var.a * 2, qp0Var.b);
            int i = (int) (1073741823 & j);
            int i2 = (int) ((1152921503533105152L & j) >> 30);
            while (true) {
                int i3 = qp0Var.c;
                int i4 = i & i3;
                if (i4 == (i3 & i2)) {
                    break;
                }
                Object pp0Var = qp0Var.d.get(i4);
                if (pp0Var == null) {
                    pp0Var = new pp0(i);
                }
                qp0Var3.d.set(qp0Var3.c & i, pp0Var);
                i++;
            }
            atomicLongFieldUpdater.set(qp0Var3, (-1152921504606846977L) & j);
            while (!atomicReferenceFieldUpdater.compareAndSet(this, null, qp0Var3) && atomicReferenceFieldUpdater.get(this) == null) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0040, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object d() {
        /*
            r30 = this;
            r1 = r30
        L2:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = defpackage.qp0.f
            long r2 = r0.get(r1)
            r6 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r4 = r2 & r6
            r8 = 0
            int r10 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r10 == 0) goto L15
            wg1 r0 = defpackage.qp0.g
            return r0
        L15:
            r10 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r4 = r2 & r10
            int r5 = (int) r4
            r12 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r12 = r12 & r2
            r4 = 30
            long r12 = r12 >> r4
            int r4 = (int) r12
            int r12 = r1.c
            r4 = r4 & r12
            r12 = r12 & r5
            r13 = 0
            if (r4 != r12) goto L2d
            goto L40
        L2d:
            java.util.concurrent.atomic.AtomicReferenceArray r14 = r1.d
            java.lang.Object r15 = r14.get(r12)
            boolean r4 = r1.b
            if (r15 != 0) goto L3a
            if (r4 == 0) goto L2
            goto L40
        L3a:
            r16 = r6
            boolean r6 = r15 instanceof defpackage.pp0
            if (r6 == 0) goto L41
        L40:
            return r13
        L41:
            int r5 = r5 + 1
            r6 = 1073741823(0x3fffffff, float:1.9999999)
            r5 = r5 & r6
            r6 = -1073741824(0xffffffffc0000000, double:NaN)
            long r18 = r2 & r6
            r20 = r6
            long r6 = (long) r5
            long r18 = r18 | r6
            r28 = r18
            r18 = r4
            r4 = r28
            boolean r0 = r0.compareAndSet(r1, r2, r4)
            if (r0 == 0) goto L61
            r14.set(r12, r13)
            return r15
        L61:
            r1 = r30
            if (r18 == 0) goto L2
        L65:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = defpackage.qp0.f
            long r24 = r0.get(r1)
            long r2 = r24 & r10
            int r3 = (int) r2
            long r4 = r24 & r16
            int r2 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r2 == 0) goto L7a
            qp0 r0 = r1.c()
            r1 = r0
            goto L93
        L7a:
            long r4 = r24 & r20
            long r26 = r4 | r6
            r22 = r0
            r23 = r1
            boolean r0 = r22.compareAndSet(r23, r24, r26)
            r1 = r23
            if (r0 == 0) goto L65
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r1.d
            int r1 = r1.c
            r1 = r1 & r3
            r0.set(r1, r13)
            r1 = r13
        L93:
            if (r1 != 0) goto L65
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qp0.d():java.lang.Object");
    }
}
