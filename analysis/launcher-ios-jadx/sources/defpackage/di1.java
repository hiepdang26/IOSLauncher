package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class di1 implements Comparable {
    public boolean g;
    public float k;
    public int r;
    public int h = -1;
    public int i = -1;
    public int j = 0;
    public boolean l = false;
    public final float[] m = new float[9];
    public final float[] n = new float[9];
    public f9[] o = new f9[16];
    public int p = 0;
    public int q = 0;

    public di1(int i) {
        this.r = i;
    }

    public final void a(f9 f9Var) {
        int i = 0;
        while (true) {
            int i2 = this.p;
            if (i >= i2) {
                f9[] f9VarArr = this.o;
                if (i2 >= f9VarArr.length) {
                    this.o = (f9[]) Arrays.copyOf(f9VarArr, f9VarArr.length * 2);
                }
                f9[] f9VarArr2 = this.o;
                int i3 = this.p;
                f9VarArr2[i3] = f9Var;
                this.p = i3 + 1;
                return;
            }
            if (this.o[i] == f9Var) {
                return;
            } else {
                i++;
            }
        }
    }

    public final void b(f9 f9Var) {
        int i = this.p;
        int i2 = 0;
        while (i2 < i) {
            if (this.o[i2] == f9Var) {
                while (i2 < i - 1) {
                    f9[] f9VarArr = this.o;
                    int i3 = i2 + 1;
                    f9VarArr[i2] = f9VarArr[i3];
                    i2 = i3;
                }
                this.p--;
                return;
            }
            i2++;
        }
    }

    public final void c() {
        this.r = 5;
        this.j = 0;
        this.h = -1;
        this.i = -1;
        this.k = 0.0f;
        this.l = false;
        int i = this.p;
        for (int i2 = 0; i2 < i; i2++) {
            this.o[i2] = null;
        }
        this.p = 0;
        this.q = 0;
        this.g = false;
        Arrays.fill(this.n, 0.0f);
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.h - ((di1) obj).h;
    }

    public final void d(qn0 qn0Var, float f) {
        this.k = f;
        this.l = true;
        int i = this.p;
        this.i = -1;
        for (int i2 = 0; i2 < i; i2++) {
            this.o[i2].h(qn0Var, this, false);
        }
        this.p = 0;
    }

    public final void e(qn0 qn0Var, f9 f9Var) {
        int i = this.p;
        for (int i2 = 0; i2 < i; i2++) {
            this.o[i2].i(qn0Var, f9Var, false);
        }
        this.p = 0;
    }

    public final String toString() {
        return "" + this.h;
    }
}
