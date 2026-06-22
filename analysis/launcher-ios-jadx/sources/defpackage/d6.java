package defpackage;

import android.os.Bundle;
import android.view.LayoutInflater;

/* JADX INFO: loaded from: classes.dex */
public final class d6 implements ry0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ e6 b;

    public /* synthetic */ d6(e6 e6Var, int i) {
        this.a = i;
        this.b = e6Var;
    }

    @Override // defpackage.ry0
    public final void a() {
        switch (this.a) {
            case 0:
                e6 e6Var = this.b;
                g6 g6VarN = e6Var.n();
                q6 q6Var = (q6) g6VarN;
                LayoutInflater layoutInflaterFrom = LayoutInflater.from(q6Var.j);
                if (layoutInflaterFrom.getFactory() == null) {
                    layoutInflaterFrom.setFactory2(q6Var);
                } else {
                    boolean z = layoutInflaterFrom.getFactory2() instanceof q6;
                }
                ((nd1) e6Var.k.b).a("androidx:appcompat");
                g6VarN.b();
                break;
            default:
                e6 e6Var2 = this.b;
                ow1 ow1Var = e6Var2.u;
                x50 x50Var = (x50) ow1Var.h;
                x50Var.E.b(x50Var, x50Var, null);
                Bundle bundleA = ((nd1) e6Var2.k.b).a("android:support:fragments");
                if (bundleA != null) {
                    ((x50) ow1Var.h).E.O(bundleA.getParcelable("android:support:fragments"));
                }
                break;
        }
    }
}
