package defpackage;

import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* JADX INFO: loaded from: classes.dex */
public class je implements ph {
    public static final AtomicLongFieldUpdater h = AtomicLongFieldUpdater.newUpdater(je.class, "sendersAndCloseStatus");
    public static final AtomicLongFieldUpdater i = AtomicLongFieldUpdater.newUpdater(je.class, "receivers");
    public static final AtomicLongFieldUpdater j = AtomicLongFieldUpdater.newUpdater(je.class, "bufferEnd");
    public static final AtomicLongFieldUpdater k = AtomicLongFieldUpdater.newUpdater(je.class, "completedExpandBuffersAndPauseFlag");
    public static final AtomicReferenceFieldUpdater l = AtomicReferenceFieldUpdater.newUpdater(je.class, Object.class, "sendSegment");
    public static final AtomicReferenceFieldUpdater m = AtomicReferenceFieldUpdater.newUpdater(je.class, Object.class, "receiveSegment");
    public static final AtomicReferenceFieldUpdater n = AtomicReferenceFieldUpdater.newUpdater(je.class, Object.class, "bufferEndSegment");
    public static final AtomicReferenceFieldUpdater o = AtomicReferenceFieldUpdater.newUpdater(je.class, Object.class, "_closeCause");
    public static final AtomicReferenceFieldUpdater p = AtomicReferenceFieldUpdater.newUpdater(je.class, Object.class, "closeHandler");
    private volatile Object _closeCause;
    private volatile long bufferEnd;
    private volatile Object bufferEndSegment;
    private volatile Object closeHandler;
    private volatile long completedExpandBuffersAndPauseFlag;
    public final int g;
    private volatile Object receiveSegment;
    private volatile long receivers;
    private volatile Object sendSegment;
    private volatile long sendersAndCloseStatus;

