package defpackage;

/* JADX INFO: loaded from: classes.dex */
public abstract class hx1 implements ru {
    public int a;
    public jn b;
    public xc1 c;
    public in d;
    public final gv e = new gv(this);
    public int f = 0;
    public boolean g = false;
    public final vu h = new vu(this);
    public final vu i = new vu(this);
    public int j = 1;

    public hx1(jn jnVar) {
        this.b = jnVar;
    }

    public static void b(vu vuVar, vu vuVar2, int i) {
        vuVar.l.add(vuVar2);
        vuVar.f = i;
        vuVar2.k.add(vuVar);
    }

    public static vu h(gm gmVar) {
        gm gmVar2 = gmVar.f;
        if (gmVar2 == null) {
            return null;
        }
        int iV = uo.v(gmVar2.e);
        jn jnVar = gmVar2.d;
        if (iV == 1) {
            return jnVar.d.h;
        }
        if (iV == 2) {
            return jnVar.e.h;
        }
        if (iV == 3) {
            return jnVar.d.i;
        }
        if (iV == 4) {
            return jnVar.e.i;
        }
        if (iV != 5) {
            return null;
        }
        return jnVar.e.k;
    }

    public static vu i(gm gmVar, int i) {
        gm gmVar2 = gmVar.f;
        if (gmVar2 == null) {
            return null;
        }
        jn jnVar = gmVar2.d;
        hx1 hx1Var = i == 0 ? jnVar.d : jnVar.e;
        int iV = uo.v(gmVar2.e);
        if (iV == 1 || iV == 2) {
            return hx1Var.h;
        }
        if (iV == 3 || iV == 4) {
            return hx1Var.i;
        }
        return null;
    }

    public final void c(vu vuVar, vu vuVar2, int i, gv gvVar) {
        vuVar.l.add(vuVar2);
        vuVar.l.add(this.e);
        vuVar.h = i;
        vuVar.i = gvVar;
        vuVar2.k.add(vuVar);
        gvVar.k.add(vuVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i, int i2) {
        if (i2 == 0) {
            jn jnVar = this.b;
            int i3 = jnVar.v;
            int iMax = Math.max(jnVar.u, i);
            if (i3 > 0) {
                iMax = Math.min(i3, i);
            }
            if (iMax != i) {
                return iMax;
            }
        } else {
            jn jnVar2 = this.b;
            int i4 = jnVar2.y;
            int iMax2 = Math.max(jnVar2.x, i);
            if (i4 > 0) {
                iMax2 = Math.min(i4, i);
            }
            if (iMax2 != i) {
                return iMax2;
            }
        }
        return i;
    }

    public long j() {
        if (this.e.j) {
            return r0.g;
        }
        return 0L;
    }

    public abstract boolean k();

    /* JADX WARN: Removed duplicated region for block: B:29:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(defpackage.gm r13, defpackage.gm r14, int r15) {
        /*
            Method dump skipped, instruction units count: 240
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hx1.l(gm, gm, int):void");
    }
}
