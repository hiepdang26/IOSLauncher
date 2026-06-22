package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class yb0 extends hx1 {
    @Override // defpackage.ru
    public final void a(ru ruVar) {
        sa saVar = (sa) this.b;
        int i = saVar.v0;
        vu vuVar = this.h;
        ArrayList arrayList = vuVar.l;
        int size = arrayList.size();
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            int i5 = ((vu) obj).g;
            if (i4 == -1 || i5 < i4) {
                i4 = i5;
            }
            if (i2 < i5) {
                i2 = i5;
            }
        }
        if (i == 0 || i == 2) {
            vuVar.d(i4 + saVar.x0);
        } else {
            vuVar.d(i2 + saVar.x0);
        }
    }

    @Override // defpackage.hx1
    public final void d() {
        jn jnVar = this.b;
        if (jnVar instanceof sa) {
            vu vuVar = this.h;
            vuVar.b = true;
            sa saVar = (sa) jnVar;
            int i = saVar.v0;
            boolean z = saVar.w0;
            int i2 = 0;
            if (i == 0) {
                vuVar.e = 4;
                while (i2 < saVar.u0) {
                    jn jnVar2 = saVar.t0[i2];
                    if (z || jnVar2.h0 != 8) {
                        vu vuVar2 = jnVar2.d.h;
                        vuVar2.k.add(vuVar);
                        vuVar.l.add(vuVar2);
                    }
                    i2++;
                }
                m(this.b.d.h);
                m(this.b.d.i);
                return;
            }
            if (i == 1) {
                vuVar.e = 5;
                while (i2 < saVar.u0) {
                    jn jnVar3 = saVar.t0[i2];
                    if (z || jnVar3.h0 != 8) {
                        vu vuVar3 = jnVar3.d.i;
                        vuVar3.k.add(vuVar);
                        vuVar.l.add(vuVar3);
                    }
                    i2++;
                }
                m(this.b.d.h);
                m(this.b.d.i);
                return;
            }
            if (i == 2) {
                vuVar.e = 6;
                while (i2 < saVar.u0) {
                    jn jnVar4 = saVar.t0[i2];
                    if (z || jnVar4.h0 != 8) {
                        vu vuVar4 = jnVar4.e.h;
                        vuVar4.k.add(vuVar);
                        vuVar.l.add(vuVar4);
                    }
                    i2++;
                }
                m(this.b.e.h);
                m(this.b.e.i);
                return;
            }
            if (i != 3) {
                return;
            }
            vuVar.e = 7;
            while (i2 < saVar.u0) {
                jn jnVar5 = saVar.t0[i2];
                if (z || jnVar5.h0 != 8) {
                    vu vuVar5 = jnVar5.e.i;
                    vuVar5.k.add(vuVar);
                    vuVar.l.add(vuVar5);
                }
                i2++;
            }
            m(this.b.e.h);
            m(this.b.e.i);
        }
    }

    @Override // defpackage.hx1
    public final void e() {
        jn jnVar = this.b;
        if (jnVar instanceof sa) {
            int i = ((sa) jnVar).v0;
            vu vuVar = this.h;
            if (i == 0 || i == 1) {
                jnVar.Z = vuVar.g;
            } else {
                jnVar.a0 = vuVar.g;
            }
        }
    }

    @Override // defpackage.hx1
    public final void f() {
        this.c = null;
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
