package defpackage;

import android.util.SparseArray;

/* JADX INFO: loaded from: classes.dex */
public final class du0 {
    public final SparseArray a;
    public hz b;

    public du0(int i) {
        this.a = new SparseArray(i);
    }

    public final void a(hz hzVar, int i, int i2) {
        int iA = hzVar.a(i);
        SparseArray sparseArray = this.a;
        du0 du0Var = sparseArray == null ? null : (du0) sparseArray.get(iA);
        if (du0Var == null) {
            du0Var = new du0(1);
            sparseArray.put(hzVar.a(i), du0Var);
        }
        if (i2 > i) {
            du0Var.a(hzVar, i + 1, i2);
        } else {
            du0Var.b = hzVar;
        }
    }
}
