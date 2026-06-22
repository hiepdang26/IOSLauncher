package defpackage;

import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class ji1 implements Cloneable {
    public /* synthetic */ int[] g;
    public /* synthetic */ Object[] h;
    public /* synthetic */ int i;

    public ji1() {
        int i;
        int i2 = 4;
        while (true) {
            i = 40;
            if (i2 >= 32) {
                break;
            }
            int i3 = (1 << i2) - 12;
            if (40 <= i3) {
                i = i3;
                break;
            }
            i2++;
        }
        int i4 = i / 4;
        this.g = new int[i4];
        this.h = new Object[i4];
    }

    public final void a(int i, Object obj) {
        int i2 = this.i;
        if (i2 != 0 && i <= this.g[i2 - 1]) {
            d(i, obj);
            return;
        }
        if (i2 >= this.g.length) {
            int i3 = (i2 + 1) * 4;
            int i4 = 4;
            while (true) {
                if (i4 >= 32) {
                    break;
                }
                int i5 = (1 << i4) - 12;
                if (i3 <= i5) {
                    i3 = i5;
                    break;
                }
                i4++;
            }
            int i6 = i3 / 4;
            int[] iArrCopyOf = Arrays.copyOf(this.g, i6);
            qg0.k(iArrCopyOf, "copyOf(this, newSize)");
            this.g = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.h, i6);
            qg0.k(objArrCopyOf, "copyOf(this, newSize)");
            this.h = objArrCopyOf;
        }
        this.g[i2] = i;
        this.h[i2] = obj;
        this.i = i2 + 1;
    }

    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final ji1 clone() throws CloneNotSupportedException {
        Object objClone = super.clone();
        qg0.i(objClone, "null cannot be cast to non-null type androidx.collection.SparseArrayCompat<E of androidx.collection.SparseArrayCompat>");
        ji1 ji1Var = (ji1) objClone;
        ji1Var.g = (int[]) this.g.clone();
        ji1Var.h = (Object[]) this.h.clone();
        return ji1Var;
    }

    public final Object c(int i) {
        Object obj;
        int iD = z71.d(this.g, this.i, i);
        if (iD < 0 || (obj = this.h[iD]) == z71.d) {
            return null;
        }
        return obj;
    }

    public final void d(int i, Object obj) {
        int iD = z71.d(this.g, this.i, i);
        if (iD >= 0) {
            this.h[iD] = obj;
            return;
        }
        int i2 = ~iD;
        int i3 = this.i;
        if (i2 < i3) {
            Object[] objArr = this.h;
            if (objArr[i2] == z71.d) {
                this.g[i2] = i;
                objArr[i2] = obj;
                return;
            }
        }
        if (i3 >= this.g.length) {
            int i4 = (i3 + 1) * 4;
            int i5 = 4;
            while (true) {
                if (i5 >= 32) {
                    break;
                }
                int i6 = (1 << i5) - 12;
                if (i4 <= i6) {
                    i4 = i6;
                    break;
                }
                i5++;
            }
            int i7 = i4 / 4;
            int[] iArrCopyOf = Arrays.copyOf(this.g, i7);
            qg0.k(iArrCopyOf, "copyOf(this, newSize)");
            this.g = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.h, i7);
            qg0.k(objArrCopyOf, "copyOf(this, newSize)");
            this.h = objArrCopyOf;
        }
        int i8 = this.i;
        if (i8 - i2 != 0) {
            int[] iArr = this.g;
            int i9 = i2 + 1;
            h9.A(i9, i2, i8, iArr, iArr);
            Object[] objArr2 = this.h;
            h9.B(objArr2, i9, objArr2, i2, this.i);
        }
        this.g[i2] = i;
        this.h[i2] = obj;
        this.i++;
    }

    public final String toString() {
        int i = this.i;
        if (i <= 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(i * 28);
        sb.append('{');
        int i2 = this.i;
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            sb.append(this.g[i3]);
            sb.append('=');
            Object obj = this.h[i3];
            if (obj != this) {
                sb.append(obj);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        qg0.k(string, "buffer.toString()");
        return string;
    }
}
