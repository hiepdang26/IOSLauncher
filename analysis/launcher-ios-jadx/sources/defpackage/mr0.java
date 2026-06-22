package defpackage;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class mr0 implements ny0 {
    public final View g;
    public int h;
    public int i;

    public mr0(View view) {
        this.g = view;
    }

    @Override // defpackage.ny0
    public ly1 n(View view, ly1 ly1Var) {
        int i = ly1Var.a.f(519).b;
        View view2 = this.g;
        int i2 = this.h;
        if (i2 >= 0) {
            view2.getLayoutParams().height = i2 + i;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        view2.setPadding(view2.getPaddingLeft(), this.i + i, view2.getPaddingRight(), view2.getPaddingBottom());
        return ly1Var;
    }

    public mr0(View view, int i, int i2) {
        this.h = i;
        this.g = view;
        this.i = i2;
    }
}
