package defpackage;

import android.graphics.Typeface;

/* JADX INFO: loaded from: classes.dex */
public final class dg extends n90 {
    public final Typeface m;
    public final nx0 n;
    public boolean o;

    public dg(nx0 nx0Var, Typeface typeface) {
        this.m = typeface;
        this.n = nx0Var;
    }

    @Override // defpackage.n90
    public final void A(int i) {
        if (this.o) {
            return;
        }
        vj vjVar = (vj) this.n.h;
        if (vjVar.k(this.m)) {
            vjVar.i(false);
        }
    }

    @Override // defpackage.n90
    public final void B(Typeface typeface, boolean z) {
        if (this.o) {
            return;
        }
        vj vjVar = (vj) this.n.h;
        if (vjVar.k(typeface)) {
            vjVar.i(false);
        }
    }
}
