package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class n00 implements pa1, ha1 {
    public final Object a;
    public final Object b;
    public volatile ha1 c;
    public volatile ha1 d;
    public int e = 3;
    public int f = 3;

    public n00(Object obj, pa1 pa1Var) {
        this.a = obj;
        this.b = pa1Var;
    }

    @Override // defpackage.pa1, defpackage.ha1
    public final boolean a() {
        boolean z;
        synchronized (this.a) {
            try {
                z = this.c.a() || this.d.a();
            } finally {
            }
        }
        return z;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, pa1] */
    @Override // defpackage.pa1
    public final boolean b(ha1 ha1Var) {
        boolean z;
        int i;
        synchronized (this.a) {
            ?? r1 = this.b;
            z = false;
            if (r1 == 0 || r1.b(this)) {
                if (this.e != 5 ? ha1Var.equals(this.c) : ha1Var.equals(this.d) && ((i = this.f) == 4 || i == 5)) {
                    z = true;
                }
            }
        }
        return z;
    }

    @Override // defpackage.ha1
    public final boolean c(ha1 ha1Var) {
        if (ha1Var instanceof n00) {
            n00 n00Var = (n00) ha1Var;
            if (this.c.c(n00Var.c) && this.d.c(n00Var.d)) {
                return true;
            }
        }
        return false;
    }

    @Override // defpackage.ha1
    public final void clear() {
        synchronized (this.a) {
            try {
                this.e = 3;
                this.c.clear();
                if (this.f != 3) {
                    this.f = 3;
                    this.d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [java.lang.Object, pa1] */
    @Override // defpackage.pa1
    public final void d(ha1 ha1Var) {
        synchronized (this.a) {
            try {
                if (ha1Var.equals(this.c)) {
                    this.e = 4;
                } else if (ha1Var.equals(this.d)) {
                    this.f = 4;
                }
                ?? r4 = this.b;
                if (r4 != 0) {
                    r4.d(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.ha1
    public final boolean e() {
        boolean z;
        synchronized (this.a) {
            try {
                z = this.e == 3 && this.f == 3;
            } finally {
            }
        }
        return z;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, pa1] */
    @Override // defpackage.pa1
    public final boolean f(ha1 ha1Var) {
        boolean z;
        synchronized (this.a) {
            ?? r0 = this.b;
            z = r0 == 0 || r0.f(this);
        }
        return z;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, pa1] */
    @Override // defpackage.pa1
    public final void g(ha1 ha1Var) {
        synchronized (this.a) {
            try {
                if (ha1Var.equals(this.d)) {
                    this.f = 5;
                    ?? r3 = this.b;
                    if (r3 != 0) {
                        r3.g(this);
                    }
                    return;
                }
                this.e = 5;
                if (this.f != 1) {
                    this.f = 1;
                    this.d.k();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, pa1] */
    @Override // defpackage.pa1
    public final boolean h(ha1 ha1Var) {
        boolean z;
        synchronized (this.a) {
            ?? r1 = this.b;
            z = (r1 == 0 || r1.h(this)) && ha1Var.equals(this.c);
        }
        return z;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, pa1] */
    @Override // defpackage.pa1
    public final pa1 i() {
        pa1 pa1VarI;
        synchronized (this.a) {
            try {
                ?? r1 = this.b;
                pa1VarI = r1 != 0 ? r1.i() : this;
            } catch (Throwable th) {
                throw th;
            }
        }
        return pa1VarI;
    }

    @Override // defpackage.ha1
    public final boolean isRunning() {
        boolean z;
        synchronized (this.a) {
            try {
                z = true;
                if (this.e != 1 && this.f != 1) {
                    z = false;
                }
            } finally {
            }
        }
        return z;
    }

    @Override // defpackage.ha1
    public final void j() {
        synchronized (this.a) {
            try {
                if (this.e == 1) {
                    this.e = 2;
                    this.c.j();
                }
                if (this.f == 1) {
                    this.f = 2;
                    this.d.j();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.ha1
    public final void k() {
        synchronized (this.a) {
            try {
                if (this.e != 1) {
                    this.e = 1;
                    this.c.k();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.ha1
    public final boolean l() {
        boolean z;
        synchronized (this.a) {
            try {
                z = this.e == 4 || this.f == 4;
            } finally {
            }
        }
        return z;
    }
}
