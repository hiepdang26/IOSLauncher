package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatDrawableManager;
import androidx.appcompat.widget.AppCompatImageHelper;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import defpackage.a20;
import defpackage.az1;
import defpackage.b71;
import defpackage.be;
import defpackage.d20;
import defpackage.d51;
import defpackage.f71;
import defpackage.fz1;
import defpackage.hd;
import defpackage.hg1;
import defpackage.lo;
import defpackage.mn1;
import defpackage.mo;
import defpackage.np1;
import defpackage.o30;
import defpackage.po;
import defpackage.q30;
import defpackage.q41;
import defpackage.qg0;
import defpackage.qo;
import defpackage.qs1;
import defpackage.rr0;
import defpackage.ru0;
import defpackage.tr0;
import defpackage.ug1;
import defpackage.wf1;
import defpackage.y91;
import defpackage.z10;
import defpackage.zc;
import defpackage.zu1;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public class FloatingActionButton extends zu1 implements z10, hg1, lo {
    public static final int w = b71.Widget_Design_FloatingActionButton;
    public ColorStateList h;
    public PorterDuff.Mode i;
    public ColorStateList j;
    public PorterDuff.Mode k;
    public ColorStateList l;
    public int m;
    public int n;
    public int o;
    public int p;
    public boolean q;
    public final Rect r;
    public final Rect s;
    public final AppCompatImageHelper t;
    public final a20 u;
    public q30 v;

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        int i = q41.floatingActionButtonStyle;
        int i2 = w;
        super(tr0.a(context, attributeSet, i, i2), attributeSet, i);
        this.g = getVisibility();
        this.r = new Rect();
        this.s = new Rect();
        Context context2 = getContext();
        TypedArray typedArrayD = mn1.d(context2, attributeSet, f71.FloatingActionButton, i, i2, new int[0]);
        this.h = np1.l(context2, typedArrayD, f71.FloatingActionButton_backgroundTint);
        this.i = qg0.C(typedArrayD.getInt(f71.FloatingActionButton_backgroundTintMode, -1), null);
        this.l = np1.l(context2, typedArrayD, f71.FloatingActionButton_rippleColor);
        this.m = typedArrayD.getInt(f71.FloatingActionButton_fabSize, -1);
        this.n = typedArrayD.getDimensionPixelSize(f71.FloatingActionButton_fabCustomSize, 0);
        int dimensionPixelSize = typedArrayD.getDimensionPixelSize(f71.FloatingActionButton_borderWidth, 0);
        float dimension = typedArrayD.getDimension(f71.FloatingActionButton_elevation, 0.0f);
        float dimension2 = typedArrayD.getDimension(f71.FloatingActionButton_hoveredFocusedTranslationZ, 0.0f);
        float dimension3 = typedArrayD.getDimension(f71.FloatingActionButton_pressedTranslationZ, 0.0f);
        this.q = typedArrayD.getBoolean(f71.FloatingActionButton_useCompatPadding, false);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d51.mtrl_fab_min_touch_target);
        setMaxImageSize(typedArrayD.getDimensionPixelSize(f71.FloatingActionButton_maxImageSize, 0));
        ru0 ru0VarA = ru0.a(context2, typedArrayD, f71.FloatingActionButton_showMotionSpec);
        ru0 ru0VarA2 = ru0.a(context2, typedArrayD, f71.FloatingActionButton_hideMotionSpec);
        y91 y91Var = wf1.m;
        TypedArray typedArrayObtainStyledAttributes = context2.obtainStyledAttributes(attributeSet, f71.MaterialShape, i, i2);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(f71.MaterialShape_shapeAppearance, 0);
        int resourceId2 = typedArrayObtainStyledAttributes.getResourceId(f71.MaterialShape_shapeAppearanceOverlay, 0);
        typedArrayObtainStyledAttributes.recycle();
        wf1 wf1VarA = wf1.a(context2, resourceId, resourceId2, y91Var).a();
        boolean z = typedArrayD.getBoolean(f71.FloatingActionButton_ensureMinTouchTargetSize, false);
        setEnabled(typedArrayD.getBoolean(f71.FloatingActionButton_android_enabled, true));
        typedArrayD.recycle();
        AppCompatImageHelper appCompatImageHelper = new AppCompatImageHelper(this);
        this.t = appCompatImageHelper;
        appCompatImageHelper.loadFromAttributes(attributeSet, i);
        this.u = new a20(this);
        getImpl().n(wf1VarA);
        getImpl().g(this.h, this.i, this.l, dimensionPixelSize);
        getImpl().k = dimensionPixelSize2;
        o30 impl = getImpl();
        if (impl.h != dimension) {
            impl.h = dimension;
            impl.k(dimension, impl.i, impl.j);
        }
        o30 impl2 = getImpl();
        if (impl2.i != dimension2) {
            impl2.i = dimension2;
            impl2.k(impl2.h, dimension2, impl2.j);
        }
        o30 impl3 = getImpl();
        if (impl3.j != dimension3) {
            impl3.j = dimension3;
            impl3.k(impl3.h, impl3.i, dimension3);
        }
        getImpl().m = ru0VarA;
        getImpl().n = ru0VarA2;
        getImpl().f = z;
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private o30 getImpl() {
        if (this.v == null) {
            this.v = new q30(this, new fz1(this, 14));
        }
        return this.v;
    }

    public final int c(int i) {
        int i2 = this.n;
        if (i2 != 0) {
            return i2;
        }
        Resources resources = getResources();
        return i != -1 ? i != 1 ? resources.getDimensionPixelSize(d51.design_fab_size_normal) : resources.getDimensionPixelSize(d51.design_fab_size_mini) : Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? c(1) : c(0);
    }

    public final void d() {
        o30 impl = getImpl();
        FloatingActionButton floatingActionButton = impl.s;
        if (floatingActionButton.getVisibility() == 0) {
            if (impl.r == 1) {
                return;
            }
        } else if (impl.r != 2) {
            return;
        }
        Animator animator = impl.l;
        if (animator != null) {
            animator.cancel();
        }
        WeakHashMap weakHashMap = qs1.a;
        FloatingActionButton floatingActionButton2 = impl.s;
        if (!floatingActionButton2.isLaidOut() || floatingActionButton2.isInEditMode()) {
            floatingActionButton.a(4, false);
            return;
        }
        ru0 ru0Var = impl.n;
        AnimatorSet animatorSetB = ru0Var != null ? impl.b(ru0Var, 0.0f, 0.0f, 0.0f) : impl.c(0.0f, 0.4f, 0.4f);
        animatorSetB.addListener(new zc(impl));
        animatorSetB.start();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().j(getDrawableState());
    }

    public final void e() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.j;
        if (colorStateList == null) {
            az1.d(drawable);
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.k;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(AppCompatDrawableManager.getPorterDuffColorFilter(colorForState, mode));
    }

    public final void f() {
        o30 impl = getImpl();
        if (impl.s.getVisibility() != 0) {
            if (impl.r == 2) {
                return;
            }
        } else if (impl.r != 1) {
            return;
        }
        Animator animator = impl.l;
        if (animator != null) {
            animator.cancel();
        }
        boolean z = impl.m == null;
        WeakHashMap weakHashMap = qs1.a;
        FloatingActionButton floatingActionButton = impl.s;
        boolean z2 = floatingActionButton.isLaidOut() && !floatingActionButton.isInEditMode();
        Matrix matrix = impl.x;
        if (!z2) {
            floatingActionButton.a(0, false);
            floatingActionButton.setAlpha(1.0f);
            floatingActionButton.setScaleY(1.0f);
            floatingActionButton.setScaleX(1.0f);
            impl.p = 1.0f;
            impl.a(1.0f, matrix);
            floatingActionButton.setImageMatrix(matrix);
            return;
        }
        if (floatingActionButton.getVisibility() != 0) {
            floatingActionButton.setAlpha(0.0f);
            floatingActionButton.setScaleY(z ? 0.4f : 0.0f);
            floatingActionButton.setScaleX(z ? 0.4f : 0.0f);
            float f = z ? 0.4f : 0.0f;
            impl.p = f;
            impl.a(f, matrix);
            floatingActionButton.setImageMatrix(matrix);
        }
        ru0 ru0Var = impl.m;
        AnimatorSet animatorSetB = ru0Var != null ? impl.b(ru0Var, 1.0f, 1.0f, 1.0f) : impl.c(1.0f, 1.0f, 1.0f);
        animatorSetB.addListener(new be(impl, 5));
        animatorSetB.start();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.h;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.i;
    }

    @Override // defpackage.lo
    public mo getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().e();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().i;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().j;
    }

    public Drawable getContentBackground() {
        return getImpl().e;
    }

    public int getCustomSize() {
        return this.n;
    }

    public int getExpandedComponentIdHint() {
        return this.u.c;
    }

    public ru0 getHideMotionSpec() {
        return getImpl().n;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.l;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.l;
    }

    public wf1 getShapeAppearanceModel() {
        wf1 wf1Var = getImpl().a;
        wf1Var.getClass();
        return wf1Var;
    }

    public ru0 getShowMotionSpec() {
        return getImpl().m;
    }

    public int getSize() {
        return this.m;
    }

    public int getSizeDimension() {
        return c(this.m);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.j;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.k;
    }

    public boolean getUseCompatPadding() {
        return this.q;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().h();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        o30 impl = getImpl();
        rr0 rr0Var = impl.b;
        FloatingActionButton floatingActionButton = impl.s;
        if (rr0Var != null) {
            az1.H(floatingActionButton, rr0Var);
        }
        if (impl instanceof q30) {
            return;
        }
        ViewTreeObserver viewTreeObserver = floatingActionButton.getViewTreeObserver();
        if (impl.y == null) {
            impl.y = new qo(impl, 1);
        }
        viewTreeObserver.addOnPreDrawListener(impl.y);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        o30 impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.s.getViewTreeObserver();
        qo qoVar = impl.y;
        if (qoVar != null) {
            viewTreeObserver.removeOnPreDrawListener(qoVar);
            impl.y = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i, int i2) {
        int sizeDimension = getSizeDimension();
        this.o = (sizeDimension - this.p) / 2;
        getImpl().q();
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(sizeDimension, size);
        } else if (mode == 0) {
            size = sizeDimension;
        } else if (mode != 1073741824) {
            throw new IllegalArgumentException();
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE) {
            sizeDimension = Math.min(sizeDimension, size2);
        } else if (mode2 != 0) {
            if (mode2 != 1073741824) {
                throw new IllegalArgumentException();
            }
            sizeDimension = size2;
        }
        int iMin = Math.min(size, sizeDimension);
        Rect rect = this.r;
        setMeasuredDimension(rect.left + iMin + rect.right, iMin + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        List list;
        if (!(parcelable instanceof d20)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        d20 d20Var = (d20) parcelable;
        super.onRestoreInstanceState(d20Var.getSuperState());
        Object obj = d20Var.g.get("expandableWidgetHelper");
        obj.getClass();
        Bundle bundle = (Bundle) obj;
        a20 a20Var = this.u;
        a20Var.getClass();
        a20Var.b = bundle.getBoolean("expanded", false);
        a20Var.c = bundle.getInt("expandedComponentIdHint", 0);
        if (a20Var.b) {
            View view = a20Var.a;
            ViewParent parent = view.getParent();
            if (!(parent instanceof CoordinatorLayout) || (list = (List) ((ug1) ((CoordinatorLayout) parent).h.b).get(view)) == null || list.isEmpty()) {
                return;
            }
            for (int i = 0; i < list.size(); i++) {
                View view2 = (View) list.get(i);
                mo moVar = ((po) view2.getLayoutParams()).a;
                if (moVar != null) {
                    moVar.d(view2, view);
                }
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState();
        if (parcelableOnSaveInstanceState == null) {
            parcelableOnSaveInstanceState = new Bundle();
        }
        d20 d20Var = new d20(parcelableOnSaveInstanceState);
        ug1 ug1Var = d20Var.g;
        a20 a20Var = this.u;
        a20Var.getClass();
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", a20Var.b);
        bundle.putInt("expandedComponentIdHint", a20Var.c);
        ug1Var.put("expandableWidgetHelper", bundle);
        return d20Var;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            WeakHashMap weakHashMap = qs1.a;
            if (isLaidOut()) {
                int width = getWidth();
                int height = getHeight();
                Rect rect = this.s;
                rect.set(0, 0, width, height);
                int i = rect.left;
                Rect rect2 = this.r;
                rect.left = i + rect2.left;
                rect.top += rect2.top;
                rect.right -= rect2.right;
                rect.bottom -= rect2.bottom;
                if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    return false;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
    }

    @Override // android.view.View
    public void setBackgroundResource(int i) {
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.h != colorStateList) {
            this.h = colorStateList;
            o30 impl = getImpl();
            rr0 rr0Var = impl.b;
            if (rr0Var != null) {
                rr0Var.setTintList(colorStateList);
            }
            hd hdVar = impl.d;
            if (hdVar != null) {
                if (colorStateList != null) {
                    hdVar.m = colorStateList.getColorForState(hdVar.getState(), hdVar.m);
                }
                hdVar.p = colorStateList;
                hdVar.n = true;
                hdVar.invalidateSelf();
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.i != mode) {
            this.i = mode;
            rr0 rr0Var = getImpl().b;
            if (rr0Var != null) {
                rr0Var.setTintMode(mode);
            }
        }
    }

    public void setCompatElevation(float f) {
        o30 impl = getImpl();
        if (impl.h != f) {
            impl.h = f;
            impl.k(f, impl.i, impl.j);
        }
    }

    public void setCompatElevationResource(int i) {
        setCompatElevation(getResources().getDimension(i));
    }

    public void setCompatHoveredFocusedTranslationZ(float f) {
        o30 impl = getImpl();
        if (impl.i != f) {
            impl.i = f;
            impl.k(impl.h, f, impl.j);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int i) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i));
    }

    public void setCompatPressedTranslationZ(float f) {
        o30 impl = getImpl();
        if (impl.j != f) {
            impl.j = f;
            impl.k(impl.h, impl.i, f);
        }
    }

    public void setCompatPressedTranslationZResource(int i) {
        setCompatPressedTranslationZ(getResources().getDimension(i));
    }

    public void setCustomSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i != this.n) {
            this.n = i;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        rr0 rr0Var = getImpl().b;
        if (rr0Var != null) {
            rr0Var.j(f);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z) {
        if (z != getImpl().f) {
            getImpl().f = z;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i) {
        this.u.c = i;
    }

    public void setHideMotionSpec(ru0 ru0Var) {
        getImpl().n = ru0Var;
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(ru0.b(getContext(), i));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            o30 impl = getImpl();
            float f = impl.p;
            impl.p = f;
            Matrix matrix = impl.x;
            impl.a(f, matrix);
            impl.s.setImageMatrix(matrix);
            if (this.j != null) {
                e();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i) {
        this.t.setImageResource(i);
        e();
    }

    public void setMaxImageSize(int i) {
        this.p = i;
        o30 impl = getImpl();
        if (impl.q != i) {
            impl.q = i;
            float f = impl.p;
            impl.p = f;
            Matrix matrix = impl.x;
            impl.a(f, matrix);
            impl.s.setImageMatrix(matrix);
        }
    }

    public void setRippleColor(int i) {
        setRippleColor(ColorStateList.valueOf(i));
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        super.setScaleX(f);
        getImpl().getClass();
    }

    @Override // android.view.View
    public void setScaleY(float f) {
        super.setScaleY(f);
        getImpl().getClass();
    }

    public void setShadowPaddingEnabled(boolean z) {
        o30 impl = getImpl();
        impl.g = z;
        impl.q();
    }

    @Override // defpackage.hg1
    public void setShapeAppearanceModel(wf1 wf1Var) {
        getImpl().n(wf1Var);
    }

    public void setShowMotionSpec(ru0 ru0Var) {
        getImpl().m = ru0Var;
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(ru0.b(getContext(), i));
    }

    public void setSize(int i) {
        this.n = 0;
        if (i != this.m) {
            this.m = i;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.j != colorStateList) {
            this.j = colorStateList;
            e();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.k != mode) {
            this.k = mode;
            e();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f) {
        super.setTranslationX(f);
        getImpl().l();
    }

    @Override // android.view.View
    public void setTranslationY(float f) {
        super.setTranslationY(f);
        getImpl().l();
    }

    @Override // android.view.View
    public void setTranslationZ(float f) {
        super.setTranslationZ(f);
        getImpl().l();
    }

    public void setUseCompatPadding(boolean z) {
        if (this.q != z) {
            this.q = z;
            getImpl().i();
        }
    }

    @Override // defpackage.zu1, android.widget.ImageView, android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
    }

    public static class BaseBehavior<T extends FloatingActionButton> extends mo {
        public final boolean a;

        public BaseBehavior() {
            this.a = true;
        }

        @Override // defpackage.mo
        public final boolean a(View view, Rect rect) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            int left = floatingActionButton.getLeft();
            Rect rect2 = floatingActionButton.r;
            rect.set(left + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // defpackage.mo
        public final void c(po poVar) {
            if (poVar.h == 0) {
                poVar.h = 80;
            }
        }

        @Override // defpackage.mo
        public final boolean d(View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            if (layoutParams instanceof po ? ((po) layoutParams).a instanceof BottomSheetBehavior : false) {
                s(view2, floatingActionButton);
            }
            return false;
        }

        @Override // defpackage.mo
        public final boolean g(CoordinatorLayout coordinatorLayout, View view, int i) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            ArrayList arrayListD = coordinatorLayout.d(floatingActionButton);
            int size = arrayListD.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                View view2 = (View) arrayListD.get(i3);
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if ((layoutParams instanceof po ? ((po) layoutParams).a instanceof BottomSheetBehavior : false) && s(view2, floatingActionButton)) {
                    break;
                }
            }
            coordinatorLayout.j(i, floatingActionButton);
            Rect rect = floatingActionButton.r;
            if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
                return true;
            }
            po poVar = (po) floatingActionButton.getLayoutParams();
            int i4 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) poVar).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) poVar).leftMargin ? -rect.left : 0;
            if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) poVar).bottomMargin) {
                i2 = rect.bottom;
            } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) poVar).topMargin) {
                i2 = -rect.top;
            }
            if (i2 != 0) {
                qs1.j(i2, floatingActionButton);
            }
            if (i4 == 0) {
                return true;
            }
            qs1.i(i4, floatingActionButton);
            return true;
        }

        public final boolean s(View view, FloatingActionButton floatingActionButton) {
            if (!(this.a && ((po) floatingActionButton.getLayoutParams()).f == view.getId() && floatingActionButton.getUserSetVisibility() == 0)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((po) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.d();
            } else {
                floatingActionButton.f();
            }
            return true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f71.FloatingActionButton_Behavior_Layout);
            this.a = typedArrayObtainStyledAttributes.getBoolean(f71.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.l != colorStateList) {
            this.l = colorStateList;
            getImpl().m(this.l);
        }
    }
}
