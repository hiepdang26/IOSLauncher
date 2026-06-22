package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class dm1 implements View.OnLayoutChangeListener {
    public final /* synthetic */ View g;
    public final /* synthetic */ em1 h;

    public dm1(em1 em1Var, View view) {
        this.h = em1Var;
        this.g = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        View view2 = this.g;
        if (view2.getVisibility() == 0) {
            this.h.d(view2);
        }
    }
}