    public je(int i2) {
        this.g = i2;
        if (i2 < 0) {
            throw new IllegalArgumentException(uo.d(i2, "Invalid channel capacity: ", ", should be >=0").toString());
        }
        vh vhVar = le.a;
        this.bufferEnd = i2 != 0 ? i2 != Integer.MAX_VALUE ? i2 : Long.MAX_VALUE : 0L;
        this.completedExpandBuffersAndPauseFlag = j.get(this);
        vh vhVar2 = new vh(0L, null, this, 3);
        this.sendSegment = vhVar2;
        this.receiveSegment = vhVar2;
        if (v()) {
            vhVar2 = le.a;
            qg0.i(vhVar2, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment = vhVar2;
        this._closeCause = le.s;
    }

    public static boolean C(Object obj) {
        if (obj instanceof fg) {
            qg0.i(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return le.a((fg) obj, zp1.a, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    public static final vh a(je jeVar, long j2, vh vhVar) {
        Object objL;
        je jeVar2;
        jeVar.getClass();
        vh vhVar2 = le.a;
        ke keVar = ke.o;
        loop0: while (true) {
            objL = hs0.l(j2, vhVar);
            if (!n90.v(objL)) {
                af1 af1VarO = n90.o(objL);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = l;
                    af1 af1Var = (af1) atomicReferenceFieldUpdater.get(jeVar);
                    if (af1Var.i >= af1VarO.i) {
                        break loop0;
                    }
                    if (!af1VarO.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(jeVar, af1Var, af1VarO)) {
                        if (atomicReferenceFieldUpdater.get(jeVar) != af1Var) {
                            if (af1VarO.e()) {
                                af1VarO.d();
                            }
                        }
                    }
                    if (af1Var.e()) {
                        af1Var.d();
                    }
                }
            } else {
                break;
            }
        }
        boolean zV = n90.v(objL);
        AtomicLongFieldUpdater atomicLongFieldUpdater = i;
        if (zV) {
            jeVar.t();
            if (vhVar.i * ((long) le.b) < atomicLongFieldUpdater.get(jeVar)) {
                vhVar.a();
                return null;
            }
        } else {
            vh vhVar3 = (vh) n90.o(objL);
            long j3 = vhVar3.i;
            if (j3 <= j2) {
                return vhVar3;
            }
            long j4 = ((long) le.b) * j3;
            while (true) {
                AtomicLongFieldUpdater atomicLongFieldUpdater2 = h;
                long j5 = atomicLongFieldUpdater2.get(jeVar);
                long j6 = 1152921504606846975L & j5;
                if (j6 >= j4) {
                    jeVar2 = jeVar;
                    break;
                }
                jeVar2 = jeVar;
                if (atomicLongFieldUpdater2.compareAndSet(jeVar2, j5, j6 + (((long) ((int) (j5 >> 60))) << 60))) {
                    break;
                }
                jeVar = jeVar2;
            }
            if (j3 * ((long) le.b) < atomicLongFieldUpdater.get(jeVar2)) {
                vhVar3.a();
            }
        }
        return null;
    }

    public static final void c(je jeVar, ff0 ff0Var, gg ggVar) {
        jeVar.getClass();
        ggVar.resumeWith(np1.e(jeVar.p()));
    }

    public static final int h(je jeVar, vh vhVar, int i2, Object obj, long j2, Object obj2, boolean z) {
        jeVar.getClass();
        vhVar.m(i2, obj);
        if (z) {
            return jeVar.E(vhVar, i2, obj, j2, obj2, z);
        }
        Object objK = vhVar.k(i2);
        if (objK == null) {
            if (jeVar.i(j2)) {
                if (vhVar.j(i2, null, le.d)) {
                    return 1;
                }
            } else {
                if (obj2 == null) {
                    return 3;
                }
                if (vhVar.j(i2, null, obj2)) {
                    return 2;
                }
            }
        } else if (objK instanceof hv1) {
            vhVar.m(i2, null);
            if (jeVar.B(objK, obj)) {
                vhVar.n(i2, le.i);
                return 0;
            }
            wg1 wg1Var = le.k;
            if (vhVar.l.getAndSet((i2 * 2) + 1, wg1Var) == wg1Var) {
                return 5;
            }
            vhVar.l(i2, true);
            return 5;
        }
        return jeVar.E(vhVar, i2, obj, j2, obj2, z);
    }

    public static void r(je jeVar) {
        jeVar.getClass();
        AtomicLongFieldUpdater atomicLongFieldUpdater = k;
        if ((atomicLongFieldUpdater.addAndGet(jeVar, 1L) & 4611686018427387904L) != 0) {
            while ((atomicLongFieldUpdater.get(jeVar) & 4611686018427387904L) != 0) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.Object y(defpackage.je r13, defpackage.go r14) {
        /*
            boolean r0 = r14 instanceof defpackage.he
            if (r0 == 0) goto L14
            r0 = r14
            he r0 = (defpackage.he) r0
            int r1 = r0.i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.i = r1
        L12:
            r6 = r0
            goto L1a
        L14:
            he r0 = new he
            r0.<init>(r13, r14)
            goto L12
        L1a:
            java.lang.Object r14 = r6.g
            hp r0 = defpackage.hp.g
            int r1 = r6.i
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2d
            defpackage.np1.I(r14)
            uh r14 = (defpackage.uh) r14
            java.lang.Object r13 = r14.a
            return r13
        L2d:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L35:
            defpackage.np1.I(r14)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r14 = defpackage.je.m
            java.lang.Object r14 = r14.get(r13)
            vh r14 = (defpackage.vh) r14
        L40:
            r13.getClass()
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = defpackage.je.h
            long r3 = r1.get(r13)
            boolean r1 = r13.s(r3, r2)
            if (r1 == 0) goto L59
            java.lang.Throwable r13 = r13.o()
            sh r14 = new sh
            r14.<init>(r13)
            return r14
        L59:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = defpackage.je.i
            long r4 = r1.getAndIncrement(r13)
            int r1 = defpackage.le.b
            long r7 = (long) r1
            long r9 = r4 / r7
            long r7 = r4 % r7
            int r3 = (int) r7
            long r7 = r14.i
            int r1 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r1 == 0) goto L76
            vh r1 = r13.n(r9, r14)
            if (r1 != 0) goto L74
            goto L40
        L74:
            r8 = r1
            goto L77
        L76:
            r8 = r14
        L77:
            r12 = 0
            r7 = r13
            r9 = r3
            r10 = r4
            java.lang.Object r13 = r7.D(r8, r9, r10, r12)
            r1 = r7
            wg1 r14 = defpackage.le.m
            if (r13 == r14) goto La9
            wg1 r14 = defpackage.le.o
            if (r13 != r14) goto L96
            long r13 = r1.q()
            int r3 = (r4 > r13 ? 1 : (r4 == r13 ? 0 : -1))
            if (r3 >= 0) goto L93
            r8.a()
        L93:
            r13 = r1
            r14 = r8
            goto L40
        L96:
            wg1 r14 = defpackage.le.n
            if (r13 != r14) goto La5
            r6.i = r2
            r2 = r8
            java.lang.Object r13 = r1.z(r2, r3, r4, r6)
            if (r13 != r0) goto La4
            return r0
        La4:
            return r13
        La5:
            r8.a()
            return r13
        La9:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "unexpected"
            r13.<init>(r14)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.je.y(je, go):java.lang.Object");
    }

    public final void A(hv1 hv1Var, boolean z) {
        Throwable thP;
        if (hv1Var instanceof fg) {
            eo eoVar = (eo) hv1Var;
            if (z) {
                thP = o();
                if (thP == null) {
                    thP = new pj("Channel was closed");
                }
            } else {
                thP = p();
            }
            eoVar.resumeWith(np1.e(thP));
            return;
        }
        if (hv1Var instanceof i81) {
            ((i81) hv1Var).g.resumeWith(new uh(new sh(o())));
            return;
        }
        if (!(hv1Var instanceof ge)) {
            throw new IllegalStateException(("Unexpected waiter: " + hv1Var).toString());
        }
        ge geVar = (ge) hv1Var;
        gg ggVar = geVar.h;
        qg0.h(ggVar);
        geVar.h = null;
        geVar.g = le.l;
        Throwable thO = geVar.i.o();
        if (thO == null) {
            ggVar.resumeWith(Boolean.FALSE);
        } else {
            ggVar.resumeWith(np1.e(thO));
        }
    }

    public final boolean B(Object obj, Object obj2) {
        if (obj instanceof i81) {
            qg0.i(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            return le.a(((i81) obj).g, new uh(obj2), null);
        }
        if (!(obj instanceof ge)) {
            if (obj instanceof fg) {
                qg0.i(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
                return le.a((fg) obj, obj2, null);
            }
            throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
        }
        qg0.i(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
        ge geVar = (ge) obj;
        gg ggVar = geVar.h;
        qg0.h(ggVar);
        geVar.h = null;
        geVar.g = obj2;
        Boolean bool = Boolean.TRUE;
        geVar.i.getClass();
        return le.a(ggVar, bool, null);
    }

    public final Object D(vh vhVar, int i2, long j2, Object obj) {
        Object objK = vhVar.k(i2);
        AtomicReferenceArray atomicReferenceArray = vhVar.l;
        AtomicLongFieldUpdater atomicLongFieldUpdater = h;
        if (objK == null) {
            if (j2 >= (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                if (obj == null) {
                    return le.n;
                }
                if (vhVar.j(i2, objK, obj)) {
                    m();
                    return le.m;
                }
            }
        } else if (objK == le.d && vhVar.j(i2, objK, le.i)) {
            m();
            Object obj2 = atomicReferenceArray.get(i2 * 2);
            vhVar.m(i2, null);
            return obj2;
        }
        while (true) {
            Object objK2 = vhVar.k(i2);
            if (objK2 == null || objK2 == le.e) {
                if (j2 < (atomicLongFieldUpdater.get(this) & 1152921504606846975L)) {
                    if (vhVar.j(i2, objK2, le.h)) {
                        m();
                        return le.o;
                    }
                } else {
                    if (obj == null) {
                        return le.n;
                    }
                    if (vhVar.j(i2, objK2, obj)) {
                        m();
                        return le.m;
                    }
                }
            } else if (objK2 != le.d) {
                wg1 wg1Var = le.j;
                if (objK2 == wg1Var) {
                    return le.o;
                }
                if (objK2 == le.h) {
                    return le.o;
                }
                if (objK2 == le.l) {
                    m();
                    return le.o;
                }
                if (objK2 != le.g && vhVar.j(i2, objK2, le.f)) {
                    boolean z = objK2 instanceof iv1;
                    if (z) {
                        objK2 = ((iv1) objK2).a;
                    }
                    if (C(objK2)) {
                        vhVar.n(i2, le.i);
                        m();
                        Object obj3 = atomicReferenceArray.get(i2 * 2);
                        vhVar.m(i2, null);
                        return obj3;
                    }
                    vhVar.n(i2, wg1Var);
                    vhVar.h();
                    if (z) {
                        m();
                    }
                    return le.o;
                }
            } else if (vhVar.j(i2, objK2, le.i)) {
                m();
                Object obj4 = atomicReferenceArray.get(i2 * 2);
                vhVar.m(i2, null);
                return obj4;
            }
        }
    }

    public final int E(vh vhVar, int i2, Object obj, long j2, Object obj2, boolean z) {
        while (true) {
            Object objK = vhVar.k(i2);
            if (objK == null) {
                if (!i(j2) || z) {
                    if (z) {
                        if (vhVar.j(i2, null, le.j)) {
                            vhVar.h();
                            return 4;
                        }
                    } else {
                        if (obj2 == null) {
                            return 3;
                        }
                        if (vhVar.j(i2, null, obj2)) {
                            return 2;
                        }
                    }
                } else if (vhVar.j(i2, null, le.d)) {
                    break;
                }
            } else {
                if (objK != le.e) {
                    wg1 wg1Var = le.k;
                    if (objK == wg1Var) {
                        vhVar.m(i2, null);
                        return 5;
                    }
                    if (objK == le.h) {
                        vhVar.m(i2, null);
                        return 5;
                    }
                    if (objK == le.l) {
                        vhVar.m(i2, null);
                        t();
                        return 4;
                    }
                    vhVar.m(i2, null);
                    if (objK instanceof iv1) {
                        objK = ((iv1) objK).a;
                    }
                    if (B(objK, obj)) {
                        vhVar.n(i2, le.i);
                        return 0;
                    }
                    if (vhVar.l.getAndSet((i2 * 2) + 1, wg1Var) != wg1Var) {
                        vhVar.l(i2, true);
                    }
                    return 5;
                }
                if (vhVar.j(i2, objK, le.d)) {
                    break;
                }
            }
        }
        return 1;
    }

    public final void F(long j2) {
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        je jeVar = this;
        if (jeVar.v()) {
            return;
        }
        while (true) {
            atomicLongFieldUpdater = j;
            if (atomicLongFieldUpdater.get(jeVar) > j2) {
                break;
            } else {
                jeVar = this;
            }
        }
        int i2 = le.c;
        int i3 = 0;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater2 = k;
            if (i3 < i2) {
                long j3 = atomicLongFieldUpdater.get(jeVar);
                if (j3 == (4611686018427387903L & atomicLongFieldUpdater2.get(jeVar)) && j3 == atomicLongFieldUpdater.get(jeVar)) {
                    return;
                } else {
                    i3++;
                }
            } else {
                while (true) {
                    long j4 = atomicLongFieldUpdater2.get(jeVar);
                    if (atomicLongFieldUpdater2.compareAndSet(jeVar, j4, (j4 & 4611686018427387903L) + 4611686018427387904L)) {
                        break;
                    } else {
                        jeVar = this;
                    }
                }
                while (true) {
                    long j5 = atomicLongFieldUpdater.get(jeVar);
                    long j6 = atomicLongFieldUpdater2.get(jeVar);
                    long j7 = j6 & 4611686018427387903L;
                    boolean z = (j6 & 4611686018427387904L) != 0;
                    if (j5 == j7 && j5 == atomicLongFieldUpdater.get(jeVar)) {
                        break;
                    }
                    if (!z) {
                        atomicLongFieldUpdater2.compareAndSet(this, j6, 4611686018427387904L + j7);
                    }
                    jeVar = this;
                }
                while (true) {
                    long j8 = atomicLongFieldUpdater2.get(jeVar);
                    if (atomicLongFieldUpdater2.compareAndSet(jeVar, j8, j8 & 4611686018427387903L)) {
                        return;
                    } else {
                        jeVar = this;
                    }
                }
            }
        }
    }

    @Override // defpackage.j81
    public final void b(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new CancellationException("Channel was cancelled");
        }
        j(true, cancellationException);
    }

    /* JADX WARN: Code restructure failed: missing block: B:105:0x017b, code lost:
    
        return r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00c5, code lost:
    
        c(r1, r4, r7);
     */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0164  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0167 A[RETURN] */
    @Override // defpackage.df1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object d(defpackage.ff0 r25, defpackage.jk r26) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 385
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.je.d(ff0, jk):java.lang.Object");
    }

    @Override // defpackage.j81
    public final Object e() {
        vh vhVar;
        AtomicLongFieldUpdater atomicLongFieldUpdater = i;
        long j2 = atomicLongFieldUpdater.get(this);
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = h;
        long j3 = atomicLongFieldUpdater2.get(this);
        if (s(j3, true)) {
            return new sh(o());
        }
        long j4 = j3 & 1152921504606846975L;
        th thVar = uh.b;
        if (j2 >= j4) {
            return thVar;
        }
        Object obj = le.k;
        vh vhVar2 = (vh) m.get(this);
        while (!s(atomicLongFieldUpdater2.get(this), true)) {
            long andIncrement = atomicLongFieldUpdater.getAndIncrement(this);
            long j5 = le.b;
            long j6 = andIncrement / j5;
            int i2 = (int) (andIncrement % j5);
            if (vhVar2.i != j6) {
                vh vhVarN = n(j6, vhVar2);
                if (vhVarN == null) {
                    continue;
                } else {
                    vhVar = vhVarN;
                }
            } else {
                vhVar = vhVar2;
            }
            Object objD = D(vhVar, i2, andIncrement, obj);
            vh vhVar3 = vhVar;
            if (objD == le.m) {
                hv1 hv1Var = obj instanceof hv1 ? (hv1) obj : null;
                if (hv1Var != null) {
                    hv1Var.a(vhVar3, i2);
                }
                F(andIncrement);
                vhVar3.h();
                return thVar;
            }
            if (objD != le.o) {
                if (objD == le.n) {
                    throw new IllegalStateException("unexpected");
                }
                vhVar3.a();
                return objD;
            }
            if (andIncrement < q()) {
                vhVar3.a();
            }
            vhVar2 = vhVar3;
        }
        return new sh(o());
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00be A[SYNTHETIC] */
    @Override // defpackage.df1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object f(java.lang.Object r16) {
        /*
            r15 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = defpackage.je.h
            long r1 = r8.get(r15)
            r9 = 0
            boolean r3 = r15.s(r1, r9)
            r10 = 1
            r11 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            if (r3 == 0) goto L15
            r1 = 0
            goto L1b
        L15:
            long r1 = r1 & r11
            boolean r1 = r15.i(r1)
            r1 = r1 ^ r10
        L1b:
            th r13 = defpackage.uh.b
            if (r1 == 0) goto L20
            return r13
        L20:
            wg1 r6 = defpackage.le.j
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = defpackage.je.l
            java.lang.Object r1 = r1.get(r15)
            vh r1 = (defpackage.vh) r1
        L2a:
            long r2 = r8.getAndIncrement(r15)
            long r4 = r2 & r11
            boolean r7 = r15.s(r2, r9)
            int r14 = defpackage.le.b
            long r2 = (long) r14
            long r11 = r4 / r2
            long r2 = r4 % r2
            int r2 = (int) r2
            long r9 = r1.i
            int r3 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r3 == 0) goto L5d
            vh r3 = a(r15, r11, r1)
            if (r3 != 0) goto L5c
            if (r7 == 0) goto L54
            java.lang.Throwable r1 = r15.p()
            sh r2 = new sh
            r2.<init>(r1)
            return r2
        L54:
            r9 = 0
            r10 = 1
        L56:
            r11 = 1152921504606846975(0xfffffffffffffff, double:1.2882297539194265E-231)
            goto L2a
        L5c:
            r1 = r3
        L5d:
            r0 = r15
            r3 = r16
            int r9 = h(r0, r1, r2, r3, r4, r6, r7)
            zp1 r3 = defpackage.zp1.a
            if (r9 == 0) goto Lbe
            r10 = 1
            if (r9 == r10) goto Lbd
            r3 = 2
            if (r9 == r3) goto L9c
            r2 = 3
            if (r9 == r2) goto L94
            r2 = 4
            if (r9 == r2) goto L7d
            r2 = 5
            if (r9 == r2) goto L78
            goto L7b
        L78:
            r1.a()
        L7b:
            r9 = 0
            goto L56
        L7d:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = defpackage.je.i
            long r2 = r2.get(r15)
            int r6 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r6 >= 0) goto L8a
            r1.a()
        L8a:
            java.lang.Throwable r1 = r15.p()
            sh r2 = new sh
            r2.<init>(r1)
            return r2
        L94:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "unexpected"
            r1.<init>(r2)
            throw r1
        L9c:
            if (r7 == 0) goto Lab
            r1.h()
            java.lang.Throwable r1 = r15.p()
            sh r2 = new sh
            r2.<init>(r1)
            return r2
        Lab:
            boolean r3 = r6 instanceof defpackage.hv1
            if (r3 == 0) goto Lb2
            hv1 r6 = (defpackage.hv1) r6
            goto Lb3
        Lb2:
            r6 = 0
        Lb3:
            if (r6 == 0) goto Lb9
            int r2 = r2 + r14
            r6.a(r1, r2)
        Lb9:
            r1.h()
            return r13
        Lbd:
            return r3
        Lbe:
            r1.a()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.je.f(java.lang.Object):java.lang.Object");
    }

    @Override // defpackage.j81
    public final Object g(lk lkVar) {
        return y(this, lkVar);
    }

    public final boolean i(long j2) {
        return j2 < j.get(this) || j2 < i.get(this) + ((long) this.g);
    }

    public final boolean j(boolean z, Throwable th) {
        je jeVar;
        boolean z2;
        long j2;
        long j3;
        long j4;
        Object obj;
        long j5;
        long j6;
        AtomicLongFieldUpdater atomicLongFieldUpdater = h;
        if (!z) {
            jeVar = this;
            break;
        }
        do {
            j6 = atomicLongFieldUpdater.get(this);
            if (((int) (j6 >> 60)) != 0) {
                jeVar = this;
                break;
            }
            vh vhVar = le.a;
            jeVar = this;
        } while (!atomicLongFieldUpdater.compareAndSet(jeVar, j6, (j6 & 1152921504606846975L) + (((long) 1) << 60)));
        wg1 wg1Var = le.s;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = o;
            if (atomicReferenceFieldUpdater.compareAndSet(this, wg1Var, th)) {
                z2 = true;
                break;
            }
            if (atomicReferenceFieldUpdater.get(this) != wg1Var) {
                z2 = false;
                break;
            }
        }
        if (z) {
            do {
                j5 = atomicLongFieldUpdater.get(this);
            } while (!atomicLongFieldUpdater.compareAndSet(jeVar, j5, (((long) 3) << 60) + (j5 & 1152921504606846975L)));
        } else {
            do {
                j2 = atomicLongFieldUpdater.get(this);
                int i2 = (int) (j2 >> 60);
                if (i2 == 0) {
                    j3 = j2 & 1152921504606846975L;
                    j4 = 2;
                } else {
                    if (i2 != 1) {
                        break;
                    }
                    j3 = j2 & 1152921504606846975L;
                    j4 = 3;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(jeVar, j2, (j4 << 60) + j3));
        }
        t();
        if (z2) {
            loop3: while (true) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = p;
                obj = atomicReferenceFieldUpdater2.get(this);
                wg1 wg1Var2 = obj == null ? le.q : le.r;
                while (!atomicReferenceFieldUpdater2.compareAndSet(this, obj, wg1Var2)) {
                    if (atomicReferenceFieldUpdater2.get(this) != obj) {
                        break;
                    }
                }
            }
            if (obj != null) {
                np1.c(1, obj);
                ((o70) obj).invoke(o());
                return z2;
            }
        }
        return z2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0090, code lost:
    
        r1 = (defpackage.vh) ((defpackage.ol) defpackage.ol.h.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final defpackage.vh k(long r14) {
        /*
            Method dump skipped, instruction units count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.je.k(long):vh");
    }

    public final void l(long j2) {
        vh vhVar = (vh) m.get(this);
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = i;
            long j3 = atomicLongFieldUpdater.get(this);
            if (j2 < Math.max(((long) this.g) + j3, j.get(this))) {
                return;
            }
            if (atomicLongFieldUpdater.compareAndSet(this, j3, 1 + j3)) {
                long j4 = le.b;
                long j5 = j3 / j4;
                int i2 = (int) (j3 % j4);
                if (vhVar.i != j5) {
                    vh vhVarN = n(j5, vhVar);
                    if (vhVarN != null) {
                        vhVar = vhVarN;
                    }
                }
                vh vhVar2 = vhVar;
                if (D(vhVar2, i2, j3, null) != le.o || j3 < q()) {
                    vhVar2.a();
                }
                vhVar = vhVar2;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x018f, code lost:
    
        r(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0192, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m() {
        /*
            Method dump skipped, instruction units count: 403
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.je.m():void");
    }

    public final vh n(long j2, vh vhVar) {
        Object objL;
        AtomicLongFieldUpdater atomicLongFieldUpdater;
        long j3;
        vh vhVar2 = le.a;
        ke keVar = ke.o;
        loop0: while (true) {
            objL = hs0.l(j2, vhVar);
            if (!n90.v(objL)) {
                af1 af1VarO = n90.o(objL);
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = m;
                    af1 af1Var = (af1) atomicReferenceFieldUpdater.get(this);
                    if (af1Var.i >= af1VarO.i) {
                        break loop0;
                    }
                    if (!af1VarO.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater.compareAndSet(this, af1Var, af1VarO)) {
                        if (atomicReferenceFieldUpdater.get(this) != af1Var) {
                            if (af1VarO.e()) {
                                af1VarO.d();
                            }
                        }
                    }
                    if (af1Var.e()) {
                        af1Var.d();
                    }
                }
            } else {
                break;
            }
        }
        if (n90.v(objL)) {
            t();
            if (vhVar.i * ((long) le.b) < q()) {
                vhVar.a();
                return null;
            }
        } else {
            vh vhVar3 = (vh) n90.o(objL);
            boolean zV = v();
            long j4 = vhVar3.i;
            if (!zV && j2 <= j.get(this) / ((long) le.b)) {
                while (true) {
                    AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = n;
                    af1 af1Var2 = (af1) atomicReferenceFieldUpdater2.get(this);
                    if (af1Var2.i >= j4 || !vhVar3.i()) {
                        break;
                    }
                    while (!atomicReferenceFieldUpdater2.compareAndSet(this, af1Var2, vhVar3)) {
                        if (atomicReferenceFieldUpdater2.get(this) != af1Var2) {
                            if (vhVar3.e()) {
                                vhVar3.d();
                            }
                        }
                    }
                    if (af1Var2.e()) {
                        af1Var2.d();
                    }
                }
            }
            if (j4 <= j2) {
                return vhVar3;
            }
            long j5 = j4 * ((long) le.b);
            do {
                atomicLongFieldUpdater = i;
                j3 = atomicLongFieldUpdater.get(this);
                if (j3 >= j5) {
                    break;
                }
            } while (!atomicLongFieldUpdater.compareAndSet(this, j3, j5));
            if (j4 * ((long) le.b) < q()) {
                vhVar3.a();
            }
        }
        return null;
    }

    public final Throwable o() {
        return (Throwable) o.get(this);
    }

    public final Throwable p() {
        Throwable thO = o();
        return thO == null ? new qj("Channel was closed") : thO;
    }

    public final long q() {
        return h.get(this) & 1152921504606846975L;
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x00a4, code lost:
    
        r1 = (defpackage.vh) ((defpackage.ol) defpackage.ol.h.get(r1));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean s(long r15, boolean r17) {
        /*
            Method dump skipped, instruction units count: 370
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.je.s(long, boolean):boolean");
    }

    public final boolean t() {
        return s(h.get(this), false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:80:0x01ac, code lost:
    
        r3 = (defpackage.vh) r3.b();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String toString() {
        /*
            Method dump skipped, instruction units count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.je.toString():java.lang.String");
    }

    public boolean u() {
        return false;
    }

    public final boolean v() {
        long j2 = j.get(this);
        return j2 == 0 || j2 == Long.MAX_VALUE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0011, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void w(long r6, defpackage.vh r8) {
        /*
            r5 = this;
        L0:
            long r0 = r8.i
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 >= 0) goto L11
            ol r0 = r8.b()
            vh r0 = (defpackage.vh) r0
            if (r0 != 0) goto Lf
            goto L11
        Lf:
            r8 = r0
            goto L0
        L11:
            boolean r6 = r8.c()
            if (r6 == 0) goto L22
            ol r6 = r8.b()
            vh r6 = (defpackage.vh) r6
            if (r6 != 0) goto L20
            goto L22
        L20:
            r8 = r6
            goto L11
        L22:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r6 = defpackage.je.n
            java.lang.Object r7 = r6.get(r5)
            af1 r7 = (defpackage.af1) r7
            long r0 = r7.i
            long r2 = r8.i
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 < 0) goto L33
            goto L49
        L33:
            boolean r0 = r8.i()
            if (r0 != 0) goto L3a
            goto L11
        L3a:
            boolean r0 = r6.compareAndSet(r5, r7, r8)
            if (r0 == 0) goto L4a
            boolean r6 = r7.e()
            if (r6 == 0) goto L49
            r7.d()
        L49:
            return
        L4a:
            java.lang.Object r0 = r6.get(r5)
            if (r0 == r7) goto L3a
            boolean r6 = r8.e()
            if (r6 == 0) goto L22
            r8.d()
            goto L22
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.je.w(long, vh):void");
    }

    public final Object x(ff0 ff0Var, jk jkVar) {
        gg ggVar = new gg(1, e42.d(jkVar));
        ggVar.o();
        ggVar.resumeWith(np1.e(p()));
        Object objN = ggVar.n();
        return objN == hp.g ? objN : zp1.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0015  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object z(defpackage.vh r16, int r17, long r18, defpackage.go r20) {
        /*
            Method dump skipped, instruction units count: 265
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.je.z(vh, int, long, go):java.lang.Object");
    }
}
