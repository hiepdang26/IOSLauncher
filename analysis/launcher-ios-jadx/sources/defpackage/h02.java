package defpackage;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public final class h02 extends Drawable implements Drawable.Callback, g02, zn1 {
    public static final PorterDuff.Mode m = PorterDuff.Mode.SRC_IN;
    public static Method n;
    public int g;
    public PorterDuff.Mode h;
    public boolean i;
    public i02 j;
    public boolean k;
    public Drawable l;

    public final boolean a() {
        if (Build.VERSION.SDK_INT != 21) {
            return false;
        }
        Drawable drawable = this.l;
        return (drawable instanceof GradientDrawable) || (drawable instanceof DrawableContainer) || (drawable instanceof InsetDrawable) || (drawable instanceof RippleDrawable);
    }

    public final i02 b() {
        i02 i02Var = this.j;
        i02 i02Var2 = new i02();
        i02Var2.c = null;
        i02Var2.d = m;
        if (i02Var != null) {
            i02Var2.a = i02Var.a;
            i02Var2.b = i02Var.b;
            i02Var2.c = i02Var.c;
            i02Var2.d = i02Var.d;
        }
        return i02Var2;
    }

    public final boolean c(int[] iArr) {
        return h(iArr) || this.l.setState(iArr);
    }

    public final void d(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        this.l.draw(canvas);
    }

    public final void e(ColorStateList colorStateList) {
        this.j.c = colorStateList;
        h(this.l.getState());
    }

    public final void f(PorterDuff.Mode mode) {
        this.j.d = mode;
        h(this.l.getState());
    }

    public final void g(Drawable drawable) {
        Drawable drawable2 = this.l;
        if (drawable2 != null) {
            drawable2.setCallback(null);
        }
        this.l = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            setVisible(drawable.isVisible(), true);
            setState(drawable.getState());
            setLevel(drawable.getLevel());
            setBounds(drawable.getBounds());
            i02 i02Var = this.j;
            if (i02Var != null) {
                i02Var.b = drawable.getConstantState();
            }
        }
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getChangingConfigurations() {
        int changingConfigurations = super.getChangingConfigurations();
        i02 i02Var = this.j;
        return changingConfigurations | (i02Var != null ? i02Var.getChangingConfigurations() : 0) | this.l.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        i02 i02Var = this.j;
        if (i02Var == null || i02Var.b == null) {
            return null;
        }
        i02Var.a = getChangingConfigurations();
        return this.j;
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable getCurrent() {
        return this.l.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public final Rect getDirtyBounds() {
        return this.l.getDirtyBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicHeight() {
        return this.l.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getIntrinsicWidth() {
        return this.l.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getLayoutDirection() {
        return az1.r(this.l);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumHeight() {
        return this.l.getMinimumHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getMinimumWidth() {
        return this.l.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return this.l.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public final void getOutline(Outline outline) {
        this.l.getOutline(outline);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean getPadding(Rect rect) {
        return this.l.getPadding(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public final int[] getState() {
        return this.l.getState();
    }

    @Override // android.graphics.drawable.Drawable
    public final Region getTransparentRegion() {
        return this.l.getTransparentRegion();
    }

    public final boolean h(int[] iArr) {
        if (a()) {
            i02 i02Var = this.j;
            ColorStateList colorStateList = i02Var.c;
            PorterDuff.Mode mode = i02Var.d;
            if (colorStateList == null || mode == null) {
                this.i = false;
                clearColorFilter();
                return false;
            }
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (!this.i || colorForState != this.g || mode != this.h) {
                setColorFilter(colorForState, mode);
                this.g = colorForState;
                this.h = mode;
                this.i = true;
                return true;
            }
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isAutoMirrored() {
        return this.l.isAutoMirrored();
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isProjected() {
        Method method;
        Drawable drawable = this.l;
        if (drawable == null || (method = n) == null) {
            return false;
        }
        try {
            return ((Boolean) method.invoke(drawable, null)).booleanValue();
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean isStateful() {
        i02 i02Var;
        ColorStateList colorStateList = (!a() || (i02Var = this.j) == null) ? null : i02Var.c;
        return (colorStateList != null && colorStateList.isStateful()) || this.l.isStateful();
    }

    @Override // android.graphics.drawable.Drawable
    public final void jumpToCurrentState() {
        this.l.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable mutate() {
        if (!this.k && super.mutate() == this) {
            this.j = b();
            Drawable drawable = this.l;
            if (drawable != null) {
                drawable.mutate();
            }
            i02 i02Var = this.j;
            if (i02Var != null) {
                Drawable drawable2 = this.l;
                i02Var.b = drawable2 != null ? drawable2.getConstantState() : null;
            }
            this.k = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    public final void onBoundsChange(Rect rect) {
        Drawable drawable = this.l;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLayoutDirectionChanged(int i) {
        return az1.G(this.l, i);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean onLevelChange(int i) {
        return this.l.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
        this.l.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAutoMirrored(boolean z) {
        this.l.setAutoMirrored(z);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setChangingConfigurations(int i) {
        this.l.setChangingConfigurations(i);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
        this.l.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setDither(boolean z) {
        this.l.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setFilterBitmap(boolean z) {
        this.l.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspot(float f, float f2) {
        this.l.setHotspot(f, f2);
    }

    @Override // android.graphics.drawable.Drawable
    public final void setHotspotBounds(int i, int i2, int i3, int i4) {
        this.l.setHotspotBounds(i, i2, i3, i4);
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setState(int[] iArr) {
        if (!c(iArr)) {
            return false;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTint(int i) {
        if (a()) {
            d(i);
        } else {
            this.l.setTint(i);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintList(ColorStateList colorStateList) {
        if (a()) {
            e(colorStateList);
        } else {
            this.l.setTintList(colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final void setTintMode(PorterDuff.Mode mode) {
        if (a()) {
            f(mode);
        } else {
            this.l.setTintMode(mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public final boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2) || this.l.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public final void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
