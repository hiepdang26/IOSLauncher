package defpackage;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;

/* JADX INFO: loaded from: classes.dex */
public final class jr1 extends Drawable.ConstantState {
    public final Drawable.ConstantState a;

    public jr1(Drawable.ConstantState constantState) {
        this.a = constantState;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final boolean canApplyTheme() {
        return this.a.canApplyTheme();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public int getChangingConfigurations() {
        return this.a.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        kr1 kr1Var = new kr1();
        kr1Var.g = (VectorDrawable) this.a.newDrawable();
        return kr1Var;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        kr1 kr1Var = new kr1();
        kr1Var.g = (VectorDrawable) this.a.newDrawable(resources);
        return kr1Var;
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources, Resources.Theme theme) {
        kr1 kr1Var = new kr1();
        kr1Var.g = (VectorDrawable) this.a.newDrawable(resources, theme);
        return kr1Var;
    }
}
