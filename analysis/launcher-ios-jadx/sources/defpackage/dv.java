package defpackage;

import android.app.Dialog;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class dv extends wd {
    public final /* synthetic */ u50 B;
    public final /* synthetic */ ev C;

    public dv(ev evVar, u50 u50Var) {
        this.C = evVar;
        this.B = u50Var;
    }

    @Override // defpackage.wd
    public final View w(int i) {
        u50 u50Var = this.B;
        if (u50Var.x()) {
            return u50Var.w(i);
        }
        Dialog dialog = this.C.i0;
        if (dialog != null) {
            return dialog.findViewById(i);
        }
        return null;
    }

    @Override // defpackage.wd
    public final boolean x() {
        return this.B.x() || this.C.m0;
    }
}
