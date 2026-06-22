package defpackage;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes.dex */
public abstract class p implements do0 {
    public static final boolean j = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger k = Logger.getLogger(p.class.getName());
    public static final hg0 l;
    public static final Object m;
    public volatile Object g;
    public volatile k h;
    public volatile o i;

    static {
        hg0 nVar;
        try {
            nVar = new l(AtomicReferenceFieldUpdater.newUpdater(o.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(o.class, o.class, "b"), AtomicReferenceFieldUpdater.newUpdater(p.class, o.class, "i"), AtomicReferenceFieldUpdater.newUpdater(p.class, k.class, "h"), AtomicReferenceFieldUpdater.newUpdater(p.class, Object.class, "g"));
            th = null;
        } catch (Throwable th) {
            th = th;
            nVar = new n();
        }
        l = nVar;
        if (th != null) {
            k.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        m = new Object();
    }

    public static void b(p pVar) {
        k kVar;
        k kVar2;
        k kVar3 = null;
        while (true) {
            o oVar = pVar.i;
            if (l.e(pVar, oVar, o.c)) {
                while (oVar != null) {
                    Thread thread = oVar.a;
                    if (thread != null) {
                        oVar.a = null;
                        LockSupport.unpark(thread);
                    }
                    oVar = oVar.b;
                }
                do {
                    kVar = pVar.h;
                } while (!l.c(pVar, kVar, k.d));
                while (true) {
                    kVar2 = kVar3;
                    kVar3 = kVar;
                    if (kVar3 == null) {
                        break;
                    }
                    kVar = kVar3.c;
                    kVar3.c = kVar2;
                }
                while (kVar2 != null) {
                    kVar3 = kVar2.c;
                    Runnable runnable = kVar2.a;
                    if (runnable instanceof m) {
                        m mVar = (m) runnable;
                        pVar = mVar.g;
                        if (pVar.g == mVar) {
                            if (l.d(pVar, mVar, e(mVar.h))) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else {
                        c(runnable, kVar2.b);
                    }
                    kVar2 = kVar3;
                }
                return;
            }
        }
    }

    public static void c(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e) {
            k.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e);
        }
    }

    public static Object d(Object obj) throws ExecutionException {
        if (obj instanceof h) {
            CancellationException cancellationException = ((h) obj).b;
            CancellationException cancellationException2 = new CancellationException("Task was cancelled.");
            cancellationException2.initCause(cancellationException);
            throw cancellationException2;
        }
        if (obj instanceof j) {
            throw new ExecutionException(((j) obj).a);
        }
        if (obj == m) {
            return null;
        }
        return obj;
    }

    public static Object e(do0 do0Var) {
        if (do0Var instanceof p) {
            Object obj = ((p) do0Var).g;
            if (!(obj instanceof h)) {
                return obj;
            }
            h hVar = (h) obj;
            return hVar.a ? hVar.b != null ? new h(false, hVar.b) : h.d : obj;
        }
        boolean zIsCancelled = do0Var.isCancelled();
        if ((!j) && zIsCancelled) {
            return h.d;
        }
        try {
            Object objF = f(do0Var);
            return objF == null ? m : objF;
        } catch (CancellationException e) {
            if (zIsCancelled) {
                return new h(false, e);
            }
            return new j(new IllegalArgumentException("get() threw CancellationException, despite reporting isCancelled() == false: " + do0Var, e));
        } catch (ExecutionException e2) {
            return new j(e2.getCause());
        } catch (Throwable th) {
            return new j(th);
        }
    }

    public static Object f(do0 do0Var) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = do0Var.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    public final void a(StringBuilder sb) {
        try {
            Object objF = f(this);
            sb.append("SUCCESS, result=[");
            sb.append(objF == this ? "this future" : String.valueOf(objF));
            sb.append("]");
        } catch (CancellationException unused) {
            sb.append("CANCELLED");
        } catch (RuntimeException e) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e.getClass());
            sb.append(" thrown from get()]");
        } catch (ExecutionException e2) {
            sb.append("FAILURE, cause=[");
            sb.append(e2.getCause());
            sb.append("]");
        }
    }

