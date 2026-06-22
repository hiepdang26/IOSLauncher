package defpackage;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayDeque;

/* JADX INFO: loaded from: classes.dex */
public final class id0 {
    public long a = 0;
    public long b;
    public final int c;
    public final bd0 d;
    public final ArrayDeque e;
    public boolean f;
    public final gd0 g;
    public final fd0 h;
    public final hd0 i;
    public final hd0 j;
    public int k;
    public IOException l;

    public id0(int i, bd0 bd0Var, boolean z, boolean z2, ob0 ob0Var) {
        ArrayDeque arrayDeque = new ArrayDeque();
        this.e = arrayDeque;
        int i2 = 0;
        this.i = new hd0(this, i2);
        this.j = new hd0(this, i2);
        if (bd0Var == null) {
            throw new NullPointerException("connection == null");
        }
        this.c = i;
        this.d = bd0Var;
        this.b = bd0Var.x.e();
        gd0 gd0Var = new gd0(this, bd0Var.w.e());
        this.g = gd0Var;
        fd0 fd0Var = new fd0(this);
        this.h = fd0Var;
        gd0Var.k = z2;
        fd0Var.i = z;
        if (ob0Var != null) {
            arrayDeque.add(ob0Var);
        }
        if (g() && ob0Var != null) {
            throw new IllegalStateException("locally-initiated streams shouldn't have headers yet");
        }
        if (!g() && ob0Var == null) {
            throw new IllegalStateException("remotely-initiated streams should have headers");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r2 = this;
            monitor-enter(r2)
            gd0 r0 = r2.g     // Catch: java.lang.Throwable -> L16
            boolean r1 = r0.k     // Catch: java.lang.Throwable -> L16
            if (r1 != 0) goto L1a
            boolean r0 = r0.j     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L1a
            fd0 r0 = r2.h     // Catch: java.lang.Throwable -> L16
            boolean r1 = r0.i     // Catch: java.lang.Throwable -> L16
            if (r1 != 0) goto L18
            boolean r0 = r0.h     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L1a
            goto L18
        L16:
            r0 = move-exception
            goto L32
        L18:
            r0 = 1
            goto L1b
        L1a:
            r0 = 0
        L1b:
            boolean r1 = r2.h()     // Catch: java.lang.Throwable -> L16
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L16
            if (r0 == 0) goto L28
            r0 = 6
            r1 = 0
            r2.c(r1, r0)
            return
        L28:
            if (r1 != 0) goto L31
            bd0 r0 = r2.d
            int r1 = r2.c
            r0.n(r1)
        L31:
            return
        L32:
            monitor-exit(r2)     // Catch: java.lang.Throwable -> L16
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.id0.a():void");
    }

    public final void b() throws IOException {
        fd0 fd0Var = this.h;
        if (fd0Var.h) {
            throw new IOException("stream closed");
        }
        if (fd0Var.i) {
            throw new IOException("stream finished");
        }
        if (this.k != 0) {
            IOException iOException = this.l;
            if (iOException == null) {
                throw new vj1(this.k);
            }
        }
    }

    public final void c(IOException iOException, int i) {
        if (d(iOException, i)) {
            this.d.z.z(this.c, i);
        }
    }

    public final boolean d(IOException iOException, int i) {
        synchronized (this) {
            try {
                if (this.k != 0) {
                    return false;
                }
                if (this.g.k && this.h.i) {
                    return false;
                }
                this.k = i;
                this.l = iOException;
                notifyAll();
                this.d.n(this.c);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void e(int i) {
        if (d(null, i)) {
            this.d.B(this.c, i);
        }
    }

    public final fd0 f() {
        synchronized (this) {
            try {
                if (!this.f && !g()) {
                    throw new IllegalStateException("reply before requesting the sink");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return this.h;
    }

    public final boolean g() {
        return this.d.g == ((this.c & 1) == 1);
    }

    public final synchronized boolean h() {
        try {
            if (this.k != 0) {
                return false;
            }
            gd0 gd0Var = this.g;
            if (gd0Var.k || gd0Var.j) {
                fd0 fd0Var = this.h;
                if (fd0Var.i || fd0Var.h) {
                    if (this.f) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void i(ob0 ob0Var, boolean z) {
        boolean zH;
        synchronized (this) {
            try {
                if (this.f && z) {
                    this.g.getClass();
                } else {
                    this.f = true;
                    this.e.add(ob0Var);
                }
                if (z) {
                    this.g.k = true;
                }
                zH = h();
                notifyAll();
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zH) {
            return;
        }
        this.d.n(this.c);
    }

    public final synchronized void j(int i) {
        if (this.k == 0) {
            this.k = i;
            notifyAll();
        }
    }

    public final void k() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }
}
