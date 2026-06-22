package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import androidx.appcompat.widget.AppCompatButton;
import defpackage.ar0;
import defpackage.az1;
import defpackage.b71;
import defpackage.d;
import defpackage.f71;
import defpackage.hg0;
import defpackage.hg1;
import defpackage.ic1;
import defpackage.mn1;
import defpackage.np1;
import defpackage.ow1;
import defpackage.q41;
import defpackage.qg0;
import defpackage.qs1;
import defpackage.tr0;
import defpackage.uo;
import defpackage.vf1;
import defpackage.wd;
import defpackage.wf1;
import defpackage.yq0;
import defpackage.zq0;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, hg1 {
    public static final int[] t = {R.attr.state_checkable};
    public static final int[] u = {R.attr.state_checked};
    public static final int v = b71.Widget_MaterialComponents_Button;
    public final ar0 g;
    public final LinkedHashSet h;
    public yq0 i;
    public PorterDuff.Mode j;
    public ColorStateList k;
    public Drawable l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public boolean r;
    public int s;

    /* JADX WARN: Illegal instructions before constructor call */
    public MaterialButton(Context context, AttributeSet attributeSet) {
        int i = q41.materialButtonStyle;
        int i2 = v;
        super(tr0.a(context, attributeSet, i, i2), attributeSet, i);
        this.h = new LinkedHashSet();
        this.q = false;
        this.r = false;
        Context context2 = getContext();
        TypedArray typedArrayD = mn1.d(context2, attributeSet, f71.MaterialButton, i, i2, new int[0]);
        this.p = typedArrayD.getDimensionPixelSize(f71.MaterialButton_iconPadding, 0);
        int i3 = typedArrayD.getInt(f71.MaterialButton_iconTintMode, -1);
        PorterDuff.Mode mode = PorterDuff.Mode.SRC_IN;
        this.j = qg0.C(i3, mode);
        this.k = np1.l(getContext(), typedArrayD, f71.MaterialButton_iconTint);
        this.l = np1.n(getContext(), typedArrayD, f71.MaterialButton_icon);
        this.s = typedArrayD.getInteger(f71.MaterialButton_iconGravity, 1);
        this.m = typedArrayD.getDimensionPixelSize(f71.MaterialButton_iconSize, 0);
        ar0 ar0Var = new ar0(this, wf1.b(context2, attributeSet, i, i2).a());
        this.g = ar0Var;
        ar0Var.c = typedArrayD.getDimensionPixelOffset(f71.MaterialButton_android_insetLeft, 0);
        ar0Var.d = typedArrayD.getDimensionPixelOffset(f71.MaterialButton_android_insetRight, 0);
        ar0Var.e = typedArrayD.getDimensionPixelOffset(f71.MaterialButton_android_insetTop, 0);
        ar0Var.f = typedArrayD.getDimensionPixelOffset(f71.MaterialButton_android_insetBottom, 0);
        if (typedArrayD.hasValue(f71.MaterialButton_cornerRadius)) {
            int dimensionPixelSize = typedArrayD.getDimensionPixelSize(f71.MaterialButton_cornerRadius, -1);
            ar0Var.g = dimensionPixelSize;
            float f = dimensionPixelSize;
            vf1 vf1VarE = ar0Var.b.e();
            vf1VarE.e = new d(f);
            vf1VarE.f = new d(f);
            vf1VarE.g = new d(f);
            vf1VarE.h = new d(f);
            ar0Var.c(vf1VarE.a());
            ar0Var.p = true;
        }
        ar0Var.h = typedArrayD.getDimensionPixelSize(f71.MaterialButton_strokeWidth, 0);
        ar0Var.i = qg0.C(typedArrayD.getInt(f71.MaterialButton_backgroundTintMode, -1), mode);
        ar0Var.j = np1.l(getContext(), typedArrayD, f71.MaterialButton_backgroundTint);
        ar0Var.k = np1.l(getContext(), typedArrayD, f71.MaterialButton_strokeColor);
        ar0Var.l = np1.l(getContext(), typedArrayD, f71.MaterialButton_rippleColor);
        ar0Var.q = typedArrayD.getBoolean(f71.MaterialButton_android_checkable, false);
        ar0Var.s = typedArrayD.getDimensionPixelSize(f71.MaterialButton_elevation, 0);
        WeakHashMap weakHashMap = qs1.a;
        int paddingStart = getPaddingStart();
        int paddingTop = getPaddingTop();
        int paddingEnd = getPaddingEnd();
        int paddingBottom = getPaddingBottom();
        if (typedArrayD.hasValue(f71.MaterialButton_android_background)) {
            ar0Var.o = true;
            setSupportBackgroundTintList(ar0Var.j);
            setSupportBackgroundTintMode(ar0Var.i);
        } else {
            ar0Var.e();
        }
        setPaddingRelative(paddingStart + ar0Var.c, paddingTop + ar0Var.e, paddingEnd + ar0Var.d, paddingBottom + ar0Var.f);
        typedArrayD.recycle();
        setCompoundDrawablePadding(this.p);
        c(this.l != null);
    }

    private String getA11yClassName() {
        ar0 ar0Var = this.g;
        return ((ar0Var == null || !ar0Var.q) ? Button.class : CompoundButton.class).getName();
    }

    private Layout.Alignment getActualTextAlignment() {
        int textAlignment = getTextAlignment();
        return textAlignment != 1 ? (textAlignment == 6 || textAlignment == 3) ? Layout.Alignment.ALIGN_OPPOSITE : textAlignment != 4 ? Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER : getGravityTextAlignment();
    }

    private Layout.Alignment getGravityTextAlignment() {
        int gravity = getGravity() & 8388615;
        return gravity != 1 ? (gravity == 5 || gravity == 8388613) ? Layout.Alignment.ALIGN_OPPOSITE : Layout.Alignment.ALIGN_NORMAL : Layout.Alignment.ALIGN_CENTER;
    }

    private int getTextHeight() {
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(string, 0, string.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextWidth() {
        TextPaint paint = getPaint();
        String string = getText().toString();
        if (getTransformationMethod() != null) {
            string = getTransformationMethod().getTransformation(string, this).toString();
        }
        return Math.min((int) paint.measureText(string), getLayout().getEllipsizedWidth());
    }

    public final boolean a() {
        ar0 ar0Var = this.g;
        return (ar0Var == null || ar0Var.o) ? false : true;
    }

    public final void b() {
        int i = this.s;
        boolean z = true;
        if (i != 1 && i != 2) {
            z = false;
        }
        if (z) {
            setCompoundDrawablesRelative(this.l, null, null, null);
            return;
        }
        if (i == 3 || i == 4) {
            setCompoundDrawablesRelative(null, null, this.l, null);
        } else if (i == 16 || i == 32) {
            setCompoundDrawablesRelative(null, this.l, null, null);
        }
    }

    public final void c(boolean z) {
        Drawable drawable = this.l;
        if (drawable != null) {
            Drawable drawableMutate = az1.L(drawable).mutate();
            this.l = drawableMutate;
            drawableMutate.setTintList(this.k);
            PorterDuff.Mode mode = this.j;
            if (mode != null) {
                this.l.setTintMode(mode);
            }
            int intrinsicWidth = this.m;
            if (intrinsicWidth == 0) {
                intrinsicWidth = this.l.getIntrinsicWidth();
            }
            int intrinsicHeight = this.m;
            if (intrinsicHeight == 0) {
                intrinsicHeight = this.l.getIntrinsicHeight();
            }
            Drawable drawable2 = this.l;
            int i = this.n;
            int i2 = this.o;
            drawable2.setBounds(i, i2, intrinsicWidth + i, intrinsicHeight + i2);
            this.l.setVisible(true, z);
        }
        if (z) {
            b();
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        Drawable drawable3 = compoundDrawablesRelative[0];
        Drawable drawable4 = compoundDrawablesRelative[1];
        Drawable drawable5 = compoundDrawablesRelative[2];
        int i3 = this.s;
        if (((i3 == 1 || i3 == 2) && drawable3 != this.l) || (((i3 == 3 || i3 == 4) && drawable5 != this.l) || ((i3 == 16 || i3 == 32) && drawable4 != this.l))) {
            b();
        }
    }

    public final void d(int i, int i2) {
        if (this.l == null || getLayout() == null) {
            return;
        }
        int i3 = this.s;
        if (!(i3 == 1 || i3 == 2) && i3 != 3 && i3 != 4) {
            if (i3 == 16 || i3 == 32) {
                this.n = 0;
                if (i3 == 16) {
                    this.o = 0;
                    c(false);
                    return;
                }
                int intrinsicHeight = this.m;
                if (intrinsicHeight == 0) {
                    intrinsicHeight = this.l.getIntrinsicHeight();
                }
                int textHeight = (((((i2 - getTextHeight()) - getPaddingTop()) - intrinsicHeight) - this.p) - getPaddingBottom()) / 2;
                if (this.o != textHeight) {
                    this.o = textHeight;
                    c(false);
                    return;
                }
                return;
            }
            return;
        }
        this.o = 0;
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        int i4 = this.s;
        if (i4 == 1 || i4 == 3 || ((i4 == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) || (i4 == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE))) {
            this.n = 0;
            c(false);
            return;
        }
        int intrinsicWidth = this.m;
        if (intrinsicWidth == 0) {
            intrinsicWidth = this.l.getIntrinsicWidth();
        }
        int textWidth = i - getTextWidth();
        WeakHashMap weakHashMap = qs1.a;
        int paddingEnd = (((textWidth - getPaddingEnd()) - intrinsicWidth) - this.p) - getPaddingStart();
        if (actualTextAlignment == Layout.Alignment.ALIGN_CENTER) {
            paddingEnd /= 2;
        }
        if ((getLayoutDirection() == 1) != (this.s == 4)) {
            paddingEnd = -paddingEnd;
        }
        if (this.n != paddingEnd) {
            this.n = paddingEnd;
            c(false);
        }
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (a()) {
            return this.g.g;
        }
        return 0;
    }

    public Drawable getIcon() {
        return this.l;
    }

    public int getIconGravity() {
        return this.s;
    }

    public int getIconPadding() {
        return this.p;
    }

    public int getIconSize() {
        return this.m;
    }

    public ColorStateList getIconTint() {
        return this.k;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.j;
    }

    public int getInsetBottom() {
        return this.g.f;
    }

    public int getInsetTop() {
        return this.g.e;
    }

    public ColorStateList getRippleColor() {
        if (a()) {
            return this.g.l;
        }
        return null;
    }

    public wf1 getShapeAppearanceModel() {
        if (a()) {
            return this.g.b;
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (a()) {
            return this.g.k;
        }
        return null;
    }

    public int getStrokeWidth() {
        if (a()) {
            return this.g.h;
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public ColorStateList getSupportBackgroundTintList() {
        return a() ? this.g.j : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return a() ? this.g.i : super.getSupportBackgroundTintMode();
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.q;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (a()) {
            az1.H(this, this.g.b(false));
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        ar0 ar0Var = this.g;
        if (ar0Var != null && ar0Var.q) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, t);
        }
        if (this.q) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, u);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(this.q);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        ar0 ar0Var = this.g;
        accessibilityNodeInfo.setCheckable(ar0Var != null && ar0Var.q);
        accessibilityNodeInfo.setChecked(this.q);
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        ar0 ar0Var;
        super.onLayout(z, i, i2, i3, i4);
        if (Build.VERSION.SDK_INT == 21 && (ar0Var = this.g) != null) {
            int i5 = i4 - i2;
            int i6 = i3 - i;
            Drawable drawable = ar0Var.m;
            if (drawable != null) {
                drawable.setBounds(ar0Var.c, ar0Var.e, i6 - ar0Var.d, i5 - ar0Var.f);
            }
        }
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof zq0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        zq0 zq0Var = (zq0) parcelable;
        super.onRestoreInstanceState(zq0Var.getSuperState());
        setChecked(zq0Var.g);
    }

    @Override // android.widget.TextView, android.view.View
    public final Parcelable onSaveInstanceState() {
        zq0 zq0Var = new zq0(super.onSaveInstanceState());
        zq0Var.g = this.q;
        return zq0Var;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public final boolean performClick() {
        toggle();
        return super.performClick();
    }

    @Override // android.view.View
    public final void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.l != null) {
            if (this.l.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (!a()) {
            super.setBackgroundColor(i);
            return;
        }
        ar0 ar0Var = this.g;
        if (ar0Var.b(false) != null) {
            ar0Var.b(false).setTint(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!a()) {
            super.setBackgroundDrawable(drawable);
            return;
        }
        if (drawable == getBackground()) {
            getBackground().setState(drawable.getState());
            return;
        }
        ar0 ar0Var = this.g;
        ar0Var.o = true;
        ColorStateList colorStateList = ar0Var.j;
        MaterialButton materialButton = ar0Var.a;
        materialButton.setSupportBackgroundTintList(colorStateList);
        materialButton.setSupportBackgroundTintMode(ar0Var.i);
        super.setBackgroundDrawable(drawable);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? hg0.o(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (a()) {
            this.g.q = z;
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        ar0 ar0Var = this.g;
        if (ar0Var == null || !ar0Var.q || !isEnabled() || this.q == z) {
            return;
        }
        this.q = z;
        refreshDrawableState();
        if (getParent() instanceof MaterialButtonToggleGroup) {
            MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) getParent();
            boolean z2 = this.q;
            if (!materialButtonToggleGroup.l) {
                materialButtonToggleGroup.b(getId(), z2);
            }
        }
        if (this.r) {
            return;
        }
        this.r = true;
        Iterator it = this.h.iterator();
        if (it.hasNext()) {
            throw uo.c(it);
        }
        this.r = false;
    }

    public void setCornerRadius(int i) {
        if (a()) {
            ar0 ar0Var = this.g;
            if (ar0Var.p && ar0Var.g == i) {
                return;
            }
            ar0Var.g = i;
            ar0Var.p = true;
            float f = i;
            vf1 vf1VarE = ar0Var.b.e();
            vf1VarE.e = new d(f);
            vf1VarE.f = new d(f);
            vf1VarE.g = new d(f);
            vf1VarE.h = new d(f);
            ar0Var.c(vf1VarE.a());
        }
    }

    public void setCornerRadiusResource(int i) {
        if (a()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        if (a()) {
            this.g.b(false).j(f);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.l != drawable) {
            this.l = drawable;
            c(true);
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconGravity(int i) {
        if (this.s != i) {
            this.s = i;
            d(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i) {
        if (this.p != i) {
            this.p = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? hg0.o(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.m != i) {
            this.m = i;
            c(true);
        }
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.k != colorStateList) {
            this.k = colorStateList;
            c(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.j != mode) {
            this.j = mode;
            c(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(hg0.m(getContext(), i));
    }

    public void setInsetBottom(int i) {
        ar0 ar0Var = this.g;
        ar0Var.d(ar0Var.e, i);
    }

    public void setInsetTop(int i) {
        ar0 ar0Var = this.g;
        ar0Var.d(i, ar0Var.f);
    }

    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    public void setOnPressedChangeListenerInternal(yq0 yq0Var) {
        this.i = yq0Var;
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        yq0 yq0Var = this.i;
        if (yq0Var != null) {
            ((MaterialButtonToggleGroup) ((ow1) yq0Var).h).invalidate();
        }
        super.setPressed(z);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (a()) {
            ar0 ar0Var = this.g;
            if (ar0Var.l != colorStateList) {
                ar0Var.l = colorStateList;
                boolean z = ar0.t;
                MaterialButton materialButton = ar0Var.a;
                if (z && (materialButton.getBackground() instanceof RippleDrawable)) {
                    ((RippleDrawable) materialButton.getBackground()).setColor(wd.F(colorStateList));
                } else {
                    if (z || !(materialButton.getBackground() instanceof ic1)) {
                        return;
                    }
                    ((ic1) materialButton.getBackground()).setTintList(wd.F(colorStateList));
                }
            }
        }
    }

    public void setRippleColorResource(int i) {
        if (a()) {
            setRippleColor(hg0.m(getContext(), i));
        }
    }

    @Override // defpackage.hg1
    public void setShapeAppearanceModel(wf1 wf1Var) {
        if (!a()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.g.c(wf1Var);
    }

    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (a()) {
            ar0 ar0Var = this.g;
            ar0Var.n = z;
            ar0Var.f();
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (a()) {
            ar0 ar0Var = this.g;
            if (ar0Var.k != colorStateList) {
                ar0Var.k = colorStateList;
                ar0Var.f();
            }
        }
    }

    public void setStrokeColorResource(int i) {
        if (a()) {
            setStrokeColor(hg0.m(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (a()) {
            ar0 ar0Var = this.g;
            if (ar0Var.h != i) {
                ar0Var.h = i;
                ar0Var.f();
            }
        }
    }

    public void setStrokeWidthResource(int i) {
        if (a()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (!a()) {
            super.setSupportBackgroundTintList(colorStateList);
            return;
        }
        ar0 ar0Var = this.g;
        if (ar0Var.j != colorStateList) {
            ar0Var.j = colorStateList;
            if (ar0Var.b(false) != null) {
                ar0Var.b(false).setTintList(ar0Var.j);
            }
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (!a()) {
            super.setSupportBackgroundTintMode(mode);
            return;
        }
        ar0 ar0Var = this.g;
        if (ar0Var.i != mode) {
            ar0Var.i = mode;
            if (ar0Var.b(false) == null || ar0Var.i == null) {
                return;
            }
            ar0Var.b(false).setTintMode(ar0Var.i);
        }
    }

    @Override // android.view.View
    public void setTextAlignment(int i) {
        super.setTextAlignment(i);
        d(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.q);
    }
}
