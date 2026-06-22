package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class s8 extends pq {
    public final double[] a;
    public final r8[] b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, s8] */
    public s8(int[] iArr, double[] dArr, double[][] dArr2) {
        double d;
        double d2;
        int i;
        double[] dArr3;
        double[] dArr4 = dArr;
        ?? obj = new Object();
        obj.a = dArr4;
        int i2 = 1;
        obj.b = new r8[dArr4.length - 1];
        char c = 0;
        int i3 = 0;
        int i4 = 1;
        int i5 = 1;
        s8 s8Var = obj;
        while (true) {
            r8[] r8VarArr = s8Var.b;
            if (i3 >= r8VarArr.length) {
                return;
            }
            int i6 = iArr[i3];
            if (i6 == 0) {
                i5 = 3;
            } else if (i6 == i2) {
                i4 = 1;
                i5 = 1;
            } else if (i6 == 2) {
                i4 = 2;
                i5 = 2;
            } else if (i6 == 3) {
                i4 = i4 == i2 ? 2 : 1;
                i5 = i4;
            } else if (i6 == 4) {
                i5 = 4;
            } else if (i6 == 5) {
                i5 = 5;
            }
            double d3 = dArr4[i3];
            int i7 = i3 + 1;
            double d4 = dArr4[i7];
            double[] dArr5 = dArr2[i3];
            double d5 = dArr5[c];
            int i8 = i3;
            double d6 = dArr5[1];
            double[] dArr6 = dArr2[i7];
            double d7 = dArr6[0];
            double d8 = dArr6[1];
            r8 r8Var = new r8();
            r8Var.r = false;
            int i9 = i4;
            double d9 = d7 - d5;
            double d10 = d8 - d6;
            boolean z = true;
            if (i5 != 1) {
                if (i5 == 4) {
                    r8Var.q = d10 > 0.0d;
                } else if (i5 != 5) {
                    r8Var.q = false;
                } else {
                    r8Var.q = d10 < 0.0d;
                }
                d = d9;
                d2 = d3;
                z = true;
            } else {
                r8Var.q = true;
                d = d9;
                d2 = d3;
            }
            r8Var.c = d2;
            r8Var.d = d4;
            double d11 = d4 - d2;
            double d12 = 1.0d / d11;
            r8Var.i = d12;
            if (3 == i5) {
                r8Var.r = z;
            }
            if (r8Var.r || Math.abs(d) < 0.001d || Math.abs(d10) < 0.001d) {
                i = i5;
                r8Var.r = true;
                r8Var.e = d5;
                r8Var.f = d7;
                r8Var.g = d6;
                r8Var.h = d8;
                double d13 = d;
                double dHypot = Math.hypot(d10, d13);
                r8Var.b = dHypot;
                r8Var.n = dHypot * d12;
                r8Var.l = d13 / d11;
                r8Var.m = d10 / d11;
            } else {
                r8Var.a = new double[101];
                boolean z2 = r8Var.q;
                r8Var.j = ((double) (z2 ? -1 : 1)) * d;
                r8Var.k = d10 * ((double) (z2 ? 1 : -1));
                r8Var.l = z2 ? d7 : d5;
                r8Var.m = z2 ? d6 : d8;
                double d14 = d6 - d8;
                double dHypot2 = 0.0d;
                double d15 = 0.0d;
                double d16 = 0.0d;
                int i10 = 0;
                while (true) {
                    dArr3 = r8.s;
                    if (i10 >= 91) {
                        break;
                    }
                    int i11 = i5;
                    double radians = Math.toRadians((((double) i10) * 90.0d) / ((double) 90));
                    double dSin = Math.sin(radians) * d;
                    double dCos = Math.cos(radians) * d14;
                    if (i10 > 0) {
                        dHypot2 += Math.hypot(dSin - d15, dCos - d16);
                        dArr3[i10] = dHypot2;
                    }
                    i10++;
                    d16 = dCos;
                    d15 = dSin;
                    i5 = i11;
                }
                i = i5;
                r8Var.b = dHypot2;
                for (int i12 = 0; i12 < 91; i12++) {
                    dArr3[i12] = dArr3[i12] / dHypot2;
                }
                int i13 = 0;
                while (true) {
                    double[] dArr7 = r8Var.a;
                    if (i13 >= dArr7.length) {
                        break;
                    }
                    double length = ((double) i13) / ((double) (dArr7.length - 1));
                    int iBinarySearch = Arrays.binarySearch(dArr3, length);
                    if (iBinarySearch >= 0) {
                        dArr7[i13] = ((double) iBinarySearch) / ((double) 90);
                    } else if (iBinarySearch == -1) {
                        dArr7[i13] = 0.0d;
                    } else {
                        int i14 = -iBinarySearch;
                        int i15 = i14 - 2;
                        double d17 = dArr3[i15];
                        dArr7[i13] = (((length - d17) / (dArr3[i14 - 1] - d17)) + ((double) i15)) / ((double) 90);
                    }
                    i13++;
                }
                r8Var.n = r8Var.b * r8Var.i;
            }
            r8VarArr[i8] = r8Var;
            s8Var = this;
            dArr4 = dArr;
            i3 = i7;
            i4 = i9;
            i5 = i;
            c = 0;
            i2 = 1;
        }
    }

    @Override // defpackage.pq
    public final double b(double d) {
        r8[] r8VarArr = this.b;
        r8 r8Var = r8VarArr[0];
        double d2 = r8Var.c;
        if (d < d2) {
            double d3 = d - d2;
            if (r8Var.r) {
                return (d3 * r8VarArr[0].l) + r8Var.c(d2);
            }
            r8Var.g(d2);
            return (r8VarArr[0].a() * d3) + r8VarArr[0].e();
        }
        if (d > r8VarArr[r8VarArr.length - 1].d) {
            double d4 = r8VarArr[r8VarArr.length - 1].d;
            double d5 = d - d4;
            int length = r8VarArr.length - 1;
            return (d5 * r8VarArr[length].l) + r8VarArr[length].c(d4);
        }
        for (int i = 0; i < r8VarArr.length; i++) {
            r8 r8Var2 = r8VarArr[i];
            if (d <= r8Var2.d) {
                if (r8Var2.r) {
                    return r8Var2.c(d);
                }
                r8Var2.g(d);
                return r8VarArr[i].e();
            }
        }
        return Double.NaN;
    }

    @Override // defpackage.pq
    public final void c(double d, double[] dArr) {
        r8[] r8VarArr = this.b;
        r8 r8Var = r8VarArr[0];
        double d2 = r8Var.c;
        if (d < d2) {
            double d3 = d - d2;
            if (r8Var.r) {
                double dC = r8Var.c(d2);
                r8 r8Var2 = r8VarArr[0];
                dArr[0] = (r8Var2.l * d3) + dC;
                dArr[1] = (d3 * r8VarArr[0].m) + r8Var2.d(d2);
                return;
            }
            r8Var.g(d2);
            dArr[0] = (r8VarArr[0].a() * d3) + r8VarArr[0].e();
            dArr[1] = (r8VarArr[0].b() * d3) + r8VarArr[0].f();
            return;
        }
        if (d <= r8VarArr[r8VarArr.length - 1].d) {
            for (int i = 0; i < r8VarArr.length; i++) {
                r8 r8Var3 = r8VarArr[i];
                if (d <= r8Var3.d) {
                    if (r8Var3.r) {
                        dArr[0] = r8Var3.c(d);
                        dArr[1] = r8VarArr[i].d(d);
                        return;
                    } else {
                        r8Var3.g(d);
                        dArr[0] = r8VarArr[i].e();
                        dArr[1] = r8VarArr[i].f();
                        return;
                    }
                }
            }
            return;
        }
        double d4 = r8VarArr[r8VarArr.length - 1].d;
        double d5 = d - d4;
        int length = r8VarArr.length - 1;
        r8 r8Var4 = r8VarArr[length];
        if (r8Var4.r) {
            double dC2 = r8Var4.c(d4);
            r8 r8Var5 = r8VarArr[length];
            dArr[0] = (r8Var5.l * d5) + dC2;
            dArr[1] = (d5 * r8VarArr[length].m) + r8Var5.d(d4);
            return;
        }
        r8Var4.g(d);
        dArr[0] = (r8VarArr[length].a() * d5) + r8VarArr[length].e();
        dArr[1] = (r8VarArr[length].b() * d5) + r8VarArr[length].f();
    }

    @Override // defpackage.pq
    public final void d(double d, float[] fArr) {
        r8[] r8VarArr = this.b;
        r8 r8Var = r8VarArr[0];
        double d2 = r8Var.c;
        if (d < d2) {
            double d3 = d - d2;
            if (r8Var.r) {
                double dC = r8Var.c(d2);
                r8 r8Var2 = r8VarArr[0];
                fArr[0] = (float) ((r8Var2.l * d3) + dC);
                fArr[1] = (float) ((d3 * r8VarArr[0].m) + r8Var2.d(d2));
                return;
            }
            r8Var.g(d2);
            fArr[0] = (float) ((r8VarArr[0].a() * d3) + r8VarArr[0].e());
            fArr[1] = (float) ((r8VarArr[0].b() * d3) + r8VarArr[0].f());
            return;
        }
        if (d <= r8VarArr[r8VarArr.length - 1].d) {
            for (int i = 0; i < r8VarArr.length; i++) {
                r8 r8Var3 = r8VarArr[i];
                if (d <= r8Var3.d) {
                    if (r8Var3.r) {
                        fArr[0] = (float) r8Var3.c(d);
                        fArr[1] = (float) r8VarArr[i].d(d);
                        return;
                    } else {
                        r8Var3.g(d);
                        fArr[0] = (float) r8VarArr[i].e();
                        fArr[1] = (float) r8VarArr[i].f();
                        return;
                    }
                }
            }
            return;
        }
        double d4 = r8VarArr[r8VarArr.length - 1].d;
        double d5 = d - d4;
        int length = r8VarArr.length - 1;
        r8 r8Var4 = r8VarArr[length];
        if (!r8Var4.r) {
            r8Var4.g(d);
            fArr[0] = (float) r8VarArr[length].e();
            fArr[1] = (float) r8VarArr[length].f();
        } else {
            double dC2 = r8Var4.c(d4);
            r8 r8Var5 = r8VarArr[length];
            fArr[0] = (float) ((r8Var5.l * d5) + dC2);
            fArr[1] = (float) ((d5 * r8VarArr[length].m) + r8Var5.d(d4));
        }
    }

    @Override // defpackage.pq
    public final double e(double d) {
        r8[] r8VarArr = this.b;
        double d2 = r8VarArr[0].c;
        if (d < d2) {
            d = d2;
        }
        if (d > r8VarArr[r8VarArr.length - 1].d) {
            d = r8VarArr[r8VarArr.length - 1].d;
        }
        for (int i = 0; i < r8VarArr.length; i++) {
            r8 r8Var = r8VarArr[i];
            if (d <= r8Var.d) {
                if (r8Var.r) {
                    return r8Var.l;
                }
                r8Var.g(d);
                return r8VarArr[i].a();
            }
        }
        return Double.NaN;
    }

    @Override // defpackage.pq
    public final void f(double d, double[] dArr) {
        r8[] r8VarArr = this.b;
        double d2 = r8VarArr[0].c;
        if (d < d2) {
            d = d2;
        } else if (d > r8VarArr[r8VarArr.length - 1].d) {
            d = r8VarArr[r8VarArr.length - 1].d;
        }
        for (int i = 0; i < r8VarArr.length; i++) {
            r8 r8Var = r8VarArr[i];
            if (d <= r8Var.d) {
                if (r8Var.r) {
                    dArr[0] = r8Var.l;
                    dArr[1] = r8Var.m;
                    return;
                } else {
                    r8Var.g(d);
                    dArr[0] = r8VarArr[i].a();
                    dArr[1] = r8VarArr[i].b();
                    return;
                }
            }
        }
    }

    @Override // defpackage.pq
    public final double[] g() {
        return this.a;
    }
}
