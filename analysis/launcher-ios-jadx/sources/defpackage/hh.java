package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class hh extends hx1 {
    public final ArrayList k;
    public int l;

    public hh(jn jnVar, int i) {
        jn jnVar2;
        super(jnVar);
        this.k = new ArrayList();
        this.f = i;
        jn jnVar3 = this.b;
        jn jnVarN = jnVar3.n(i);
        while (true) {
            jn jnVar4 = jnVarN;
            jnVar2 = jnVar3;
            jnVar3 = jnVar4;
            if (jnVar3 == null) {
                break;
            } else {
                jnVarN = jnVar3.n(this.f);
            }
        }
        this.b = jnVar2;
        int i2 = this.f;
        hx1 hx1Var = i2 == 0 ? jnVar2.d : i2 == 1 ? jnVar2.e : null;
        ArrayList arrayList = this.k;
        arrayList.add(hx1Var);
        jn jnVarM = jnVar2.m(this.f);
        while (jnVarM != null) {
            int i3 = this.f;
            arrayList.add(i3 == 0 ? jnVarM.d : i3 == 1 ? jnVarM.e : null);
            jnVarM = jnVarM.m(this.f);
        }
        int size = arrayList.size();
        int i4 = 0;
        while (i4 < size) {
            Object obj = arrayList.get(i4);
            i4++;
            hx1 hx1Var2 = (hx1) obj;
            int i5 = this.f;
            if (i5 == 0) {
                hx1Var2.b.b = this;
            } else if (i5 == 1) {
                hx1Var2.b.c = this;
            }
        }
        if (this.f == 0 && ((kn) this.b.U).y0 && arrayList.size() > 1) {
            this.b = ((hx1) arrayList.get(arrayList.size() - 1)).b;
        }
        this.l = this.f == 0 ? this.b.k0 : this.b.l0;
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x015b  */
    @Override // defpackage.ru
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(defpackage.ru r30) {
        /*
            Method dump skipped, instruction units count: 962
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.hh.a(ru):void");
    }

    @Override // defpackage.hx1
    public final void d() {
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((hx1) obj).d();
        }
        int size2 = arrayList.size();
        if (size2 < 1) {
            return;
        }
        jn jnVar = ((hx1) arrayList.get(0)).b;
        jn jnVar2 = ((hx1) arrayList.get(size2 - 1)).b;
        int i2 = this.f;
        vu vuVar = this.i;
        vu vuVar2 = this.h;
        if (i2 == 0) {
            gm gmVar = jnVar.I;
            gm gmVar2 = jnVar2.K;
            vu vuVarI = hx1.i(gmVar, 0);
            int iE = gmVar.e();
            jn jnVarM = m();
            if (jnVarM != null) {
                iE = jnVarM.I.e();
            }
            if (vuVarI != null) {
                hx1.b(vuVar2, vuVarI, iE);
            }
            vu vuVarI2 = hx1.i(gmVar2, 0);
            int iE2 = gmVar2.e();
            jn jnVarN = n();
            if (jnVarN != null) {
                iE2 = jnVarN.K.e();
            }
            if (vuVarI2 != null) {
                hx1.b(vuVar, vuVarI2, -iE2);
            }
        } else {
            gm gmVar3 = jnVar.J;
            gm gmVar4 = jnVar2.L;
            vu vuVarI3 = hx1.i(gmVar3, 1);
            int iE3 = gmVar3.e();
            jn jnVarM2 = m();
            if (jnVarM2 != null) {
                iE3 = jnVarM2.J.e();
            }
            if (vuVarI3 != null) {
                hx1.b(vuVar2, vuVarI3, iE3);
            }
            vu vuVarI4 = hx1.i(gmVar4, 1);
            int iE4 = gmVar4.e();
            jn jnVarN2 = n();
            if (jnVarN2 != null) {
                iE4 = jnVarN2.L.e();
            }
            if (vuVarI4 != null) {
                hx1.b(vuVar, vuVarI4, -iE4);
            }
        }
        vuVar2.a = this;
        vuVar.a = this;
    }

    @Override // defpackage.hx1
    public final void e() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.k;
            if (i >= arrayList.size()) {
                return;
            }
            ((hx1) arrayList.get(i)).e();
            i++;
        }
    }

    @Override // defpackage.hx1
    public final void f() {
        this.c = null;
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((hx1) obj).f();
        }
    }

    @Override // defpackage.hx1
    public final long j() {
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            hx1 hx1Var = (hx1) arrayList.get(i);
            j = ((long) hx1Var.i.f) + hx1Var.j() + j + ((long) hx1Var.h.f);
        }
        return j;
    }

    @Override // defpackage.hx1
    public final boolean k() {
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (!((hx1) arrayList.get(i)).k()) {
                return false;
            }
        }
        return true;
    }

    public final jn m() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.k;
            if (i >= arrayList.size()) {
                return null;
            }
            jn jnVar = ((hx1) arrayList.get(i)).b;
            if (jnVar.h0 != 8) {
                return jnVar;
            }
            i++;
        }
    }

    public final jn n() {
        ArrayList arrayList = this.k;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            jn jnVar = ((hx1) arrayList.get(size)).b;
            if (jnVar.h0 != 8) {
                return jnVar;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("ChainRun ");
        sb.append(this.f == 0 ? "horizontal : " : "vertical : ");
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            sb.append("<");
            sb.append((hx1) obj);
            sb.append("> ");
        }
        return sb.toString();
    }
}
