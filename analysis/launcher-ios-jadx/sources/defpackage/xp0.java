package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class xp0 implements Cloneable {
    public /* synthetic */ boolean g;
    public /* synthetic */ long[] h;
    public /* synthetic */ Object[] i;
    public /* synthetic */ int j;

    public xp0() {
        int i;
        int i2 = 4;
        while (true) {
            i = 80;
            if (i2 >= 32) {
                break;
            }
            int i3 = (1 << i2) - 12;
            if (80 <= i3) {
                i = i3;
                break;
            }
            i2++;
        }
        int i4 = i / 8;
        this.h = new long[i4];
        this.i = new Object[i4];
    }

    public final void a(long j, Long l) {
        int i = this.j;
        if (i != 0 && j <= this.h[i - 1]) {
            g(j, l);
            return;
        }
        if (this.g) {
            long[] jArr = this.h;
            if (i >= jArr.length) {
                Object[] objArr = this.i;
                int i2 = 0;
                for (int i3 = 0; i3 < i; i3++) {
                    Object obj = objArr[i3];
                    if (obj != z71.c) {
                        if (i3 != i2) {
                            jArr[i2] = jArr[i3];
                            objArr[i2] = obj;
                            objArr[i3] = null;
                        }
                        i2++;
                    }
                }
                this.g = false;
                this.j = i2;
            }
        }
        int i4 = this.j;
        if (i4 >= this.h.length) {
            int i5 = (i4 + 1) * 8;
            int i6 = 4;
            while (true) {
                if (i6 >= 32) {
                    break;
                }
                int i7 = (1 << i6) - 12;
                if (i5 <= i7) {
                    i5 = i7;
                    break;
                }
                i6++;
            }
            int i8 = i5 / 8;
            long[] jArrCopyOf = Arrays.copyOf(this.h, i8);
            qg0.k(jArrCopyOf, "copyOf(this, newSize)");
            this.h = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.i, i8);
            qg0.k(objArrCopyOf, "copyOf(this, newSize)");
            this.i = objArrCopyOf;
        }
        this.h[i4] = j;
        this.i[i4] = l;
        this.j = i4 + 1;
    }

    public final void b() {
        int i = this.j;
        Object[] objArr = this.i;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        this.j = 0;
        this.g = false;
    }

    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public final xp0 clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        qg0.i(objClone, "null cannot be cast to non-null type androidx.collection.LongSparseArray<E of androidx.collection.LongSparseArray>");
        xp0 xp0Var = (xp0) objClone;
        xp0Var.h = (long[]) this.h.clone();
        xp0Var.i = (Object[]) this.i.clone();
        return xp0Var;
    }

    public final Object d(long j) {
        Object obj;
        int iE = z71.e(this.h, this.j, j);
        if (iE < 0 || (obj = this.i[iE]) == z71.c) {
            return null;
        }
        return obj;
    }

    public final Object e(long j) {
        Object obj;
        int iE = z71.e(this.h, this.j, j);
        if (iE < 0 || (obj = this.i[iE]) == z71.c) {
            return -1L;
        }
        return obj;
    }

    public final long f(int i) {
        if (!(i >= 0 && i < this.j)) {
            p02.C("Expected index to be within 0..size()-1, but was " + i);
            throw null;
        }
        if (this.g) {
            int i2 = this.j;
            long[] jArr = this.h;
            Object[] objArr = this.i;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != z71.c) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.g = false;
            this.j = i3;
        }
        return this.h[i];
    }

    public final void g(long j, Object obj) {
        int iE = z71.e(this.h, this.j, j);
        if (iE >= 0) {
            this.i[iE] = obj;
            return;
        }
        int i = ~iE;
        int i2 = this.j;
        Object obj2 = z71.c;
        if (i < i2) {
            Object[] objArr = this.i;
            if (objArr[i] == obj2) {
                this.h[i] = j;
                objArr[i] = obj;
                return;
            }
        }
        if (this.g) {
            long[] jArr = this.h;
            if (i2 >= jArr.length) {
                Object[] objArr2 = this.i;
                int i3 = 0;
                for (int i4 = 0; i4 < i2; i4++) {
                    Object obj3 = objArr2[i4];
                    if (obj3 != obj2) {
                        if (i4 != i3) {
                            jArr[i3] = jArr[i4];
                            objArr2[i3] = obj3;
                            objArr2[i4] = null;
                        }
                        i3++;
                    }
                }
                this.g = false;
                this.j = i3;
                i = ~z71.e(this.h, i3, j);
            }
        }
        int i5 = this.j;
        if (i5 >= this.h.length) {
            int i6 = (i5 + 1) * 8;
            int i7 = 4;
            while (true) {
                if (i7 >= 32) {
                    break;
                }
                int i8 = (1 << i7) - 12;
                if (i6 <= i8) {
                    i6 = i8;
                    break;
                }
                i7++;
            }
            int i9 = i6 / 8;
            long[] jArrCopyOf = Arrays.copyOf(this.h, i9);
            qg0.k(jArrCopyOf, "copyOf(this, newSize)");
            this.h = jArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.i, i9);
            qg0.k(objArrCopyOf, "copyOf(this, newSize)");
            this.i = objArrCopyOf;
        }
        int i10 = this.j - i;
        if (i10 != 0) {
            long[] jArr2 = this.h;
            int i11 = i + 1;
            qg0.l(jArr2, "<this>");
            System.arraycopy(jArr2, i, jArr2, i11, i10);
            Object[] objArr3 = this.i;
            h9.B(objArr3, i11, objArr3, i, this.j);
        }
        this.h[i] = j;
        this.i[i] = obj;
        this.j++;
    }

    public final int h() {
        if (this.g) {
            int i = this.j;
            long[] jArr = this.h;
            Object[] objArr = this.i;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object obj = objArr[i3];
                if (obj != z71.c) {
                    if (i3 != i2) {
                        jArr[i2] = jArr[i3];
                        objArr[i2] = obj;
                        objArr[i3] = null;
                    }
                    i2++;
                }
            }
            this.g = false;
            this.j = i2;
        }
        return this.j;
    }

    public final Object i(int i) {
        if (!(i >= 0 && i < this.j)) {
            p02.C("Expected index to be within 0..size()-1, but was " + i);
            throw null;
        }
        if (this.g) {
            int i2 = this.j;
            long[] jArr = this.h;
            Object[] objArr = this.i;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                Object obj = objArr[i4];
                if (obj != z71.c) {
                    if (i4 != i3) {
                        jArr[i3] = jArr[i4];
                        objArr[i3] = obj;
                        objArr[i4] = null;
                    }
                    i3++;
                }
            }
            this.g = false;
            this.j = i3;
        }
        return this.i[i];
    }

    public final String toString() {
        if (h() <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.j * 28);
        sb.append('{');
        int i = this.j;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(f(i2));
            sb.append('=');
            Object objI = i(i2);
            if (objI != sb) {
                sb.append(objI);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        qg0.k(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }
}
