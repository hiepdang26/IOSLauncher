package defpackage;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
public class ug1 {
    public int[] g;
    public Object[] h;
    public int i;

    public ug1(int i) {
        this.g = i == 0 ? z71.a : new int[i];
        this.h = i == 0 ? z71.b : new Object[i << 1];
    }

    public final int a(Object obj) {
        int i = this.i * 2;
        Object[] objArr = this.h;
        if (obj == null) {
            for (int i2 = 1; i2 < i; i2 += 2) {
                if (objArr[i2] == null) {
                    return i2 >> 1;
                }
            }
            return -1;
        }
        for (int i3 = 1; i3 < i; i3 += 2) {
            if (obj.equals(objArr[i3])) {
                return i3 >> 1;
            }
        }
        return -1;
    }

    public final void b(int i) {
        int i2 = this.i;
        int[] iArr = this.g;
        if (iArr.length < i) {
            int[] iArrCopyOf = Arrays.copyOf(iArr, i);
            qg0.k(iArrCopyOf, "copyOf(this, newSize)");
            this.g = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.h, i * 2);
            qg0.k(objArrCopyOf, "copyOf(this, newSize)");
            this.h = objArrCopyOf;
        }
        if (this.i != i2) {
            throw new ConcurrentModificationException();
        }
    }

    public final int c(Object obj, int i) {
        int i2 = this.i;
        if (i2 == 0) {
            return -1;
        }
        int iD = z71.d(this.g, i2, i);
        if (iD < 0 || qg0.d(obj, this.h[iD << 1])) {
            return iD;
        }
        int i3 = iD + 1;
        while (i3 < i2 && this.g[i3] == i) {
            if (qg0.d(obj, this.h[i3 << 1])) {
                return i3;
            }
            i3++;
        }
        for (int i4 = iD - 1; i4 >= 0 && this.g[i4] == i; i4--) {
            if (qg0.d(obj, this.h[i4 << 1])) {
                return i4;
            }
        }
        return ~i3;
    }

    public void clear() {
        if (this.i > 0) {
            this.g = z71.a;
            this.h = z71.b;
            this.i = 0;
        }
        if (this.i > 0) {
            throw new ConcurrentModificationException();
        }
    }

    public boolean containsKey(Object obj) {
        return d(obj) >= 0;
    }

    public boolean containsValue(Object obj) {
        return a(obj) >= 0;
    }

    public final int d(Object obj) {
        return obj == null ? e() : c(obj, obj.hashCode());
    }

    public final int e() {
        int i = this.i;
        if (i == 0) {
            return -1;
        }
        int iD = z71.d(this.g, i, 0);
        if (iD < 0 || this.h[iD << 1] == null) {
            return iD;
        }
        int i2 = iD + 1;
        while (i2 < i && this.g[i2] == 0) {
            if (this.h[i2 << 1] == null) {
                return i2;
            }
            i2++;
        }
        for (int i3 = iD - 1; i3 >= 0 && this.g[i3] == 0; i3--) {
            if (this.h[i3 << 1] == null) {
                return i3;
            }
        }
        return ~i2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        try {
            if (obj instanceof ug1) {
                int i = this.i;
                if (i != ((ug1) obj).i) {
                    return false;
                }
                ug1 ug1Var = (ug1) obj;
                for (int i2 = 0; i2 < i; i2++) {
                    Object objF = f(i2);
                    Object objJ = j(i2);
                    Object obj2 = ug1Var.get(objF);
                    if (objJ == null) {
                        if (obj2 != null || !ug1Var.containsKey(objF)) {
                            return false;
                        }
                    } else if (!objJ.equals(obj2)) {
                        return false;
                    }
                }
                return true;
            }
            if (!(obj instanceof Map) || this.i != ((Map) obj).size()) {
                return false;
            }
            int i3 = this.i;
            for (int i4 = 0; i4 < i3; i4++) {
                Object objF2 = f(i4);
                Object objJ2 = j(i4);
                Object obj3 = ((Map) obj).get(objF2);
                if (objJ2 == null) {
                    if (obj3 != null || !((Map) obj).containsKey(objF2)) {
                        return false;
                    }
                } else if (!objJ2.equals(obj3)) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
        }
        return false;
    }

    public final Object f(int i) {
        boolean z = false;
        if (i >= 0 && i < this.i) {
            z = true;
        }
        if (z) {
            return this.h[i << 1];
        }
        p02.C("Expected index to be within 0..size()-1, but was " + i);
        throw null;
    }

    public void g(ug1 ug1Var) {
        qg0.l(ug1Var, "map");
        int i = ug1Var.i;
        b(this.i + i);
        if (this.i != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                put(ug1Var.f(i2), ug1Var.j(i2));
            }
        } else if (i > 0) {
            h9.A(0, 0, i, ug1Var.g, this.g);
            h9.B(ug1Var.h, 0, this.h, 0, i << 1);
            this.i = i;
        }
    }

    public Object get(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return this.h[(iD << 1) + 1];
        }
        return null;
    }

    public final Object getOrDefault(Object obj, Object obj2) {
        int iD = d(obj);
        return iD >= 0 ? this.h[(iD << 1) + 1] : obj2;
    }

    public Object h(int i) {
        if (!(i >= 0 && i < this.i)) {
            p02.C("Expected index to be within 0..size()-1, but was " + i);
            throw null;
        }
        Object[] objArr = this.h;
        int i2 = i << 1;
        Object obj = objArr[i2 + 1];
        int i3 = this.i;
        if (i3 <= 1) {
            clear();
            return obj;
        }
        int i4 = i3 - 1;
        int[] iArr = this.g;
        if (iArr.length <= 8 || i3 >= iArr.length / 3) {
            if (i < i4) {
                int i5 = i + 1;
                h9.A(i, i5, i3, iArr, iArr);
                Object[] objArr2 = this.h;
                h9.B(objArr2, i2, objArr2, i5 << 1, i3 << 1);
            }
            Object[] objArr3 = this.h;
            int i6 = i4 << 1;
            objArr3[i6] = null;
            objArr3[i6 + 1] = null;
        } else {
            int i7 = i3 > 8 ? i3 + (i3 >> 1) : 8;
            int[] iArrCopyOf = Arrays.copyOf(iArr, i7);
            qg0.k(iArrCopyOf, "copyOf(this, newSize)");
            this.g = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.h, i7 << 1);
            qg0.k(objArrCopyOf, "copyOf(this, newSize)");
            this.h = objArrCopyOf;
            if (i3 != this.i) {
                throw new ConcurrentModificationException();
            }
            if (i > 0) {
                h9.A(0, 0, i, iArr, this.g);
                h9.B(objArr, 0, this.h, 0, i2);
            }
            if (i < i4) {
                int i8 = i + 1;
                h9.A(i, i8, i3, iArr, this.g);
                h9.B(objArr, i2, this.h, i8 << 1, i3 << 1);
            }
        }
        if (i3 != this.i) {
            throw new ConcurrentModificationException();
        }
        this.i = i4;
        return obj;
    }

    public int hashCode() {
        int[] iArr = this.g;
        Object[] objArr = this.h;
        int i = this.i;
        int i2 = 1;
        int i3 = 0;
        int iHashCode = 0;
        while (i3 < i) {
            Object obj = objArr[i2];
            iHashCode += (obj != null ? obj.hashCode() : 0) ^ iArr[i3];
            i3++;
            i2 += 2;
        }
        return iHashCode;
    }

    public Object i(int i, Object obj) {
        boolean z = false;
        if (i >= 0 && i < this.i) {
            z = true;
        }
        if (!z) {
            p02.C("Expected index to be within 0..size()-1, but was " + i);
            throw null;
        }
        int i2 = (i << 1) + 1;
        Object[] objArr = this.h;
        Object obj2 = objArr[i2];
        objArr[i2] = obj;
        return obj2;
    }

    public final boolean isEmpty() {
        return this.i <= 0;
    }

    public final Object j(int i) {
        boolean z = false;
        if (i >= 0 && i < this.i) {
            z = true;
        }
        if (z) {
            return this.h[(i << 1) + 1];
        }
        p02.C("Expected index to be within 0..size()-1, but was " + i);
        throw null;
    }

    public Object put(Object obj, Object obj2) {
        int i = this.i;
        int iHashCode = obj != null ? obj.hashCode() : 0;
        int iC = obj != null ? c(obj, iHashCode) : e();
        if (iC >= 0) {
            int i2 = (iC << 1) + 1;
            Object[] objArr = this.h;
            Object obj3 = objArr[i2];
            objArr[i2] = obj2;
            return obj3;
        }
        int i3 = ~iC;
        int[] iArr = this.g;
        if (i >= iArr.length) {
            int i4 = 8;
            if (i >= 8) {
                i4 = (i >> 1) + i;
            } else if (i < 4) {
                i4 = 4;
            }
            int[] iArrCopyOf = Arrays.copyOf(iArr, i4);
            qg0.k(iArrCopyOf, "copyOf(this, newSize)");
            this.g = iArrCopyOf;
            Object[] objArrCopyOf = Arrays.copyOf(this.h, i4 << 1);
            qg0.k(objArrCopyOf, "copyOf(this, newSize)");
            this.h = objArrCopyOf;
            if (i != this.i) {
                throw new ConcurrentModificationException();
            }
        }
        if (i3 < i) {
            int[] iArr2 = this.g;
            int i5 = i3 + 1;
            h9.A(i5, i3, i, iArr2, iArr2);
            Object[] objArr2 = this.h;
            h9.B(objArr2, i5 << 1, objArr2, i3 << 1, this.i << 1);
        }
        int i6 = this.i;
        if (i == i6) {
            int[] iArr3 = this.g;
            if (i3 < iArr3.length) {
                iArr3[i3] = iHashCode;
                Object[] objArr3 = this.h;
                int i7 = i3 << 1;
                objArr3[i7] = obj;
                objArr3[i7 + 1] = obj2;
                this.i = i6 + 1;
                return null;
            }
        }
        throw new ConcurrentModificationException();
    }

    public final Object putIfAbsent(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 == null ? put(obj, obj2) : obj3;
    }

    public Object remove(Object obj) {
        int iD = d(obj);
        if (iD >= 0) {
            return h(iD);
        }
        return null;
    }

    public final Object replace(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD >= 0) {
            return i(iD, obj2);
        }
        return null;
    }

    public final int size() {
        return this.i;
    }

    public final String toString() {
        if (isEmpty()) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder(this.i * 28);
        sb.append('{');
        int i = this.i;
        for (int i2 = 0; i2 < i; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            Object objF = f(i2);
            if (objF != sb) {
                sb.append(objF);
            } else {
                sb.append("(this Map)");
            }
            sb.append('=');
            Object objJ = j(i2);
            if (objJ != sb) {
                sb.append(objJ);
            } else {
                sb.append("(this Map)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        qg0.k(string, "StringBuilder(capacity).…builderAction).toString()");
        return string;
    }

    public final boolean remove(Object obj, Object obj2) {
        int iD = d(obj);
        if (iD < 0 || !qg0.d(obj2, j(iD))) {
            return false;
        }
        h(iD);
        return true;
    }

    public final boolean replace(Object obj, Object obj2, Object obj3) {
        int iD = d(obj);
        if (iD < 0 || !qg0.d(obj2, j(iD))) {
            return false;
        }
        i(iD, obj3);
        return true;
    }

    public ug1(ug1 ug1Var) {
        this(0);
        if (ug1Var != null) {
            g(ug1Var);
        }
    }
}
