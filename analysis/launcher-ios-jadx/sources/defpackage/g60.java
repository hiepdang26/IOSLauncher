package defpackage;

import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public final class g60 implements f60 {
    public final int a;
    public final /* synthetic */ h60 b;

    public g60(h60 h60Var, int i) {
        this.b = h60Var;
        this.a = i;
    }

    @Override // defpackage.f60
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        h60 h60Var = this.b;
        w50 w50Var = h60Var.s;
        int i = this.a;
        if (w50Var == null || i >= 0 || !w50Var.o().K()) {
            return h60Var.L(arrayList, arrayList2, i, 1);
        }
        return false;
    }
}
