package defpackage;

/* JADX INFO: loaded from: classes.dex */
public final class wa0 extends hx1 {
    @Override // defpackage.ru
    public final void a(ru ruVar) {
        vu vuVar = this.h;
        if (vuVar.c && !vuVar.j) {
            vuVar.d((int) ((((vu) vuVar.l.get(0)).g * ((va0) this.b).t0) + 0.5f));
        }
    }

    @Override // defpackage.hx1
    public final void d() {
        jn jnVar = this.b;
        va0 va0Var = (va0) jnVar;
        int i = va0Var.u0;
        int i2 = va0Var.v0;
        int i3 = va0Var.x0;
        vu vuVar = this.h;
        if (i3 == 1) {
            if (i != -1) {
                vuVar.l.add(jnVar.U.d.h);
                this.b.U.d.h.k.add(vuVar);
                vuVar.f = i;
            } else if (i2 != -1) {
                vuVar.l.add(jnVar.U.d.i);
                this.b.U.d.i.k.add(vuVar);
                vuVar.f = -i2;
            } else {
                vuVar.b = true;
                vuVar.l.add(jnVar.U.d.i);
                this.b.U.d.i.k.add(vuVar);
            }
            m(this.b.d.h);
            m(this.b.d.i);
            return;
        }
        if (i != -1) {
            vuVar.l.add(jnVar.U.e.h);
            this.b.U.e.h.k.add(vuVar);
            vuVar.f = i;
        } else if (i2 != -1) {
            vuVar.l.add(jnVar.U.e.i);
            this.b.U.e.i.k.add(vuVar);
            vuVar.f = -i2;
        } else {
            vuVar.b = true;
            vuVar.l.add(jnVar.U.e.i);
            this.b.U.e.i.k.add(vuVar);
        }
        m(this.b.e.h);
        m(this.b.e.i);
    }

    @Override // defpackage.hx1
    public final void e() {
        jn jnVar = this.b;
        int i = ((va0) jnVar).x0;
        vu vuVar = this.h;
        if (i == 1) {
            jnVar.Z = vuVar.g;
        } else {
            jnVar.a0 = vuVar.g;
        }
    }

    @Override // defpackage.hx1
    public final void f() {
        this.h.c();
    }

    @Override // defpackage.hx1
    public final boolean k() {
        return false;
    }

    public final void m(vu vuVar) {
        vu vuVar2 = this.h;
        vuVar2.k.add(vuVar);
        vuVar.l.add(vuVar2);
    }
}
