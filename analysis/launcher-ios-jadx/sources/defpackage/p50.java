package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import androidx.appcompat.widget.LinearLayoutCompat;

/* JADX INFO: loaded from: classes.dex */
public abstract class p50 extends LinearLayoutCompat {
    public Drawable g;
    public final Rect h;
    public final Rect i;
    public int j;
    public final boolean k;
    public boolean l;

    public p50(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.h = new Rect();
        this.i = new Rect();
        this.j = 119;
        this.k = true;
        this.l = false;
        TypedArray typedArrayD = mn1.d(context, attributeSet, f71.ForegroundLinearLayout, 0, 0, new int[0]);
        this.j = typedArrayD.getInt(f71.ForegroundLinearLayout_android_foregroundGravity, this.j);
        Drawable drawable = typedArrayD.getDrawable(f71.ForegroundLinearLayout_android_foreground);
        if (drawable != null) {
            setForeground(drawable);
        }
        this.k = typedArrayD.getBoolean(f71.ForegroundLinearLayout_foregroundInsidePadding, true);
        typedArrayD.recycle();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.g;
        if (drawable != null) {
            if (this.l) {
                this.l = false;
                int right = getRight() - getLeft();
                int bottom = getBottom() - getTop();
                boolean z = this.k;
                Rect rect = this.h;
                if (z) {
                    rect.set(0, 0, right, bottom);
                } else {
                    rect.set(getPaddingLeft(), getPaddingTop(), right - getPaddingRight(), bottom - getPaddingBottom());
                }
                int i = this.j;
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                Rect rect2 = this.i;
                Gravity.apply(i, intrinsicWidth, intrinsicHeight, rect, rect2);
                drawable.setBounds(rect2);
            }
            drawable.draw(canvas);
        }
    }

    @Override // android.view.View
    public final void drawableHotspotChanged(float f, float f2) {
        super.drawableHotspotChanged(f, f2);
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.setHotspot(f, f2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.g;
        if (drawable == null || !drawable.isStateful()) {
            return;
        }
        this.g.setState(getDrawableState());
    }

    @Override // android.view.View
    public Drawable getForeground() {
        return this.g;
    }

    @Override // android.view.View
    public int getForegroundGravity() {
        return this.j;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.g;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.l = z | this.l;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.l = true;
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        Drawable drawable2 = this.g;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
                unscheduleDrawable(this.g);
            }
            this.g = drawable;
            if (drawable != null) {
                setWillNotDraw(false);
                drawable.setCallback(this);
                if (drawable.isStateful()) {
                    drawable.setState(getDrawableState());
                }
                if (this.j == 119) {
                    drawable.getPadding(new Rect());
                }
            } else {
                setWillNotDraw(true);
            }
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setForegroundGravity(int i) {
        if (this.j != i) {
            if ((8388615 & i) == 0) {
                i |= 8388611;
            }
            if ((i & 112) == 0) {
                i |= 48;
            }
            this.j = i;
            if (i == 119 && this.g != null) {
                this.g.getPadding(new Rect());
            }
            requestLayout();
        }
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.g;
    }
}
