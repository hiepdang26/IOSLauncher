package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public class np0 {
    public static final AtomicReferenceFieldUpdater g = AtomicReferenceFieldUpdater.newUpdater(np0.class, Object.class, "_next");
    public static final AtomicReferenceFieldUpdater h = AtomicReferenceFieldUpdater.newUpdater(np0.class, Object.class, "_prev");
    public static final AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(np0.class, Object.class, "_removedRef");
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    /* JADX WARN: Code restructure failed: missing block: B:25:0x003e, code lost:
    
        r6 = ((defpackage.ca1) r6).a;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0046, code lost:
    
        if (r5.compareAndSet(r4, r3, r6) == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x004e, code lost:
    
        if (r5.get(r4) == r3) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.np0 g() {
        /*
            r9 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = defpackage.np0.h
            java.lang.Object r1 = r0.get(r9)
            np0 r1 = (defpackage.np0) r1
            r2 = 0
            r3 = r1
        La:
            r4 = r2
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = defpackage.np0.g
            java.lang.Object r6 = r5.get(r3)
            if (r6 != r9) goto L24
            if (r1 != r3) goto L16
            goto L2d
        L16:
            boolean r2 = r0.compareAndSet(r9, r1, r3)
            if (r2 == 0) goto L1d
            goto L2d
        L1d:
            java.lang.Object r2 = r0.get(r9)
            if (r2 == r1) goto L16
            goto L0
        L24:
            boolean r7 = r9.k()
            if (r7 == 0) goto L2b
            return r2
        L2b:
            if (r6 != 0) goto L2e
        L2d:
            return r3
        L2e:
            boolean r7 = r6 instanceof defpackage.nz0
            if (r7 == 0) goto L38
            nz0 r6 = (defpackage.nz0) r6
            r6.a(r3)
            goto L0
        L38:
            boolean r7 = r6 instanceof defpackage.ca1
            if (r7 == 0) goto L58
            if (r4 == 0) goto L51
            ca1 r6 = (defpackage.ca1) r6
            np0 r6 = r6.a
        L42:
            boolean r7 = r5.compareAndSet(r4, r3, r6)
            if (r7 == 0) goto L4a
            r3 = r4
            goto La
        L4a:
            java.lang.Object r7 = r5.get(r4)
            if (r7 == r3) goto L42
            goto L0
        L51:
            java.lang.Object r3 = r0.get(r3)
            np0 r3 = (defpackage.np0) r3
            goto Lb
        L58:
            java.lang.String r4 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            defpackage.qg0.i(r6, r4)
            r4 = r6
            np0 r4 = (defpackage.np0) r4
            r8 = r4
            r4 = r3
            r3 = r8
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.np0.g():np0");
    }

    public final void h(np0 np0Var) {
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = h;
            np0 np0Var2 = (np0) atomicReferenceFieldUpdater.get(np0Var);
            if (i() != np0Var) {
                return;
            }
            while (!atomicReferenceFieldUpdater.compareAndSet(np0Var, np0Var2, this)) {
                if (atomicReferenceFieldUpdater.get(np0Var) != np0Var2) {
                    break;
                }
            }
            if (k()) {
                np0Var.g();
                return;
            }
            return;
        }
    }

    public final Object i() {
        while (true) {
            Object obj = g.get(this);
            if (!(obj instanceof nz0)) {
                return obj;
            }
            ((nz0) obj).a(this);
        }
    }

    public final np0 j() {
        np0 np0Var;
        Object objI = i();
        ca1 ca1Var = objI instanceof ca1 ? (ca1) objI : null;
        if (ca1Var != null && (np0Var = ca1Var.a) != null) {
            return np0Var;
        }
        qg0.i(objI, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
        return (np0) objI;
    }

    public boolean k() {
        return i() instanceof ca1;
    }

    public String toString() {
        return new mp0(this) + '@' + os.e(this);
    }
}
