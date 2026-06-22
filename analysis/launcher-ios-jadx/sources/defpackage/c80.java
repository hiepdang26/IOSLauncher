package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public final class c80 {
    public int a;
    public int b;
    public int c;
    public Object d;

    public void a(cw cwVar) {
        Object obj;
        Object obj2;
        Object[] objArr = (Object[]) this.d;
        int i = this.a;
        int iHashCode = cwVar.hashCode() * (-1640531527);
        int i2 = (iHashCode ^ (iHashCode >>> 16)) & i;
        Object obj3 = objArr[i2];
        if (obj3 != null) {
            if (obj3.equals(cwVar)) {
                return;
            }
            do {
                i2 = (i2 + 1) & i;
                obj2 = objArr[i2];
                if (obj2 == null) {
                }
            } while (!obj2.equals(cwVar));
            return;
        }
        objArr[i2] = cwVar;
        int i3 = this.b + 1;
        this.b = i3;
        if (i3 < this.c) {
            return;
        }
        Object[] objArr2 = (Object[]) this.d;
        int length = objArr2.length;
        int i4 = length << 1;
        int i5 = i4 - 1;
        Object[] objArr3 = new Object[i4];
        while (true) {
            int i6 = i3 - 1;
            if (i3 == 0) {
                this.a = i5;
                this.c = (int) (i4 * 0.75f);
                this.d = objArr3;
                return;
            }
            do {
                length--;
                obj = objArr2[length];
            } while (obj == null);
            int iHashCode2 = obj.hashCode() * (-1640531527);
            int i7 = (iHashCode2 ^ (iHashCode2 >>> 16)) & i5;
            if (objArr3[i7] != null) {
                do {
                    i7 = (i7 + 1) & i5;
                } while (objArr3[i7] != null);
            }
            objArr3[i7] = objArr2[length];
            i3 = i6;
        }
    }

    public void b(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }
        int i3 = this.c;
        int i4 = i3 * 2;
        int[] iArr = (int[]) this.d;
        if (iArr == null) {
            int[] iArr2 = new int[4];
            this.d = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i4 >= iArr.length) {
            int[] iArr3 = new int[i3 * 4];
            this.d = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        }
        int[] iArr4 = (int[]) this.d;
        iArr4[i4] = i;
        iArr4[i4 + 1] = i2;
        this.c++;
    }

    public void c(RecyclerView recyclerView, boolean z) {
        this.c = 0;
        int[] iArr = (int[]) this.d;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        u81 u81Var = recyclerView.t;
        if (recyclerView.s == null || u81Var == null || !u81Var.i) {
            return;
        }
        if (z) {
            if (!recyclerView.k.h()) {
                u81Var.i(recyclerView.s.c(), this);
            }
        } else if (!recyclerView.S()) {
            u81Var.h(this.a, this.b, recyclerView.n0, this);
        }
        int i = this.c;
        if (i > u81Var.j) {
            u81Var.j = i;
            u81Var.k = z;
            recyclerView.i.m();
        }
    }

    public void d(int i, int i2, Object[] objArr) {
        int i3;
        Object obj;
        this.b--;
        while (true) {
            int i4 = i + 1;
            while (true) {
                i3 = i4 & i2;
                obj = objArr[i3];
                if (obj == null) {
                    objArr[i] = null;
                    return;
                }
                int iHashCode = obj.hashCode() * (-1640531527);
                int i5 = (iHashCode ^ (iHashCode >>> 16)) & i2;
                if (i <= i3) {
                    if (i >= i5 || i5 > i3) {
                        break;
                    } else {
                        i4 = i3 + 1;
                    }
                } else if (i < i5 || i5 <= i3) {
                    i4 = i3 + 1;
                }
            }
            objArr[i] = obj;
            i = i3;
        }
    }
}
