package defpackage;

import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class hc1 extends Drawable.ConstantState {
    public rr0 a;
    public boolean b;

    public hc1(hc1 hc1Var) {
        this.a = (rr0) hc1Var.a.g.newDrawable();
        this.b = hc1Var.b;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return new ic1(new hc1(this));
    }
}
