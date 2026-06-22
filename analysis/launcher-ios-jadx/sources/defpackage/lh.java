package defpackage;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class lh extends zo1 {
    public boolean g = false;
    public final /* synthetic */ ViewGroup h;

    public lh(ViewGroup viewGroup) {
        this.h = viewGroup;
    }

    @Override // defpackage.zo1, defpackage.vo1
    public final void b() {
        n90.E(this.h, false);
    }

    @Override // defpackage.zo1, defpackage.vo1
    public final void c() {
        n90.E(this.h, true);
    }

    @Override // defpackage.vo1
    public final void d(xo1 xo1Var) {
        if (!this.g) {
            n90.E(this.h, false);
        }
        xo1Var.u(this);
    }

    @Override // defpackage.zo1, defpackage.vo1
    public final void e() {
        n90.E(this.h, false);
        this.g = true;
    }
}
