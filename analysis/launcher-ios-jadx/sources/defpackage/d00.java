package defpackage;

import android.os.SystemClock;
import android.util.Log;
import java.util.HashMap;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class d00 {
    public static final boolean h = Log.isLoggable("Engine", 2);
    public final ow1 a;
    public final ka0 b;
    public final iq0 c;
    public final mj d;
    public final jd e;
    public final xk f;
    public final hz1 g;

    public d00(iq0 iq0Var, nx0 nx0Var, s90 s90Var, s90 s90Var2, s90 s90Var3, s90 s90Var4) throws Throwable {
        this.c = iq0Var;
        zn znVar = new zn(nx0Var);
        hz1 hz1Var = new hz1();
        this.g = hz1Var;
        synchronized (this) {
            try {
                try {
                    synchronized (hz1Var) {
                        try {
                            hz1Var.d = this;
                        } catch (Throwable th) {
                            th = th;
                            while (true) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    th = th2;
                                }
                            }
                        }
                    }
                    this.b = new ka0(17);
                    this.a = new ow1(19);
                    this.d = new mj(s90Var, s90Var2, s90Var3, s90Var4, this, this);
                    this.f = new xk(znVar);
                    this.e = new jd();
                    iq0Var.d = this;
                } catch (Throwable th3) {
                    th = th3;
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                throw th;
            }
        }
    }

    public static void f(eb1 eb1Var) {
        if (!(eb1Var instanceof j00)) {
            throw new IllegalArgumentException("Cannot release anything but an EngineResource");
        }
        ((j00) eb1Var).b();
    }

    public final wb2 a(o90 o90Var, Object obj, bj0 bj0Var, int i, int i2, Class cls, Class cls2, j31 j31Var, qv qvVar, jf jfVar, boolean z, boolean z2, g01 g01Var, boolean z3, boolean z4, yg1 yg1Var, l10 l10Var) {
        long jElapsedRealtimeNanos;
        if (h) {
            int i3 = tp0.a;
            jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        } else {
            jElapsedRealtimeNanos = 0;
        }
        this.b.getClass();
        i00 i00Var = new i00(obj, bj0Var, i, i2, jfVar, cls, cls2, g01Var);
        synchronized (this) {
            try {
                j00 j00VarC = c(i00Var, z3, jElapsedRealtimeNanos);
                if (j00VarC == null) {
                    return g(o90Var, obj, bj0Var, i, i2, cls, cls2, j31Var, qvVar, jfVar, z, z2, g01Var, z3, z4, yg1Var, l10Var, i00Var, jElapsedRealtimeNanos);
                }
                yg1Var.g(j00VarC, 5, false);
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Finally extract failed */
    public final j00 b(i00 i00Var) throws Throwable {
        j00 j00Var;
        Object obj;
        d00 d00Var;
        i00 i00Var2;
        iq0 iq0Var = this.c;
        synchronized (iq0Var) {
            try {
                eq0 eq0Var = (eq0) iq0Var.a.remove(i00Var);
                j00Var = null;
                if (eq0Var == null) {
                    obj = null;
                } else {
                    iq0Var.c -= (long) eq0Var.b;
                    obj = eq0Var.a;
                }
            } catch (Throwable th) {
                th = th;
                while (true) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                }
            }
        }
        eb1 eb1Var = (eb1) obj;
        if (eb1Var == null) {
            d00Var = this;
            i00Var2 = i00Var;
        } else if (eb1Var instanceof j00) {
            j00Var = (j00) eb1Var;
            d00Var = this;
            i00Var2 = i00Var;
        } else {
            d00Var = this;
            i00Var2 = i00Var;
            j00Var = new j00(eb1Var, true, true, i00Var2, d00Var);
        }
        if (j00Var != null) {
            j00Var.a();
            d00Var.g.a(i00Var2, j00Var);
        }
        return j00Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final j00 c(i00 i00Var, boolean z, long j) throws Throwable {
        j00 j00Var;
        if (z) {
            hz1 hz1Var = this.g;
            synchronized (hz1Var) {
                q1 q1Var = (q1) ((HashMap) hz1Var.b).get(i00Var);
                if (q1Var == null) {
                    j00Var = null;
                } else {
                    j00Var = (j00) q1Var.get();
                    if (j00Var == null) {
                        hz1Var.b(q1Var);
                    }
                }
            }
            if (j00Var != null) {
                j00Var.a();
            }
            if (j00Var != null) {
                if (h) {
                    int i = tp0.a;
                    SystemClock.elapsedRealtimeNanos();
                    Objects.toString(i00Var);
                }
                return j00Var;
            }
            j00 j00VarB = b(i00Var);
            if (j00VarB != null) {
                if (h) {
                    int i2 = tp0.a;
                    SystemClock.elapsedRealtimeNanos();
                    Objects.toString(i00Var);
                }
                return j00VarB;
            }
        }
        return null;
    }

    public final synchronized void d(h00 h00Var, i00 i00Var, j00 j00Var) {
        if (j00Var != null) {
            try {
                if (j00Var.g) {
                    this.g.a(i00Var, j00Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        ow1 ow1Var = this.a;
        ow1Var.getClass();
        h00Var.getClass();
        HashMap map = (HashMap) ow1Var.h;
        if (h00Var.equals(map.get(i00Var))) {
            map.remove(i00Var);
        }
    }

    public final void e(i00 i00Var, j00 j00Var) {
        hz1 hz1Var = this.g;
        synchronized (hz1Var) {
            q1 q1Var = (q1) ((HashMap) hz1Var.b).remove(i00Var);
            if (q1Var != null) {
                q1Var.c = null;
                q1Var.clear();
            }
        }
        if (j00Var.g) {
        } else {
            this.e.d(j00Var, false);
        }
    }

    public final wb2 g(o90 o90Var, Object obj, bj0 bj0Var, int i, int i2, Class cls, Class cls2, j31 j31Var, qv qvVar, jf jfVar, boolean z, boolean z2, g01 g01Var, boolean z3, boolean z4, yg1 yg1Var, l10 l10Var, i00 i00Var, long j) {
        h00 h00Var = (h00) ((HashMap) this.a.h).get(i00Var);
        if (h00Var != null) {
            h00Var.a(yg1Var, l10Var);
            if (h) {
                int i3 = tp0.a;
                SystemClock.elapsedRealtimeNanos();
                Objects.toString(i00Var);
            }
            return new wb2(this, yg1Var, h00Var);
        }
        h00 h00Var2 = (h00) ((wb2) this.d.g).h();
        synchronized (h00Var2) {
            h00Var2.q = i00Var;
            h00Var2.r = z3;
            h00Var2.s = z4;
        }
        xk xkVar = this.f;
        ss ssVar = (ss) ((wb2) xkVar.d).h();
        int i4 = xkVar.b;
        xkVar.b = i4 + 1;
        qs qsVar = ssVar.g;
        qsVar.c = o90Var;
        qsVar.d = obj;
        qsVar.n = bj0Var;
        qsVar.e = i;
        qsVar.f = i2;
        qsVar.p = qvVar;
        qsVar.g = cls;
        qsVar.h = ssVar.j;
        qsVar.k = cls2;
        qsVar.o = j31Var;
        qsVar.i = g01Var;
        qsVar.j = jfVar;
        qsVar.q = z;
        qsVar.r = z2;
        ssVar.n = o90Var;
        ssVar.o = bj0Var;
        ssVar.p = j31Var;
        ssVar.q = i00Var;
        ssVar.r = i;
        ssVar.s = i2;
        ssVar.t = qvVar;
        ssVar.u = g01Var;
        ssVar.v = h00Var2;
        ssVar.w = i4;
        ssVar.I = 1;
        ssVar.x = obj;
        ow1 ow1Var = this.a;
        ow1Var.getClass();
        ((HashMap) ow1Var.h).put(i00Var, h00Var2);
        h00Var2.a(yg1Var, l10Var);
        h00Var2.k(ssVar);
        if (h) {
            int i5 = tp0.a;
            SystemClock.elapsedRealtimeNanos();
            Objects.toString(i00Var);
        }
        return new wb2(this, yg1Var, h00Var2);
    }
}
