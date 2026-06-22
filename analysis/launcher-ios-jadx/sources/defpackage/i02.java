package defpackage;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class i02 extends Drawable.ConstantState {
    public int a;
    public Drawable.ConstantState b;
    public ColorStateList c;
    public PorterDuff.Mode d;

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final int getChangingConfigurations() {
        int i = this.a;
        Drawable.ConstantState constantState = this.b;
        return i | (constantState != null ? constantState.getChangingConfigurations() : 0);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable() {
        return newDrawable(null);
    }

    @Override // android.graphics.drawable.Drawable.ConstantState
    public final Drawable newDrawable(Resources resources) {
        h02 h02Var = new h02();
        h02Var.j = this;
        Drawable.ConstantState constantState = this.b;
        if (constantState != null) {
            h02Var.g(constantState.newDrawable(resources));
        }
        if (h02.n == null) {
            try {
                h02.n = Drawable.class.getDeclaredMethod("isProjected", null);
            } catch (Exception unused) {
            }
        }
        return h02Var;
    }
}
