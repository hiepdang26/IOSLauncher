package defpackage;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* JADX INFO: loaded from: classes.dex */
public final class c6 implements md1 {
    public final /* synthetic */ int a;
    public final Object b;

    public /* synthetic */ c6(e6 e6Var, int i) {
        this.a = i;
        this.b = e6Var;
    }

    @Override // defpackage.md1
    public final Bundle a() {
        switch (this.a) {
            case 0:
                Bundle bundle = new Bundle();
                ((e6) this.b).n().getClass();
                return bundle;
            case 1:
                Bundle bundle2 = new Bundle();
                e6 e6Var = (e6) this.b;
                while (e6.q(e6Var.o())) {
                }
                e6Var.v.d(um0.ON_STOP);
                i60 i60VarP = ((x50) e6Var.u.h).E.P();
                if (i60VarP != null) {
                    bundle2.putParcelable("android:support:fragments", i60VarP);
                }
                return bundle2;
            default:
                Bundle bundle3 = new Bundle();
                bundle3.putStringArrayList("classes_to_restore", new ArrayList<>((LinkedHashSet) this.b));
                return bundle3;
        }
    }

    public c6(nd1 nd1Var) {
        this.a = 2;
        qg0.l(nd1Var, "registry");
        this.b = new LinkedHashSet();
        nd1Var.b("androidx.savedstate.Restarter", this);
    }
}
