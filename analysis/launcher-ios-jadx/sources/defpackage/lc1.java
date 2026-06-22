package defpackage;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: classes.dex */
public final class lc1 implements yk1, xk1, AutoCloseable {
    public static final TreeMap o = new TreeMap();
    public final int g;
    public volatile String h;
    public final long[] i;
    public final double[] j;
    public final String[] k;
    public final byte[][] l;
    public final int[] m;
    public int n;

    public lc1(int i) {
        this.g = i;
        int i2 = i + 1;
        this.m = new int[i2];
        this.i = new long[i2];
        this.j = new double[i2];
        this.k = new String[i2];
        this.l = new byte[i2][];
    }

    public static final lc1 a(int i, String str) {
        TreeMap treeMap = o;
        synchronized (treeMap) {
            Map.Entry entryCeilingEntry = treeMap.ceilingEntry(Integer.valueOf(i));
            if (entryCeilingEntry == null) {
                lc1 lc1Var = new lc1(i);
                lc1Var.h = str;
                lc1Var.n = i;
                return lc1Var;
            }
            treeMap.remove(entryCeilingEntry.getKey());
            lc1 lc1Var2 = (lc1) entryCeilingEntry.getValue();
            lc1Var2.h = str;
            lc1Var2.n = i;
            return lc1Var2;
        }
    }

    @Override // defpackage.yk1
    public final String b() {
        String str = this.h;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    @Override // defpackage.xk1
    public final void e(int i, String str) {
        qg0.l(str, "value");
        this.m[i] = 4;
        this.k[i] = str;
    }

    @Override // defpackage.xk1
    public final void g(int i) {
        this.m[i] = 1;
    }

    @Override // defpackage.yk1
    public final void h(xk1 xk1Var) {
        int i = this.n;
        if (1 > i) {
            return;
        }
        int i2 = 1;
        while (true) {
            int i3 = this.m[i2];
            if (i3 == 1) {
                xk1Var.g(i2);
            } else if (i3 == 2) {
                xk1Var.q(i2, this.i[i2]);
            } else if (i3 == 3) {
                xk1Var.i(i2, this.j[i2]);
            } else if (i3 == 4) {
                String str = this.k[i2];
                if (str == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                xk1Var.e(i2, str);
            } else if (i3 == 5) {
                byte[] bArr = this.l[i2];
                if (bArr == null) {
                    throw new IllegalArgumentException("Required value was null.");
                }
                xk1Var.s(i2, bArr);
            }
            if (i2 == i) {
                return;
            } else {
                i2++;
            }
        }
    }

    @Override // defpackage.xk1
    public final void i(int i, double d) {
        this.m[i] = 3;
        this.j[i] = d;
    }

    public final void k() {
        TreeMap treeMap = o;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.g), this);
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator it = treeMap.descendingKeySet().iterator();
                qg0.k(it, "queryPool.descendingKeySet().iterator()");
                while (true) {
                    int i = size - 1;
                    if (size <= 0) {
                        break;
                    }
                    it.next();
                    it.remove();
                    size = i;
                }
            }
        }
    }

    @Override // defpackage.xk1
    public final void q(int i, long j) {
        this.m[i] = 2;
        this.i[i] = j;
    }

    @Override // defpackage.xk1
    public final void s(int i, byte[] bArr) {
        this.m[i] = 5;
        this.l[i] = bArr;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
    }
}
