package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class qb extends FrameLayout {
    public static final pb n = new pb(0);
    public int g;
    public final float h;
    public final float i;
    public final int j;
    public final int k;
    public ColorStateList l;
    public PorterDuff.Mode m;

    public qb(Context context, AttributeSet attributeSet) {
        Drawable drawableL;
        super(tr0.a(context, attributeSet, 0, 0), attributeSet);
        Context context2 = getContext();
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, f71.SnackbarLayout);
        if (typedArrayObtainStyledAttributes.hasValue(f71.SnackbarLayout_elevation)) {
            float dimensionPixelSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(f71.SnackbarLayout_elevation, 0);
            WeakHashMap weakHashMap = qs1.a;
            hs1.l(this, dimensionPixelSize);
        }
        this.g = typedArrayObtainStyledAttributes.getInt(f71.SnackbarLayout_animationMode, 0);
        this.h = typedArrayObtainStyledAttributes.getFloat(f71.SnackbarLayout_backgroundOverlayColorAlpha, 1.0f);
        setBackgroundTintList(np1.l(context2, typedArrayObtainStyledAttributes, f71.SnackbarLayout_backgroundTint));
        setBackgroundTintMode(qg0.C(typedArrayObtainStyledAttributes.getInt(f71.SnackbarLayout_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN));
        this.i = typedArrayObtainStyledAttributes.getFloat(f71.SnackbarLayout_actionTextColorAlpha, 1.0f);
        this.j = typedArrayObtainStyledAttributes.getDimensionPixelSize(f71.SnackbarLayout_android_maxWidth, -1);
        this.k = typedArrayObtainStyledAttributes.getDimensionPixelSize(f71.SnackbarLayout_maxActionInlineWidth, -1);
        typedArrayObtainStyledAttributes.recycle();
        setOnTouchListener(n);
        setFocusable(true);
        if (getBackground() == null) {
            float dimension = getResources().getDimension(d51.mtrl_snackbar_background_corner_radius);
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setShape(0);
            gradientDrawable.setCornerRadius(dimension);
            gradientDrawable.setColor(bf1.p(getBackgroundOverlayColorAlpha(), bf1.e(q41.colorSurface, this), bf1.e(q41.colorOnSurface, this)));
            if (this.l != null) {
                drawableL = az1.L(gradientDrawable);
                drawableL.setTintList(this.l);
            } else {
                drawableL = az1.L(gradientDrawable);
            }
            WeakHashMap weakHashMap2 = qs1.a;
            setBackground(drawableL);
        }
    }

    public float getActionTextColorAlpha() {
        return this.i;
    }

    public int getAnimationMode() {
        return this.g;
    }

    public float getBackgroundOverlayColorAlpha() {
        return this.h;
    }

    public int getMaxInlineActionWidth() {
        return this.k;
    }

    public int getMaxWidth() {
        return this.j;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        WeakHashMap weakHashMap = qs1.a;
        fs1.c(this);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int i3 = this.j;
        if (i3 <= 0 || getMeasuredWidth() <= i3) {
            return;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i3, 1073741824), i2);
    }

    public void setAnimationMode(int i) {
        this.g = i;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable != null && this.l != null) {
            drawable = az1.L(drawable.mutate());
            drawable.setTintList(this.l);
            drawable.setTintMode(this.m);
        }
        super.setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        this.l = colorStateList;
        if (getBackground() != null) {
            Drawable drawableL = az1.L(getBackground().mutate());
            drawableL.setTintList(colorStateList);
            drawableL.setTintMode(this.m);
            if (drawableL != getBackground()) {
                super.setBackgroundDrawable(drawableL);
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        this.m = mode;
        if (getBackground() != null) {
            Drawable drawableL = az1.L(getBackground().mutate());
            drawableL.setTintMode(mode);
            if (drawableL != getBackground()) {
                super.setBackgroundDrawable(drawableL);
            }
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        setOnTouchListener(onClickListener != null ? null : n);
        super.setOnClickListener(onClickListener);
    }

    private void setBaseTransientBottomBar(rb rbVar) {
    }
}
