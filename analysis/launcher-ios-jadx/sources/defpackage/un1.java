package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class un1 implements pa1, ha1 {
    public final Object a;
    public final Object b;
    public volatile yg1 c;
    public volatile ha1 d;
    public int e = 3;
    public int f = 3;
    public boolean g;

    public un1(Object obj, pa1 pa1Var) {
        this.b = obj;
        this.a = pa1Var;
    }

    @Override // defpackage.pa1, defpackage.ha1
    public final boolean a() {
        boolean z;
        synchronized (this.b) {
            try {
                z = this.d.a() || this.c.a();
            } finally {
            }
        }
        return z;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, pa1] */
    @Override // defpackage.pa1
    public final boolean b(ha1 ha1Var) {
        boolean z;
        synchronized (this.b) {
            try {
                ?? r1 = this.a;
                z = (r1 == 0 || r1.b(this)) && ha1Var.equals(this.c) && !a();
            } finally {
            }
        }
        return z;
    }

    @Override // defpackage.ha1
    public final boolean c(ha1 ha1Var) {
        if (!(ha1Var instanceof un1)) {
            return false;
        }
        un1 un1Var = (un1) ha1Var;
        if (this.c == null) {
            if (un1Var.c != null) {
                return false;
            }
        } else if (!this.c.c(un1Var.c)) {
            return false;
        }
        return this.d == null ? un1Var.d == null : this.d.c(un1Var.d);
    }

    @Override // defpackage.ha1
    public final void clear() {
        synchronized (this.b) {
            this.g = false;
            this.e = 3;
            this.f = 3;
            this.d.clear();
            this.c.clear();
        }
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, pa1] */
    @Override // defpackage.pa1
    public final void d(ha1 ha1Var) {
        synchronized (this.b) {
            try {
                if (ha1Var.equals(this.d)) {
                    this.f = 4;
                    return;
                }
                this.e = 4;
                ?? r3 = this.a;
                if (r3 != 0) {
                    r3.d(this);
                }
                if (!k31.e(this.f)) {
                    this.d.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.ha1
    public final boolean e() {
        boolean z;
        synchronized (this.b) {
            z = this.e == 3;
        }
        return z;
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.Object, pa1] */
    @Override // defpackage.pa1
    public final boolean f(ha1 ha1Var) {
        boolean z;
        synchronized (this.b) {
            try {
                ?? r1 = this.a;
                z = (r1 == 0 || r1.f(this)) && (ha1Var.equals(this.c) || this.e != 4);
            } finally {
            }
        }
        return z;
    }

    /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, pa1] */
    @Override // defpackage.pa1
    public final void g(ha1 ha1Var) {
        synchronized (this.b) {
            try {
                if (!ha1Var.equals(this.c)) {
                    this.f = 5;
                    return;
                }
                this.e = 5;
                ?? r3 = this.a;
                if (r3 != 0) {
                    r3.g(this);
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
        synchronized (this.b) {
            try {
                ?? r1 = this.a;
                z = (r1 == 0 || r1.h(this)) && ha1Var.equals(this.c) && this.e != 2;
            } finally {
            }
        }
        return z;
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object, pa1] */
    @Override // defpackage.pa1
    public final pa1 i() {
        pa1 pa1VarI;
        synchronized (this.b) {
            try {
                ?? r1 = this.a;
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
        synchronized (this.b) {
            z = true;
            if (this.e != 1) {
                z = false;
            }
        }
        return z;
    }

    @Override // defpackage.ha1
    public final void j() {
        synchronized (this.b) {
            try {
                if (!k31.e(this.f)) {
                    this.f = 2;
                    this.d.j();
                }
                if (!k31.e(this.e)) {
                    this.e = 2;
                    this.c.j();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.ha1
    public final void k() {
        synchronized (this.b) {
            try {
                this.g = true;
                try {
                    if (this.e != 4 && this.f != 1) {
                        this.f = 1;
                        this.d.k();
                    }
                    if (this.g && this.e != 1) {
                        this.e = 1;
                        this.c.k();
                    }
                    this.g = false;
                } catch (Throwable th) {
                    this.g = false;
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    @Override // defpackage.ha1
    public final boolean l() {
        boolean z;
        synchronized (this.b) {
            z = this.e == 4;
        }
        return z;
    }
}
