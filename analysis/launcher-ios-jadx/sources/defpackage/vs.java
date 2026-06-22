package defpackage;

import android.content.Context;
import java.util.HashSet;

/* JADX INFO: loaded from: classes.dex */
public final class vs implements dm {
    public final Context g;
    public final ra1 h;

    public vs(Context context, ra1 ra1Var) {
        this.g = context.getApplicationContext();
        this.h = ra1Var;
    }

    @Override // defpackage.cn0
    public final void b() {
        hh1 hh1VarB = hh1.b(this.g);
        ra1 ra1Var = this.h;
        synchronized (hh1VarB) {
            ((HashSet) hh1VarB.b).remove(ra1Var);
            if (hh1VarB.c && ((HashSet) hh1VarB.b).isEmpty()) {
                ((dh1) hh1VarB.d).a();
                hh1VarB.c = false;
            }
        }
    }

    @Override // defpackage.cn0
    public final void j() {
        hh1 hh1VarB = hh1.b(this.g);
        ra1 ra1Var = this.h;
        synchronized (hh1VarB) {
            ((HashSet) hh1VarB.b).add(ra1Var);
            if (!hh1VarB.c && !((HashSet) hh1VarB.b).isEmpty()) {
                hh1VarB.c = ((dh1) hh1VarB.d).b();
            }
        }
    }

    @Override // defpackage.cn0
    public final void onDestroy() {
    }
}