    @Override // defpackage.do0
    public final void addListener(Runnable runnable, Executor executor) {
        runnable.getClass();
        executor.getClass();
        k kVar = this.h;
        k kVar2 = k.d;
        if (kVar != kVar2) {
            k kVar3 = new k(runnable, executor);
            do {
                kVar3.c = kVar;
                if (l.c(this, kVar, kVar3)) {
                    return;
                } else {
                    kVar = this.h;
                }
            } while (kVar != kVar2);
        }
        c(runnable, executor);
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0053, code lost:
    
        return true;
     */
    @Override // java.util.concurrent.Future
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean cancel(boolean r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.g
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L8
            r3 = 1
            goto L9
        L8:
            r3 = 0
        L9:
            boolean r4 = r0 instanceof defpackage.m
            r3 = r3 | r4
            if (r3 == 0) goto L5b
            boolean r3 = defpackage.p.j
            if (r3 == 0) goto L1f
            h r3 = new h
            java.util.concurrent.CancellationException r4 = new java.util.concurrent.CancellationException
            java.lang.String r5 = "Future.cancel() was called."
            r4.<init>(r5)
            r3.<init>(r8, r4)
            goto L26
        L1f:
            if (r8 == 0) goto L24
            h r3 = defpackage.h.c
            goto L26
        L24:
            h r3 = defpackage.h.d
        L26:
            r5 = 0
            r4 = r7
        L28:
            hg0 r6 = defpackage.p.l
            boolean r6 = r6.d(r4, r0, r3)
            if (r6 == 0) goto L54
            b(r4)
            boolean r4 = r0 instanceof defpackage.m
            if (r4 == 0) goto L53
            m r0 = (defpackage.m) r0
            do0 r0 = r0.h
            boolean r4 = r0 instanceof defpackage.p
            if (r4 == 0) goto L50
            r4 = r0
            p r4 = (defpackage.p) r4
            java.lang.Object r0 = r4.g
            if (r0 != 0) goto L48
            r5 = 1
            goto L49
        L48:
            r5 = 0
        L49:
            boolean r6 = r0 instanceof defpackage.m
            r5 = r5 | r6
            if (r5 == 0) goto L53
            r5 = 1
            goto L28
        L50:
            r0.cancel(r8)
        L53:
            return r1
        L54:
            java.lang.Object r0 = r4.g
            boolean r6 = r0 instanceof defpackage.m
            if (r6 != 0) goto L28
            return r5
        L5b:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p.cancel(boolean):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String g() {
        Object obj = this.g;
        if (obj instanceof m) {
            StringBuilder sb = new StringBuilder("setFuture=[");
            do0 do0Var = ((m) obj).h;
            return uo.k(sb, do0Var == this ? "this future" : String.valueOf(do0Var), "]");
        }
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.g;
        if ((obj != null) && (!(obj instanceof m))) {
            return d(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            o oVar = this.i;
            o oVar2 = o.c;
            if (oVar != oVar2) {
                o oVar3 = new o();
                do {
                    hg0 hg0Var = l;
                    hg0Var.y(oVar3, oVar);
                    if (hg0Var.e(this, oVar, oVar3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                h(oVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.g;
                            if ((obj2 != null) && (!(obj2 instanceof m))) {
                                return d(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        h(oVar3);
                    } else {
                        oVar = this.i;
                    }
                } while (oVar != oVar2);
            }
            return d(this.g);
        }
        while (nanos > 0) {
            Object obj3 = this.g;
            if ((obj3 != null) && (!(obj3 instanceof m))) {
                return d(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String strH = "Waited " + j2 + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String strH2 = uo.h(strH, " (plus ");
            long j3 = -nanos;
            long jConvert = timeUnit.convert(j3, TimeUnit.NANOSECONDS);
            long nanos2 = j3 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String strH3 = strH2 + jConvert + " " + lowerCase;
                if (z) {
                    strH3 = uo.h(strH3, ",");
                }
                strH2 = uo.h(strH3, " ");
            }
            if (z) {
                strH2 = strH2 + nanos2 + " nanoseconds ";
            }
            strH = uo.h(strH2, "delay)");
        }
        if (isDone()) {
            throw new TimeoutException(uo.h(strH, " but future completed as timeout expired"));
        }
        throw new TimeoutException(uo.i(strH, " for ", string));
    }

    public final void h(o oVar) {
        oVar.a = null;
        while (true) {
            o oVar2 = this.i;
            if (oVar2 == o.c) {
                return;
            }
            o oVar3 = null;
            while (oVar2 != null) {
                o oVar4 = oVar2.b;
                if (oVar2.a != null) {
                    oVar3 = oVar2;
                } else if (oVar3 != null) {
                    oVar3.b = oVar4;
                    if (oVar3.a == null) {
                        break;
                    }
                } else if (!l.e(this, oVar2, oVar4)) {
                    break;
                }
                oVar2 = oVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.g instanceof h;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return (!(r0 instanceof m)) & (this.g != null);
    }

    public final String toString() {
        String strG;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.g instanceof h) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                strG = g();
            } catch (RuntimeException e) {
                strG = "Exception thrown from implementation: " + e.getClass();
            }
            if (strG != null && !strG.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strG);
                sb.append("]");
            } else if (isDone()) {
                a(sb);
            } else {
                sb.append("PENDING");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException {
        Object obj;
        if (!Thread.interrupted()) {
            Object obj2 = this.g;
            if ((obj2 != null) & (!(obj2 instanceof m))) {
                return d(obj2);
            }
            o oVar = this.i;
            o oVar2 = o.c;
            if (oVar != oVar2) {
                o oVar3 = new o();
                do {
                    hg0 hg0Var = l;
                    hg0Var.y(oVar3, oVar);
                    if (hg0Var.e(this, oVar, oVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.g;
                            } else {
                                h(oVar3);
                                throw new InterruptedException();
                            }
                        } while (!((obj != null) & (!(obj instanceof m))));
                        return d(obj);
                    }
                    oVar = this.i;
                } while (oVar != oVar2);
            }
            return d(this.g);
        }
        throw new InterruptedException();
    }
}
