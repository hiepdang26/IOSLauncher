package defpackage;

import androidx.appcompat.widget.ActivityChooserView;
import java.io.Closeable;
import java.io.IOException;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class bd0 implements Closeable, AutoCloseable {
    public static final ThreadPoolExecutor C;
    public final ad0 A;
    public final LinkedHashSet B;
    public final boolean g;
    public final yc0 h;
    public final String j;
    public int k;
    public int l;
    public boolean m;
    public final ScheduledThreadPoolExecutor n;
    public final ThreadPoolExecutor o;
    public final ka0 p;
    public long v;
    public final t3 w;
    public final t3 x;
    public final Socket y;
    public final jd0 z;
    public final LinkedHashMap i = new LinkedHashMap();
    public long q = 0;
    public long r = 0;
    public long s = 0;
    public long t = 0;
    public long u = 0;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        byte[] bArr = wq1.a;
        C = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60L, timeUnit, synchronousQueue, new tq1("OkHttp Http2Connection", true));
    }

    public bd0(wc0 wc0Var) {
        t3 t3Var = new t3(8, false);
        this.w = t3Var;
        t3 t3Var2 = new t3(8, false);
        this.x = t3Var2;
        this.B = new LinkedHashSet();
        this.p = ka0.m;
        boolean z = wc0Var.g;
        this.g = z;
        this.h = (yc0) wc0Var.l;
        int i = z ? 1 : 2;
        this.l = i;
        if (z) {
            this.l = i + 2;
        }
        if (z) {
            t3Var.h(7, 16777216);
        }
        String str = (String) wc0Var.i;
        this.j = str;
        byte[] bArr = wq1.a;
        Locale locale = Locale.US;
        this.n = new ScheduledThreadPoolExecutor(1, new tq1(uo.t("OkHttp ", str, " Writer"), false));
        this.o = new ThreadPoolExecutor(0, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new tq1(uo.t("OkHttp ", str, " Push Observer"), true));
        t3Var2.h(7, 65535);
        t3Var2.h(5, 16384);
        this.v = t3Var2.e();
        this.y = (Socket) wc0Var.h;
        this.z = new jd0((a81) wc0Var.k, z);
        this.A = new ad0(this, new ed0((b81) wc0Var.j, z));
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
    
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r3), r8.z.j);
        r6 = r3;
        r8.v -= r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void A(int r9, boolean r10, defpackage.fe r11, long r12) {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto Ld
            jd0 r12 = r8.z
            r12.b(r10, r9, r11, r0)
            return
        Ld:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L65
            monitor-enter(r8)
        L12:
            long r3 = r8.v     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L32
            java.util.LinkedHashMap r3 = r8.i     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            boolean r3 = r3.containsKey(r4)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            if (r3 == 0) goto L2a
            r8.wait()     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            goto L12
        L28:
            r9 = move-exception
            goto L63
        L2a:
            java.io.IOException r9 = new java.io.IOException     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
            throw r9     // Catch: java.lang.Throwable -> L28 java.lang.InterruptedException -> L56
        L32:
            long r3 = java.lang.Math.min(r12, r3)     // Catch: java.lang.Throwable -> L28
            int r4 = (int) r3     // Catch: java.lang.Throwable -> L28
            jd0 r3 = r8.z     // Catch: java.lang.Throwable -> L28
            int r3 = r3.j     // Catch: java.lang.Throwable -> L28
            int r3 = java.lang.Math.min(r4, r3)     // Catch: java.lang.Throwable -> L28
            long r4 = r8.v     // Catch: java.lang.Throwable -> L28
            long r6 = (long) r3     // Catch: java.lang.Throwable -> L28
            long r4 = r4 - r6
            r8.v = r4     // Catch: java.lang.Throwable -> L28
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            long r12 = r12 - r6
            jd0 r4 = r8.z
            if (r10 == 0) goto L51
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L51
            r5 = 1
            goto L52
        L51:
            r5 = 0
        L52:
            r4.b(r5, r9, r11, r3)
            goto Ld
        L56:
            java.lang.Thread r9 = java.lang.Thread.currentThread()     // Catch: java.lang.Throwable -> L28
            r9.interrupt()     // Catch: java.lang.Throwable -> L28
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch: java.lang.Throwable -> L28
            r9.<init>()     // Catch: java.lang.Throwable -> L28
            throw r9     // Catch: java.lang.Throwable -> L28
        L63:
            monitor-exit(r8)     // Catch: java.lang.Throwable -> L28
            throw r9
        L65:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.bd0.A(int, boolean, fe, long):void");
    }

    public final void B(int i, int i2) {
        try {
            this.n.execute(new rc0(this, new Object[]{this.j, Integer.valueOf(i)}, i, i2));
        } catch (RejectedExecutionException unused) {
        }
    }

    public final void C(int i, long j) {
        try {
            this.n.execute(new sc0(this, new Object[]{this.j, Integer.valueOf(i)}, i, j));
        } catch (RejectedExecutionException unused) {
        }
    }

    public final void a(int i, int i2, IOException iOException) {
        id0[] id0VarArr;
        try {
            r(i);
        } catch (IOException unused) {
        }
        synchronized (this) {
            try {
                if (this.i.isEmpty()) {
                    id0VarArr = null;
                } else {
                    id0VarArr = (id0[]) this.i.values().toArray(new id0[this.i.size()]);
                    this.i.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (id0VarArr != null) {
            for (id0 id0Var : id0VarArr) {
                try {
                    id0Var.c(iOException, i2);
                } catch (IOException unused2) {
                }
            }
        }
        try {
            this.z.close();
        } catch (IOException unused3) {
        }
        try {
            this.y.close();
        } catch (IOException unused4) {
        }
        this.n.shutdown();
        this.o.shutdown();
    }

    public final synchronized id0 b(int i) {
        return (id0) this.i.get(Integer.valueOf(i));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        a(1, 6, null);
    }

    public final void flush() {
        this.z.flush();
    }

    public final synchronized int h() {
        t3 t3Var;
        t3Var = this.x;
        return (t3Var.g & 16) != 0 ? ((int[]) t3Var.h)[4] : ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    public final synchronized void k(cg cgVar) {
        if (!this.m) {
            this.o.execute(cgVar);
        }
    }

    public final synchronized id0 n(int i) {
        id0 id0Var;
        id0Var = (id0) this.i.remove(Integer.valueOf(i));
        notifyAll();
        return id0Var;
    }

    public final void r(int i) {
        synchronized (this.z) {
            synchronized (this) {
                if (this.m) {
                    return;
                }
                this.m = true;
                this.z.k(this.k, wq1.a, i);
            }
        }
    }

    public final synchronized void z(long j) {
        long j2 = this.u + j;
        this.u = j2;
        if (j2 >= this.w.e() / 2) {
            C(0, this.u);
            this.u = 0L;
        }
    }
}
