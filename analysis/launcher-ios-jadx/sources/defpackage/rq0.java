package defpackage;

import androidx.appcompat.widget.ActivityChooserView;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class rq0 implements Map, Serializable {
    public static final rq0 t;
    public Object[] g;
    public Object[] h;
    public int[] i;
    public int[] j;
    public int k;
    public int l;
    public int m;
    public int n;
    public int o;
    public sq0 p;
    public tq0 q;
    public sq0 r;
    public boolean s;

    static {
        rq0 rq0Var = new rq0(0);
        rq0Var.s = true;
        t = rq0Var;
    }

    public rq0() {
        this(8);
    }

    public final int a(Object obj) {
        c();
        while (true) {
            int iJ = j(obj);
            int i = this.k * 2;
            int length = this.j.length / 2;
            if (i > length) {
                i = length;
            }
            int i2 = 0;
            while (true) {
                int[] iArr = this.j;
                int i3 = iArr[iJ];
                if (i3 <= 0) {
                    int i4 = this.l;
                    Object[] objArr = this.g;
                    if (i4 < objArr.length) {
                        int i5 = i4 + 1;
                        this.l = i5;
                        objArr[i4] = obj;
                        this.i[i4] = iJ;
                        iArr[iJ] = i5;
                        this.o++;
                        this.n++;
                        if (i2 > this.k) {
                            this.k = i2;
                        }
                        return i4;
                    }
                    g(1);
                } else {
                    if (qg0.d(this.g[i3 - 1], obj)) {
                        return -i3;
                    }
                    i2++;
                    if (i2 > i) {
                        k(this.j.length * 2);
                        break;
                    }
                    iJ = iJ == 0 ? this.j.length - 1 : iJ - 1;
                }
            }
        }
    }

    public final rq0 b() {
        c();
        this.s = true;
        if (this.o > 0) {
            return this;
        }
        rq0 rq0Var = t;
        qg0.i(rq0Var, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.builders.MapBuilder, V of kotlin.collections.builders.MapBuilder>");
        return rq0Var;
    }

    public final void c() {
        if (this.s) {
            throw new UnsupportedOperationException();
        }
    }

    @Override // java.util.Map
    public final void clear() {
        c();
        int i = this.l - 1;
        if (i >= 0) {
            int i2 = 0;
            while (true) {
                int[] iArr = this.i;
                int i3 = iArr[i2];
                if (i3 >= 0) {
                    this.j[i3] = 0;
                    iArr[i2] = -1;
                }
                if (i2 == i) {
                    break;
                } else {
                    i2++;
                }
            }
        }
        hg0.A(0, this.l, this.g);
        Object[] objArr = this.h;
        if (objArr != null) {
            hg0.A(0, this.l, objArr);
        }
        this.o = 0;
        this.l = 0;
        this.n++;
    }

    @Override // java.util.Map
    public final boolean containsKey(Object obj) {
        return h(obj) >= 0;
    }

    @Override // java.util.Map
    public final boolean containsValue(Object obj) {
        return i(obj) >= 0;
    }

    public final void d(boolean z) {
        int i;
        Object[] objArr = this.h;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            i = this.l;
            if (i2 >= i) {
                break;
            }
            int[] iArr = this.i;
            int i4 = iArr[i2];
            if (i4 >= 0) {
                Object[] objArr2 = this.g;
                objArr2[i3] = objArr2[i2];
                if (objArr != null) {
                    objArr[i3] = objArr[i2];
                }
                if (z) {
                    iArr[i3] = i4;
                    this.j[i4] = i3 + 1;
                }
                i3++;
            }
            i2++;
        }
        hg0.A(i3, i, this.g);
        if (objArr != null) {
            hg0.A(i3, this.l, objArr);
        }
        this.l = i3;
    }

    public final boolean e(Collection collection) {
        qg0.l(collection, "m");
        for (Object obj : collection) {
            if (obj != null) {
                try {
                    if (!f((Map.Entry) obj)) {
                    }
                } catch (ClassCastException unused) {
                }
            }
            return false;
        }
        return true;
    }

    @Override // java.util.Map
    public final Set entrySet() {
        sq0 sq0Var = this.r;
        if (sq0Var != null) {
            return sq0Var;
        }
        sq0 sq0Var2 = new sq0(this, 0);
        this.r = sq0Var2;
        return sq0Var2;
    }

    @Override // java.util.Map
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        return this.o == map.size() && e(map.entrySet());
    }

    public final boolean f(Map.Entry entry) {
        qg0.l(entry, "entry");
        int iH = h(entry.getKey());
        if (iH < 0) {
            return false;
        }
        Object[] objArr = this.h;
        qg0.h(objArr);
        return qg0.d(objArr[iH], entry.getValue());
    }

    public final void g(int i) {
        Object[] objArrCopyOf;
        Object[] objArr = this.g;
        int length = objArr.length;
        int i2 = this.l;
        int i3 = length - i2;
        int i4 = i2 - this.o;
        if (i3 < i && i3 + i4 >= i && i4 >= objArr.length / 4) {
            d(true);
            return;
        }
        int i5 = i2 + i;
        if (i5 < 0) {
            throw new OutOfMemoryError();
        }
        if (i5 > objArr.length) {
            int length2 = objArr.length;
            int i6 = length2 + (length2 >> 1);
            if (i6 - i5 < 0) {
                i6 = i5;
            }
            if (i6 - 2147483639 > 0) {
                i6 = i5 > 2147483639 ? ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED : 2147483639;
            }
            Object[] objArrCopyOf2 = Arrays.copyOf(objArr, i6);
            qg0.k(objArrCopyOf2, "copyOf(...)");
            this.g = objArrCopyOf2;
            Object[] objArr2 = this.h;
            if (objArr2 != null) {
                objArrCopyOf = Arrays.copyOf(objArr2, i6);
                qg0.k(objArrCopyOf, "copyOf(...)");
            } else {
                objArrCopyOf = null;
            }
            this.h = objArrCopyOf;
            int[] iArrCopyOf = Arrays.copyOf(this.i, i6);
            qg0.k(iArrCopyOf, "copyOf(...)");
            this.i = iArrCopyOf;
            int iHighestOneBit = Integer.highestOneBit((i6 >= 1 ? i6 : 1) * 3);
            if (iHighestOneBit > this.j.length) {
                k(iHighestOneBit);
            }
        }
    }

    @Override // java.util.Map
    public final Object get(Object obj) {
        int iH = h(obj);
        if (iH < 0) {
            return null;
        }
        Object[] objArr = this.h;
        qg0.h(objArr);
        return objArr[iH];
    }

    public final int h(Object obj) {
        int iJ = j(obj);
        int i = this.k;
        while (true) {
            int i2 = this.j[iJ];
            if (i2 == 0) {
                return -1;
            }
            if (i2 > 0) {
                int i3 = i2 - 1;
                if (qg0.d(this.g[i3], obj)) {
                    return i3;
                }
            }
            i--;
            if (i < 0) {
                return -1;
            }
            iJ = iJ == 0 ? this.j.length - 1 : iJ - 1;
        }
    }

    @Override // java.util.Map
    public final int hashCode() {
        oq0 oq0Var = new oq0(this, 0);
        int i = 0;
        while (oq0Var.hasNext()) {
            int i2 = oq0Var.g;
            rq0 rq0Var = (rq0) oq0Var.j;
            if (i2 >= rq0Var.l) {
                throw new NoSuchElementException();
            }
            oq0Var.g = i2 + 1;
            oq0Var.h = i2;
            Object obj = rq0Var.g[i2];
            int iHashCode = obj != null ? obj.hashCode() : 0;
            Object[] objArr = rq0Var.h;
            qg0.h(objArr);
            Object obj2 = objArr[oq0Var.h];
            int iHashCode2 = obj2 != null ? obj2.hashCode() : 0;
            oq0Var.e();
            i += iHashCode ^ iHashCode2;
        }
        return i;
    }

    public final int i(Object obj) {
        int i = this.l;
        while (true) {
            i--;
            if (i < 0) {
                return -1;
            }
            if (this.i[i] >= 0) {
                Object[] objArr = this.h;
                qg0.h(objArr);
                if (qg0.d(objArr[i], obj)) {
                    return i;
                }
            }
        }
    }

    @Override // java.util.Map
    public final boolean isEmpty() {
        return this.o == 0;
    }

    public final int j(Object obj) {
        return ((obj != null ? obj.hashCode() : 0) * (-1640531527)) >>> this.m;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0032, code lost:
    
        r3[r0] = r6;
        r5.i[r2] = r0;
        r2 = r6;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void k(int r6) {
        /*
            r5 = this;
            int r0 = r5.n
            int r0 = r0 + 1
            r5.n = r0
            int r0 = r5.l
            int r1 = r5.o
            r2 = 0
            if (r0 <= r1) goto L10
            r5.d(r2)
        L10:
            int[] r0 = new int[r6]
            r5.j = r0
            int r6 = java.lang.Integer.numberOfLeadingZeros(r6)
            int r6 = r6 + 1
            r5.m = r6
        L1c:
            int r6 = r5.l
            if (r2 >= r6) goto L50
            int r6 = r2 + 1
            java.lang.Object[] r0 = r5.g
            r0 = r0[r2]
            int r0 = r5.j(r0)
            int r1 = r5.k
        L2c:
            int[] r3 = r5.j
            r4 = r3[r0]
            if (r4 != 0) goto L3a
            r3[r0] = r6
            int[] r1 = r5.i
            r1[r2] = r0
            r2 = r6
            goto L1c
        L3a:
            int r1 = r1 + (-1)
            if (r1 < 0) goto L48
            int r4 = r0 + (-1)
            if (r0 != 0) goto L46
            int r0 = r3.length
            int r0 = r0 + (-1)
            goto L2c
        L46:
            r0 = r4
            goto L2c
        L48:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "This cannot happen with fixed magic multiplier and grow-only hash array. Have object hashCodes changed?"
            r6.<init>(r0)
            throw r6
        L50:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rq0.k(int):void");
    }

    @Override // java.util.Map
    public final Set keySet() {
        sq0 sq0Var = this.p;
        if (sq0Var != null) {
            return sq0Var;
        }
        sq0 sq0Var2 = new sq0(this, 1);
        this.p = sq0Var2;
        return sq0Var2;
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0068 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[LOOP:0: B:9:0x0024->B:33:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(int r12) {
        /*
            r11 = this;
            java.lang.Object[] r0 = r11.g
            java.lang.String r1 = "<this>"
            defpackage.qg0.l(r0, r1)
            r1 = 0
            r0[r12] = r1
            java.lang.Object[] r0 = r11.h
            if (r0 == 0) goto L10
            r0[r12] = r1
        L10:
            int[] r0 = r11.i
            r0 = r0[r12]
            int r1 = r11.k
            int r1 = r1 * 2
            int[] r2 = r11.j
            int r2 = r2.length
            int r2 = r2 / 2
            if (r1 <= r2) goto L20
            r1 = r2
        L20:
            r2 = 0
            r3 = r1
            r4 = 0
            r1 = r0
        L24:
            int r5 = r0 + (-1)
            if (r0 != 0) goto L2e
            int[] r0 = r11.j
            int r0 = r0.length
            int r0 = r0 + (-1)
            goto L2f
        L2e:
            r0 = r5
        L2f:
            int r4 = r4 + 1
            int r5 = r11.k
            r6 = -1
            if (r4 <= r5) goto L3b
            int[] r0 = r11.j
            r0[r1] = r2
            goto L6c
        L3b:
            int[] r5 = r11.j
            r7 = r5[r0]
            if (r7 != 0) goto L44
            r5[r1] = r2
            goto L6c
        L44:
            if (r7 >= 0) goto L4b
            r5[r1] = r6
        L48:
            r1 = r0
            r4 = 0
            goto L65
        L4b:
            java.lang.Object[] r5 = r11.g
            int r8 = r7 + (-1)
            r5 = r5[r8]
            int r5 = r11.j(r5)
            int r5 = r5 - r0
            int[] r9 = r11.j
            int r10 = r9.length
            int r10 = r10 + (-1)
            r5 = r5 & r10
            if (r5 < r4) goto L65
            r9[r1] = r7
            int[] r4 = r11.i
            r4[r8] = r1
            goto L48
        L65:
            int r3 = r3 + r6
            if (r3 >= 0) goto L24
            int[] r0 = r11.j
            r0[r1] = r6
        L6c:
            int[] r0 = r11.i
            r0[r12] = r6
            int r12 = r11.o
            int r12 = r12 + r6
            r11.o = r12
            int r12 = r11.n
            int r12 = r12 + 1
            r11.n = r12
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.rq0.l(int):void");
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        c();
        int iA = a(obj);
        Object[] objArr = this.h;
        if (objArr == null) {
            int length = this.g.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            this.h = objArr;
        }
        if (iA >= 0) {
            objArr[iA] = obj2;
            return null;
        }
        int i = (-iA) - 1;
        Object obj3 = objArr[i];
        objArr[i] = obj2;
        return obj3;
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        qg0.l(map, "from");
        c();
        Set<Map.Entry> setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return;
        }
        g(setEntrySet.size());
        for (Map.Entry entry : setEntrySet) {
            int iA = a(entry.getKey());
            Object[] objArr = this.h;
            if (objArr == null) {
                int length = this.g.length;
                if (length < 0) {
                    throw new IllegalArgumentException("capacity must be non-negative.");
                }
                objArr = new Object[length];
                this.h = objArr;
            }
            if (iA >= 0) {
                objArr[iA] = entry.getValue();
            } else {
                int i = (-iA) - 1;
                if (!qg0.d(entry.getValue(), objArr[i])) {
                    objArr[i] = entry.getValue();
                }
            }
        }
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        c();
        int iH = h(obj);
        if (iH < 0) {
            return null;
        }
        Object[] objArr = this.h;
        qg0.h(objArr);
        Object obj2 = objArr[iH];
        l(iH);
        return obj2;
    }

    @Override // java.util.Map
    public final int size() {
        return this.o;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder((this.o * 3) + 2);
        sb.append("{");
        oq0 oq0Var = new oq0(this, 0);
        int i = 0;
        while (oq0Var.hasNext()) {
            if (i > 0) {
                sb.append(", ");
            }
            int i2 = oq0Var.g;
            rq0 rq0Var = (rq0) oq0Var.j;
            if (i2 >= rq0Var.l) {
                throw new NoSuchElementException();
            }
            oq0Var.g = i2 + 1;
            oq0Var.h = i2;
            Object obj = rq0Var.g[i2];
            if (obj == rq0Var) {
                sb.append("(this Map)");
            } else {
                sb.append(obj);
            }
            sb.append('=');
            Object[] objArr = rq0Var.h;
            qg0.h(objArr);
            Object obj2 = objArr[oq0Var.h];
            if (obj2 == rq0Var) {
                sb.append("(this Map)");
            } else {
                sb.append(obj2);
            }
            oq0Var.e();
            i++;
        }
        sb.append("}");
        String string = sb.toString();
        qg0.k(string, "toString(...)");
        return string;
    }

    @Override // java.util.Map
    public final Collection values() {
        tq0 tq0Var = this.q;
        if (tq0Var != null) {
            return tq0Var;
        }
        tq0 tq0Var2 = new tq0(this);
        this.q = tq0Var2;
        return tq0Var2;
    }

    public rq0(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("capacity must be non-negative.");
        }
        Object[] objArr = new Object[i];
        int[] iArr = new int[i];
        int iHighestOneBit = Integer.highestOneBit((i < 1 ? 1 : i) * 3);
        this.g = objArr;
        this.h = null;
        this.i = iArr;
        this.j = new int[iHighestOneBit];
        this.k = 2;
        this.l = 0;
        this.m = Integer.numberOfLeadingZeros(iHighestOneBit) + 1;
    }
}
