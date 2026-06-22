package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class gv extends vu {
    public int m;

    public gv(hx1 hx1Var) {
        super(hx1Var);
        if (hx1Var instanceof dc0) {
            this.e = 2;
        } else {
            this.e = 3;
        }
    }

    @Override // defpackage.vu
    public final void d(int i) {
        if (this.j) {
            return;
        }
        this.j = true;
        this.g = i;
        ArrayList arrayList = this.k;
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            ru ruVar = (ru) obj;
            ruVar.a(ruVar);
        }
    }
}
