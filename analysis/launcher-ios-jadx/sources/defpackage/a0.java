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
public abstract class a0 implements do0 {
    public static final boolean j = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));
    public static final Logger k = Logger.getLogger(a0.class.getName());
    public static final hs0 l;
    public static final Object m;
    public volatile Object g;
    public volatile w h;
    public volatile z i;

    static {
        hs0 yVar;
        try {
            yVar = new x(AtomicReferenceFieldUpdater.newUpdater(z.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(z.class, z.class, "b"), AtomicReferenceFieldUpdater.newUpdater(a0.class, z.class, "i"), AtomicReferenceFieldUpdater.newUpdater(a0.class, w.class, "h"), AtomicReferenceFieldUpdater.newUpdater(a0.class, Object.class, "g"));
            th = null;
        } catch (Throwable th) {
            th = th;
            yVar = new y();
        }
        l = yVar;
        if (th != null) {
            k.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        m = new Object();
    }

    public static void b(a0 a0Var) {
        z zVar;
        w wVar;
        w wVar2;
        w wVar3;
        do {
            zVar = a0Var.i;
        } while (!l.g(a0Var, zVar, z.c));
        while (true) {
            wVar = null;
            if (zVar == null) {
                break;
            }
            Thread thread = zVar.a;
            if (thread != null) {
                zVar.a = null;
                LockSupport.unpark(thread);
            }
            zVar = zVar.b;
        }
        do {
            wVar2 = a0Var.h;
        } while (!l.e(a0Var, wVar2, w.d));
        while (true) {
            wVar3 = wVar;
            wVar = wVar2;
            if (wVar == null) {
                break;
            }
            wVar2 = wVar.c;
            wVar.c = wVar3;
        }
        while (wVar3 != null) {
            w wVar4 = wVar3.c;
            c(wVar3.a, wVar3.b);
            wVar3 = wVar4;
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
        if (obj instanceof u) {
            CancellationException cancellationException = ((u) obj).a;
            CancellationException cancellationException2 = new CancellationException("Task was cancelled.");
            cancellationException2.initCause(cancellationException);
            throw cancellationException2;
        }
        if (obj instanceof v) {
            throw new ExecutionException(((v) obj).a);
        }
        if (obj == m) {
            return null;
        }
        return obj;
    }

    public static Object e(a0 a0Var) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = a0Var.get();
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
            Object objE = e(this);
            sb.append("SUCCESS, result=[");
            sb.append(objE == this ? "this future" : String.valueOf(objE));
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
        w wVar = this.h;
        w wVar2 = w.d;
        if (wVar != wVar2) {
            w wVar3 = new w(runnable, executor);
            do {
                wVar3.c = wVar;
                if (l.e(this, wVar, wVar3)) {
                    return;
                } else {
                    wVar = this.h;
                }
            } while (wVar != wVar2);
        }
        c(runnable, executor);
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        Object obj = this.g;
        if (obj != null) {
            return false;
        }
        if (!l.f(this, obj, j ? new u(z, new CancellationException("Future.cancel() was called.")) : z ? u.b : u.c)) {
            return false;
        }
        b(this);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String f() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void g(z zVar) {
        zVar.a = null;
        while (true) {
            z zVar2 = this.i;
            if (zVar2 == z.c) {
                return;
            }
            z zVar3 = null;
            while (zVar2 != null) {
                z zVar4 = zVar2.b;
                if (zVar2.a != null) {
                    zVar3 = zVar2;
                } else if (zVar3 != null) {
                    zVar3.b = zVar4;
                    if (zVar3.a == null) {
                        break;
                    }
                } else if (!l.g(this, zVar2, zVar4)) {
                    break;
                }
                zVar2 = zVar4;
            }
            return;
        }
    }

    @Override // java.util.concurrent.Future
    public final Object get(long j2, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j2);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.g;
        if (obj != null) {
            return d(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            z zVar = this.i;
            z zVar2 = z.c;
            if (zVar != zVar2) {
                z zVar3 = new z();
                do {
                    hs0 hs0Var = l;
                    hs0Var.p(zVar3, zVar);
                    if (hs0Var.g(this, zVar, zVar3)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                g(zVar3);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.g;
                            if (obj2 != null) {
                                return d(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        g(zVar3);
                    } else {
                        zVar = this.i;
                    }
                } while (zVar != zVar2);
            }
            return d(this.g);
        }
        while (nanos > 0) {
            Object obj3 = this.g;
            if (obj3 != null) {
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

    public boolean h(Throwable th) {
        th.getClass();
        if (!l.f(this, null, new v(th))) {
            return false;
        }
        b(this);
        return true;
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.g instanceof u;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.g != null;
    }

    public final String toString() {
        String strF;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (this.g instanceof u) {
            sb.append("CANCELLED");
        } else if (isDone()) {
            a(sb);
        } else {
            try {
                strF = f();
            } catch (RuntimeException e) {
                strF = "Exception thrown from implementation: " + e.getClass();
            }
            if (strF != null && !strF.isEmpty()) {
                sb.append("PENDING, info=[");
                sb.append(strF);
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
            if (obj2 != null) {
                return d(obj2);
            }
            z zVar = this.i;
            z zVar2 = z.c;
            if (zVar != zVar2) {
                z zVar3 = new z();
                do {
                    hs0 hs0Var = l;
                    hs0Var.p(zVar3, zVar);
                    if (hs0Var.g(this, zVar, zVar3)) {
                        do {
                            LockSupport.park(this);
                            if (!Thread.interrupted()) {
                                obj = this.g;
                            } else {
                                g(zVar3);
                                throw new InterruptedException();
                            }
                        } while (obj == null);
                        return d(obj);
                    }
                    zVar = this.i;
                } while (zVar != zVar2);
            }
            return d(this.g);
        }
        throw new InterruptedException();
    }
}
