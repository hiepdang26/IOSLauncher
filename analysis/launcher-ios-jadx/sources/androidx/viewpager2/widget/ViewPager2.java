package androidx.viewpager2.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.profileinstaller.ProfileVerifier;
import defpackage.e71;
import defpackage.je1;
import defpackage.ke1;
import defpackage.m81;
import defpackage.mc1;
import defpackage.nx0;
import defpackage.ol1;
import defpackage.pt1;
import defpackage.qs1;
import defpackage.qt1;
import defpackage.r81;
import defpackage.rt1;
import defpackage.st1;
import defpackage.u81;
import defpackage.ut1;
import defpackage.vt1;
import defpackage.wt1;
import defpackage.x01;
import defpackage.xt1;
import defpackage.yf;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ViewPager2 extends ViewGroup {
    public final Rect g;
    public final Rect h;
    public int i;
    public boolean j;
    public final pt1 k;
    public final st1 l;
    public int m;
    public Parcelable n;
    public final wt1 o;
    public final vt1 p;
    public final ke1 q;
    public final qt1 r;
    public final nx0 s;
    public final x01 t;
    public r81 u;
    public boolean v;
    public boolean w;
    public int x;
    public final ol1 y;

    public ViewPager2(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = new Rect();
        this.h = new Rect();
        qt1 qt1Var = new qt1();
        int i = 0;
        this.j = false;
        this.k = new pt1(this, i);
        this.m = -1;
        this.u = null;
        this.v = false;
        int i2 = 1;
        this.w = true;
        this.x = -1;
        this.y = new ol1(this);
        wt1 wt1Var = new wt1(this, context);
        this.o = wt1Var;
        WeakHashMap weakHashMap = qs1.a;
        wt1Var.setId(View.generateViewId());
        this.o.setDescendantFocusability(ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ);
        st1 st1Var = new st1(this);
        this.l = st1Var;
        this.o.setLayoutManager(st1Var);
        this.o.setScrollingTouchSlop(1);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, e71.ViewPager2);
        qs1.o(this, context, e71.ViewPager2, attributeSet, typedArrayObtainStyledAttributes, 0);
        try {
            setOrientation(typedArrayObtainStyledAttributes.getInt(e71.ViewPager2_android_orientation, 0));
            typedArrayObtainStyledAttributes.recycle();
            this.o.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
            wt1 wt1Var2 = this.o;
            rt1 rt1Var = new rt1();
            if (wt1Var2.I == null) {
                wt1Var2.I = new ArrayList();
            }
            wt1Var2.I.add(rt1Var);
            ke1 ke1Var = new ke1(this);
            this.q = ke1Var;
            this.s = new nx0(ke1Var, 12);
            vt1 vt1Var = new vt1(this);
            this.p = vt1Var;
            vt1Var.a(this.o);
            this.o.l(this.q);
            qt1 qt1Var2 = new qt1();
            this.r = qt1Var2;
            this.q.a = qt1Var2;
            qt1 qt1Var3 = new qt1(this, i);
            qt1 qt1Var4 = new qt1(this, i2);
            ((ArrayList) qt1Var2.b).add(qt1Var3);
            ((ArrayList) this.r.b).add(qt1Var4);
            ol1 ol1Var = this.y;
            wt1 wt1Var3 = this.o;
            ol1Var.getClass();
            wt1Var3.setImportantForAccessibility(2);
            ol1Var.i = new pt1(ol1Var, i2);
            ViewPager2 viewPager2 = (ViewPager2) ol1Var.j;
            if (viewPager2.getImportantForAccessibility() == 0) {
                viewPager2.setImportantForAccessibility(1);
            }
            ((ArrayList) this.r.b).add(qt1Var);
            x01 x01Var = new x01(this.l);
            this.t = x01Var;
            ((ArrayList) this.r.b).add(x01Var);
            wt1 wt1Var4 = this.o;
            attachViewToParent(wt1Var4, 0, wt1Var4.getLayoutParams());
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    public final void a() {
        m81 adapter;
        if (this.m == -1 || (adapter = getAdapter()) == null) {
            return;
        }
        if (this.n != null) {
            this.n = null;
        }
        int iMax = Math.max(0, Math.min(this.m, adapter.c() - 1));
        this.i = iMax;
        this.m = -1;
        this.o.l0(iMax);
        this.y.o();
    }

    public final void b(int i) {
        qt1 qt1Var;
        m81 adapter = getAdapter();
        if (adapter == null) {
            if (this.m != -1) {
                this.m = Math.max(i, 0);
                return;
            }
            return;
        }
        if (adapter.c() <= 0) {
            return;
        }
        int iMin = Math.min(Math.max(i, 0), adapter.c() - 1);
        int i2 = this.i;
        if ((iMin == i2 && this.q.f == 0) || iMin == i2) {
            return;
        }
        double d = i2;
        this.i = iMin;
        this.y.o();
        ke1 ke1Var = this.q;
        if (ke1Var.f != 0) {
            ke1Var.e();
            je1 je1Var = ke1Var.g;
            d = ((double) je1Var.a) + ((double) je1Var.b);
        }
        ke1 ke1Var2 = this.q;
        ke1Var2.getClass();
        ke1Var2.e = 2;
        boolean z = ke1Var2.i != iMin;
        ke1Var2.i = iMin;
        ke1Var2.c(2);
        if (z && (qt1Var = ke1Var2.a) != null) {
            qt1Var.c(iMin);
        }
        double d2 = iMin;
        if (Math.abs(d2 - d) <= 3.0d) {
            this.o.o0(iMin);
            return;
        }
        this.o.l0(d2 > d ? iMin - 3 : iMin + 3);
        wt1 wt1Var = this.o;
        wt1Var.post(new yf(iMin, wt1Var));
    }

    public final void c() {
        vt1 vt1Var = this.p;
        if (vt1Var == null) {
            throw new IllegalStateException("Design assumption violated.");
        }
        View viewE = vt1Var.e(this.l);
        if (viewE == null) {
            return;
        }
        this.l.getClass();
        int iJ = u81.J(viewE);
        if (iJ != this.i && getScrollState() == 0) {
            this.r.c(iJ);
        }
        this.j = false;
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i) {
        return this.o.canScrollHorizontally(i);
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i) {
        return this.o.canScrollVertically(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        Parcelable parcelable = (Parcelable) sparseArray.get(getId());
        if (parcelable instanceof xt1) {
            int i = ((xt1) parcelable).g;
            sparseArray.put(this.o.getId(), (Parcelable) sparseArray.get(i));
            sparseArray.remove(i);
        }
        super.dispatchRestoreInstanceState(sparseArray);
        a();
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        this.y.getClass();
        this.y.getClass();
        return "androidx.viewpager.widget.ViewPager";
    }

    public m81 getAdapter() {
        return this.o.getAdapter();
    }

    public int getCurrentItem() {
        return this.i;
    }

    public int getItemDecorationCount() {
        return this.o.getItemDecorationCount();
    }

    public int getOffscreenPageLimit() {
        return this.x;
    }

    public int getOrientation() {
        return this.l.p == 1 ? 1 : 0;
    }

    public int getPageSize() {
        int height;
        int paddingBottom;
        wt1 wt1Var = this.o;
        if (getOrientation() == 0) {
            height = wt1Var.getWidth() - wt1Var.getPaddingLeft();
            paddingBottom = wt1Var.getPaddingRight();
        } else {
            height = wt1Var.getHeight() - wt1Var.getPaddingTop();
            paddingBottom = wt1Var.getPaddingBottom();
        }
        return height - paddingBottom;
    }

    public int getScrollState() {
        return this.q.f;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        int iC;
        int iC2;
        int iC3;
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        ViewPager2 viewPager2 = (ViewPager2) this.y.j;
        if (viewPager2.getAdapter() == null) {
            iC = 0;
            iC2 = 0;
        } else if (viewPager2.getOrientation() == 1) {
            iC = viewPager2.getAdapter().c();
            iC2 = 1;
        } else {
            iC2 = viewPager2.getAdapter().c();
            iC = 1;
        }
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) mc1.v(iC, iC2, 0).h);
        m81 adapter = viewPager2.getAdapter();
        if (adapter == null || (iC3 = adapter.c()) == 0 || !viewPager2.w) {
            return;
        }
        if (viewPager2.i > 0) {
            accessibilityNodeInfo.addAction(8192);
        }
        if (viewPager2.i < iC3 - 1) {
            accessibilityNodeInfo.addAction(MotionScene.Transition.TransitionOnClick.JUMP_TO_START);
        }
        accessibilityNodeInfo.setScrollable(true);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = this.o.getMeasuredWidth();
        int measuredHeight = this.o.getMeasuredHeight();
        int paddingLeft = getPaddingLeft();
        Rect rect = this.g;
        rect.left = paddingLeft;
        rect.right = (i3 - i) - getPaddingRight();
        rect.top = getPaddingTop();
        rect.bottom = (i4 - i2) - getPaddingBottom();
        Rect rect2 = this.h;
        Gravity.apply(8388659, measuredWidth, measuredHeight, rect, rect2);
        this.o.layout(rect2.left, rect2.top, rect2.right, rect2.bottom);
        if (this.j) {
            c();
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        measureChild(this.o, i, i2);
        int measuredWidth = this.o.getMeasuredWidth();
        int measuredHeight = this.o.getMeasuredHeight();
        int measuredState = this.o.getMeasuredState();
        int paddingRight = getPaddingRight() + getPaddingLeft() + measuredWidth;
        int paddingBottom = getPaddingBottom() + getPaddingTop() + measuredHeight;
        setMeasuredDimension(View.resolveSizeAndState(Math.max(paddingRight, getSuggestedMinimumWidth()), i, measuredState), View.resolveSizeAndState(Math.max(paddingBottom, getSuggestedMinimumHeight()), i2, measuredState << 16));
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof xt1)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        xt1 xt1Var = (xt1) parcelable;
        super.onRestoreInstanceState(xt1Var.getSuperState());
        this.m = xt1Var.h;
        this.n = xt1Var.i;
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        xt1 xt1Var = new xt1(super.onSaveInstanceState());
        xt1Var.g = this.o.getId();
        int i = this.m;
        if (i == -1) {
            i = this.i;
        }
        xt1Var.h = i;
        Parcelable parcelable = this.n;
        if (parcelable != null) {
            xt1Var.i = parcelable;
            return xt1Var;
        }
        this.o.getAdapter();
        return xt1Var;
    }

    @Override // android.view.ViewGroup
    public final void onViewAdded(View view) {
        throw new IllegalStateException("ViewPager2 does not support direct child views");
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i, Bundle bundle) {
        this.y.getClass();
        if (i != 8192 && i != 4096) {
            return super.performAccessibilityAction(i, bundle);
        }
        ol1 ol1Var = this.y;
        ol1Var.getClass();
        if (i != 8192 && i != 4096) {
            throw new IllegalStateException();
        }
        ViewPager2 viewPager2 = (ViewPager2) ol1Var.j;
        int currentItem = i == 8192 ? viewPager2.getCurrentItem() - 1 : viewPager2.getCurrentItem() + 1;
        if (viewPager2.w) {
            viewPager2.b(currentItem);
        }
        return true;
    }

    public void setAdapter(m81 m81Var) {
        m81 adapter = this.o.getAdapter();
        ol1 ol1Var = this.y;
        if (adapter != null) {
            adapter.g.unregisterObserver((pt1) ol1Var.i);
        } else {
            ol1Var.getClass();
        }
        pt1 pt1Var = this.k;
        if (adapter != null) {
            adapter.g.unregisterObserver(pt1Var);
        }
        this.o.setAdapter(m81Var);
        this.i = 0;
        a();
        ol1 ol1Var2 = this.y;
        ol1Var2.o();
        if (m81Var != null) {
            m81Var.g.registerObserver((pt1) ol1Var2.i);
        }
        if (m81Var != null) {
            m81Var.g.registerObserver(pt1Var);
        }
    }

    public void setCurrentItem(int i) {
        Object obj = this.s.h;
        b(i);
    }

    @Override // android.view.View
    public void setLayoutDirection(int i) {
        super.setLayoutDirection(i);
        this.y.o();
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1 && i != -1) {
            throw new IllegalArgumentException("Offscreen page limit must be OFFSCREEN_PAGE_LIMIT_DEFAULT or a number > 0");
        }
        this.x = i;
        this.o.requestLayout();
    }

    public void setOrientation(int i) {
        this.l.f1(i);
        this.y.o();
    }

    public void setPageTransformer(ut1 ut1Var) {
        if (ut1Var != null) {
            if (!this.v) {
                this.u = this.o.getItemAnimator();
                this.v = true;
            }
            this.o.setItemAnimator(null);
        } else if (this.v) {
            this.o.setItemAnimator(this.u);
            this.u = null;
            this.v = false;
        }
        x01 x01Var = this.t;
        if (ut1Var == x01Var.b) {
            return;
        }
        x01Var.b = ut1Var;
        if (ut1Var == null) {
            return;
        }
        ke1 ke1Var = this.q;
        ke1Var.e();
        je1 je1Var = ke1Var.g;
        double d = ((double) je1Var.a) + ((double) je1Var.b);
        int i = (int) d;
        float f = (float) (d - ((double) i));
        this.t.b(i, f, Math.round(getPageSize() * f));
    }

    public void setUserInputEnabled(boolean z) {
        this.w = z;
        this.y.o();
    }
}
