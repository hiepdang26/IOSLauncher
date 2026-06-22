package defpackage;

import android.os.Build;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public final class ss implements ds, Runnable, Comparable, i20 {
    public bj0 A;
    public Object B;
    public cs C;
    public volatile es D;
    public volatile boolean E;
    public volatile boolean F;
    public boolean G;
    public int H;
    public int I;
    public int J;
    public final zn j;
    public final wb2 k;
    public o90 n;
    public bj0 o;
    public j31 p;
    public i00 q;
    public int r;
    public int s;
    public qv t;
    public g01 u;
    public h00 v;
    public int w;
    public Object x;
    public Thread y;
    public bj0 z;
    public final qs g = new qs();
    public final ArrayList h = new ArrayList();
    public final gj1 i = new gj1();
    public final wb2 l = new wb2(8, false);
    public final rs m = new rs();

    public ss(zn znVar, wb2 wb2Var) {
        this.j = znVar;
        this.k = wb2Var;
    }

    @Override // defpackage.ds
    public final void a(bj0 bj0Var, Exception exc, cs csVar, int i) {
        csVar.b();
        q90 q90Var = new q90("Fetching data failed", Collections.singletonList(exc));
        Class clsA = csVar.a();
        q90Var.h = bj0Var;
        q90Var.i = i;
        q90Var.j = clsA;
        this.h.add(q90Var);
        if (Thread.currentThread() != this.y) {
            n(2);
        } else {
            o();
        }
    }

    @Override // defpackage.i20
    public final gj1 b() {
        return this.i;
    }

    @Override // defpackage.ds
    public final void c(bj0 bj0Var, Object obj, cs csVar, int i, bj0 bj0Var2) {
        this.z = bj0Var;
        this.B = obj;
        this.C = csVar;
        this.J = i;
        this.A = bj0Var2;
        this.G = bj0Var != this.g.a().get(0);
        if (Thread.currentThread() != this.y) {
            n(3);
        } else {
            f();
        }
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        ss ssVar = (ss) obj;
        int iOrdinal = this.p.ordinal() - ssVar.p.ordinal();
        return iOrdinal == 0 ? this.w - ssVar.w : iOrdinal;
    }

    public final eb1 d(cs csVar, Object obj, int i) {
        if (obj == null) {
            csVar.b();
            return null;
        }
        try {
            int i2 = tp0.a;
            SystemClock.elapsedRealtimeNanos();
            eb1 eb1VarE = e(i, obj);
            if (Log.isLoggable("DecodeJob", 2)) {
                eb1VarE.toString();
                SystemClock.elapsedRealtimeNanos();
                Objects.toString(this.q);
                Thread.currentThread().getName();
            }
            return eb1VarE;
        } finally {
            csVar.b();
        }
    }

    public final eb1 e(int i, Object obj) {
        Class<?> cls = obj.getClass();
        qs qsVar = this.g;
        yo0 yo0VarC = qsVar.c(cls);
        g01 g01Var = this.u;
        if (Build.VERSION.SDK_INT >= 26) {
            boolean z = i == 4 || qsVar.r;
            e01 e01Var = jw.i;
            Boolean bool = (Boolean) g01Var.c(e01Var);
            if (bool == null || (bool.booleanValue() && !z)) {
                g01Var = new g01();
                g01 g01Var2 = this.u;
                jf jfVar = g01Var.b;
                jfVar.g(g01Var2.b);
                jfVar.put(e01Var, Boolean.valueOf(z));
            }
        }
        g01 g01Var3 = g01Var;
        gs gsVarH = this.n.b().h(obj);
        try {
            return yo0VarC.a(this.r, this.s, new t3(this, i), gsVarH, g01Var3);
        } finally {
            gsVarH.b();
        }
    }

    public final void f() {
        eb1 eb1VarD;
        if (Log.isLoggable("DecodeJob", 2)) {
            String str = "data: " + this.B + ", cache key: " + this.z + ", fetcher: " + this.C;
            int i = tp0.a;
            SystemClock.elapsedRealtimeNanos();
            Objects.toString(this.q);
            if (str != null) {
                ", ".concat(str);
            }
            Thread.currentThread().getName();
        }
        rp0 rp0Var = null;
        try {
            eb1VarD = d(this.C, this.B, this.J);
        } catch (q90 e) {
            bj0 bj0Var = this.A;
            int i2 = this.J;
            e.h = bj0Var;
            e.i = i2;
            e.j = null;
            this.h.add(e);
            eb1VarD = null;
        }
        if (eb1VarD == null) {
            o();
            return;
        }
        int i3 = this.J;
        boolean z = this.G;
        if (eb1VarD instanceof nf0) {
            ((nf0) eb1VarD).a();
        }
        boolean z2 = true;
        if (((rp0) this.l.j) != null) {
            rp0Var = (rp0) rp0.k.h();
            rp0Var.j = false;
            rp0Var.i = true;
            rp0Var.h = eb1VarD;
            eb1VarD = rp0Var;
        }
        q();
        h00 h00Var = this.v;
        synchronized (h00Var) {
            h00Var.t = eb1VarD;
            h00Var.u = i3;
            h00Var.B = z;
        }
        h00Var.h();
        this.H = 5;
        try {
            wb2 wb2Var = this.l;
            if (((rp0) wb2Var.j) == null) {
                z2 = false;
            }
            if (z2) {
                zn znVar = this.j;
                g01 g01Var = this.u;
                wb2Var.getClass();
                try {
                    znVar.a().i((bj0) wb2Var.h, new wb2((lb1) wb2Var.i, (rp0) wb2Var.j, g01Var, 7));
                    ((rp0) wb2Var.j).a();
                } catch (Throwable th) {
                    ((rp0) wb2Var.j).a();
                    throw th;
                }
            }
            j();
        } finally {
            if (rp0Var != null) {
                rp0Var.a();
            }
        }
    }

    public final es g() {
        int iV = uo.v(this.H);
        qs qsVar = this.g;
        if (iV == 1) {
            return new fb1(qsVar, this);
        }
        if (iV == 2) {
            return new zr(qsVar.a(), qsVar, this);
        }
        if (iV == 3) {
            return new gi1(qsVar, this);
        }
        if (iV == 5) {
            return null;
        }
        throw new IllegalStateException("Unrecognized stage: ".concat(uo.w(this.H)));
    }

    public final int h(int i) {
        boolean z;
        boolean z2;
        int iV = uo.v(i);
        if (iV == 0) {
            switch (this.t.a) {
                case 0:
                default:
                    z = true;
                    break;
                case 1:
                case 2:
                    z = false;
                    break;
            }
            if (z) {
                return 2;
            }
            return h(2);
        }
        if (iV != 1) {
            if (iV == 2) {
                return 4;
            }
            if (iV == 3 || iV == 5) {
                return 6;
            }
            throw new IllegalArgumentException("Unrecognized stage: ".concat(uo.w(i)));
        }
        switch (this.t.a) {
            case 0:
            case 2:
            default:
                z2 = true;
                break;
            case 1:
                z2 = false;
                break;
        }
        if (z2) {
            return 3;
        }
        return h(3);
    }

    public final void i() {
        q();
        q90 q90Var = new q90("Failed to load resource", new ArrayList(this.h));
        h00 h00Var = this.v;
        synchronized (h00Var) {
            h00Var.w = q90Var;
        }
        h00Var.g();
        k();
    }

    public final void j() {
        boolean zA;
        rs rsVar = this.m;
        synchronized (rsVar) {
            rsVar.b = true;
            zA = rsVar.a();
        }
        if (zA) {
            m();
        }
    }

    public final void k() {
        boolean zA;
        rs rsVar = this.m;
        synchronized (rsVar) {
            rsVar.c = true;
            zA = rsVar.a();
        }
        if (zA) {
            m();
        }
    }

    public final void l() {
        boolean zA;
        rs rsVar = this.m;
        synchronized (rsVar) {
            rsVar.a = true;
            zA = rsVar.a();
        }
        if (zA) {
            m();
        }
    }

    public final void m() {
        rs rsVar = this.m;
        synchronized (rsVar) {
            rsVar.b = false;
            rsVar.a = false;
            rsVar.c = false;
        }
        wb2 wb2Var = this.l;
        wb2Var.h = null;
        wb2Var.i = null;
        wb2Var.j = null;
        qs qsVar = this.g;
        qsVar.c = null;
        qsVar.d = null;
        qsVar.n = null;
        qsVar.g = null;
        qsVar.k = null;
        qsVar.i = null;
        qsVar.o = null;
        qsVar.j = null;
        qsVar.p = null;
        qsVar.a.clear();
        qsVar.l = false;
        qsVar.b.clear();
        qsVar.m = false;
        this.E = false;
        this.n = null;
        this.o = null;
        this.u = null;
        this.p = null;
        this.q = null;
        this.v = null;
        this.H = 0;
        this.D = null;
        this.y = null;
        this.z = null;
        this.B = null;
        this.J = 0;
        this.C = null;
        this.F = false;
        this.x = null;
        this.h.clear();
        this.k.z(this);
    }

    public final void n(int i) {
        this.I = i;
        h00 h00Var = this.v;
        (h00Var.s ? h00Var.o : h00Var.n).execute(this);
    }

    public final void o() {
        this.y = Thread.currentThread();
        int i = tp0.a;
        SystemClock.elapsedRealtimeNanos();
        boolean zB = false;
        while (!this.F && this.D != null && !(zB = this.D.b())) {
            this.H = h(this.H);
            this.D = g();
            if (this.H == 4) {
                n(2);
                return;
            }
        }
        if ((this.H == 6 || this.F) && !zB) {
            i();
        }
    }

    public final void p() {
        int iV = uo.v(this.I);
        if (iV == 0) {
            this.H = h(1);
            this.D = g();
            o();
        } else if (iV == 1) {
            o();
        } else if (iV == 2) {
            f();
        } else {
            int i = this.I;
            throw new IllegalStateException("Unrecognized run reason: ".concat(i != 1 ? i != 2 ? i != 3 ? "null" : "DECODE_DATA" : "SWITCH_TO_SOURCE_SERVICE" : "INITIALIZE"));
        }
    }

    public final void q() {
        Throwable th;
        this.i.a();
        if (!this.E) {
            this.E = true;
            return;
        }
        if (this.h.isEmpty()) {
            th = null;
        } else {
            ArrayList arrayList = this.h;
            th = (Throwable) arrayList.get(arrayList.size() - 1);
        }
        throw new IllegalStateException("Already notified", th);
    }

    @Override // java.lang.Runnable
    public final void run() {
        cs csVar = this.C;
        try {
            try {
                try {
                    if (this.F) {
                        i();
                        if (csVar != null) {
                            csVar.b();
                            return;
                        }
                        return;
                    }
                    p();
                    if (csVar != null) {
                        csVar.b();
                    }
                } catch (sf e) {
                    throw e;
                }
            } catch (Throwable th) {
                Log.isLoggable("DecodeJob", 3);
                if (this.H != 5) {
                    this.h.add(th);
                    i();
                }
                if (!this.F) {
                    throw th;
                }
                throw th;
            }
        } catch (Throwable th2) {
            if (csVar != null) {
                csVar.b();
            }
            throw th2;
        }
    }
}
