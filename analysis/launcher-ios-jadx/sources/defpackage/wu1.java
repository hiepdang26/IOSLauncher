package defpackage;

import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class wu1 extends zo1 {
    public final /* synthetic */ ViewGroup g;
    public final /* synthetic */ View h;
    public final /* synthetic */ View i;
    public final /* synthetic */ l20 j;

    public wu1(l20 l20Var, ViewGroup viewGroup, View view, View view2) {
        this.j = l20Var;
        this.g = viewGroup;
        this.h = view;
        this.i = view2;
    }

    @Override // defpackage.zo1, defpackage.vo1
    public final void b() {
        this.g.getOverlay().remove(this.h);
    }

    @Override // defpackage.zo1, defpackage.vo1
    public final void c() {
        View view = this.h;
        if (view.getParent() == null) {
            this.g.getOverlay().add(view);
        } else {
            this.j.cancel();
        }
    }

    @Override // defpackage.vo1
    public final void d(xo1 xo1Var) {
        this.i.setTag(q51.save_overlay_view, null);
        this.g.getOverlay().remove(this.h);
        xo1Var.u(this);
    }
}
