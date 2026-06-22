package defpackage;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.ref.Reference;
import java.net.Socket;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes.dex */
public final class hp1 {
    public final iy0 a;
    public final f81 b;
    public final d81 c;
    public final iy d;
    public final hd0 e;
    public Object f;
    public ia1 g;
    public g10 h;
    public e81 i;
    public e10 j;
    public boolean k;
    public boolean l;
    public boolean m;
    public boolean n;
    public boolean o;

    public hp1(iy0 iy0Var, d81 d81Var) {
        hd0 hd0Var = new hd0(this, 2);
        this.e = hd0Var;
        this.a = iy0Var;
        ka0 ka0Var = ka0.q;
        ow1 ow1Var = iy0Var.v;
        ka0Var.getClass();
        this.b = (f81) ow1Var.h;
        this.c = d81Var;
        iy0Var.l.getClass();
        this.d = iy.h;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        hd0Var.g(0);
    }

    public final void a() {
        e10 e10Var;
        e81 e81Var;
        synchronized (this.b) {
            this.m = true;
            e10Var = this.j;
            g10 g10Var = this.h;
            if (g10Var == null || (e81Var = g10Var.g) == null) {
                e81Var = this.i;
            }
        }
        if (e10Var != null) {
            e10Var.d.cancel();
        } else if (e81Var != null) {
            wq1.d(e81Var.d);
        }
    }

    public final void b() {
        synchronized (this.b) {
            try {
                if (this.o) {
                    throw new IllegalStateException();
                }
                this.j = null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final IOException c(e10 e10Var, boolean z, boolean z2, IOException iOException) {
        boolean z3;
        synchronized (this.b) {
            try {
                e10 e10Var2 = this.j;
                if (e10Var != e10Var2) {
                    return iOException;
                }
                boolean z4 = true;
                if (z) {
                    z3 = !this.k;
                    this.k = true;
                } else {
                    z3 = false;
                }
                if (z2) {
                    if (!this.l) {
                        z3 = true;
                    }
                    this.l = true;
                }
                if (this.k && this.l && z3) {
                    e10Var2.d.h().m++;
                    this.j = null;
                } else {
                    z4 = false;
                }
                return z4 ? e(iOException, false) : iOException;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean d() {
        boolean z;
        synchronized (this.b) {
            z = this.m;
        }
        return z;
    }

    public final IOException e(IOException iOException, boolean z) {
        e81 e81Var;
        Socket socketG;
        boolean z2;
        synchronized (this.b) {
            if (z) {
                try {
                    if (this.j != null) {
                        throw new IllegalStateException("cannot release connection while it is in use");
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            e81Var = this.i;
            socketG = (e81Var != null && this.j == null && (z || this.o)) ? g() : null;
            if (this.i != null) {
                e81Var = null;
            }
            z2 = this.o && this.j == null;
        }
        wq1.d(socketG);
        if (e81Var != null) {
            this.d.getClass();
        }
        if (z2) {
            boolean z3 = iOException != null;
            if (!this.n && this.e.k()) {
                InterruptedIOException interruptedIOException = new InterruptedIOException("timeout");
                if (iOException != null) {
                    interruptedIOException.initCause(iOException);
                }
                iOException = interruptedIOException;
            }
            if (z3) {
                this.d.getClass();
                return iOException;
            }
            this.d.getClass();
        }
        return iOException;
    }

    public final IOException f(IOException iOException) {
        synchronized (this.b) {
            this.o = true;
        }
        return e(iOException, false);
    }

    public final Socket g() {
        int size = this.i.p.size();
        int i = 0;
        while (true) {
            if (i >= size) {
                i = -1;
                break;
            }
            if (((Reference) this.i.p.get(i)).get() == this) {
                break;
            }
            i++;
        }
        if (i == -1) {
            throw new IllegalStateException();
        }
        e81 e81Var = this.i;
        e81Var.p.remove(i);
        this.i = null;
        if (!e81Var.p.isEmpty()) {
            return null;
        }
        e81Var.q = System.nanoTime();
        f81 f81Var = this.b;
        f81Var.getClass();
        if (e81Var.k || f81Var.a == 0) {
            f81Var.d.remove(e81Var);
            return e81Var.e;
        }
        f81Var.notifyAll();
        return null;
    }
}
