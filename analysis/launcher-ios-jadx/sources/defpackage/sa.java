package defpackage;

import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class sa extends zb0 {
    public int v0 = 0;
    public boolean w0 = true;
    public int x0 = 0;
    public boolean y0 = false;

    @Override // defpackage.jn
    public final boolean B() {
        return this.y0;
    }

    @Override // defpackage.jn
    public final boolean C() {
        return this.y0;
    }

    public final boolean S() {
        int i;
        int i2;
        int i3;
        int i4 = 0;
        boolean z = true;
        while (true) {
            i = this.u0;
            if (i4 >= i) {
                break;
            }
            jn jnVar = this.t0[i4];
            if ((this.w0 || jnVar.d()) && ((((i2 = this.v0) == 0 || i2 == 1) && !jnVar.B()) || (((i3 = this.v0) == 2 || i3 == 3) && !jnVar.C()))) {
                z = false;
            }
            i4++;
        }
        if (!z || i <= 0) {
            return false;
        }
        int iMax = 0;
        boolean z2 = false;
        for (int i5 = 0; i5 < this.u0; i5++) {
            jn jnVar2 = this.t0[i5];
            if (this.w0 || jnVar2.d()) {
                if (!z2) {
                    int i6 = this.v0;
                    if (i6 == 0) {
                        iMax = jnVar2.j(2).d();
                    } else if (i6 == 1) {
                        iMax = jnVar2.j(4).d();
                    } else if (i6 == 2) {
                        iMax = jnVar2.j(3).d();
                    } else if (i6 == 3) {
                        iMax = jnVar2.j(5).d();
                    }
                    z2 = true;
                }
                int i7 = this.v0;
                if (i7 == 0) {
                    iMax = Math.min(iMax, jnVar2.j(2).d());
                } else if (i7 == 1) {
                    iMax = Math.max(iMax, jnVar2.j(4).d());
                } else if (i7 == 2) {
                    iMax = Math.min(iMax, jnVar2.j(3).d());
                } else if (i7 == 3) {
                    iMax = Math.max(iMax, jnVar2.j(5).d());
                }
            }
        }
        int i8 = iMax + this.x0;
        int i9 = this.v0;
        if (i9 == 0 || i9 == 1) {
            I(i8, i8);
        } else {
            J(i8, i8);
        }
        this.y0 = true;
        return true;
    }

    public final int T() {
        int i = this.v0;
        if (i == 0 || i == 1) {
            return 0;
        }
        return (i == 2 || i == 3) ? 1 : -1;
    }

    @Override // defpackage.jn
    public final void c(qn0 qn0Var, boolean z) {
        boolean z2;
        int i;
        gm[] gmVarArr = this.Q;
        gm gmVar = this.I;
        gmVarArr[0] = gmVar;
        gm gmVar2 = this.J;
        int i2 = 2;
        gmVarArr[2] = gmVar2;
        gm gmVar3 = this.K;
        gmVarArr[1] = gmVar3;
        gm gmVar4 = this.L;
        gmVarArr[3] = gmVar4;
        for (gm gmVar5 : gmVarArr) {
            gmVar5.i = qn0Var.k(gmVar5);
        }
        int i3 = this.v0;
        if (i3 < 0 || i3 >= 4) {
            return;
        }
        gm gmVar6 = gmVarArr[i3];
        if (!this.y0) {
            S();
        }
        if (this.y0) {
            this.y0 = false;
            int i4 = this.v0;
            if (i4 == 0 || i4 == 1) {
                qn0Var.d(gmVar.i, this.Z);
                qn0Var.d(gmVar3.i, this.Z);
                return;
            } else {
                if (i4 == 2 || i4 == 3) {
                    qn0Var.d(gmVar2.i, this.a0);
                    qn0Var.d(gmVar4.i, this.a0);
                    return;
                }
                return;
            }
        }
        for (int i5 = 0; i5 < this.u0; i5++) {
            jn jnVar = this.t0[i5];
            if (this.w0 || jnVar.d()) {
                int i6 = this.v0;
                in inVar = in.i;
                if (((i6 == 0 || i6 == 1) && jnVar.T[0] == inVar && jnVar.I.f != null && jnVar.K.f != null) || ((i6 == 2 || i6 == 3) && jnVar.T[1] == inVar && jnVar.J.f != null && jnVar.L.f != null)) {
                    z2 = true;
                    break;
                }
            }
        }
        z2 = false;
        boolean z3 = gmVar.g() || gmVar3.g();
        boolean z4 = gmVar2.g() || gmVar4.g();
        int i7 = (z2 || !(((i = this.v0) == 0 && z3) || ((i == 2 && z4) || ((i == 1 && z3) || (i == 3 && z4))))) ? 4 : 5;
        int i8 = 0;
        while (i8 < this.u0) {
            jn jnVar2 = this.t0[i8];
            if (this.w0 || jnVar2.d()) {
                di1 di1VarK = qn0Var.k(jnVar2.Q[this.v0]);
                int i9 = this.v0;
                gm gmVar7 = jnVar2.Q[i9];
                gmVar7.i = di1VarK;
                gm gmVar8 = gmVar7.f;
                int i10 = (gmVar8 == null || gmVar8.d != this) ? 0 : gmVar7.g;
                if (i9 == 0 || i9 == i2) {
                    di1 di1Var = gmVar6.i;
                    int i11 = this.x0 - i10;
                    f9 f9VarL = qn0Var.l();
                    di1 di1VarM = qn0Var.m();
                    di1VarM.j = 0;
                    f9VarL.c(di1Var, di1VarK, di1VarM, i11);
                    qn0Var.c(f9VarL);
                } else {
                    di1 di1Var2 = gmVar6.i;
                    int i12 = this.x0 + i10;
                    f9 f9VarL2 = qn0Var.l();
                    di1 di1VarM2 = qn0Var.m();
                    di1VarM2.j = 0;
                    f9VarL2.b(di1Var2, di1VarK, di1VarM2, i12);
                    qn0Var.c(f9VarL2);
                }
                qn0Var.e(gmVar6.i, di1VarK, this.x0 + i10, i7);
            }
            i8++;
            i2 = 2;
        }
        int i13 = this.v0;
        if (i13 == 0) {
            qn0Var.e(gmVar3.i, gmVar.i, 0, 8);
            qn0Var.e(gmVar.i, this.U.K.i, 0, 4);
            qn0Var.e(gmVar.i, this.U.I.i, 0, 0);
            return;
        }
        if (i13 == 1) {
            qn0Var.e(gmVar.i, gmVar3.i, 0, 8);
            qn0Var.e(gmVar.i, this.U.I.i, 0, 4);
            qn0Var.e(gmVar.i, this.U.K.i, 0, 0);
        } else if (i13 == 2) {
            qn0Var.e(gmVar4.i, gmVar2.i, 0, 8);
            qn0Var.e(gmVar2.i, this.U.L.i, 0, 4);
            qn0Var.e(gmVar2.i, this.U.J.i, 0, 0);
        } else if (i13 == 3) {
            qn0Var.e(gmVar2.i, gmVar4.i, 0, 8);
            qn0Var.e(gmVar2.i, this.U.J.i, 0, 4);
            qn0Var.e(gmVar2.i, this.U.L.i, 0, 0);
        }
    }

    @Override // defpackage.jn
    public final boolean d() {
        return true;
    }

    @Override // defpackage.zb0, defpackage.jn
    public final void g(jn jnVar, HashMap map) {
        super.g(jnVar, map);
        sa saVar = (sa) jnVar;
        this.v0 = saVar.v0;
        this.w0 = saVar.w0;
        this.x0 = saVar.x0;
    }

    @Override // defpackage.jn
    public final String toString() {
        String strK = uo.k(new StringBuilder("[Barrier] "), this.j0, " {");
        for (int i = 0; i < this.u0; i++) {
            jn jnVar = this.t0[i];
            if (i > 0) {
                strK = uo.h(strK, ", ");
            }
            StringBuilder sbM = uo.m(strK);
            sbM.append(jnVar.j0);
            strK = sbM.toString();
        }
        return uo.h(strK, "}");
    }
}
