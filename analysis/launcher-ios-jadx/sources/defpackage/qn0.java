package defpackage;

import com.google.android.gms.internal.ads.zzbbc;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class qn0 {
    public static boolean q = false;
    public final l31 d;
    public final wb2 m;
    public f9 p;
    public int a = zzbbc.zzq.zzf;
    public boolean b = false;
    public int c = 0;
    public int e = 32;
    public int f = 32;
    public boolean h = false;
    public boolean[] i = new boolean[32];
    public int j = 1;
    public int k = 0;
    public int l = 32;
    public di1[] n = new di1[zzbbc.zzq.zzf];
    public int o = 0;
    public f9[] g = new f9[32];

    public qn0() {
        s();
        wb2 wb2Var = new wb2(4, false);
        wb2Var.h = new k21();
        wb2Var.i = new k21();
        wb2Var.j = new di1[32];
        this.m = wb2Var;
        l31 l31Var = new l31(wb2Var);
        l31Var.f = new di1[128];
        l31Var.g = new di1[128];
        l31Var.h = 0;
        l31Var.i = new oz1(l31Var);
        this.d = l31Var;
        this.p = new f9(wb2Var);
    }

    public static int n(Object obj) {
        di1 di1Var = ((gm) obj).i;
        if (di1Var != null) {
            return (int) (di1Var.k + 0.5f);
        }
        return 0;
    }

    public final di1 a(int i) {
        k21 k21Var = (k21) this.m.i;
        int i2 = k21Var.b;
        Object obj = null;
        if (i2 > 0) {
            int i3 = i2 - 1;
            Object[] objArr = k21Var.a;
            Object obj2 = objArr[i3];
            objArr[i3] = null;
            k21Var.b = i3;
            obj = obj2;
        }
        di1 di1Var = (di1) obj;
        if (di1Var == null) {
            di1Var = new di1(i);
            di1Var.r = i;
        } else {
            di1Var.c();
            di1Var.r = i;
        }
        int i4 = this.o;
        int i5 = this.a;
        if (i4 >= i5) {
            int i6 = i5 * 2;
            this.a = i6;
            this.n = (di1[]) Arrays.copyOf(this.n, i6);
        }
        di1[] di1VarArr = this.n;
        int i7 = this.o;
        this.o = i7 + 1;
        di1VarArr[i7] = di1Var;
        return di1Var;
    }

    public final void b(di1 di1Var, di1 di1Var2, int i, float f, di1 di1Var3, di1 di1Var4, int i2, int i3) {
        f9 f9VarL = l();
        if (di1Var2 == di1Var3) {
            f9VarL.d.g(di1Var, 1.0f);
            f9VarL.d.g(di1Var4, 1.0f);
            f9VarL.d.g(di1Var2, -2.0f);
        } else if (f == 0.5f) {
            f9VarL.d.g(di1Var, 1.0f);
            f9VarL.d.g(di1Var2, -1.0f);
            f9VarL.d.g(di1Var3, -1.0f);
            f9VarL.d.g(di1Var4, 1.0f);
            if (i > 0 || i2 > 0) {
                f9VarL.b = (-i) + i2;
            }
        } else if (f <= 0.0f) {
            f9VarL.d.g(di1Var, -1.0f);
            f9VarL.d.g(di1Var2, 1.0f);
            f9VarL.b = i;
        } else if (f >= 1.0f) {
            f9VarL.d.g(di1Var4, -1.0f);
            f9VarL.d.g(di1Var3, 1.0f);
            f9VarL.b = -i2;
        } else {
            float f2 = 1.0f - f;
            f9VarL.d.g(di1Var, f2 * 1.0f);
            f9VarL.d.g(di1Var2, f2 * (-1.0f));
            f9VarL.d.g(di1Var3, (-1.0f) * f);
            f9VarL.d.g(di1Var4, 1.0f * f);
            if (i > 0 || i2 > 0) {
                f9VarL.b = (i2 * f) + ((-i) * f2);
            }
        }
        if (i3 != 8) {
            f9VarL.a(this, i3);
        }
        c(f9VarL);
    }

    /* JADX WARN: Removed duplicated region for block: B:121:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:159:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00fe  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(defpackage.f9 r18) {
        /*
            Method dump skipped, instruction units count: 459
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qn0.c(f9):void");
    }

    public final void d(di1 di1Var, int i) {
        int i2 = di1Var.i;
        if (i2 == -1) {
            di1Var.d(this, i);
            for (int i3 = 0; i3 < this.c + 1; i3++) {
                di1 di1Var2 = ((di1[]) this.m.j)[i3];
            }
            return;
        }
        if (i2 == -1) {
            f9 f9VarL = l();
            f9VarL.a = di1Var;
            float f = i;
            di1Var.k = f;
            f9VarL.b = f;
            f9VarL.e = true;
            c(f9VarL);
            return;
        }
        f9 f9Var = this.g[i2];
        if (f9Var.e) {
            f9Var.b = i;
            return;
        }
        if (f9Var.d.d() == 0) {
            f9Var.e = true;
            f9Var.b = i;
            return;
        }
        f9 f9VarL2 = l();
        if (i < 0) {
            f9VarL2.b = i * (-1);
            f9VarL2.d.g(di1Var, 1.0f);
        } else {
            f9VarL2.b = i;
            f9VarL2.d.g(di1Var, -1.0f);
        }
        c(f9VarL2);
    }

    public final void e(di1 di1Var, di1 di1Var2, int i, int i2) {
        if (i2 == 8 && di1Var2.l && di1Var.i == -1) {
            di1Var.d(this, di1Var2.k + i);
            return;
        }
        f9 f9VarL = l();
        boolean z = false;
        if (i != 0) {
            if (i < 0) {
                i *= -1;
                z = true;
            }
            f9VarL.b = i;
        }
        if (z) {
            f9VarL.d.g(di1Var, 1.0f);
            f9VarL.d.g(di1Var2, -1.0f);
        } else {
            f9VarL.d.g(di1Var, -1.0f);
            f9VarL.d.g(di1Var2, 1.0f);
        }
        if (i2 != 8) {
            f9VarL.a(this, i2);
        }
        c(f9VarL);
    }

    public final void f(di1 di1Var, di1 di1Var2, int i, int i2) {
        f9 f9VarL = l();
        di1 di1VarM = m();
        di1VarM.j = 0;
        f9VarL.b(di1Var, di1Var2, di1VarM, i);
        if (i2 != 8) {
            f9VarL.d.g(j(i2), (int) (f9VarL.d.c(di1VarM) * (-1.0f)));
        }
        c(f9VarL);
    }

    public final void g(di1 di1Var, di1 di1Var2, int i, int i2) {
        f9 f9VarL = l();
        di1 di1VarM = m();
        di1VarM.j = 0;
        f9VarL.c(di1Var, di1Var2, di1VarM, i);
        if (i2 != 8) {
            f9VarL.d.g(j(i2), (int) (f9VarL.d.c(di1VarM) * (-1.0f)));
        }
        c(f9VarL);
    }

    public final void h(f9 f9Var) {
        int i;
        if (f9Var.e) {
            f9Var.a.d(this, f9Var.b);
        } else {
            f9[] f9VarArr = this.g;
            int i2 = this.k;
            f9VarArr[i2] = f9Var;
            di1 di1Var = f9Var.a;
            di1Var.i = i2;
            this.k = i2 + 1;
            di1Var.e(this, f9Var);
        }
        if (this.b) {
            int i3 = 0;
            while (i3 < this.k) {
                if (this.g[i3] == null) {
                    System.out.println("WTF");
                }
                f9 f9Var2 = this.g[i3];
                if (f9Var2 != null && f9Var2.e) {
                    f9Var2.a.d(this, f9Var2.b);
                    ((k21) this.m.h).b(f9Var2);
                    this.g[i3] = null;
                    int i4 = i3 + 1;
                    int i5 = i4;
                    while (true) {
                        i = this.k;
                        if (i4 >= i) {
                            break;
                        }
                        f9[] f9VarArr2 = this.g;
                        int i6 = i4 - 1;
                        f9 f9Var3 = f9VarArr2[i4];
                        f9VarArr2[i6] = f9Var3;
                        di1 di1Var2 = f9Var3.a;
                        if (di1Var2.i == i4) {
                            di1Var2.i = i6;
                        }
                        i5 = i4;
                        i4++;
                    }
                    if (i5 < i) {
                        this.g[i5] = null;
                    }
                    this.k = i - 1;
                    i3--;
                }
                i3++;
            }
            this.b = false;
        }
    }

    public final void i() {
        for (int i = 0; i < this.k; i++) {
            f9 f9Var = this.g[i];
            f9Var.a.k = f9Var.b;
        }
    }

    public final di1 j(int i) {
        if (this.j + 1 >= this.f) {
            o();
        }
        di1 di1VarA = a(4);
        int i2 = this.c + 1;
        this.c = i2;
        this.j++;
        di1VarA.h = i2;
        di1VarA.j = i;
        ((di1[]) this.m.j)[i2] = di1VarA;
        l31 l31Var = this.d;
        l31Var.i.h = di1VarA;
        float[] fArr = di1VarA.n;
        Arrays.fill(fArr, 0.0f);
        fArr[di1VarA.j] = 1.0f;
        l31Var.j(di1VarA);
        return di1VarA;
    }

    public final di1 k(Object obj) {
        if (obj == null) {
            return null;
        }
        if (this.j + 1 >= this.f) {
            o();
        }
        if (!(obj instanceof gm)) {
            return null;
        }
        gm gmVar = (gm) obj;
        di1 di1Var = gmVar.i;
        if (di1Var == null) {
            gmVar.k();
            di1Var = gmVar.i;
        }
        int i = di1Var.h;
        wb2 wb2Var = this.m;
        if (i != -1 && i <= this.c && ((di1[]) wb2Var.j)[i] != null) {
            return di1Var;
        }
        if (i != -1) {
            di1Var.c();
        }
        int i2 = this.c + 1;
        this.c = i2;
        this.j++;
        di1Var.h = i2;
        di1Var.r = 1;
        ((di1[]) wb2Var.j)[i2] = di1Var;
        return di1Var;
    }

    public final f9 l() {
        Object obj;
        wb2 wb2Var = this.m;
        k21 k21Var = (k21) wb2Var.h;
        int i = k21Var.b;
        if (i > 0) {
            int i2 = i - 1;
            Object[] objArr = k21Var.a;
            obj = objArr[i2];
            objArr[i2] = null;
            k21Var.b = i2;
        } else {
            obj = null;
        }
        f9 f9Var = (f9) obj;
        if (f9Var == null) {
            return new f9(wb2Var);
        }
        f9Var.a = null;
        f9Var.d.b();
        f9Var.b = 0.0f;
        f9Var.e = false;
        return f9Var;
    }

    public final di1 m() {
        if (this.j + 1 >= this.f) {
            o();
        }
        di1 di1VarA = a(3);
        int i = this.c + 1;
        this.c = i;
        this.j++;
        di1VarA.h = i;
        ((di1[]) this.m.j)[i] = di1VarA;
        return di1VarA;
    }

    public final void o() {
        int i = this.e * 2;
        this.e = i;
        this.g = (f9[]) Arrays.copyOf(this.g, i);
        wb2 wb2Var = this.m;
        wb2Var.j = (di1[]) Arrays.copyOf((di1[]) wb2Var.j, this.e);
        int i2 = this.e;
        this.i = new boolean[i2];
        this.f = i2;
        this.l = i2;
    }

    public final void p() {
        l31 l31Var = this.d;
        if (l31Var.e()) {
            i();
            return;
        }
        if (!this.h) {
            q(l31Var);
            return;
        }
        for (int i = 0; i < this.k; i++) {
            if (!this.g[i].e) {
                q(l31Var);
                return;
            }
        }
        i();
    }

    public final void q(l31 l31Var) {
        int i = 0;
        while (true) {
            if (i >= this.k) {
                break;
            }
            f9 f9Var = this.g[i];
            int i2 = 1;
            if (f9Var.a.r != 1) {
                float f = 0.0f;
                if (f9Var.b < 0.0f) {
                    boolean z = false;
                    int i3 = 0;
                    while (!z) {
                        i3 += i2;
                        float f2 = Float.MAX_VALUE;
                        int i4 = 0;
                        int i5 = -1;
                        int i6 = -1;
                        int i7 = 0;
                        while (i4 < this.k) {
                            f9 f9Var2 = this.g[i4];
                            if (f9Var2.a.r != i2 && !f9Var2.e && f9Var2.b < f) {
                                int iD = f9Var2.d.d();
                                int i8 = 0;
                                while (i8 < iD) {
                                    di1 di1VarE = f9Var2.d.e(i8);
                                    float fC = f9Var2.d.c(di1VarE);
                                    if (fC > f) {
                                        for (int i9 = 0; i9 < 9; i9++) {
                                            float f3 = di1VarE.m[i9] / fC;
                                            if ((f3 < f2 && i9 == i7) || i9 > i7) {
                                                i7 = i9;
                                                i6 = di1VarE.h;
                                                i5 = i4;
                                                f2 = f3;
                                            }
                                        }
                                    }
                                    i8++;
                                    f = 0.0f;
                                }
                            }
                            i4++;
                            f = 0.0f;
                            i2 = 1;
                        }
                        if (i5 != -1) {
                            f9 f9Var3 = this.g[i5];
                            f9Var3.a.i = -1;
                            f9Var3.g(((di1[]) this.m.j)[i6]);
                            di1 di1Var = f9Var3.a;
                            di1Var.i = i5;
                            di1Var.e(this, f9Var3);
                        } else {
                            z = true;
                        }
                        if (i3 > this.j / 2) {
                            z = true;
                        }
                        f = 0.0f;
                        i2 = 1;
                    }
                }
            }
            i++;
        }
        r(l31Var);
        i();
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0092 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(defpackage.f9 r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r2 = 0
            r3 = 0
        L6:
            int r4 = r0.j
            if (r3 >= r4) goto L11
            boolean[] r4 = r0.i
            r4[r3] = r2
            int r3 = r3 + 1
            goto L6
        L11:
            r3 = 0
            r4 = 0
        L13:
            if (r3 != 0) goto Lb0
            r5 = 1
            int r4 = r4 + r5
            int r6 = r0.j
            int r6 = r6 * 2
            if (r4 < r6) goto L1f
            goto Lb0
        L1f:
            di1 r6 = r1.a
            if (r6 == 0) goto L29
            boolean[] r7 = r0.i
            int r6 = r6.h
            r7[r6] = r5
        L29:
            boolean[] r6 = r0.i
            di1 r6 = r1.d(r6)
            if (r6 == 0) goto L3d
            boolean[] r7 = r0.i
            int r8 = r6.h
            boolean r9 = r7[r8]
            if (r9 == 0) goto L3b
            goto Lb0
        L3b:
            r7[r8] = r5
        L3d:
            if (r6 == 0) goto Lac
            r7 = -1
            r8 = 2139095039(0x7f7fffff, float:3.4028235E38)
            r9 = 0
            r10 = -1
        L45:
            int r11 = r0.k
            if (r9 >= r11) goto L97
            f9[] r11 = r0.g
            r11 = r11[r9]
            di1 r12 = r11.a
            int r12 = r12.r
            if (r12 != r5) goto L54
            goto L92
        L54:
            boolean r12 = r11.e
            if (r12 == 0) goto L59
            goto L92
        L59:
            z8 r12 = r11.d
            int r13 = r12.h
            r15 = -1
            if (r13 != r15) goto L61
            goto L7a
        L61:
            r2 = 0
        L62:
            if (r13 == r15) goto L7a
            int r5 = r12.a
            if (r2 >= r5) goto L7a
            int[] r5 = r12.e
            r5 = r5[r13]
            int r14 = r6.h
            if (r5 != r14) goto L72
            r14 = 1
            goto L7b
        L72:
            int[] r5 = r12.f
            r13 = r5[r13]
            int r2 = r2 + 1
            r5 = 1
            goto L62
        L7a:
            r14 = 0
        L7b:
            if (r14 == 0) goto L92
            z8 r2 = r11.d
            float r2 = r2.c(r6)
            r5 = 0
            int r5 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r5 >= 0) goto L92
            float r5 = r11.b
            float r5 = -r5
            float r5 = r5 / r2
            int r2 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r2 >= 0) goto L92
            r8 = r5
            r10 = r9
        L92:
            int r9 = r9 + 1
            r2 = 0
            r5 = 1
            goto L45
        L97:
            if (r10 <= r7) goto Lad
            f9[] r2 = r0.g
            r2 = r2[r10]
            di1 r5 = r2.a
            r5.i = r7
            r2.g(r6)
            di1 r5 = r2.a
            r5.i = r10
            r5.e(r0, r2)
            goto Lad
        Lac:
            r3 = 1
        Lad:
            r2 = 0
            goto L13
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.qn0.r(f9):void");
    }

    public final void s() {
        for (int i = 0; i < this.k; i++) {
            f9 f9Var = this.g[i];
            if (f9Var != null) {
                ((k21) this.m.h).b(f9Var);
            }
            this.g[i] = null;
        }
    }

    public final void t() {
        wb2 wb2Var;
        int i = 0;
        while (true) {
            wb2Var = this.m;
            di1[] di1VarArr = (di1[]) wb2Var.j;
            if (i >= di1VarArr.length) {
                break;
            }
            di1 di1Var = di1VarArr[i];
            if (di1Var != null) {
                di1Var.c();
            }
            i++;
        }
        k21 k21Var = (k21) wb2Var.i;
        di1[] di1VarArr2 = this.n;
        int length = this.o;
        k21Var.getClass();
        if (length > di1VarArr2.length) {
            length = di1VarArr2.length;
        }
        for (int i2 = 0; i2 < length; i2++) {
            di1 di1Var2 = di1VarArr2[i2];
            int i3 = k21Var.b;
            Object[] objArr = k21Var.a;
            if (i3 < objArr.length) {
                objArr[i3] = di1Var2;
                k21Var.b = i3 + 1;
            }
        }
        this.o = 0;
        Arrays.fill((di1[]) wb2Var.j, (Object) null);
        this.c = 0;
        l31 l31Var = this.d;
        l31Var.h = 0;
        l31Var.b = 0.0f;
        this.j = 1;
        for (int i4 = 0; i4 < this.k; i4++) {
            f9 f9Var = this.g[i4];
        }
        s();
        this.k = 0;
        this.p = new f9(wb2Var);
    }
}
