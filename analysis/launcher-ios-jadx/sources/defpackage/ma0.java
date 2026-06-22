package defpackage;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ma0 implements ud1, qy0, h10 {
    public final Context g;
    public final mu i;
    public boolean j;
    public final s31 m;
    public final q11 n;
    public final rl o;
    public Boolean q;
    public final pw1 r;
    public final rm1 s;
    public final xv t;
    public final HashMap h = new HashMap();
    public final Object k = new Object();
    public final q11 l = new q11(21);
    public final HashMap p = new HashMap();

    static {
        ka0.r("GreedyScheduler");
    }

    public ma0(Context context, rl rlVar, hz1 hz1Var, s31 s31Var, q11 q11Var, rm1 rm1Var) {
        this.g = context;
        jl1 jl1Var = rlVar.c;
        ow1 ow1Var = rlVar.f;
        this.i = new mu(this, ow1Var, jl1Var);
        this.t = new xv(ow1Var, q11Var);
        this.s = rm1Var;
        this.r = new pw1(hz1Var);
        this.o = rlVar;
        this.m = s31Var;
        this.n = q11Var;
    }

    @Override // defpackage.ud1
    public final void a(String str) {
        Runnable runnable;
        if (this.q == null) {
            this.q = Boolean.valueOf(q31.a(this.g, this.o));
        }
        if (!this.q.booleanValue()) {
            ka0.j().getClass();
            return;
        }
        if (!this.j) {
            this.m.a(this);
            this.j = true;
        }
        ka0.j().getClass();
        mu muVar = this.i;
        if (muVar != null && (runnable = (Runnable) muVar.d.remove(str)) != null) {
            ((Handler) muVar.b.h).removeCallbacks(runnable);
        }
        for (bj1 bj1Var : this.l.N(str)) {
            this.t.a(bj1Var);
            q11 q11Var = this.n;
            q11Var.getClass();
            q11Var.P(bj1Var, -512);
        }
    }

    @Override // defpackage.qy0
    public final void b(lz1 lz1Var, sn snVar) {
        zy1 zy1VarI = m90.i(lz1Var);
        boolean z = snVar instanceof qn;
        q11 q11Var = this.n;
        xv xvVar = this.t;
        q11 q11Var2 = this.l;
        if (z) {
            if (q11Var2.j(zy1VarI)) {
                return;
            }
            ka0 ka0VarJ = ka0.j();
            zy1VarI.toString();
            ka0VarJ.getClass();
            bj1 bj1VarQ = q11Var2.Q(zy1VarI);
            xvVar.c(bj1VarQ);
            ((qm0) ((rm1) q11Var.i)).e(new xm((s31) q11Var.h, bj1VarQ, (wb2) null));
            return;
        }
        ka0 ka0VarJ2 = ka0.j();
        zy1VarI.toString();
        ka0VarJ2.getClass();
        bj1 bj1VarM = q11Var2.M(zy1VarI);
        if (bj1VarM != null) {
            xvVar.a(bj1VarM);
            int i = ((rn) snVar).a;
            q11Var.getClass();
            q11Var.P(bj1VarM, i);
        }
    }

    @Override // defpackage.ud1
    public final void c(lz1... lz1VarArr) {
        if (this.q == null) {
            this.q = Boolean.valueOf(q31.a(this.g, this.o));
        }
        if (!this.q.booleanValue()) {
            ka0.j().getClass();
            return;
        }
        if (!this.j) {
            this.m.a(this);
            this.j = true;
        }
        HashSet<lz1> hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (lz1 lz1Var : lz1VarArr) {
            if (!this.l.j(m90.i(lz1Var))) {
                long jMax = Math.max(lz1Var.a(), g(lz1Var));
                this.o.c.getClass();
                long jCurrentTimeMillis = System.currentTimeMillis();
                if (lz1Var.b == 1) {
                    if (jCurrentTimeMillis < jMax) {
                        mu muVar = this.i;
                        if (muVar != null) {
                            HashMap map = muVar.d;
                            Runnable runnable = (Runnable) map.remove(lz1Var.a);
                            ow1 ow1Var = muVar.b;
                            if (runnable != null) {
                                ((Handler) ow1Var.h).removeCallbacks(runnable);
                            }
                            w1 w1Var = new w1(muVar, lz1Var, 10, false);
                            map.put(lz1Var.a, w1Var);
                            muVar.c.getClass();
                            ((Handler) ow1Var.h).postDelayed(w1Var, jMax - System.currentTimeMillis());
                        }
                    } else if (lz1Var.b()) {
                        int i = Build.VERSION.SDK_INT;
                        if (i >= 23 && lz1Var.j.c) {
                            ka0 ka0VarJ = ka0.j();
                            lz1Var.toString();
                            ka0VarJ.getClass();
                        } else if (i < 24 || !lz1Var.j.a()) {
                            hashSet.add(lz1Var);
                            hashSet2.add(lz1Var.a);
                        } else {
                            ka0 ka0VarJ2 = ka0.j();
                            lz1Var.toString();
                            ka0VarJ2.getClass();
                        }
                    } else if (!this.l.j(m90.i(lz1Var))) {
                        ka0.j().getClass();
                        q11 q11Var = this.l;
                        q11Var.getClass();
                        bj1 bj1VarQ = q11Var.Q(m90.i(lz1Var));
                        this.t.c(bj1VarQ);
                        q11 q11Var2 = this.n;
                        ((qm0) ((rm1) q11Var2.i)).e(new xm((s31) q11Var2.h, bj1VarQ, (wb2) null));
                    }
                }
            }
        }
        synchronized (this.k) {
            try {
                if (!hashSet.isEmpty()) {
                    TextUtils.join(",", hashSet2);
                    ka0.j().getClass();
                    for (lz1 lz1Var2 : hashSet) {
                        zy1 zy1VarI = m90.i(lz1Var2);
                        if (!this.h.containsKey(zy1VarI)) {
                            this.h.put(zy1VarI, ty1.a(this.r, lz1Var2, (j10) ((qm0) this.s).b, this));
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // defpackage.h10
    public final void d(zy1 zy1Var, boolean z) {
        bj1 bj1VarM = this.l.M(zy1Var);
        if (bj1VarM != null) {
            this.t.a(bj1VarM);
        }
        f(zy1Var);
        if (z) {
            return;
        }
        synchronized (this.k) {
            this.p.remove(zy1Var);
        }
    }

    @Override // defpackage.ud1
    public final boolean e() {
        return false;
    }

    public final void f(zy1 zy1Var) {
        fi0 fi0Var;
        synchronized (this.k) {
            fi0Var = (fi0) this.h.remove(zy1Var);
        }
        if (fi0Var != null) {
            ka0 ka0VarJ = ka0.j();
            Objects.toString(zy1Var);
            ka0VarJ.getClass();
            fi0Var.b(null);
        }
    }

    public final long g(lz1 lz1Var) {
        long jMax;
        synchronized (this.k) {
            try {
                zy1 zy1VarI = m90.i(lz1Var);
                la0 la0Var = (la0) this.p.get(zy1VarI);
                if (la0Var == null) {
                    int i = lz1Var.k;
                    this.o.c.getClass();
                    la0Var = new la0(i, System.currentTimeMillis());
                    this.p.put(zy1VarI, la0Var);
                }
                jMax = (((long) Math.max((lz1Var.k - la0Var.a) - 5, 0)) * 30000) + la0Var.b;
            } catch (Throwable th) {
                throw th;
            }
        }
        return jMax;
    }
}
