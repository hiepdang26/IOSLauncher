package defpackage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes.dex */
public final class h00 implements i20 {
    public static final iy C = new iy();
    public volatile boolean A;
    public boolean B;
    public final g00 g;
    public final gj1 h;
    public final d00 i;
    public final wb2 j;
    public final iy k;
    public final d00 l;
    public final s90 m;
    public final s90 n;
    public final s90 o;
    public final AtomicInteger p;
    public i00 q;
    public boolean r;
    public boolean s;
    public eb1 t;
    public int u;
    public boolean v;
    public q90 w;
    public boolean x;
    public j00 y;
    public ss z;

    public h00(s90 s90Var, s90 s90Var2, s90 s90Var3, s90 s90Var4, d00 d00Var, d00 d00Var2, wb2 wb2Var) {
        iy iyVar = C;
        this.g = new g00(new ArrayList(2));
        this.h = new gj1();
        this.p = new AtomicInteger();
        this.m = s90Var;
        this.n = s90Var2;
        this.o = s90Var4;
        this.l = d00Var;
        this.i = d00Var2;
        this.j = wb2Var;
        this.k = iyVar;
    }

    public final synchronized void a(yg1 yg1Var, l10 l10Var) {
        try {
            this.h.a();
            g00 g00Var = this.g;
            g00Var.getClass();
            g00Var.g.add(new f00(yg1Var, l10Var));
            if (this.v) {
                e(1);
                e00 e00Var = new e00(this, yg1Var, 1);
                l10Var.getClass();
                vq1.j(e00Var);
            } else if (this.x) {
                e(1);
                e00 e00Var2 = new e00(this, yg1Var, 0);
                l10Var.getClass();
                vq1.j(e00Var2);
            } else {
                n90.e("Cannot add callbacks to a cancelled EngineJob", !this.A);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // defpackage.i20
    public final gj1 b() {
        return this.h;
    }

    public final void c() {
        if (f()) {
            return;
        }
        this.A = true;
        ss ssVar = this.z;
        ssVar.F = true;
        es esVar = ssVar.D;
        if (esVar != null) {
            esVar.cancel();
        }
        d00 d00Var = this.l;
        i00 i00Var = this.q;
        synchronized (d00Var) {
            ow1 ow1Var = d00Var.a;
            ow1Var.getClass();
            HashMap map = (HashMap) ow1Var.h;
            if (equals(map.get(i00Var))) {
                map.remove(i00Var);
            }
        }
    }

    public final void d() {
        j00 j00Var;
        synchronized (this) {
            try {
                this.h.a();
                n90.e("Not yet complete!", f());
                int iDecrementAndGet = this.p.decrementAndGet();
                n90.e("Can't decrement below 0", iDecrementAndGet >= 0);
                if (iDecrementAndGet == 0) {
                    j00Var = this.y;
                    i();
                } else {
                    j00Var = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (j00Var != null) {
            j00Var.b();
        }
    }

    public final synchronized void e(int i) {
        j00 j00Var;
        n90.e("Not yet complete!", f());
        if (this.p.getAndAdd(i) == 0 && (j00Var = this.y) != null) {
            j00Var.a();
        }
    }

    public final boolean f() {
        return this.x || this.v || this.A;
    }

    public final void g() {
        synchronized (this) {
            try {
                this.h.a();
                if (this.A) {
                    i();
                    return;
                }
                if (this.g.g.isEmpty()) {
                    throw new IllegalStateException("Received an exception without any callbacks to notify");
                }
                if (this.x) {
                    throw new IllegalStateException("Already failed once");
                }
                this.x = true;
                i00 i00Var = this.q;
                g00 g00Var = this.g;
                g00Var.getClass();
                ArrayList arrayList = new ArrayList(g00Var.g);
                e(arrayList.size() + 1);
                this.l.d(this, i00Var, null);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    f00 f00Var = (f00) obj;
                    f00Var.b.execute(new e00(this, f00Var.a, 0));
                }
                d();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void h() {
        synchronized (this) {
            try {
                this.h.a();
                if (this.A) {
                    this.t.recycle();
                    i();
                    return;
                }
                if (this.g.g.isEmpty()) {
                    throw new IllegalStateException("Received a resource without any callbacks to notify");
                }
                if (this.v) {
                    throw new IllegalStateException("Already have resource");
                }
                iy iyVar = this.k;
                eb1 eb1Var = this.t;
                boolean z = this.r;
                i00 i00Var = this.q;
                d00 d00Var = this.i;
                iyVar.getClass();
                this.y = new j00(eb1Var, z, true, i00Var, d00Var);
                this.v = true;
                g00 g00Var = this.g;
                g00Var.getClass();
                ArrayList arrayList = new ArrayList(g00Var.g);
                e(arrayList.size() + 1);
                this.l.d(this, this.q, this.y);
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    f00 f00Var = (f00) obj;
                    f00Var.b.execute(new e00(this, f00Var.a, 1));
                }
                d();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void i() {
        if (this.q == null) {
            throw new IllegalArgumentException();
        }
        this.g.g.clear();
        this.q = null;
        this.y = null;
        this.t = null;
        this.x = false;
        this.A = false;
        this.v = false;
        this.B = false;
        this.z.l();
        this.z = null;
        this.w = null;
        this.u = 0;
        this.j.z(this);
    }

    public final synchronized void j(yg1 yg1Var) {
        try {
            this.h.a();
            g00 g00Var = this.g;
            g00Var.g.remove(new f00(yg1Var, wd.s));
            if (this.g.g.isEmpty()) {
                c();
                if (this.v || this.x) {
                    if (this.p.get() == 0) {
                        i();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void k(ss ssVar) {
        this.z = ssVar;
        int iH = ssVar.h(1);
        ((iH == 2 || iH == 3) ? this.m : this.s ? this.o : this.n).execute(ssVar);
    }
}
