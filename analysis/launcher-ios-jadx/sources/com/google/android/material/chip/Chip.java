package com.google.android.material.chip;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.AppCompatCheckBox;
import defpackage.an1;
import defpackage.az1;
import defpackage.b71;
import defpackage.dc;
import defpackage.en1;
import defpackage.f71;
import defpackage.g02;
import defpackage.gi;
import defpackage.h02;
import defpackage.hg0;
import defpackage.hg1;
import defpackage.hi;
import defpackage.hs1;
import defpackage.ii;
import defpackage.jd;
import defpackage.ji;
import defpackage.ki;
import defpackage.kr0;
import defpackage.lr0;
import defpackage.mn1;
import defpackage.np1;
import defpackage.nx0;
import defpackage.q41;
import defpackage.qg0;
import defpackage.qs1;
import defpackage.ru0;
import defpackage.tr0;
import defpackage.u51;
import defpackage.wd;
import defpackage.wf1;
import defpackage.wh;
import defpackage.zm1;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Locale;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class Chip extends AppCompatCheckBox implements ji, hg1, lr0 {
    public ki g;
    public InsetDrawable h;
    public RippleDrawable i;
    public View.OnClickListener j;
    public CompoundButton.OnCheckedChangeListener k;
    public kr0 l;
    public boolean m;
    public boolean n;
    public boolean o;
    public boolean p;
    public boolean q;
    public int r;
    public int s;
    public CharSequence t;
    public final ii u;
    public boolean v;
    public final Rect w;
    public final RectF x;
    public final gi y;
    public static final int z = b71.Widget_MaterialComponents_Chip_Action;
    public static final Rect A = new Rect();
    public static final int[] B = {R.attr.state_selected};
    public static final int[] C = {R.attr.state_checkable};

    /* JADX WARN: Illegal instructions before constructor call */
    public Chip(Context context, AttributeSet attributeSet) {
        int resourceId;
        int i = 1;
        int i2 = q41.chipStyle;
        int i3 = z;
        super(tr0.a(context, attributeSet, i2, i3), attributeSet, i2);
        this.w = new Rect();
        this.x = new RectF();
        this.y = new gi(this, 0);
        Context context2 = getContext();
        if (attributeSet != null) {
            attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "background");
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableLeft") != null) {
                throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableStart") != null) {
                throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableEnd") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "drawableRight") != null) {
                throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
            }
            if (!attributeSet.getAttributeBooleanValue("http://schemas.android.com/apk/res/android", "singleLine", true) || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "lines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "minLines", 1) != 1 || attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "maxLines", 1) != 1) {
                throw new UnsupportedOperationException("Chip does not support multi-line text");
            }
            attributeSet.getAttributeIntValue("http://schemas.android.com/apk/res/android", "gravity", 8388627);
        }
        ki kiVar = new ki(context2, attributeSet, i2);
        TypedArray typedArrayD = mn1.d(kiVar.k0, attributeSet, f71.Chip, i2, i3, new int[0]);
        kiVar.K0 = typedArrayD.hasValue(f71.Chip_shapeAppearance);
        int i4 = f71.Chip_chipSurfaceColor;
        Context context3 = kiVar.k0;
        ColorStateList colorStateListL = np1.l(context3, typedArrayD, i4);
        if (kiVar.D != colorStateListL) {
            kiVar.D = colorStateListL;
            kiVar.onStateChange(kiVar.getState());
        }
        ColorStateList colorStateListL2 = np1.l(context3, typedArrayD, f71.Chip_chipBackgroundColor);
        if (kiVar.E != colorStateListL2) {
            kiVar.E = colorStateListL2;
            kiVar.onStateChange(kiVar.getState());
        }
        float dimension = typedArrayD.getDimension(f71.Chip_chipMinHeight, 0.0f);
        if (kiVar.F != dimension) {
            kiVar.F = dimension;
            kiVar.invalidateSelf();
            kiVar.v();
        }
        if (typedArrayD.hasValue(f71.Chip_chipCornerRadius)) {
            kiVar.B(typedArrayD.getDimension(f71.Chip_chipCornerRadius, 0.0f));
        }
        kiVar.G(np1.l(context3, typedArrayD, f71.Chip_chipStrokeColor));
        kiVar.H(typedArrayD.getDimension(f71.Chip_chipStrokeWidth, 0.0f));
        kiVar.Q(np1.l(context3, typedArrayD, f71.Chip_rippleColor));
        String text = typedArrayD.getText(f71.Chip_android_text);
        text = text == null ? "" : text;
        boolean zEquals = TextUtils.equals(kiVar.K, text);
        en1 en1Var = kiVar.q0;
        if (!zEquals) {
            kiVar.K = text;
            en1Var.d = true;
            kiVar.invalidateSelf();
            kiVar.v();
        }
        int i5 = f71.Chip_android_textAppearance;
        zm1 zm1Var = (!typedArrayD.hasValue(i5) || (resourceId = typedArrayD.getResourceId(i5, 0)) == 0) ? null : new zm1(context3, resourceId);
        zm1Var.k = typedArrayD.getDimension(f71.Chip_android_textSize, zm1Var.k);
        int i6 = Build.VERSION.SDK_INT;
        if (i6 < 23) {
            zm1Var.j = np1.l(context3, typedArrayD, f71.Chip_android_textColor);
        }
        en1Var.b(zm1Var, context3);
        int i7 = typedArrayD.getInt(f71.Chip_android_ellipsize, 0);
        if (i7 == 1) {
            kiVar.H0 = TextUtils.TruncateAt.START;
        } else if (i7 == 2) {
            kiVar.H0 = TextUtils.TruncateAt.MIDDLE;
        } else if (i7 == 3) {
            kiVar.H0 = TextUtils.TruncateAt.END;
        }
        kiVar.F(typedArrayD.getBoolean(f71.Chip_chipIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "chipIconVisible") == null) {
            kiVar.F(typedArrayD.getBoolean(f71.Chip_chipIconEnabled, false));
        }
        kiVar.C(np1.n(context3, typedArrayD, f71.Chip_chipIcon));
        if (typedArrayD.hasValue(f71.Chip_chipIconTint)) {
            kiVar.E(np1.l(context3, typedArrayD, f71.Chip_chipIconTint));
        }
        kiVar.D(typedArrayD.getDimension(f71.Chip_chipIconSize, -1.0f));
        kiVar.N(typedArrayD.getBoolean(f71.Chip_closeIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "closeIconVisible") == null) {
            kiVar.N(typedArrayD.getBoolean(f71.Chip_closeIconEnabled, false));
        }
        kiVar.I(np1.n(context3, typedArrayD, f71.Chip_closeIcon));
        kiVar.M(np1.l(context3, typedArrayD, f71.Chip_closeIconTint));
        kiVar.K(typedArrayD.getDimension(f71.Chip_closeIconSize, 0.0f));
        kiVar.x(typedArrayD.getBoolean(f71.Chip_android_checkable, false));
        kiVar.A(typedArrayD.getBoolean(f71.Chip_checkedIconVisible, false));
        if (attributeSet != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconEnabled") != null && attributeSet.getAttributeValue("http://schemas.android.com/apk/res-auto", "checkedIconVisible") == null) {
            kiVar.A(typedArrayD.getBoolean(f71.Chip_checkedIconEnabled, false));
        }
        kiVar.y(np1.n(context3, typedArrayD, f71.Chip_checkedIcon));
        if (typedArrayD.hasValue(f71.Chip_checkedIconTint)) {
            kiVar.z(np1.l(context3, typedArrayD, f71.Chip_checkedIconTint));
        }
        kiVar.a0 = ru0.a(context3, typedArrayD, f71.Chip_showMotionSpec);
        kiVar.b0 = ru0.a(context3, typedArrayD, f71.Chip_hideMotionSpec);
        float dimension2 = typedArrayD.getDimension(f71.Chip_chipStartPadding, 0.0f);
        if (kiVar.c0 != dimension2) {
            kiVar.c0 = dimension2;
            kiVar.invalidateSelf();
            kiVar.v();
        }
        kiVar.P(typedArrayD.getDimension(f71.Chip_iconStartPadding, 0.0f));
        kiVar.O(typedArrayD.getDimension(f71.Chip_iconEndPadding, 0.0f));
        float dimension3 = typedArrayD.getDimension(f71.Chip_textStartPadding, 0.0f);
        if (kiVar.f0 != dimension3) {
            kiVar.f0 = dimension3;
            kiVar.invalidateSelf();
            kiVar.v();
        }
        float dimension4 = typedArrayD.getDimension(f71.Chip_textEndPadding, 0.0f);
        if (kiVar.g0 != dimension4) {
            kiVar.g0 = dimension4;
            kiVar.invalidateSelf();
            kiVar.v();
        }
        kiVar.L(typedArrayD.getDimension(f71.Chip_closeIconStartPadding, 0.0f));
        kiVar.J(typedArrayD.getDimension(f71.Chip_closeIconEndPadding, 0.0f));
        float dimension5 = typedArrayD.getDimension(f71.Chip_chipEndPadding, 0.0f);
        if (kiVar.j0 != dimension5) {
            kiVar.j0 = dimension5;
            kiVar.invalidateSelf();
            kiVar.v();
        }
        kiVar.J0 = typedArrayD.getDimensionPixelSize(f71.Chip_android_maxWidth, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        typedArrayD.recycle();
        int[] iArr = f71.Chip;
        mn1.a(context2, attributeSet, i2, i3);
        mn1.b(context2, attributeSet, iArr, i2, i3, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, iArr, i2, i3);
        this.q = typedArrayObtainStyledAttributes.getBoolean(f71.Chip_ensureMinTouchTargetSize, false);
        this.s = (int) Math.ceil(typedArrayObtainStyledAttributes.getDimension(f71.Chip_chipMinTouchTargetSize, (float) Math.ceil(qg0.q(getContext(), 48))));
        typedArrayObtainStyledAttributes.recycle();
        setChipDrawable(kiVar);
        WeakHashMap weakHashMap = qs1.a;
        kiVar.j(hs1.e(this));
        int[] iArr2 = f71.Chip;
        mn1.a(context2, attributeSet, i2, i3);
        mn1.b(context2, attributeSet, iArr2, i2, i3, new int[0]);
        TypedArray typedArrayObtainStyledAttributes2 = context2.obtainStyledAttributes(attributeSet, iArr2, i2, i3);
        if (i6 < 23) {
            setTextColor(np1.l(context2, typedArrayObtainStyledAttributes2, f71.Chip_android_textColor));
        }
        boolean zHasValue = typedArrayObtainStyledAttributes2.hasValue(f71.Chip_shapeAppearance);
        typedArrayObtainStyledAttributes2.recycle();
        this.u = new ii(this, this);
        e();
        if (!zHasValue) {
            setOutlineProvider(new hi(0, this));
        }
        setChecked(this.m);
        setText(kiVar.K);
        setEllipsize(kiVar.H0);
        h();
        if (!this.g.I0) {
            setLines(1);
            setHorizontallyScrolling(true);
        }
        setGravity(8388627);
        g();
        if (this.q) {
            setMinHeight(this.s);
        }
        this.r = getLayoutDirection();
        super.setOnCheckedChangeListener(new wh(this, i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCloseIconTouchBounds() {
        RectF rectF = this.x;
        rectF.setEmpty();
        if (d() && this.j != null) {
            ki kiVar = this.g;
            Rect bounds = kiVar.getBounds();
            rectF.setEmpty();
            if (kiVar.T()) {
                float f = kiVar.j0 + kiVar.i0 + kiVar.U + kiVar.h0 + kiVar.g0;
                if (az1.r(kiVar) == 0) {
                    float f2 = bounds.right;
                    rectF.right = f2;
                    rectF.left = f2 - f;
                } else {
                    float f3 = bounds.left;
                    rectF.left = f3;
                    rectF.right = f3 + f;
                }
                rectF.top = bounds.top;
                rectF.bottom = bounds.bottom;
            }
        }
        return rectF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Rect getCloseIconTouchBoundsInt() {
        RectF closeIconTouchBounds = getCloseIconTouchBounds();
        int i = (int) closeIconTouchBounds.left;
        int i2 = (int) closeIconTouchBounds.top;
        int i3 = (int) closeIconTouchBounds.right;
        int i4 = (int) closeIconTouchBounds.bottom;
        Rect rect = this.w;
        rect.set(i, i2, i3, i4);
        return rect;
    }

    private zm1 getTextAppearance() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.q0.f;
        }
        return null;
    }

    private void setCloseIconHovered(boolean z2) {
        if (this.o != z2) {
            this.o = z2;
            refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean z2) {
        if (this.n != z2) {
            this.n = z2;
            refreshDrawableState();
        }
    }

    public final void c(int i) {
        this.s = i;
        if (!this.q) {
            InsetDrawable insetDrawable = this.h;
            if (insetDrawable == null) {
                f();
                return;
            } else {
                if (insetDrawable != null) {
                    this.h = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    f();
                    return;
                }
                return;
            }
        }
        int iMax = Math.max(0, i - ((int) this.g.F));
        int iMax2 = Math.max(0, i - this.g.getIntrinsicWidth());
        if (iMax2 <= 0 && iMax <= 0) {
            InsetDrawable insetDrawable2 = this.h;
            if (insetDrawable2 == null) {
                f();
                return;
            } else {
                if (insetDrawable2 != null) {
                    this.h = null;
                    setMinWidth(0);
                    setMinHeight((int) getChipMinHeight());
                    f();
                    return;
                }
                return;
            }
        }
        int i2 = iMax2 > 0 ? iMax2 / 2 : 0;
        int i3 = iMax > 0 ? iMax / 2 : 0;
        if (this.h != null) {
            Rect rect = new Rect();
            this.h.getPadding(rect);
            if (rect.top == i3 && rect.bottom == i3 && rect.left == i2 && rect.right == i2) {
                f();
                return;
            }
        }
        if (getMinHeight() != i) {
            setMinHeight(i);
        }
        if (getMinWidth() != i) {
            setMinWidth(i);
        }
        this.h = new InsetDrawable((Drawable) this.g, i2, i3, i2, i3);
        f();
    }

    public final boolean d() {
        ki kiVar = this.g;
        if (kiVar == null) {
            return false;
        }
        Object obj = kiVar.R;
        if (obj == null) {
            obj = null;
        } else if (obj instanceof g02) {
            obj = ((h02) ((g02) obj)).l;
        }
        return obj != null;
    }

    @Override // android.view.View
    public final boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return !this.v ? super.dispatchHoverEvent(motionEvent) : this.u.l(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0057  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchKeyEvent(android.view.KeyEvent r10) {
        /*
            r9 = this;
            boolean r0 = r9.v
            if (r0 != 0) goto L9
            boolean r10 = super.dispatchKeyEvent(r10)
            return r10
        L9:
            ii r0 = r9.u
            r0.getClass()
            int r1 = r10.getAction()
            r2 = 1
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = 0
            if (r1 == r2) goto L84
            int r1 = r10.getKeyCode()
            r5 = 61
            r6 = 0
            if (r1 == r5) goto L6e
            r5 = 66
            if (r1 == r5) goto L57
            switch(r1) {
                case 19: goto L29;
                case 20: goto L29;
                case 21: goto L29;
                case 22: goto L29;
                case 23: goto L57;
                default: goto L28;
            }
        L28:
            goto L84
        L29:
            boolean r7 = r10.hasNoModifiers()
            if (r7 == 0) goto L84
            r7 = 19
            if (r1 == r7) goto L41
            r7 = 21
            if (r1 == r7) goto L3e
            r7 = 22
            if (r1 == r7) goto L43
            r5 = 130(0x82, float:1.82E-43)
            goto L43
        L3e:
            r5 = 17
            goto L43
        L41:
            r5 = 33
        L43:
            int r1 = r10.getRepeatCount()
            int r1 = r1 + r2
            r7 = 0
        L49:
            if (r4 >= r1) goto L55
            boolean r8 = r0.o(r5, r6)
            if (r8 == 0) goto L55
            int r4 = r4 + 1
            r7 = 1
            goto L49
        L55:
            r4 = r7
            goto L84
        L57:
            boolean r1 = r10.hasNoModifiers()
            if (r1 == 0) goto L84
            int r1 = r10.getRepeatCount()
            if (r1 != 0) goto L84
            int r1 = r0.r
            if (r1 == r3) goto L6c
            r4 = 16
            r0.q(r1, r4)
        L6c:
            r4 = 1
            goto L84
        L6e:
            boolean r1 = r10.hasNoModifiers()
            if (r1 == 0) goto L7a
            r1 = 2
            boolean r4 = r0.o(r1, r6)
            goto L84
        L7a:
            boolean r1 = r10.hasModifiers(r2)
            if (r1 == 0) goto L84
            boolean r4 = r0.o(r2, r6)
        L84:
            if (r4 == 0) goto L8b
            int r0 = r0.r
            if (r0 == r3) goto L8b
            return r2
        L8b:
            boolean r10 = super.dispatchKeyEvent(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.dispatchKeyEvent(android.view.KeyEvent):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean, int] */
    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        int i;
        super.drawableStateChanged();
        ki kiVar = this.g;
        boolean zW = false;
        if (kiVar != null && ki.u(kiVar.R)) {
            ki kiVar2 = this.g;
            ?? IsEnabled = isEnabled();
            int i2 = IsEnabled;
            if (this.p) {
                i2 = IsEnabled + 1;
            }
            int i3 = i2;
            if (this.o) {
                i3 = i2 + 1;
            }
            int i4 = i3;
            if (this.n) {
                i4 = i3 + 1;
            }
            int i5 = i4;
            if (isChecked()) {
                i5 = i4 + 1;
            }
            int[] iArr = new int[i5];
            if (isEnabled()) {
                iArr[0] = 16842910;
                i = 1;
            } else {
                i = 0;
            }
            if (this.p) {
                iArr[i] = 16842908;
                i++;
            }
            if (this.o) {
                iArr[i] = 16843623;
                i++;
            }
            if (this.n) {
                iArr[i] = 16842919;
                i++;
            }
            if (isChecked()) {
                iArr[i] = 16842913;
            }
            if (!Arrays.equals(kiVar2.E0, iArr)) {
                kiVar2.E0 = iArr;
                if (kiVar2.T()) {
                    zW = kiVar2.w(kiVar2.getState(), iArr);
                }
            }
        }
        if (zW) {
            invalidate();
        }
    }

    public final void e() {
        ki kiVar;
        if (!d() || (kiVar = this.g) == null || !kiVar.Q || this.j == null) {
            qs1.p(this, null);
            this.v = false;
        } else {
            qs1.p(this, this.u);
            this.v = true;
        }
    }

    public final void f() {
        this.i = new RippleDrawable(wd.F(this.g.J), getBackgroundDrawable(), null);
        this.g.getClass();
        RippleDrawable rippleDrawable = this.i;
        WeakHashMap weakHashMap = qs1.a;
        setBackground(rippleDrawable);
        g();
    }

    public final void g() {
        ki kiVar;
        if (TextUtils.isEmpty(getText()) || (kiVar = this.g) == null) {
            return;
        }
        int iR = (int) (kiVar.r() + kiVar.j0 + kiVar.g0);
        ki kiVar2 = this.g;
        int iQ = (int) (kiVar2.q() + kiVar2.c0 + kiVar2.f0);
        if (this.h != null) {
            Rect rect = new Rect();
            this.h.getPadding(rect);
            iQ += rect.left;
            iR += rect.right;
        }
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        WeakHashMap weakHashMap = qs1.a;
        setPaddingRelative(iQ, paddingTop, iR, paddingBottom);
    }

    @Override // android.widget.CheckBox, android.widget.CompoundButton, android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        if (!TextUtils.isEmpty(this.t)) {
            return this.t;
        }
        ki kiVar = this.g;
        if (kiVar == null || !kiVar.W) {
            return isClickable() ? "android.widget.Button" : "android.view.View";
        }
        ViewParent parent = getParent();
        return ((parent instanceof ChipGroup) && ((ChipGroup) parent).n.a) ? "android.widget.RadioButton" : "android.widget.CompoundButton";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable insetDrawable = this.h;
        return insetDrawable == null ? this.g : insetDrawable;
    }

    public Drawable getCheckedIcon() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.Y;
        }
        return null;
    }

    public ColorStateList getCheckedIconTint() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.Z;
        }
        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.E;
        }
        return null;
    }

    public float getChipCornerRadius() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return Math.max(0.0f, kiVar.s());
        }
        return 0.0f;
    }

    public Drawable getChipDrawable() {
        return this.g;
    }

    public float getChipEndPadding() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.j0;
        }
        return 0.0f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getChipIcon() {
        Drawable drawable;
        ki kiVar = this.g;
        if (kiVar == null || (drawable = kiVar.M) == 0) {
            return null;
        }
        return drawable instanceof g02 ? ((h02) ((g02) drawable)).l : drawable;
    }

    public float getChipIconSize() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.O;
        }
        return 0.0f;
    }

    public ColorStateList getChipIconTint() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.N;
        }
        return null;
    }

    public float getChipMinHeight() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.F;
        }
        return 0.0f;
    }

    public float getChipStartPadding() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.c0;
        }
        return 0.0f;
    }

    public ColorStateList getChipStrokeColor() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.H;
        }
        return null;
    }

    public float getChipStrokeWidth() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.I;
        }
        return 0.0f;
    }

    @Deprecated
    public CharSequence getChipText() {
        return getText();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Drawable getCloseIcon() {
        Drawable drawable;
        ki kiVar = this.g;
        if (kiVar == null || (drawable = kiVar.R) == 0) {
            return null;
        }
        return drawable instanceof g02 ? ((h02) ((g02) drawable)).l : drawable;
    }

    public CharSequence getCloseIconContentDescription() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.V;
        }
        return null;
    }

    public float getCloseIconEndPadding() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.i0;
        }
        return 0.0f;
    }

    public float getCloseIconSize() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.U;
        }
        return 0.0f;
    }

    public float getCloseIconStartPadding() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.h0;
        }
        return 0.0f;
    }

    public ColorStateList getCloseIconTint() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.T;
        }
        return null;
    }

    @Override // android.widget.TextView
    public TextUtils.TruncateAt getEllipsize() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.H0;
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void getFocusedRect(Rect rect) {
        if (this.v) {
            ii iiVar = this.u;
            if (iiVar.r == 1 || iiVar.q == 1) {
                rect.set(getCloseIconTouchBoundsInt());
                return;
            }
        }
        super.getFocusedRect(rect);
    }

    public ru0 getHideMotionSpec() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.b0;
        }
        return null;
    }

    public float getIconEndPadding() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.e0;
        }
        return 0.0f;
    }

    public float getIconStartPadding() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.d0;
        }
        return 0.0f;
    }

    public ColorStateList getRippleColor() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.J;
        }
        return null;
    }

    public wf1 getShapeAppearanceModel() {
        return this.g.g.a;
    }

    public ru0 getShowMotionSpec() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.a0;
        }
        return null;
    }

    public float getTextEndPadding() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.g0;
        }
        return 0.0f;
    }

    public float getTextStartPadding() {
        ki kiVar = this.g;
        if (kiVar != null) {
            return kiVar.f0;
        }
        return 0.0f;
    }

    public final void h() {
        TextPaint paint = getPaint();
        ki kiVar = this.g;
        if (kiVar != null) {
            paint.drawableState = kiVar.getState();
        }
        zm1 textAppearance = getTextAppearance();
        if (textAppearance != null) {
            textAppearance.e(getContext(), paint, this.y);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        az1.H(this, this.g);
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, B);
        }
        ki kiVar = this.g;
        if (kiVar != null && kiVar.W) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, C);
        }
        return iArrOnCreateDrawableState;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onFocusChanged(boolean z2, int i, Rect rect) {
        super.onFocusChanged(z2, i, rect);
        if (this.v) {
            ii iiVar = this.u;
            int i2 = iiVar.r;
            if (i2 != Integer.MIN_VALUE) {
                iiVar.j(i2);
            }
            if (z2) {
                iiVar.o(i, rect);
            }
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 7) {
            setCloseIconHovered(getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()));
        } else if (actionMasked == 10) {
            setCloseIconHovered(false);
        }
        return super.onHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int i;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getAccessibilityClassName());
        ki kiVar = this.g;
        int i2 = 0;
        accessibilityNodeInfo.setCheckable(kiVar != null && kiVar.W);
        accessibilityNodeInfo.setClickable(isClickable());
        if (getParent() instanceof ChipGroup) {
            ChipGroup chipGroup = (ChipGroup) getParent();
            if (chipGroup.i) {
                int i3 = 0;
                while (true) {
                    if (i2 >= chipGroup.getChildCount()) {
                        i3 = -1;
                        break;
                    }
                    if (chipGroup.getChildAt(i2) instanceof Chip) {
                        if (((Chip) chipGroup.getChildAt(i2)) == this) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                    i2++;
                }
                i = i3;
            } else {
                i = -1;
            }
            Object tag = getTag(u51.row_index_key);
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) nx0.v(!(tag instanceof Integer) ? -1 : ((Integer) tag).intValue(), 1, i, 1, false, isChecked()).h);
        }
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public final PointerIcon onResolvePointerIcon(MotionEvent motionEvent, int i) {
        if (getCloseIconTouchBounds().contains(motionEvent.getX(), motionEvent.getY()) && isEnabled()) {
            return PointerIcon.getSystemIcon(getContext(), 1002);
        }
        return null;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (this.r != i) {
            this.r = i;
            g();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x001e, code lost:
    
        if (r0 != 3) goto L28;
     */
    @Override // android.widget.TextView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getActionMasked()
            android.graphics.RectF r1 = r5.getCloseIconTouchBounds()
            float r2 = r6.getX()
            float r3 = r6.getY()
            boolean r1 = r1.contains(r2, r3)
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L4a
            if (r0 == r3) goto L2c
            r4 = 2
            if (r0 == r4) goto L21
            r1 = 3
            if (r0 == r1) goto L45
            goto L50
        L21:
            boolean r0 = r5.n
            if (r0 == 0) goto L50
            if (r1 != 0) goto L2a
            r5.setCloseIconPressed(r2)
        L2a:
            r0 = 1
            goto L51
        L2c:
            boolean r0 = r5.n
            if (r0 == 0) goto L45
            r5.playSoundEffect(r2)
            android.view.View$OnClickListener r0 = r5.j
            if (r0 == 0) goto L3a
            r0.onClick(r5)
        L3a:
            boolean r0 = r5.v
            if (r0 == 0) goto L43
            ii r0 = r5.u
            r0.w(r3, r3)
        L43:
            r0 = 1
            goto L46
        L45:
            r0 = 0
        L46:
            r5.setCloseIconPressed(r2)
            goto L51
        L4a:
            if (r1 == 0) goto L50
            r5.setCloseIconPressed(r3)
            goto L2a
        L50:
            r0 = 0
        L51:
            if (r0 != 0) goto L5b
            boolean r6 = super.onTouchEvent(r6)
            if (r6 == 0) goto L5a
            goto L5b
        L5a:
            return r2
        L5b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.Chip.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setAccessibilityClassName(CharSequence charSequence) {
        this.t = charSequence;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.i) {
            super.setBackground(drawable);
        }
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (drawable == getBackgroundDrawable() || drawable == this.i) {
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatCheckBox, android.view.View
    public void setBackgroundResource(int i) {
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
    }

    public void setCheckable(boolean z2) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.x(z2);
        }
    }

    public void setCheckableResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.x(kiVar.k0.getResources().getBoolean(i));
        }
    }

    @Override // android.widget.CompoundButton, android.widget.Checkable
    public void setChecked(boolean z2) {
        ki kiVar = this.g;
        if (kiVar == null) {
            this.m = z2;
        } else if (kiVar.W) {
            super.setChecked(z2);
        }
    }

    public void setCheckedIcon(Drawable drawable) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.y(drawable);
        }
    }

    @Deprecated
    public void setCheckedIconEnabled(boolean z2) {
        setCheckedIconVisible(z2);
    }

    @Deprecated
    public void setCheckedIconEnabledResource(int i) {
        setCheckedIconVisible(i);
    }

    public void setCheckedIconResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.y(hg0.o(kiVar.k0, i));
        }
    }

    public void setCheckedIconTint(ColorStateList colorStateList) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.z(colorStateList);
        }
    }

    public void setCheckedIconTintResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.z(hg0.m(kiVar.k0, i));
        }
    }

    public void setCheckedIconVisible(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.A(kiVar.k0.getResources().getBoolean(i));
        }
    }

    public void setChipBackgroundColor(ColorStateList colorStateList) {
        ki kiVar = this.g;
        if (kiVar == null || kiVar.E == colorStateList) {
            return;
        }
        kiVar.E = colorStateList;
        kiVar.onStateChange(kiVar.getState());
    }

    public void setChipBackgroundColorResource(int i) {
        ColorStateList colorStateListM;
        ki kiVar = this.g;
        if (kiVar == null || kiVar.E == (colorStateListM = hg0.m(kiVar.k0, i))) {
            return;
        }
        kiVar.E = colorStateListM;
        kiVar.onStateChange(kiVar.getState());
    }

    @Deprecated
    public void setChipCornerRadius(float f) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.B(f);
        }
    }

    @Deprecated
    public void setChipCornerRadiusResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.B(kiVar.k0.getResources().getDimension(i));
        }
    }

    public void setChipDrawable(ki kiVar) {
        ki kiVar2 = this.g;
        if (kiVar2 != kiVar) {
            if (kiVar2 != null) {
                kiVar2.G0 = new WeakReference(null);
            }
            this.g = kiVar;
            kiVar.I0 = false;
            kiVar.G0 = new WeakReference(this);
            c(this.s);
        }
    }

    public void setChipEndPadding(float f) {
        ki kiVar = this.g;
        if (kiVar == null || kiVar.j0 == f) {
            return;
        }
        kiVar.j0 = f;
        kiVar.invalidateSelf();
        kiVar.v();
    }

    public void setChipEndPaddingResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            float dimension = kiVar.k0.getResources().getDimension(i);
            if (kiVar.j0 != dimension) {
                kiVar.j0 = dimension;
                kiVar.invalidateSelf();
                kiVar.v();
            }
        }
    }

    public void setChipIcon(Drawable drawable) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.C(drawable);
        }
    }

    @Deprecated
    public void setChipIconEnabled(boolean z2) {
        setChipIconVisible(z2);
    }

    @Deprecated
    public void setChipIconEnabledResource(int i) {
        setChipIconVisible(i);
    }

    public void setChipIconResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.C(hg0.o(kiVar.k0, i));
        }
    }

    public void setChipIconSize(float f) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.D(f);
        }
    }

    public void setChipIconSizeResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.D(kiVar.k0.getResources().getDimension(i));
        }
    }

    public void setChipIconTint(ColorStateList colorStateList) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.E(colorStateList);
        }
    }

    public void setChipIconTintResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.E(hg0.m(kiVar.k0, i));
        }
    }

    public void setChipIconVisible(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.F(kiVar.k0.getResources().getBoolean(i));
        }
    }

    public void setChipMinHeight(float f) {
        ki kiVar = this.g;
        if (kiVar == null || kiVar.F == f) {
            return;
        }
        kiVar.F = f;
        kiVar.invalidateSelf();
        kiVar.v();
    }

    public void setChipMinHeightResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            float dimension = kiVar.k0.getResources().getDimension(i);
            if (kiVar.F != dimension) {
                kiVar.F = dimension;
                kiVar.invalidateSelf();
                kiVar.v();
            }
        }
    }

    public void setChipStartPadding(float f) {
        ki kiVar = this.g;
        if (kiVar == null || kiVar.c0 == f) {
            return;
        }
        kiVar.c0 = f;
        kiVar.invalidateSelf();
        kiVar.v();
    }

    public void setChipStartPaddingResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            float dimension = kiVar.k0.getResources().getDimension(i);
            if (kiVar.c0 != dimension) {
                kiVar.c0 = dimension;
                kiVar.invalidateSelf();
                kiVar.v();
            }
        }
    }

    public void setChipStrokeColor(ColorStateList colorStateList) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.G(colorStateList);
        }
    }

    public void setChipStrokeColorResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.G(hg0.m(kiVar.k0, i));
        }
    }

    public void setChipStrokeWidth(float f) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.H(f);
        }
    }

    public void setChipStrokeWidthResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.H(kiVar.k0.getResources().getDimension(i));
        }
    }

    @Deprecated
    public void setChipText(CharSequence charSequence) {
        setText(charSequence);
    }

    @Deprecated
    public void setChipTextResource(int i) {
        setText(getResources().getString(i));
    }

    public void setCloseIcon(Drawable drawable) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.I(drawable);
        }
        e();
    }

    public void setCloseIconContentDescription(CharSequence charSequence) {
        ki kiVar = this.g;
        if (kiVar == null || kiVar.V == charSequence) {
            return;
        }
        String str = dc.b;
        dc dcVar = TextUtils.getLayoutDirectionFromLocale(Locale.getDefault()) == 1 ? dc.e : dc.d;
        dcVar.getClass();
        jd jdVar = an1.a;
        kiVar.V = dcVar.c(charSequence);
        kiVar.invalidateSelf();
    }

    @Deprecated
    public void setCloseIconEnabled(boolean z2) {
        setCloseIconVisible(z2);
    }

    @Deprecated
    public void setCloseIconEnabledResource(int i) {
        setCloseIconVisible(i);
    }

    public void setCloseIconEndPadding(float f) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.J(f);
        }
    }

    public void setCloseIconEndPaddingResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.J(kiVar.k0.getResources().getDimension(i));
        }
    }

    public void setCloseIconResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.I(hg0.o(kiVar.k0, i));
        }
        e();
    }

    public void setCloseIconSize(float f) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.K(f);
        }
    }

    public void setCloseIconSizeResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.K(kiVar.k0.getResources().getDimension(i));
        }
    }

    public void setCloseIconStartPadding(float f) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.L(f);
        }
    }

    public void setCloseIconStartPaddingResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.L(kiVar.k0.getResources().getDimension(i));
        }
    }

    public void setCloseIconTint(ColorStateList colorStateList) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.M(colorStateList);
        }
    }

    public void setCloseIconTintResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.M(hg0.m(kiVar.k0, i));
        }
    }

    public void setCloseIconVisible(int i) {
        setCloseIconVisible(getResources().getBoolean(i));
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 != null) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(i, i2, i3, i4);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i, int i2, int i3, int i4) {
        if (i != 0) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (i3 != 0) {
            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }
        super.setCompoundDrawablesWithIntrinsicBounds(i, i2, i3, i4);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.j(f);
        }
    }

    @Override // android.widget.TextView
    public void setEllipsize(TextUtils.TruncateAt truncateAt) {
        if (this.g == null) {
            return;
        }
        if (truncateAt == TextUtils.TruncateAt.MARQUEE) {
            throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
        }
        super.setEllipsize(truncateAt);
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.H0 = truncateAt;
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z2) {
        this.q = z2;
        c(this.s);
    }

    @Override // android.widget.TextView
    public void setGravity(int i) {
        if (i != 8388627) {
            return;
        }
        super.setGravity(i);
    }

    public void setHideMotionSpec(ru0 ru0Var) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.b0 = ru0Var;
        }
    }

    public void setHideMotionSpecResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.b0 = ru0.b(kiVar.k0, i);
        }
    }

    public void setIconEndPadding(float f) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.O(f);
        }
    }

    public void setIconEndPaddingResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.O(kiVar.k0.getResources().getDimension(i));
        }
    }

    public void setIconStartPadding(float f) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.P(f);
        }
    }

    public void setIconStartPaddingResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.P(kiVar.k0.getResources().getDimension(i));
        }
    }

    @Override // defpackage.lr0
    public void setInternalOnCheckedChangeListener(kr0 kr0Var) {
        this.l = kr0Var;
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        if (this.g == null) {
            return;
        }
        super.setLayoutDirection(i);
    }

    @Override // android.widget.TextView
    public void setLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMaxLines(i);
    }

    @Override // android.widget.TextView
    public void setMaxWidth(int i) {
        super.setMaxWidth(i);
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.J0 = i;
        }
    }

    @Override // android.widget.TextView
    public void setMinLines(int i) {
        if (i > 1) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setMinLines(i);
    }

    @Override // android.widget.CompoundButton
    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.k = onCheckedChangeListener;
    }

    public void setOnCloseIconClickListener(View.OnClickListener onClickListener) {
        this.j = onClickListener;
        e();
    }

    public void setRippleColor(ColorStateList colorStateList) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.Q(colorStateList);
        }
        this.g.getClass();
        f();
    }

    public void setRippleColorResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.Q(hg0.m(kiVar.k0, i));
            this.g.getClass();
            f();
        }
    }

    @Override // defpackage.hg1
    public void setShapeAppearanceModel(wf1 wf1Var) {
        this.g.setShapeAppearanceModel(wf1Var);
    }

    public void setShowMotionSpec(ru0 ru0Var) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.a0 = ru0Var;
        }
    }

    public void setShowMotionSpecResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.a0 = ru0.b(kiVar.k0, i);
        }
    }

    @Override // android.widget.TextView
    public void setSingleLine(boolean z2) {
        if (!z2) {
            throw new UnsupportedOperationException("Chip does not support multi-line text");
        }
        super.setSingleLine(z2);
    }

    @Override // android.widget.TextView
    public final void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        ki kiVar = this.g;
        if (kiVar == null) {
            return;
        }
        if (charSequence == null) {
            charSequence = "";
        }
        super.setText(kiVar.I0 ? null : charSequence, bufferType);
        ki kiVar2 = this.g;
        if (kiVar2 == null || TextUtils.equals(kiVar2.K, charSequence)) {
            return;
        }
        kiVar2.K = charSequence;
        kiVar2.q0.d = true;
        kiVar2.invalidateSelf();
        kiVar2.v();
    }

    public void setTextAppearance(zm1 zm1Var) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.q0.b(zm1Var, kiVar.k0);
        }
        h();
    }

    public void setTextAppearanceResource(int i) {
        setTextAppearance(getContext(), i);
    }

    public void setTextEndPadding(float f) {
        ki kiVar = this.g;
        if (kiVar == null || kiVar.g0 == f) {
            return;
        }
        kiVar.g0 = f;
        kiVar.invalidateSelf();
        kiVar.v();
    }

    public void setTextEndPaddingResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            float dimension = kiVar.k0.getResources().getDimension(i);
            if (kiVar.g0 != dimension) {
                kiVar.g0 = dimension;
                kiVar.invalidateSelf();
                kiVar.v();
            }
        }
    }

    public void setTextStartPadding(float f) {
        ki kiVar = this.g;
        if (kiVar == null || kiVar.f0 == f) {
            return;
        }
        kiVar.f0 = f;
        kiVar.invalidateSelf();
        kiVar.v();
    }

    public void setTextStartPaddingResource(int i) {
        ki kiVar = this.g;
        if (kiVar != null) {
            float dimension = kiVar.k0.getResources().getDimension(i);
            if (kiVar.f0 != dimension) {
                kiVar.f0 = dimension;
                kiVar.invalidateSelf();
                kiVar.v();
            }
        }
    }

    public void setCloseIconVisible(boolean z2) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.N(z2);
        }
        e();
    }

    public void setCheckedIconVisible(boolean z2) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.A(z2);
        }
    }

    public void setChipIconVisible(boolean z2) {
        ki kiVar = this.g;
        if (kiVar != null) {
            kiVar.F(z2);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        if (drawable != null) {
            throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
        }
        if (drawable3 == null) {
            super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
            return;
        }
        throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        ki kiVar = this.g;
        if (kiVar != null) {
            Context context2 = kiVar.k0;
            kiVar.q0.b(new zm1(context2, i), context2);
        }
        h();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(int i) {
        super.setTextAppearance(i);
        ki kiVar = this.g;
        if (kiVar != null) {
            Context context = kiVar.k0;
            kiVar.q0.b(new zm1(context, i), context);
        }
        h();
    }
}
