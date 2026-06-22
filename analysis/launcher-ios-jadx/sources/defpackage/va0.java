package defpackage;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes.dex */
public final class va0 extends jn {
    public float t0 = -1.0f;
    public int u0 = -1;
    public int v0 = -1;
    public gm w0 = this.J;
    public int x0 = 0;
    public boolean y0;

    public va0() {
        this.R.clear();
        this.R.add(this.w0);
        int length = this.Q.length;
        for (int i = 0; i < length; i++) {
            this.Q[i] = this.w0;
        }
    }

    @Override // defpackage.jn
    public final boolean B() {
        return this.y0;
    }

    @Override // defpackage.jn
    public final boolean C() {
        return this.y0;
    }

    @Override // defpackage.jn
    public final void P(qn0 qn0Var, boolean z) {
        if (this.U == null) {
            return;
        }
        gm gmVar = this.w0;
        qn0Var.getClass();
        int iN = qn0.n(gmVar);
        if (this.x0 == 1) {
            this.Z = iN;
            this.a0 = 0;
            K(this.U.l());
            N(0);
            return;
        }
        this.Z = 0;
        this.a0 = iN;
        N(this.U.r());
        K(0);
    }

    public final void Q(int i) {
        this.w0.l(i);
        this.y0 = true;
    }

    public final void R(int i) {
        if (this.x0 == i) {
            return;
        }
        this.x0 = i;
        ArrayList arrayList = this.R;
        arrayList.clear();
        if (this.x0 == 1) {
            this.w0 = this.I;
        } else {
            this.w0 = this.J;
        }
        arrayList.add(this.w0);
        gm[] gmVarArr = this.Q;
        int length = gmVarArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            gmVarArr[i2] = this.w0;
        }
    }

    @Override // defpackage.jn
    public final void c(qn0 qn0Var, boolean z) {
        kn knVar = (kn) this.U;
        if (knVar == null) {
            return;
        }
        Object objJ = knVar.j(2);
        Object objJ2 = knVar.j(4);
        jn jnVar = this.U;
        in inVar = in.h;
        boolean z2 = jnVar != null && jnVar.T[0] == inVar;
        if (this.x0 == 0) {
            objJ = knVar.j(3);
            objJ2 = knVar.j(5);
            jn jnVar2 = this.U;
            z2 = jnVar2 != null && jnVar2.T[1] == inVar;
        }
        if (this.y0) {
            gm gmVar = this.w0;
            if (gmVar.c) {
                di1 di1VarK = qn0Var.k(gmVar);
                qn0Var.d(di1VarK, this.w0.d());
                if (this.u0 != -1) {
                    if (z2) {
                        qn0Var.f(qn0Var.k(objJ2), di1VarK, 0, 5);
                    }
                } else if (this.v0 != -1 && z2) {
                    di1 di1VarK2 = qn0Var.k(objJ2);
                    qn0Var.f(di1VarK, qn0Var.k(objJ), 0, 5);
                    qn0Var.f(di1VarK2, di1VarK, 0, 5);
                }
                this.y0 = false;
                return;
            }
        }
        if (this.u0 != -1) {
            di1 di1VarK3 = qn0Var.k(this.w0);
            qn0Var.e(di1VarK3, qn0Var.k(objJ), this.u0, 8);
            if (z2) {
                qn0Var.f(qn0Var.k(objJ2), di1VarK3, 0, 5);
                return;
            }
            return;
        }
        if (this.v0 != -1) {
            di1 di1VarK4 = qn0Var.k(this.w0);
            di1 di1VarK5 = qn0Var.k(objJ2);
            qn0Var.e(di1VarK4, di1VarK5, -this.v0, 8);
            if (z2) {
                qn0Var.f(di1VarK4, qn0Var.k(objJ), 0, 5);
                qn0Var.f(di1VarK5, di1VarK4, 0, 5);
                return;
            }
            return;
        }
        if (this.t0 != -1.0f) {
            di1 di1VarK6 = qn0Var.k(this.w0);
            di1 di1VarK7 = qn0Var.k(objJ2);
            float f = this.t0;
            f9 f9VarL = qn0Var.l();
            f9VarL.d.g(di1VarK6, -1.0f);
            f9VarL.d.g(di1VarK7, f);
            qn0Var.c(f9VarL);
        }
    }

    @Override // defpackage.jn
    public final boolean d() {
        return true;
    }

    @Override // defpackage.jn
    public final void g(jn jnVar, HashMap map) {
        super.g(jnVar, map);
        va0 va0Var = (va0) jnVar;
        this.t0 = va0Var.t0;
        this.u0 = va0Var.u0;
        this.v0 = va0Var.v0;
        R(va0Var.x0);
    }

    @Override // defpackage.jn
    public final gm j(int i) {
        int iV = uo.v(i);
        if (iV != 1) {
            if (iV != 2) {
                if (iV != 3) {
                    if (iV != 4) {
                        return null;
                    }
                }
            }
            if (this.x0 == 0) {
                return this.w0;
            }
            return null;
        }
        if (this.x0 == 1) {
            return this.w0;
        }
        return null;
    }
}
