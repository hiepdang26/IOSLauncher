package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class l31 extends f9 {
    public di1[] f;
    public di1[] g;
    public int h;
    public oz1 i;

    @Override // defpackage.f9
    public final di1 d(boolean[] zArr) {
        int i = -1;
        for (int i2 = 0; i2 < this.h; i2++) {
            di1[] di1VarArr = this.f;
            di1 di1Var = di1VarArr[i2];
            if (!zArr[di1Var.h]) {
                oz1 oz1Var = this.i;
                oz1Var.h = di1Var;
                int i3 = 8;
                if (i == -1) {
                    while (i3 >= 0) {
                        float f = ((di1) oz1Var.h).n[i3];
                        if (f <= 0.0f) {
                            if (f < 0.0f) {
                                i = i2;
                                break;
                            }
                            i3--;
                        }
                    }
                } else {
                    di1 di1Var2 = di1VarArr[i];
                    while (true) {
                        if (i3 >= 0) {
                            float f2 = di1Var2.n[i3];
                            float f3 = ((di1) oz1Var.h).n[i3];
                            if (f3 == f2) {
                                i3--;
                            } else if (f3 < f2) {
                            }
                        }
                    }
                }
            }
        }
        if (i == -1) {
            return null;
        }
        return this.f[i];
    }

    @Override // defpackage.f9
    public final boolean e() {
        return this.h == 0;
    }

    @Override // defpackage.f9
    public final void i(qn0 qn0Var, f9 f9Var, boolean z) {
        di1 di1Var = f9Var.a;
        if (di1Var == null) {
            return;
        }
        z8 z8Var = f9Var.d;
        int iD = z8Var.d();
        for (int i = 0; i < iD; i++) {
            di1 di1VarE = z8Var.e(i);
            float f = z8Var.f(i);
            oz1 oz1Var = this.i;
            oz1Var.h = di1VarE;
            boolean z2 = di1VarE.g;
            float[] fArr = di1Var.n;
            if (z2) {
                boolean z3 = true;
                for (int i2 = 0; i2 < 9; i2++) {
                    float[] fArr2 = ((di1) oz1Var.h).n;
                    float f2 = (fArr[i2] * f) + fArr2[i2];
                    fArr2[i2] = f2;
                    if (Math.abs(f2) < 1.0E-4f) {
                        ((di1) oz1Var.h).n[i2] = 0.0f;
                    } else {
                        z3 = false;
                    }
                }
                if (z3) {
                    ((l31) oz1Var.i).k((di1) oz1Var.h);
                }
            } else {
                for (int i3 = 0; i3 < 9; i3++) {
                    float f3 = fArr[i3];
                    if (f3 != 0.0f) {
                        float f4 = f3 * f;
                        if (Math.abs(f4) < 1.0E-4f) {
                            f4 = 0.0f;
                        }
                        ((di1) oz1Var.h).n[i3] = f4;
                    } else {
                        ((di1) oz1Var.h).n[i3] = 0.0f;
                    }
                }
                j(di1VarE);
            }
            this.b = (f9Var.b * f) + this.b;
        }
        k(di1Var);
    }

    public final void j(di1 di1Var) {
        int i;
        int i2 = this.h + 1;
        di1[] di1VarArr = this.f;
        if (i2 > di1VarArr.length) {
            di1[] di1VarArr2 = (di1[]) Arrays.copyOf(di1VarArr, di1VarArr.length * 2);
            this.f = di1VarArr2;
            this.g = (di1[]) Arrays.copyOf(di1VarArr2, di1VarArr2.length * 2);
        }
        di1[] di1VarArr3 = this.f;
        int i3 = this.h;
        di1VarArr3[i3] = di1Var;
        int i4 = i3 + 1;
        this.h = i4;
        if (i4 > 1 && di1VarArr3[i3].h > di1Var.h) {
            int i5 = 0;
            while (true) {
                i = this.h;
                if (i5 >= i) {
                    break;
                }
                this.g[i5] = this.f[i5];
                i5++;
            }
            Arrays.sort(this.g, 0, i, new y4(8));
            for (int i6 = 0; i6 < this.h; i6++) {
                this.f[i6] = this.g[i6];
            }
        }
        di1Var.g = true;
        di1Var.a(this);
    }

    public final void k(di1 di1Var) {
        int i = 0;
        while (i < this.h) {
            if (this.f[i] == di1Var) {
                while (true) {
                    int i2 = this.h;
                    if (i >= i2 - 1) {
                        this.h = i2 - 1;
                        di1Var.g = false;
                        return;
                    } else {
                        di1[] di1VarArr = this.f;
                        int i3 = i + 1;
                        di1VarArr[i] = di1VarArr[i3];
                        i = i3;
                    }
                }
            } else {
                i++;
            }
        }
    }

    @Override // defpackage.f9
    public final String toString() {
        String str = " goal -> (" + this.b + ") : ";
        for (int i = 0; i < this.h; i++) {
            di1 di1Var = this.f[i];
            oz1 oz1Var = this.i;
            oz1Var.h = di1Var;
            str = str + oz1Var + " ";
        }
        return str;
    }
}
