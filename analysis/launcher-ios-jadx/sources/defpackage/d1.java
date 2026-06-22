package defpackage;

import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public abstract class d1 extends ViewGroup.MarginLayoutParams {
    public int gravity;

    public d1(int i, int i2) {
        super(i, i2);
        this.gravity = 8388627;
    }

    public d1(d1 d1Var) {
        super((ViewGroup.MarginLayoutParams) d1Var);
        this.gravity = 0;
        this.gravity = d1Var.gravity;
    }

    public d1(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.gravity = 0;
    }
}
