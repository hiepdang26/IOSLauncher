package defpackage;

import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class cf1 extends df {
    public final transient byte[][] l;
    public final transient int[] m;

    public cf1(fe feVar, int i) {
        super(null);
        xq1.a(feVar.h, 0L, i);
        ze1 ze1Var = feVar.g;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = ze1Var.c;
            int i6 = ze1Var.b;
            if (i5 == i6) {
                throw new AssertionError("s.limit == s.pos");
            }
            i3 += i5 - i6;
            i4++;
            ze1Var = ze1Var.f;
        }
        this.l = new byte[i4][];
        this.m = new int[i4 * 2];
        ze1 ze1Var2 = feVar.g;
        int i7 = 0;
        while (i2 < i) {
            byte[][] bArr = this.l;
            bArr[i7] = ze1Var2.a;
            int i8 = ze1Var2.c;
            int i9 = ze1Var2.b;
            int i10 = (i8 - i9) + i2;
            i2 = i10 > i ? i : i10;
            int[] iArr = this.m;
            iArr[i7] = i2;
            iArr[bArr.length + i7] = i9;
            ze1Var2.d = true;
            i7++;
            ze1Var2 = ze1Var2.f;
        }
    }

    @Override // defpackage.df
    public final byte d(int i) {
        byte[][] bArr = this.l;
        int length = bArr.length - 1;
        int[] iArr = this.m;
        xq1.a(iArr[length], i, 1L);
        int iN = n(i);
        return bArr[iN][(i - (iN == 0 ? 0 : iArr[iN - 1])) + iArr[bArr.length + iN]];
    }

    @Override // defpackage.df
    public final String e() {
        return o().e();
    }

    @Override // defpackage.df
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof df)) {
            return false;
        }
        df dfVar = (df) obj;
        return dfVar.i() == i() && h(dfVar, i());
    }

    @Override // defpackage.df
    public final boolean g(int i, byte[] bArr, int i2, int i3) {
        if (i >= 0 && i <= i() - i3 && i2 >= 0 && i2 <= bArr.length - i3) {
            int iN = n(i);
            while (i3 > 0) {
                int[] iArr = this.m;
                int i4 = iN == 0 ? 0 : iArr[iN - 1];
                int iMin = Math.min(i3, ((iArr[iN] - i4) + i4) - i);
                byte[][] bArr2 = this.l;
                int i5 = (i - i4) + iArr[bArr2.length + iN];
                byte[] bArr3 = bArr2[iN];
                Charset charset = xq1.a;
                for (int i6 = 0; i6 < iMin; i6++) {
                    if (bArr3[i6 + i5] == bArr[i6 + i2]) {
                    }
                }
                i += iMin;
                i2 += iMin;
                i3 -= iMin;
                iN++;
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.df
    public final boolean h(df dfVar, int i) {
        if (i() - i >= 0) {
            int iN = n(0);
            int i2 = 0;
            int i3 = 0;
            while (i > 0) {
                int[] iArr = this.m;
                int i4 = iN == 0 ? 0 : iArr[iN - 1];
                int iMin = Math.min(i, ((iArr[iN] - i4) + i4) - i2);
                byte[][] bArr = this.l;
                if (dfVar.g(i3, bArr[iN], (i2 - i4) + iArr[bArr.length + iN], iMin)) {
                    i2 += iMin;
                    i3 += iMin;
                    i -= iMin;
                    iN++;
                }
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.df
    public final int hashCode() {
        int i = this.h;
        if (i != 0) {
            return i;
        }
        byte[][] bArr = this.l;
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 1;
        while (i2 < length) {
            byte[] bArr2 = bArr[i2];
            int[] iArr = this.m;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            int i7 = (i6 - i3) + i5;
            while (i5 < i7) {
                i4 = (i4 * 31) + bArr2[i5];
                i5++;
            }
            i2++;
            i3 = i6;
        }
        this.h = i4;
        return i4;
    }

    @Override // defpackage.df
    public final int i() {
        return this.m[this.l.length - 1];
    }

    @Override // defpackage.df
    public final df j() {
        return o().j();
    }

    @Override // defpackage.df
    public final df k() {
        return o().k();
    }

    @Override // defpackage.df
    public final String l() {
        return o().l();
    }

    @Override // defpackage.df
    public final void m(fe feVar) {
        byte[][] bArr = this.l;
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.m;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            ze1 ze1Var = new ze1(bArr[i], i3, (i3 + i4) - i2);
            ze1 ze1Var2 = feVar.g;
            if (ze1Var2 == null) {
                ze1Var.g = ze1Var;
                ze1Var.f = ze1Var;
                feVar.g = ze1Var;
            } else {
                ze1Var2.g.b(ze1Var);
            }
            i++;
            i2 = i4;
        }
        feVar.h += (long) i2;
    }

    public final int n(int i) {
        int iBinarySearch = Arrays.binarySearch(this.m, 0, this.l.length, i + 1);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    public final df o() {
        byte[][] bArr = this.l;
        int length = bArr.length - 1;
        int[] iArr = this.m;
        byte[] bArr2 = new byte[iArr[length]];
        int length2 = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length2) {
            int i3 = iArr[length2 + i];
            int i4 = iArr[i];
            System.arraycopy(bArr[i], i3, bArr2, i2, i4 - i2);
            i++;
            i2 = i4;
        }
        return new df(bArr2);
    }

    @Override // defpackage.df
    public final String toString() {
        return o().toString();
    }
}
