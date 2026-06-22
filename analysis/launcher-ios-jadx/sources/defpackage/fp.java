package defpackage;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;

/* JADX INFO: loaded from: classes.dex */
public final class fp implements Executor, Closeable, AutoCloseable {
    public static final AtomicLongFieldUpdater n = AtomicLongFieldUpdater.newUpdater(fp.class, "parkedWorkersStack");
    public static final AtomicLongFieldUpdater o = AtomicLongFieldUpdater.newUpdater(fp.class, "controlState");
    public static final AtomicIntegerFieldUpdater p = AtomicIntegerFieldUpdater.newUpdater(fp.class, "_isTerminated");
    public static final wg1 q = new wg1("NOT_IN_STACK", 1);
    private volatile int _isTerminated;
    private volatile long controlState;
    public final int g;
    public final int h;
    public final long i;
    public final String j;
    public final y90 k;
    public final y90 l;
    public final bb1 m;
    private volatile long parkedWorkersStack;

    public fp(int i, int i2, long j, String str) {
        this.g = i;
        this.h = i2;
        this.i = j;
        this.j = str;
        if (i < 1) {
            throw new IllegalArgumentException(uo.d(i, "Core pool size ", " should be at least 1").toString());
        }
        if (i2 < i) {
            throw new IllegalArgumentException(k31.j(i2, i, "Max pool size ", " should be greater than or equals to core pool size ").toString());
        }
        if (i2 > 2097150) {
            throw new IllegalArgumentException(uo.d(i2, "Max pool size ", " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
        }
        this.k = new y90();
        this.l = new y90();
        this.m = new bb1((i + 1) * 2);
        this.controlState = ((long) i) << 42;
        this._isTerminated = 0;
    }

    public static /* synthetic */ void h(fp fpVar, Runnable runnable, int i) {
        fpVar.b(runnable, um1.g, (i & 4) == 0);
    }

    public final int a() {
        synchronized (this.m) {
            try {
                if (p.get(this) != 0) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = o;
                long j = atomicLongFieldUpdater.get(this);
                int i = (int) (j & 2097151);
                int i2 = i - ((int) ((j & 4398044413952L) >> 21));
                if (i2 < 0) {
                    i2 = 0;
                }
                if (i2 >= this.g) {
                    return 0;
                }
                if (i >= this.h) {
                    return 0;
                }
                int i3 = ((int) (atomicLongFieldUpdater.get(this) & 2097151)) + 1;
                if (i3 <= 0 || this.m.b(i3) != null) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                ep epVar = new ep(this, i3);
                this.m.c(i3, epVar);
                if (i3 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.");
                }
                int i4 = i2 + 1;
                epVar.start();
                return i4;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(Runnable runnable, cx cxVar, boolean z) {
        om1 tm1Var;
        int i;
        um1.f.getClass();
        long jNanoTime = System.nanoTime();
        if (runnable instanceof om1) {
            tm1Var = (om1) runnable;
            tm1Var.g = jNanoTime;
            tm1Var.h = cxVar;
        } else {
            tm1Var = new tm1(runnable, jNanoTime, cxVar);
        }
        boolean z2 = false;
        boolean z3 = tm1Var.h.g == 1;
        AtomicLongFieldUpdater atomicLongFieldUpdater = o;
        long jAddAndGet = z3 ? atomicLongFieldUpdater.addAndGet(this, 2097152L) : 0L;
        Thread threadCurrentThread = Thread.currentThread();
        ep epVar = threadCurrentThread instanceof ep ? (ep) threadCurrentThread : null;
        if (epVar == null || !qg0.d(epVar.n, this)) {
            epVar = null;
        }
        if (epVar != null && (i = epVar.i) != 5 && (tm1Var.h.g != 0 || i != 2)) {
            epVar.m = true;
            jz1 jz1Var = epVar.g;
            if (z) {
                tm1Var = jz1Var.a(tm1Var);
            } else {
                jz1Var.getClass();
                om1 om1Var = (om1) jz1.b.getAndSet(jz1Var, tm1Var);
                tm1Var = om1Var == null ? null : jz1Var.a(om1Var);
            }
        }
        if (tm1Var != null) {
            if (!(tm1Var.h.g == 1 ? this.l.a(tm1Var) : this.k.a(tm1Var))) {
                throw new RejectedExecutionException(uo.k(new StringBuilder(), this.j, " was terminated"));
            }
        }
        if (z && epVar != null) {
            z2 = true;
        }
        if (z3) {
            if (z2 || r() || n(jAddAndGet)) {
                return;
            }
            r();
            return;
        }
        if (z2 || r() || n(atomicLongFieldUpdater.get(this))) {
            return;
        }
        r();
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0088  */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void close() throws java.lang.InterruptedException {
        /*
            r8 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = defpackage.fp.p
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r8, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            java.lang.Thread r0 = java.lang.Thread.currentThread()
            boolean r1 = r0 instanceof defpackage.ep
            r3 = 0
            if (r1 == 0) goto L17
            ep r0 = (defpackage.ep) r0
            goto L18
        L17:
            r0 = r3
        L18:
            if (r0 == 0) goto L23
            fp r1 = r0.n
            boolean r1 = defpackage.qg0.d(r1, r8)
            if (r1 == 0) goto L23
            goto L24
        L23:
            r0 = r3
        L24:
            bb1 r1 = r8.m
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r4 = defpackage.fp.o     // Catch: java.lang.Throwable -> Lc0
            long r4 = r4.get(r8)     // Catch: java.lang.Throwable -> Lc0
            r6 = 2097151(0x1fffff, double:1.0361303E-317)
            long r4 = r4 & r6
            int r5 = (int) r4
            monitor-exit(r1)
            if (r2 > r5) goto L76
            r1 = 1
        L36:
            bb1 r4 = r8.m
            java.lang.Object r4 = r4.b(r1)
            defpackage.qg0.h(r4)
            ep r4 = (defpackage.ep) r4
            if (r4 == r0) goto L71
        L43:
            boolean r6 = r4.isAlive()
            if (r6 == 0) goto L52
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r6 = 10000(0x2710, double:4.9407E-320)
            r4.join(r6)
            goto L43
        L52:
            jz1 r4 = r4.g
            y90 r6 = r8.l
            r4.getClass()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = defpackage.jz1.b
            java.lang.Object r7 = r7.getAndSet(r4, r3)
            om1 r7 = (defpackage.om1) r7
            if (r7 == 0) goto L66
            r6.a(r7)
        L66:
            om1 r7 = r4.b()
            if (r7 != 0) goto L6d
            goto L71
        L6d:
            r6.a(r7)
            goto L66
        L71:
            if (r1 == r5) goto L76
            int r1 = r1 + 1
            goto L36
        L76:
            y90 r1 = r8.l
            r1.b()
            y90 r1 = r8.k
            r1.b()
        L80:
            if (r0 == 0) goto L88
            om1 r1 = r0.a(r2)
            if (r1 != 0) goto Laf
        L88:
            y90 r1 = r8.k
            java.lang.Object r1 = r1.d()
            om1 r1 = (defpackage.om1) r1
            if (r1 != 0) goto Laf
            y90 r1 = r8.l
            java.lang.Object r1 = r1.d()
            om1 r1 = (defpackage.om1) r1
            if (r1 != 0) goto Laf
            if (r0 == 0) goto La2
            r1 = 5
            r0.h(r1)
        La2:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = defpackage.fp.n
            r1 = 0
            r0.set(r8, r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = defpackage.fp.o
            r0.set(r8, r1)
            return
        Laf:
            r1.run()     // Catch: java.lang.Throwable -> Lb3
            goto L80
        Lb3:
            r1 = move-exception
            java.lang.Thread r3 = java.lang.Thread.currentThread()
            java.lang.Thread$UncaughtExceptionHandler r4 = r3.getUncaughtExceptionHandler()
            r4.uncaughtException(r3, r1)
            goto L80
        Lc0:
            r0 = move-exception
            monitor-exit(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.fp.close():void");
    }

    @Override // java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        h(this, runnable, 6);
    }

    public final void k(ep epVar, int i, int i2) {
        while (true) {
            long j = n.get(this);
            int iB = (int) (2097151 & j);
            long j2 = (2097152 + j) & (-2097152);
            if (iB == i) {
                if (i2 == 0) {
                    Object objC = epVar.c();
                    while (true) {
                        if (objC == q) {
                            iB = -1;
                            break;
                        }
                        if (objC == null) {
                            iB = 0;
                            break;
                        }
                        ep epVar2 = (ep) objC;
                        iB = epVar2.b();
                        if (iB != 0) {
                            break;
                        } else {
                            objC = epVar2.c();
                        }
                    }
                } else {
                    iB = i2;
                }
            }
            if (iB >= 0) {
                if (n.compareAndSet(this, j, j2 | ((long) iB))) {
                    return;
                }
            }
        }
    }

    public final boolean n(long j) {
        int i = ((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21));
        if (i < 0) {
            i = 0;
        }
        int i2 = this.g;
        if (i < i2) {
            int iA = a();
            if (iA == 1 && i2 > 1) {
                a();
            }
            if (iA > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean r() {
        wg1 wg1Var;
        int iB;
        while (true) {
            AtomicLongFieldUpdater atomicLongFieldUpdater = n;
            long j = atomicLongFieldUpdater.get(this);
            ep epVar = (ep) this.m.b((int) (2097151 & j));
            if (epVar == null) {
                epVar = null;
            } else {
                long j2 = (2097152 + j) & (-2097152);
                Object objC = epVar.c();
                while (true) {
                    wg1Var = q;
                    if (objC == wg1Var) {
                        iB = -1;
                        break;
                    }
                    if (objC == null) {
                        iB = 0;
                        break;
                    }
                    ep epVar2 = (ep) objC;
                    iB = epVar2.b();
                    if (iB != 0) {
                        break;
                    }
                    objC = epVar2.c();
                }
                if (iB >= 0 && atomicLongFieldUpdater.compareAndSet(this, j, j2 | ((long) iB))) {
                    epVar.g(wg1Var);
                }
            }
            if (epVar == null) {
                return false;
            }
            if (ep.o.compareAndSet(epVar, -1, 0)) {
                LockSupport.unpark(epVar);
                return true;
            }
        }
    }

    public final String toString() {
        ArrayList arrayList = new ArrayList();
        bb1 bb1Var = this.m;
        int iA = bb1Var.a();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < iA; i6++) {
            ep epVar = (ep) bb1Var.b(i6);
            if (epVar != null) {
                jz1 jz1Var = epVar.g;
                jz1Var.getClass();
                int i7 = jz1.b.get(jz1Var) != null ? (jz1.c.get(jz1Var) - jz1.d.get(jz1Var)) + 1 : jz1.c.get(jz1Var) - jz1.d.get(jz1Var);
                int iV = uo.v(epVar.i);
                if (iV == 0) {
                    i++;
                    StringBuilder sb = new StringBuilder();
                    sb.append(i7);
                    sb.append('c');
                    arrayList.add(sb.toString());
                } else if (iV == 1) {
                    i2++;
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i7);
                    sb2.append('b');
                    arrayList.add(sb2.toString());
                } else if (iV == 2) {
                    i3++;
                } else if (iV == 3) {
                    i4++;
                    if (i7 > 0) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(i7);
                        sb3.append('d');
                        arrayList.add(sb3.toString());
                    }
                } else if (iV == 4) {
                    i5++;
                }
            }
        }
        long j = o.get(this);
        StringBuilder sb4 = new StringBuilder();
        sb4.append(this.j);
        sb4.append('@');
        sb4.append(os.e(this));
        sb4.append("[Pool Size {core = ");
        int i8 = this.g;
        sb4.append(i8);
        sb4.append(", max = ");
        sb4.append(this.h);
        sb4.append("}, Worker States {CPU = ");
        sb4.append(i);
        sb4.append(", blocking = ");
        sb4.append(i2);
        sb4.append(", parked = ");
        sb4.append(i3);
        sb4.append(", dormant = ");
        sb4.append(i4);
        sb4.append(", terminated = ");
        sb4.append(i5);
        sb4.append("}, running workers queues = ");
        sb4.append(arrayList);
        sb4.append(", global CPU queue size = ");
        sb4.append(this.k.c());
        sb4.append(", global blocking queue size = ");
        sb4.append(this.l.c());
        sb4.append(", Control State {created workers= ");
        sb4.append((int) (2097151 & j));
        sb4.append(", blocking tasks = ");
        sb4.append((int) ((4398044413952L & j) >> 21));
        sb4.append(", CPUs acquired = ");
        sb4.append(i8 - ((int) ((j & 9223367638808264704L) >> 42)));
        sb4.append("}]");
        return sb4.toString();
    }
}
