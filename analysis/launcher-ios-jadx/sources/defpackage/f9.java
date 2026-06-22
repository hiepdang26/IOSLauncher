package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class f9 {
    public final z8 d;
    public di1 a = null;
    public float b = 0.0f;
    public final ArrayList c = new ArrayList();
    public boolean e = false;

    public f9(wb2 wb2Var) {
        this.d = new z8(this, wb2Var);
    }

    public final void a(qn0 qn0Var, int i) {
        this.d.g(qn0Var.j(i), 1.0f);
        this.d.g(qn0Var.j(i), -1.0f);
    }

    public final void b(di1 di1Var, di1 di1Var2, di1 di1Var3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (z) {
            this.d.g(di1Var, 1.0f);
            this.d.g(di1Var2, -1.0f);
            this.d.g(di1Var3, -1.0f);
        } else {
            this.d.g(di1Var, -1.0f);
            this.d.g(di1Var2, 1.0f);
            this.d.g(di1Var3, 1.0f);
        }
    }

    public final void c(di1 di1Var, di1 di1Var2, di1 di1Var3, int i) {
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            this.b = i;
        }
        if (z) {
            this.d.g(di1Var, 1.0f);
            this.d.g(di1Var2, -1.0f);
            this.d.g(di1Var3, 1.0f);
        } else {
            this.d.g(di1Var, -1.0f);
            this.d.g(di1Var2, 1.0f);
            this.d.g(di1Var3, -1.0f);
        }
    }

    public di1 d(boolean[] zArr) {
        return f(zArr, null);
    }

    public boolean e() {
        return this.a == null && this.b == 0.0f && this.d.d() == 0;
    }

    public final di1 f(boolean[] zArr, di1 di1Var) {
        int i;
        int iD = this.d.d();
        di1 di1Var2 = null;
        float f = 0.0f;
        for (int i2 = 0; i2 < iD; i2++) {
            float f2 = this.d.f(i2);
            if (f2 < 0.0f) {
                di1 di1VarE = this.d.e(i2);
                if ((zArr == null || !zArr[di1VarE.h]) && di1VarE != di1Var && (((i = di1VarE.r) == 3 || i == 4) && f2 < f)) {
                    f = f2;
                    di1Var2 = di1VarE;
                }
            }
        }
        return di1Var2;
    }

    public final void g(di1 di1Var) {
        di1 di1Var2 = this.a;
        if (di1Var2 != null) {
            this.d.g(di1Var2, -1.0f);
            this.a.i = -1;
            this.a = null;
        }
        float fH = this.d.h(di1Var, true) * (-1.0f);
        this.a = di1Var;
        if (fH == 1.0f) {
            return;
        }
        this.b /= fH;
        z8 z8Var = this.d;
        int i = z8Var.h;
        for (int i2 = 0; i != -1 && i2 < z8Var.a; i2++) {
            float[] fArr = z8Var.g;
            fArr[i] = fArr[i] / fH;
            i = z8Var.f[i];
        }
    }

    public final void h(qn0 qn0Var, di1 di1Var, boolean z) {
        if (di1Var == null || !di1Var.l) {
            return;
        }
        float fC = this.d.c(di1Var);
        this.b = (di1Var.k * fC) + this.b;
        this.d.h(di1Var, z);
        if (z) {
            di1Var.b(this);
        }
        if (this.d.d() == 0) {
            this.e = true;
            qn0Var.b = true;
        }
    }

    public void i(qn0 qn0Var, f9 f9Var, boolean z) {
        z8 z8Var = this.d;
        z8Var.getClass();
        float fC = z8Var.c(f9Var.a);
        z8Var.h(f9Var.a, z);
        z8 z8Var2 = f9Var.d;
        int iD = z8Var2.d();
        for (int i = 0; i < iD; i++) {
            di1 di1VarE = z8Var2.e(i);
            z8Var.a(di1VarE, z8Var2.c(di1VarE) * fC, z);
        }
        this.b = (f9Var.b * fC) + this.b;
        if (z) {
            f9Var.a.b(this);
        }
        if (this.a == null || this.d.d() != 0) {
            return;
        }
        this.e = true;
        qn0Var.b = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r10 = this;
            di1 r0 = r10.a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            di1 r1 = r10.a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = defpackage.uo.h(r0, r1)
            float r1 = r10.b
            r2 = 1
            r3 = 0
            r4 = 0
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 == 0) goto L35
            java.lang.StringBuilder r0 = defpackage.uo.m(r0)
            float r1 = r10.b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = 1
            goto L36
        L35:
            r1 = 0
        L36:
            z8 r5 = r10.d
            int r5 = r5.d()
        L3c:
            if (r3 >= r5) goto L9d
            z8 r6 = r10.d
            di1 r6 = r6.e(r3)
            if (r6 != 0) goto L47
            goto L9a
        L47:
            z8 r7 = r10.d
            float r7 = r7.f(r3)
            int r8 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r8 != 0) goto L52
            goto L9a
        L52:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L67
            int r1 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r1 >= 0) goto L77
            java.lang.String r1 = "- "
            java.lang.String r0 = defpackage.uo.h(r0, r1)
        L64:
            float r7 = r7 * r9
            goto L77
        L67:
            if (r8 <= 0) goto L70
            java.lang.String r1 = " + "
            java.lang.String r0 = defpackage.uo.h(r0, r1)
            goto L77
        L70:
            java.lang.String r1 = " - "
            java.lang.String r0 = defpackage.uo.h(r0, r1)
            goto L64
        L77:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L82
            java.lang.String r0 = defpackage.uo.h(r0, r6)
            goto L99
        L82:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L99:
            r1 = 1
        L9a:
            int r3 = r3 + 1
            goto L3c
        L9d:
            if (r1 != 0) goto La5
            java.lang.String r1 = "0.0"
            java.lang.String r0 = defpackage.uo.h(r0, r1)
        La5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.f9.toString():java.lang.String");
    }
}
