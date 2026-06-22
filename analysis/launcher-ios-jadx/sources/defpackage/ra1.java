package defpackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ra1 implements cm {
    public final hh1 a;
    public final /* synthetic */ sa1 b;

    public ra1(sa1 sa1Var, hh1 hh1Var) {
        this.b = sa1Var;
        this.a = hh1Var;
    }

    @Override // defpackage.cm
    public final void a(boolean z) {
        if (z) {
            synchronized (this.b) {
                hh1 hh1Var = this.a;
                ArrayList arrayListE = vq1.e((Set) hh1Var.d);
                int size = arrayListE.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayListE.get(i);
                    i++;
                    ha1 ha1Var = (ha1) obj;
                    if (!ha1Var.l() && !ha1Var.e()) {
                        ha1Var.clear();
                        if (hh1Var.c) {
                            ((HashSet) hh1Var.b).add(ha1Var);
                        } else {
                            ha1Var.k();
                        }
                    }
                }
            }
        }
    }
}
