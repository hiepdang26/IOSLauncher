package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class z42 {
    public final String[] a;
    public final double[] b;
    public final double[] c;
    public final int[] d;
    public int e;

    public z42(wb2 wb2Var) {
        ArrayList arrayList = (ArrayList) wb2Var.i;
        int size = arrayList.size();
        this.a = (String[]) ((ArrayList) wb2Var.h).toArray(new String[size]);
        int size2 = arrayList.size();
        double[] dArr = new double[size2];
        for (int i = 0; i < size2; i++) {
            dArr[i] = ((Double) arrayList.get(i)).doubleValue();
        }
        this.b = dArr;
        ArrayList arrayList2 = (ArrayList) wb2Var.j;
        int size3 = arrayList2.size();
        double[] dArr2 = new double[size3];
        for (int i2 = 0; i2 < size3; i2++) {
            dArr2[i2] = ((Double) arrayList2.get(i2)).doubleValue();
        }
        this.c = dArr2;
        this.d = new int[size];
        this.e = 0;
    }
}
