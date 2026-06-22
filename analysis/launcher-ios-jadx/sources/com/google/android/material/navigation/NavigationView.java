package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.TintTypedArray;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.internal.NavigationMenuView;
import defpackage.az1;
import defpackage.b71;
import defpackage.d;
import defpackage.dw0;
import defpackage.f71;
import defpackage.gw0;
import defpackage.hg0;
import defpackage.hs1;
import defpackage.ie1;
import defpackage.l61;
import defpackage.lg;
import defpackage.lw0;
import defpackage.mc1;
import defpackage.mn1;
import defpackage.mt0;
import defpackage.np1;
import defpackage.nx0;
import defpackage.ow0;
import defpackage.q41;
import defpackage.qr0;
import defpackage.qs1;
import defpackage.qw0;
import defpackage.r41;
import defpackage.rr0;
import defpackage.rw0;
import defpackage.tk1;
import defpackage.tr0;
import defpackage.vf1;
import defpackage.vt0;
import defpackage.wd;
import defpackage.wf1;
import defpackage.xf1;
import defpackage.yf1;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class NavigationView extends ie1 {
    public final dw0 l;
    public final ow0 m;
    public qw0 n;
    public final int o;
    public final int[] p;
    public tk1 q;
    public final lg r;
    public boolean s;
    public boolean t;
    public final int u;
    public final int v;
    public Path w;
    public final RectF x;
    public static final int[] y = {R.attr.state_checked};
    public static final int[] z = {-16842910};
    public static final int A = b71.Widget_Design_NavigationView;

    /* JADX WARN: Illegal instructions before constructor call */
    public NavigationView(Context context, AttributeSet attributeSet) {
        int i = q41.navigationViewStyle;
        int i2 = A;
        Context contextA = tr0.a(context, attributeSet, i, i2);
        super(contextA, attributeSet, i);
        this.i = new Rect();
        this.j = true;
        this.k = true;
        int[] iArr = f71.ScrimInsetsFrameLayout;
        int i3 = b71.Widget_Design_ScrimInsetsFrameLayout;
        mn1.a(contextA, attributeSet, i, i3);
        mn1.b(contextA, attributeSet, iArr, i, i3, new int[0]);
        TypedArray typedArrayObtainStyledAttributes = contextA.obtainStyledAttributes(attributeSet, iArr, i, i3);
        this.g = typedArrayObtainStyledAttributes.getDrawable(f71.ScrimInsetsFrameLayout_insetForeground);
        typedArrayObtainStyledAttributes.recycle();
        setWillNotDraw(true);
        nx0 nx0Var = new nx0(this, 23);
        WeakHashMap weakHashMap = qs1.a;
        hs1.m(this, nx0Var);
        ow0 ow0Var = new ow0();
        this.m = ow0Var;
        this.p = new int[2];
        this.s = true;
        this.t = true;
        this.u = 0;
        this.v = 0;
        this.x = new RectF();
        Context context2 = getContext();
        dw0 dw0Var = new dw0(context2);
        this.l = dw0Var;
        int[] iArr2 = f71.NavigationView;
        mn1.a(context2, attributeSet, i, i2);
        mn1.b(context2, attributeSet, iArr2, i, i2, new int[0]);
        TintTypedArray tintTypedArrayObtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context2, attributeSet, iArr2, i, i2);
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.NavigationView_android_background)) {
            setBackground(tintTypedArrayObtainStyledAttributes.getDrawable(f71.NavigationView_android_background));
        }
        this.v = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(f71.NavigationView_drawerLayoutCornerSize, 0);
        this.u = tintTypedArrayObtainStyledAttributes.getInt(f71.NavigationView_android_layout_gravity, 0);
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            wf1 wf1VarA = wf1.b(context2, attributeSet, i, i2).a();
            Drawable background = getBackground();
            rr0 rr0Var = new rr0(wf1VarA);
            if (background instanceof ColorDrawable) {
                rr0Var.k(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            rr0Var.i(context2);
            setBackground(rr0Var);
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.NavigationView_elevation)) {
            setElevation(tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(f71.NavigationView_elevation, 0));
        }
        setFitsSystemWindows(tintTypedArrayObtainStyledAttributes.getBoolean(f71.NavigationView_android_fitsSystemWindows, false));
        this.o = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(f71.NavigationView_android_maxWidth, 0);
        ColorStateList colorStateList = tintTypedArrayObtainStyledAttributes.hasValue(f71.NavigationView_subheaderColor) ? tintTypedArrayObtainStyledAttributes.getColorStateList(f71.NavigationView_subheaderColor) : null;
        int resourceId = tintTypedArrayObtainStyledAttributes.hasValue(f71.NavigationView_subheaderTextAppearance) ? tintTypedArrayObtainStyledAttributes.getResourceId(f71.NavigationView_subheaderTextAppearance, 0) : 0;
        if (resourceId == 0 && colorStateList == null) {
            colorStateList = a(R.attr.textColorSecondary);
        }
        ColorStateList colorStateList2 = tintTypedArrayObtainStyledAttributes.hasValue(f71.NavigationView_itemIconTint) ? tintTypedArrayObtainStyledAttributes.getColorStateList(f71.NavigationView_itemIconTint) : a(R.attr.textColorSecondary);
        int resourceId2 = tintTypedArrayObtainStyledAttributes.hasValue(f71.NavigationView_itemTextAppearance) ? tintTypedArrayObtainStyledAttributes.getResourceId(f71.NavigationView_itemTextAppearance, 0) : 0;
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.NavigationView_itemIconSize)) {
            setItemIconSize(tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(f71.NavigationView_itemIconSize, 0));
        }
        ColorStateList colorStateList3 = tintTypedArrayObtainStyledAttributes.hasValue(f71.NavigationView_itemTextColor) ? tintTypedArrayObtainStyledAttributes.getColorStateList(f71.NavigationView_itemTextColor) : null;
        if (resourceId2 == 0 && colorStateList3 == null) {
            colorStateList3 = a(R.attr.textColorPrimary);
        }
        Drawable drawable = tintTypedArrayObtainStyledAttributes.getDrawable(f71.NavigationView_itemBackground);
        if (drawable == null && (tintTypedArrayObtainStyledAttributes.hasValue(f71.NavigationView_itemShapeAppearance) || tintTypedArrayObtainStyledAttributes.hasValue(f71.NavigationView_itemShapeAppearanceOverlay))) {
            drawable = b(tintTypedArrayObtainStyledAttributes, np1.m(getContext(), tintTypedArrayObtainStyledAttributes, f71.NavigationView_itemShapeFillColor));
            ColorStateList colorStateListM = np1.m(context2, tintTypedArrayObtainStyledAttributes, f71.NavigationView_itemRippleColor);
            if (colorStateListM != null) {
                ow0Var.s = new RippleDrawable(wd.F(colorStateListM), null, b(tintTypedArrayObtainStyledAttributes, null));
                ow0Var.updateMenuView(false);
            }
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.NavigationView_itemHorizontalPadding)) {
            setItemHorizontalPadding(tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(f71.NavigationView_itemHorizontalPadding, 0));
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.NavigationView_itemVerticalPadding)) {
            setItemVerticalPadding(tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(f71.NavigationView_itemVerticalPadding, 0));
        }
        setDividerInsetStart(tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(f71.NavigationView_dividerInsetStart, 0));
        setDividerInsetEnd(tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(f71.NavigationView_dividerInsetEnd, 0));
        setSubheaderInsetStart(tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(f71.NavigationView_subheaderInsetStart, 0));
        setSubheaderInsetEnd(tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(f71.NavigationView_subheaderInsetEnd, 0));
        setTopInsetScrimEnabled(tintTypedArrayObtainStyledAttributes.getBoolean(f71.NavigationView_topInsetScrimEnabled, this.s));
        setBottomInsetScrimEnabled(tintTypedArrayObtainStyledAttributes.getBoolean(f71.NavigationView_bottomInsetScrimEnabled, this.t));
        int dimensionPixelSize = tintTypedArrayObtainStyledAttributes.getDimensionPixelSize(f71.NavigationView_itemIconPadding, 0);
        setItemMaxLines(tintTypedArrayObtainStyledAttributes.getInt(f71.NavigationView_itemMaxLines, 1));
        dw0Var.k = new mc1(this, 18);
        ow0Var.j = 1;
        ow0Var.initForMenu(context2, dw0Var);
        if (resourceId != 0) {
            ow0Var.m = resourceId;
            ow0Var.updateMenuView(false);
        }
        ow0Var.n = colorStateList;
        ow0Var.updateMenuView(false);
        ow0Var.q = colorStateList2;
        ow0Var.updateMenuView(false);
        int overScrollMode = getOverScrollMode();
        ow0Var.F = overScrollMode;
        NavigationMenuView navigationMenuView = ow0Var.g;
        if (navigationMenuView != null) {
            navigationMenuView.setOverScrollMode(overScrollMode);
        }
        if (resourceId2 != 0) {
            ow0Var.o = resourceId2;
            ow0Var.updateMenuView(false);
        }
        ow0Var.p = colorStateList3;
        ow0Var.updateMenuView(false);
        ow0Var.r = drawable;
        ow0Var.updateMenuView(false);
        ow0Var.v = dimensionPixelSize;
        ow0Var.updateMenuView(false);
        dw0Var.b(ow0Var, dw0Var.g);
        if (ow0Var.g == null) {
            NavigationMenuView navigationMenuView2 = (NavigationMenuView) ow0Var.l.inflate(l61.design_navigation_menu, (ViewGroup) this, false);
            ow0Var.g = navigationMenuView2;
            navigationMenuView2.setAccessibilityDelegateCompat(new lw0(ow0Var, ow0Var.g));
            if (ow0Var.k == null) {
                ow0Var.k = new gw0(ow0Var);
            }
            int i4 = ow0Var.F;
            if (i4 != -1) {
                ow0Var.g.setOverScrollMode(i4);
            }
            ow0Var.h = (LinearLayout) ow0Var.l.inflate(l61.design_navigation_item_header, (ViewGroup) ow0Var.g, false);
            ow0Var.g.setAdapter(ow0Var.k);
        }
        addView(ow0Var.g);
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.NavigationView_menu)) {
            int resourceId3 = tintTypedArrayObtainStyledAttributes.getResourceId(f71.NavigationView_menu, 0);
            gw0 gw0Var = ow0Var.k;
            if (gw0Var != null) {
                gw0Var.l = true;
            }
            getMenuInflater().inflate(resourceId3, dw0Var);
            gw0 gw0Var2 = ow0Var.k;
            if (gw0Var2 != null) {
                gw0Var2.l = false;
            }
            ow0Var.updateMenuView(false);
        }
        if (tintTypedArrayObtainStyledAttributes.hasValue(f71.NavigationView_headerLayout)) {
            ow0Var.h.addView(ow0Var.l.inflate(tintTypedArrayObtainStyledAttributes.getResourceId(f71.NavigationView_headerLayout, 0), (ViewGroup) ow0Var.h, false));
            NavigationMenuView navigationMenuView3 = ow0Var.g;
            navigationMenuView3.setPadding(0, 0, 0, navigationMenuView3.getPaddingBottom());
        }
        tintTypedArrayObtainStyledAttributes.recycle();
        this.r = new lg(this, 2);
        getViewTreeObserver().addOnGlobalLayoutListener(this.r);
    }

    private MenuInflater getMenuInflater() {
        if (this.q == null) {
            this.q = new tk1(getContext());
        }
        return this.q;
    }

    public final ColorStateList a(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateListM = hg0.m(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(r41.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateListM.getDefaultColor();
        int[] iArr = z;
        return new ColorStateList(new int[][]{iArr, y, FrameLayout.EMPTY_STATE_SET}, new int[]{colorStateListM.getColorForState(iArr, defaultColor), i2, defaultColor});
    }

    public final InsetDrawable b(TintTypedArray tintTypedArray, ColorStateList colorStateList) {
        rr0 rr0Var = new rr0(wf1.a(getContext(), tintTypedArray.getResourceId(f71.NavigationView_itemShapeAppearance, 0), tintTypedArray.getResourceId(f71.NavigationView_itemShapeAppearanceOverlay, 0), new d(0)).a());
        rr0Var.k(colorStateList);
        return new InsetDrawable((Drawable) rr0Var, tintTypedArray.getDimensionPixelSize(f71.NavigationView_itemShapeInsetStart, 0), tintTypedArray.getDimensionPixelSize(f71.NavigationView_itemShapeInsetTop, 0), tintTypedArray.getDimensionPixelSize(f71.NavigationView_itemShapeInsetEnd, 0), tintTypedArray.getDimensionPixelSize(f71.NavigationView_itemShapeInsetBottom, 0));
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        if (this.w == null) {
            super.dispatchDraw(canvas);
            return;
        }
        int iSave = canvas.save();
        canvas.clipPath(this.w);
        super.dispatchDraw(canvas);
        canvas.restoreToCount(iSave);
    }

    public MenuItem getCheckedItem() {
        return this.m.k.k;
    }

    public int getDividerInsetEnd() {
        return this.m.y;
    }

    public int getDividerInsetStart() {
        return this.m.x;
    }

    public int getHeaderCount() {
        return this.m.h.getChildCount();
    }

    public Drawable getItemBackground() {
        return this.m.r;
    }

    public int getItemHorizontalPadding() {
        return this.m.t;
    }

    public int getItemIconPadding() {
        return this.m.v;
    }

    public ColorStateList getItemIconTintList() {
        return this.m.q;
    }

    public int getItemMaxLines() {
        return this.m.C;
    }

    public ColorStateList getItemTextColor() {
        return this.m.p;
    }

    public int getItemVerticalPadding() {
        return this.m.u;
    }

    public Menu getMenu() {
        return this.l;
    }

    public int getSubheaderInsetEnd() {
        this.m.getClass();
        return 0;
    }

    public int getSubheaderInsetStart() {
        return this.m.z;
    }

    @Override // defpackage.ie1, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        Drawable background = getBackground();
        if (background instanceof rr0) {
            az1.H(this, (rr0) background);
        }
    }

    @Override // defpackage.ie1, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.r);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int i3 = this.o;
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), i3), 1073741824);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Parcelable parcelable2;
        if (!(parcelable instanceof rw0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        rw0 rw0Var = (rw0) parcelable;
        super.onRestoreInstanceState(rw0Var.getSuperState());
        Bundle bundle = rw0Var.g;
        dw0 dw0Var = this.l;
        dw0Var.getClass();
        SparseArray sparseParcelableArray = bundle.getSparseParcelableArray("android:menu:presenters");
        if (sparseParcelableArray != null) {
            CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = dw0Var.A;
            if (copyOnWriteArrayList.isEmpty()) {
                return;
            }
            for (WeakReference weakReference : copyOnWriteArrayList) {
                vt0 vt0Var = (vt0) weakReference.get();
                if (vt0Var == null) {
                    copyOnWriteArrayList.remove(weakReference);
                } else {
                    int id = vt0Var.getId();
                    if (id > 0 && (parcelable2 = (Parcelable) sparseParcelableArray.get(id)) != null) {
                        vt0Var.onRestoreInstanceState(parcelable2);
                    }
                }
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable parcelableOnSaveInstanceState;
        rw0 rw0Var = new rw0(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        rw0Var.g = bundle;
        CopyOnWriteArrayList<WeakReference> copyOnWriteArrayList = this.l.A;
        if (copyOnWriteArrayList.isEmpty()) {
            return rw0Var;
        }
        SparseArray<? extends Parcelable> sparseArray = new SparseArray<>();
        for (WeakReference weakReference : copyOnWriteArrayList) {
            vt0 vt0Var = (vt0) weakReference.get();
            if (vt0Var == null) {
                copyOnWriteArrayList.remove(weakReference);
            } else {
                int id = vt0Var.getId();
                if (id > 0 && (parcelableOnSaveInstanceState = vt0Var.onSaveInstanceState()) != null) {
                    sparseArray.put(id, parcelableOnSaveInstanceState);
                }
            }
        }
        bundle.putSparseParcelableArray("android:menu:presenters", sparseArray);
        return rw0Var;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        int i5;
        super.onSizeChanged(i, i2, i3, i4);
        boolean z2 = getParent() instanceof DrawerLayout;
        RectF rectF = this.x;
        if (!z2 || (i5 = this.v) <= 0 || !(getBackground() instanceof rr0)) {
            this.w = null;
            rectF.setEmpty();
            return;
        }
        rr0 rr0Var = (rr0) getBackground();
        vf1 vf1VarE = rr0Var.g.a.e();
        WeakHashMap weakHashMap = qs1.a;
        if (Gravity.getAbsoluteGravity(this.u, getLayoutDirection()) == 3) {
            float f = i5;
            vf1VarE.f = new d(f);
            vf1VarE.g = new d(f);
        } else {
            float f2 = i5;
            vf1VarE.e = new d(f2);
            vf1VarE.h = new d(f2);
        }
        rr0Var.setShapeAppearanceModel(vf1VarE.a());
        if (this.w == null) {
            this.w = new Path();
        }
        this.w.reset();
        rectF.set(0.0f, 0.0f, i, i2);
        yf1 yf1Var = xf1.a;
        qr0 qr0Var = rr0Var.g;
        yf1Var.a(qr0Var.a, qr0Var.i, rectF, null, this.w);
        invalidate();
    }

    public void setBottomInsetScrimEnabled(boolean z2) {
        this.t = z2;
    }

    public void setCheckedItem(int i) {
        MenuItem menuItemFindItem = this.l.findItem(i);
        if (menuItemFindItem != null) {
            this.m.k.q((mt0) menuItemFindItem);
        }
    }

    public void setDividerInsetEnd(int i) {
        ow0 ow0Var = this.m;
        ow0Var.y = i;
        ow0Var.updateMenuView(false);
    }

    public void setDividerInsetStart(int i) {
        ow0 ow0Var = this.m;
        ow0Var.x = i;
        ow0Var.updateMenuView(false);
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        Drawable background = getBackground();
        if (background instanceof rr0) {
            ((rr0) background).j(f);
        }
    }

    public void setItemBackground(Drawable drawable) {
        ow0 ow0Var = this.m;
        ow0Var.r = drawable;
        ow0Var.updateMenuView(false);
    }

    public void setItemBackgroundResource(int i) {
        setItemBackground(getContext().getDrawable(i));
    }

    public void setItemHorizontalPadding(int i) {
        ow0 ow0Var = this.m;
        ow0Var.t = i;
        ow0Var.updateMenuView(false);
    }

    public void setItemHorizontalPaddingResource(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        ow0 ow0Var = this.m;
        ow0Var.t = dimensionPixelSize;
        ow0Var.updateMenuView(false);
    }

    public void setItemIconPadding(int i) {
        ow0 ow0Var = this.m;
        ow0Var.v = i;
        ow0Var.updateMenuView(false);
    }

    public void setItemIconPaddingResource(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        ow0 ow0Var = this.m;
        ow0Var.v = dimensionPixelSize;
        ow0Var.updateMenuView(false);
    }

    public void setItemIconSize(int i) {
        ow0 ow0Var = this.m;
        if (ow0Var.w != i) {
            ow0Var.w = i;
            ow0Var.A = true;
            ow0Var.updateMenuView(false);
        }
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        ow0 ow0Var = this.m;
        ow0Var.q = colorStateList;
        ow0Var.updateMenuView(false);
    }

    public void setItemMaxLines(int i) {
        ow0 ow0Var = this.m;
        ow0Var.C = i;
        ow0Var.updateMenuView(false);
    }

    public void setItemTextAppearance(int i) {
        ow0 ow0Var = this.m;
        ow0Var.o = i;
        ow0Var.updateMenuView(false);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        ow0 ow0Var = this.m;
        ow0Var.p = colorStateList;
        ow0Var.updateMenuView(false);
    }

    public void setItemVerticalPadding(int i) {
        ow0 ow0Var = this.m;
        ow0Var.u = i;
        ow0Var.updateMenuView(false);
    }

    public void setItemVerticalPaddingResource(int i) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i);
        ow0 ow0Var = this.m;
        ow0Var.u = dimensionPixelSize;
        ow0Var.updateMenuView(false);
    }

    public void setNavigationItemSelectedListener(qw0 qw0Var) {
        this.n = qw0Var;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i) {
        super.setOverScrollMode(i);
        ow0 ow0Var = this.m;
        if (ow0Var != null) {
            ow0Var.F = i;
            NavigationMenuView navigationMenuView = ow0Var.g;
            if (navigationMenuView != null) {
                navigationMenuView.setOverScrollMode(i);
            }
        }
    }

    public void setSubheaderInsetEnd(int i) {
        ow0 ow0Var = this.m;
        ow0Var.z = i;
        ow0Var.updateMenuView(false);
    }

    public void setSubheaderInsetStart(int i) {
        ow0 ow0Var = this.m;
        ow0Var.z = i;
        ow0Var.updateMenuView(false);
    }

    public void setTopInsetScrimEnabled(boolean z2) {
        this.s = z2;
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem menuItemFindItem = this.l.findItem(menuItem.getItemId());
        if (menuItemFindItem != null) {
            this.m.k.q((mt0) menuItemFindItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
