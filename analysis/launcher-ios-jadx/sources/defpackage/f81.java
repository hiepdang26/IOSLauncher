package defpackage;

import androidx.appcompat.widget.ActivityChooserView;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.Proxy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class f81 {
    public static final ThreadPoolExecutor g;
    public final int a;
    public final long b;
    public final r1 c;
    public final ArrayDeque d;
    public final mc1 e;
    public boolean f;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        SynchronousQueue synchronousQueue = new SynchronousQueue();
        byte[] bArr = wq1.a;
        g = new ThreadPoolExecutor(0, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 60L, timeUnit, synchronousQueue, new tq1("OkHttp ConnectionPool", true));
    }

    public f81() {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        this.c = new r1(this, 24);
        this.d = new ArrayDeque();
        this.e = new mc1(23);
        this.a = 5;
        this.b = timeUnit.toNanos(5L);
    }

    public final long a(long j) {
        synchronized (this) {
            try {
                e81 e81Var = null;
                long j2 = Long.MIN_VALUE;
                int i = 0;
                int i2 = 0;
                for (e81 e81Var2 : this.d) {
                    if (c(e81Var2, j) > 0) {
                        i2++;
                    } else {
                        i++;
                        long j3 = j - e81Var2.q;
                        if (j3 > j2) {
                            e81Var = e81Var2;
                            j2 = j3;
                        }
                    }
                }
                long j4 = this.b;
                if (j2 < j4 && i <= this.a) {
                    if (i > 0) {
                        return j4 - j2;
                    }
                    if (i2 > 0) {
                        return j4;
                    }
                    this.f = false;
                    return -1L;
                }
                this.d.remove(e81Var);
                wq1.d(e81Var.e);
                return 0L;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b(tc1 tc1Var, IOException iOException) {
        if (tc1Var.b.type() != Proxy.Type.DIRECT) {
            c3 c3Var = tc1Var.a;
            c3Var.g.connectFailed(c3Var.a.l(), tc1Var.b.address(), iOException);
        }
        mc1 mc1Var = this.e;
        synchronized (mc1Var) {
            ((LinkedHashSet) mc1Var.h).add(tc1Var);
        }
    }

    public final int c(e81 e81Var, long j) {
        ArrayList arrayList = e81Var.p;
        int i = 0;
        while (i < arrayList.size()) {
            Reference reference = (Reference) arrayList.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                d21.a.n(((gp1) reference).a, "A connection to " + e81Var.c.a.a + " was leaked. Did you forget to close a response body?");
                arrayList.remove(i);
                e81Var.k = true;
                if (arrayList.isEmpty()) {
                    e81Var.q = j - this.b;
                    return 0;
                }
            }
        }
        return arrayList.size();
    }

    /* JADX WARN: Code restructure failed: missing block: B:69:0x0006, code lost:
    
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean d(defpackage.c3 r10, defpackage.hp1 r11, java.util.ArrayList r12, boolean r13) {
        /*
            r9 = this;
            java.util.ArrayDeque r0 = r9.d
            java.util.Iterator r0 = r0.iterator()
        L6:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto Lb1
            java.lang.Object r1 = r0.next()
            e81 r1 = (defpackage.e81) r1
            if (r13 == 0) goto L19
            bd0 r3 = r1.h
            if (r3 == 0) goto L6
        L19:
            java.util.ArrayList r3 = r1.p
            int r3 = r3.size()
            int r4 = r1.o
            if (r3 >= r4) goto L6
            boolean r3 = r1.k
            if (r3 == 0) goto L28
            goto L6
        L28:
            ka0 r3 = defpackage.ka0.q
            tc1 r4 = r1.c
            c3 r5 = r4.a
            r3.getClass()
            boolean r3 = r5.a(r10)
            if (r3 != 0) goto L38
            goto L6
        L38:
            od0 r3 = r10.a
            java.lang.String r5 = r3.d
            c3 r6 = r4.a
            od0 r6 = r6.a
            java.lang.String r6 = r6.d
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L49
            goto L91
        L49:
            bd0 r5 = r1.h
            if (r5 != 0) goto L4e
            goto L6
        L4e:
            if (r12 == 0) goto L6
            int r5 = r12.size()
        L54:
            if (r2 >= r5) goto L6
            java.lang.Object r6 = r12.get(r2)
            tc1 r6 = (defpackage.tc1) r6
            java.net.Proxy r7 = r6.b
            java.net.Proxy$Type r7 = r7.type()
            java.net.Proxy$Type r8 = java.net.Proxy.Type.DIRECT
            if (r7 != r8) goto Lae
            java.net.Proxy r7 = r4.b
            java.net.Proxy$Type r7 = r7.type()
            if (r7 != r8) goto Lae
            java.net.InetSocketAddress r6 = r6.c
            java.net.InetSocketAddress r7 = r4.c
            boolean r6 = r7.equals(r6)
            if (r6 == 0) goto Lae
            hy0 r2 = defpackage.hy0.a
            hy0 r4 = r10.i
            if (r4 == r2) goto L7f
            goto L6
        L7f:
            boolean r2 = r1.k(r3)
            if (r2 != 0) goto L86
            goto L6
        L86:
            fh r2 = r10.j     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lab
            java.lang.String r3 = r3.d     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lab
            fb0 r4 = r1.f     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lab
            java.util.List r4 = r4.c     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lab
            r2.a(r3, r4)     // Catch: javax.net.ssl.SSLPeerUnverifiedException -> Lab
        L91:
            e81 r10 = r11.i
            if (r10 != 0) goto La5
            r11.i = r1
            java.util.ArrayList r10 = r1.p
            gp1 r12 = new gp1
            java.lang.Object r13 = r11.f
            r12.<init>(r11, r13)
            r10.add(r12)
            r10 = 1
            return r10
        La5:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            r10.<init>()
            throw r10
        Lab:
            goto L6
        Lae:
            int r2 = r2 + 1
            goto L54
        Lb1:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f81.d(c3, hp1, java.util.ArrayList, boolean):boolean");
    }
}
