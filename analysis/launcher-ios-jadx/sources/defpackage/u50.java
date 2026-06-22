package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class u50 extends wd {
    public final /* synthetic */ w50 B;

    public u50(w50 w50Var) {
        this.B = w50Var;
    }

    @Override // defpackage.wd
    public final View w(int i) {
        w50 w50Var = this.B;
        View view = w50Var.L;
        if (view != null) {
            return view.findViewById(i);
        }
        throw new IllegalStateException("Fragment " + w50Var + " does not have a view");
    }

    @Override // defpackage.wd
    public final boolean x() {
        return this.B.L != null;
    }
}
