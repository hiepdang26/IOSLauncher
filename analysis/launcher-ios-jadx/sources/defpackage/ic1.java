package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: classes.dex */
public final class ic1 extends Drawable implements hg1, zn1 {
    public hc1 g;

    public ic1(hc1 hc1Var) {
        this.g = hc1Var;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        hc1 hc1Var = this.g;
        if (hc1Var.b) {
            hc1Var.a.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        return this.g;
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        this.g.a.getClass();
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        this.g = new hc1(this.g);
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        this.g.a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onStateChange(int[] iArr) {
        boolean zOnStateChange = super.onStateChange(iArr);
        if (this.g.a.setState(iArr)) {
            zOnStateChange = true;
        }
        boolean zG = wd.G(iArr);
        hc1 hc1Var = this.g;
        if (hc1Var.b == zG) {
            return zOnStateChange;
        }
        hc1Var.b = zG;
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.g.a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.g.a.setColorFilter(colorFilter);
    }

    @Override // defpackage.hg1
    public final void setShapeAppearanceModel(wf1 wf1Var) {
        this.g.a.setShapeAppearanceModel(wf1Var);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        this.g.a.setTint(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        this.g.a.setTintList(colorStateList);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        this.g.a.setTintMode(mode);
    }
}
