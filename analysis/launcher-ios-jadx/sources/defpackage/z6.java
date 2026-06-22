package defpackage;

import android.content.Context;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public final class z6 implements Comparator {
    public final iy g;
    public final jq1 h = jq1.b();
    public final /* synthetic */ wb2 i;

    public z6(wb2 wb2Var, Context context) {
        this.i = wb2Var;
        this.g = iy.n(context);
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        qh0 qh0Var = (qh0) obj;
        qh0 qh0Var2 = (qh0) obj2;
        int iM = this.i.m(qh0Var.u.toString(), qh0Var2.u.toString());
        if (iM != 0 || !(qh0Var instanceof v6) || !(qh0Var2 instanceof v6) || (iM = ((v6) qh0Var).A.compareTo(((v6) qh0Var2).A)) != 0) {
            return iM;
        }
        if (this.h.equals(qh0Var.w)) {
            return -1;
        }
        jq1 jq1Var = qh0Var.w;
        iy iyVar = this.g;
        return Long.valueOf(iyVar.o(jq1Var)).compareTo(Long.valueOf(iyVar.o(qh0Var2.w)));
    }
}
