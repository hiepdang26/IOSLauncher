package com.luutinhit.launcher6;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.appcompat.widget.ActivityChooserView;
import androidx.appcompat.widget.RtlSpacingHelper;
import androidx.constraintlayout.motion.widget.Key;
import androidx.constraintlayout.motion.widget.MotionScene;
import defpackage.a11;
import defpackage.ar1;
import defpackage.b11;
import defpackage.be;
import defpackage.c11;
import defpackage.el0;
import defpackage.fl0;
import defpackage.g71;
import defpackage.k01;
import defpackage.md;
import defpackage.ul0;
import defpackage.v01;
import defpackage.w61;
import defpackage.y01;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class v extends ViewGroup implements ViewGroup.OnHierarchyChangeListener {
    public static final Matrix p0 = new Matrix();
    public static final float[] q0 = new float[2];
    public static final Rect r0 = new Rect();
    public static final RectF s0 = new RectF();
    public float A;
    public float B;
    public float C;
    public float D;
    public float E;
    public float F;
    public float G;
    public int H;
    public boolean I;
    public int[] J;
    public int K;
    public boolean L;
    public View.OnLongClickListener M;
    public final int N;
    public final int O;
    public final boolean P;
    public boolean Q;
    public final int[] R;
    public int S;
    public c11 T;
    public boolean U;
    public boolean V;
    public int W;
    public int a0;
    public final int b0;
    public PageIndicator c0;
    public final Rect d0;
    public float e0;
    public boolean f0;
    public boolean g;
    public View g0;
    public int h;
    public a11 h0;
    public int i;
    public int i0;
    public final int j;
    public boolean j0;
    public final int k;
    public boolean k0;
    public final int l;
    public int l0;
    public boolean m;
    public el0 m0;
    public int n;
    public final Rect n0;
    public int o;
    public final boolean o0;
    public int p;
    public int q;
    public int r;
    public int s;
    public final ul0 t;
    public Interpolator u;
    public VelocityTracker v;
    public int w;
    public float x;
    public float y;
    public float z;

    public v(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.g = false;
        this.h = -1;
        this.i = -1;
        this.m = true;
        this.p = -1001;
        this.r = -1;
        this.w = 0;
        this.H = -1;
        this.K = 0;
        this.L = false;
        this.Q = true;
        this.R = new int[2];
        this.S = -1;
        this.U = false;
        this.V = false;
        this.d0 = new Rect();
        this.e0 = 1.0f;
        this.f0 = false;
        this.i0 = -1;
        this.j0 = false;
        this.n0 = new Rect();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.PagedView, 0, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(g71.PagedView_pageLayoutWidthGap, 0);
        typedArrayObtainStyledAttributes.getDimensionPixelSize(g71.PagedView_pageLayoutHeightGap, 0);
        this.b0 = typedArrayObtainStyledAttributes.getResourceId(g71.PagedView_pageIndicator, -1);
        typedArrayObtainStyledAttributes.recycle();
        setHapticFeedbackEnabled(false);
        this.o0 = ar1.v(getResources());
        this.t = new ul0(getContext());
        setDefaultInterpolator(new md(3));
        this.o = 0;
        this.P = true;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.N = viewConfiguration.getScaledPagingTouchSlop();
        this.O = viewConfiguration.getScaledMaximumFlingVelocity();
        float f = getResources().getDisplayMetrics().density;
        this.j = (int) (500.0f * f);
        this.k = (int) (250.0f * f);
        this.l = (int) (f * 1500.0f);
        setOnHierarchyChangeListener(this);
        setWillNotDraw(false);
    }

    public static float[] I(v vVar, float f, float f2) {
        float[] fArr = q0;
        fArr[0] = f - vVar.getLeft();
        fArr[1] = f2 - vVar.getTop();
        Matrix matrix = vVar.getMatrix();
        Matrix matrix2 = p0;
        matrix.invert(matrix2);
        matrix2.mapPoints(fArr);
        return fArr;
    }

    public static float[] J(v vVar, float f, float f2) {
        float[] fArr = q0;
        fArr[0] = f;
        fArr[1] = f2;
        vVar.getMatrix().mapPoints(fArr);
        fArr[0] = fArr[0] + vVar.getLeft();
        fArr[1] = fArr[1] + vVar.getTop();
        return fArr;
    }

    private int getNearestHoverOverPageIndex() {
        if (this.g0 == null) {
            return -1;
        }
        int translationX = (int) (this.g0.getTranslationX() + (this.g0.getMeasuredWidth() / 2.0f) + r0.getLeft());
        int[] iArr = this.R;
        A(iArr);
        int iIndexOfChild = indexOfChild(this.g0);
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        for (int i2 = iArr[0]; i2 <= iArr[1]; i2++) {
            View viewC = C(i2);
            int iAbs = Math.abs(translationX - ((viewC.getMeasuredWidth() / 2) + viewC.getLeft()));
            if (iAbs < i) {
                iIndexOfChild = i2;
                i = iAbs;
            }
        }
        return iIndexOfChild;
    }

    private void setEnableFreeScroll(boolean z) {
        this.g = z;
        if (z) {
            g0();
            int[] iArr = this.R;
            A(iArr);
            int currentPage = getCurrentPage();
            int i = iArr[0];
            if (currentPage < i) {
                setCurrentPage(i);
            } else {
                int currentPage2 = getCurrentPage();
                int i2 = iArr[1];
                if (currentPage2 > i2) {
                    setCurrentPage(i2);
                }
            }
        }
        setEnableOverscroll(!z);
    }

    public void A(int[] iArr) {
        iArr[0] = 0;
        iArr[1] = Math.max(0, getChildCount() - 1);
    }

    public final int B(int i) {
        int[] iArr = this.J;
        if (iArr == null || i >= iArr.length || i < 0) {
            return 0;
        }
        View childAt = getChildAt(i);
        return (int) (childAt.getX() - (getViewportOffsetX() + (this.J[i] + (((b11) childAt.getLayoutParams()).a ? 0 : this.o0 ? getPaddingRight() : getPaddingLeft()))));
    }

    public View C(int i) {
        return getChildAt(i);
    }

    public abstract v01 D(int i);

    public final int E(int i) {
        int[] iArr = this.J;
        if (iArr == null || i >= iArr.length || i < 0) {
            return 0;
        }
        return iArr[i];
    }

    public final void F(int[] iArr) {
        int childCount = getChildCount();
        iArr[0] = -1;
        iArr[1] = -1;
        if (childCount <= 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i = -getLeft();
        int viewportWidth = getViewportWidth() + i;
        Matrix pageShiftMatrix = getPageShiftMatrix();
        int i2 = 0;
        for (int i3 = 0; i3 < childCount; i3++) {
            View viewC = C(i3);
            RectF rectF = s0;
            rectF.left = 0.0f;
            rectF.right = viewC.getMeasuredWidth();
            viewC.getMatrix().mapRect(rectF);
            rectF.offset(viewC.getLeft() - getScrollX(), 0.0f);
            pageShiftMatrix.mapRect(rectF);
            if (rectF.left > viewportWidth || rectF.right < i) {
                if (iArr[0] != -1) {
                    break;
                }
            } else {
                if (iArr[0] < 0) {
                    iArr[0] = i3;
                }
                i2 = i3;
            }
        }
        iArr[1] = i2;
    }

    public final boolean G() {
        return this.k0 & (this.K == 4);
    }

    public final boolean H(int i, int i2) {
        Rect rect = this.d0;
        int iWidth = rect.left - (rect.width() / 2);
        int i3 = rect.top;
        int iWidth2 = (rect.width() / 2) + rect.right;
        int i4 = rect.bottom;
        Rect rect2 = r0;
        rect2.set(iWidth, i3, iWidth2, i4);
        return rect2.contains(i, i2);
    }

    public abstract void K();

    public void L() {
        this.k0 = false;
    }

    public abstract void M();

    public void N() {
        this.V = false;
    }

    public void O() {
    }

    public void P() {
    }

    public final void Q(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.S) {
            int i = action == 0 ? 1 : 0;
            float x = motionEvent.getX(i);
            this.z = x;
            this.D = x;
            this.F = motionEvent.getY(i);
            this.E = 0.0f;
            this.S = motionEvent.getPointerId(i);
            VelocityTracker velocityTracker = this.v;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    public void R() {
        this.K = 4;
        this.k0 = true;
        invalidate();
    }

    public void S(float f) {
        k(f);
    }

    public final void T() {
        int i = 6;
        VelocityTracker velocityTracker = this.v;
        if (velocityTracker != null) {
            velocityTracker.clear();
            this.v.recycle();
            this.v = null;
        }
        if (this.j0) {
            this.j0 = false;
            this.m0 = new el0(this, new fl0(this, i), i);
            this.l0 = 2;
            a0(indexOfChild(this.g0), 0);
            if (this.g0 != null) {
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.setDuration(200L);
                animatorSet.playTogether(ObjectAnimator.ofFloat(this.g0, Key.TRANSLATION_X, 0.0f), ObjectAnimator.ofFloat(this.g0, Key.TRANSLATION_Y, 0.0f), ObjectAnimator.ofFloat(this.g0, Key.SCALE_X, 1.0f), ObjectAnimator.ofFloat(this.g0, Key.SCALE_Y, 1.0f));
                animatorSet.addListener(new be(this, 14));
                animatorSet.start();
            }
        }
        this.I = false;
        this.K = 0;
        this.S = -1;
    }

    public void U(int i) {
    }

    public void V() {
        if (getNextPage() > 0) {
            Z(getNextPage() - 1);
        }
    }

    public void W() {
        if (getNextPage() < getChildCount() - 1) {
            Z(getNextPage() + 1);
        }
    }

    public boolean X(View view) {
        return view.getVisibility() == 0;
    }

    public void Y() {
        a0(getPageNearestToCenterOfScreen(), getPageSnapDuration());
    }

    public final void Z(int i) {
        a0(i, 750);
    }

    public final void a0(int i, int i2) {
        int iH0 = h0(i);
        b0(iH0, E(iH0) - getUnboundedScrollX(), i2, false, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void addFocusables(ArrayList arrayList, int i, int i2) {
        int i3 = this.o;
        if (i3 >= 0 && i3 < getPageCount()) {
            C(this.o).addFocusables(arrayList, i, i2);
        }
        if (i == 17) {
            int i4 = this.o;
            if (i4 > 0) {
                C(i4 - 1).addFocusables(arrayList, i, i2);
                return;
            }
            return;
        }
        if (i != 66 || this.o >= getPageCount() - 1) {
            return;
        }
        C(this.o + 1).addFocusables(arrayList, i, i2);
    }

    public final void b0(int i, int i2, int i3, boolean z, TimeInterpolator timeInterpolator) {
        this.r = h0(i);
        if (this.U) {
            this.U = false;
            N();
        }
        awakenScrollBars(i3);
        if (z) {
            i3 = 0;
        } else if (i3 == 0) {
            i3 = Math.abs(i2);
        }
        if (!this.t.o) {
            d(false);
        }
        if (timeInterpolator != null) {
            this.t.p = timeInterpolator;
        } else {
            this.t.p = this.u;
        }
        this.t.a(getUnboundedScrollX(), i2, i3);
        PageIndicator pageIndicator = this.c0;
        if (pageIndicator != null) {
            pageIndicator.setContentDescription(getPageIndicatorDescription());
            if (!this.k0) {
                this.c0.setActiveMarker(getNextPage());
            }
        }
        if (z) {
            computeScroll();
        }
        this.L = true;
        invalidate();
    }

    public final void c0(int i, int i2) {
        int iH0 = h0(i);
        int viewportWidth = getViewportWidth() / 2;
        int iE = E(iH0) - getUnboundedScrollX();
        if (Math.abs(i2) < this.k) {
            a0(iH0, 750);
            return;
        }
        float fMin = Math.min(1.0f, (Math.abs(iE) * 1.0f) / (viewportWidth * 2));
        float f = viewportWidth;
        b0(iH0, iE, Math.round(Math.abs(((((float) Math.sin((float) (((double) (fMin - 0.5f)) * 0.4712389167638204d))) * f) + f) / Math.max(this.l, Math.abs(i2))) * 1000.0f) * 4, false, null);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b11;
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x016d  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void computeScroll() {
        /*
            Method dump skipped, instruction units count: 394
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.v.computeScroll():void");
    }

    public final void d(boolean z) {
        ul0 ul0Var = this.t;
        ul0Var.h = ul0Var.d;
        ul0Var.i = ul0Var.e;
        ul0Var.o = true;
        if (z) {
            this.r = -1;
        }
    }

    public final void d0(View view) {
        int iIndexOfChild = indexOfChild(view);
        if (this.K != 0 || iIndexOfChild == -1) {
            return;
        }
        int[] iArr = this.R;
        iArr[0] = 0;
        iArr[1] = getPageCount() - 1;
        A(iArr);
        this.j0 = true;
        if (iArr[0] > iIndexOfChild || iIndexOfChild > iArr[1]) {
            return;
        }
        View childAt = getChildAt(iIndexOfChild);
        this.g0 = childAt;
        childAt.animate().withLayer().scaleX(1.15f).scaleY(1.15f).setDuration(100L).start();
        this.C = this.g0.getLeft();
        Z(getPageNearestToCenterOfScreen());
        setEnableFreeScroll(false);
        R();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        int childCount = getChildCount();
        if (childCount > 0) {
            int scrollX = getScrollX() + (getViewportWidth() / 2);
            if (scrollX != this.H || this.L) {
                this.L = false;
                U(scrollX);
                this.H = scrollX;
            }
            F(this.R);
            int[] iArr = this.R;
            int i = iArr[0];
            int i2 = iArr[1];
            if (i == -1 || i2 == -1) {
                return;
            }
            synchronized (canvas) {
                try {
                    long drawingTime = getDrawingTime();
                    canvas.save();
                    canvas.clipRect(getScrollX(), getScrollY(), (getScrollX() + getRight()) - getLeft(), (getScrollY() + getBottom()) - getTop());
                    int i3 = childCount - 1;
                    while (i3 >= 0) {
                        View viewC = C(i3);
                        if (viewC != this.g0) {
                            boolean z = i <= i3 && i3 <= i2;
                            boolean z2 = z && X(viewC);
                            if (viewC instanceof y01) {
                                ((CellLayout) ((y01) viewC)).z(z);
                            }
                            if (z2) {
                                drawChild(canvas, viewC, drawingTime);
                            }
                        }
                        i3--;
                    }
                    View view = this.g0;
                    if (view != null) {
                        drawChild(canvas, view, drawingTime);
                    }
                    canvas.restore();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchUnhandledMove(View view, int i) {
        if (super.dispatchUnhandledMove(view, i)) {
            return true;
        }
        if (this.o0) {
            if (i == 17) {
                i = 66;
            } else if (i == 66) {
                i = 17;
            }
        }
        if (i == 17) {
            if (getCurrentPage() <= 0) {
                return false;
            }
            Z(getCurrentPage() - 1);
            return true;
        }
        if (i != 66 || getCurrentPage() >= getPageCount() - 1) {
            return false;
        }
        Z(getCurrentPage() + 1);
        return true;
    }

    public final void e(CellLayout cellLayout, int i) {
        b11 b11Var = new b11(-2, -2);
        b11Var.a = true;
        super.addView(cellLayout, i == 0 ? 0 : getPageCount(), b11Var);
    }

    public final void e0() {
        int i = this.o;
        int iE = (i < 0 || i >= getPageCount()) ? 0 : E(this.o);
        scrollTo(iE, 0);
        ul0 ul0Var = this.t;
        ul0Var.d = iE;
        ul0Var.m = iE - ul0Var.b;
        ul0Var.o = false;
        ul0Var.o = true;
        this.r = -1;
    }

    public final void f0() {
        if (this.g0 != null) {
            float left = (this.C - this.g0.getLeft()) + (getScrollX() - this.B) + (this.D - this.z);
            float f = this.F - this.A;
            this.g0.setTranslationX(left);
            this.g0.setTranslationY(f);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void focusableViewAvailable(View view) {
        View viewC = C(this.o);
        for (View view2 = view; view2 != viewC; view2 = (View) view2.getParent()) {
            if (view2 == this || !(view2.getParent() instanceof View)) {
                return;
            }
        }
        super.focusableViewAvailable(view);
    }

    public final void g0() {
        int[] iArr = this.R;
        A(iArr);
        if (this.o0) {
            this.h = E(iArr[1]);
            this.i = E(iArr[0]);
        } else {
            this.h = E(iArr[0]);
            this.i = E(iArr[1]);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        b11 b11Var = new b11(-2, -2);
        b11Var.a = false;
        return b11Var;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        b11 b11Var = new b11(getContext(), attributeSet);
        b11Var.a = false;
        return b11Var;
    }

    public int getChildGap() {
        return 0;
    }

    public int getCurrentPage() {
        return this.o;
    }

    public String getCurrentPageDescription() {
        return String.format(getContext().getString(w61.default_scroll_format), Integer.valueOf(getNextPage() + 1), Integer.valueOf(getChildCount()));
    }

    public int getNextPage() {
        int i = this.r;
        return i != -1 ? i : this.o;
    }

    public int getNormalChildHeight() {
        return this.n;
    }

    public int getPageCount() {
        return getChildCount();
    }

    public PageIndicator getPageIndicator() {
        return this.c0;
    }

    public View.OnClickListener getPageIndicatorClickListener() {
        return null;
    }

    public String getPageIndicatorDescription() {
        return getCurrentPageDescription();
    }

    public int getPageNearestToCenterOfScreen() {
        int viewportWidth = (getViewportWidth() / 2) + getScrollX() + getViewportOffsetX();
        int childCount = getChildCount();
        int i = ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
        int i2 = -1;
        for (int i3 = 0; i3 < childCount; i3++) {
            int iAbs = Math.abs(((z(i3) + getViewportOffsetX()) + (C(i3).getMeasuredWidth() / 2)) - viewportWidth);
            if (iAbs < i) {
                i2 = i3;
                i = iAbs;
            }
        }
        return i2;
    }

    public Matrix getPageShiftMatrix() {
        return getMatrix();
    }

    public int getPageSnapDuration() {
        int i = this.W;
        return (i > this.s || i < 0) ? 500 : 750;
    }

    public int getRestorePage() {
        return this.p;
    }

    public int getUnboundedScrollX() {
        return this.a0;
    }

    public int getViewportHeight() {
        return this.d0.height();
    }

    public int getViewportOffsetX() {
        return (getMeasuredWidth() - getViewportWidth()) / 2;
    }

    public int getViewportOffsetY() {
        return (getMeasuredHeight() - getViewportHeight()) / 2;
    }

    public int getViewportWidth() {
        return this.d0.width();
    }

    public final int h0(int i) {
        if (this.g) {
            int[] iArr = this.R;
            A(iArr);
            i = Math.max(iArr[0], Math.min(i, iArr[1]));
        }
        return Math.max(0, Math.min(i, getPageCount() - 1));
    }

    public final void k(float f) {
        int iRound;
        if (Float.compare(f, 0.0f) == 0) {
            return;
        }
        int viewportWidth = getViewportWidth();
        DecelerateInterpolator decelerateInterpolator = k01.a;
        if (Float.compare(f, 0.0f) == 0) {
            iRound = 0;
        } else {
            float f2 = viewportWidth;
            float f3 = f / f2;
            float interpolation = k01.a.getInterpolation(Math.abs(f3)) * (f3 / Math.abs(f3));
            if (Math.abs(interpolation) >= 1.0f) {
                interpolation /= Math.abs(interpolation);
            }
            iRound = Math.round(interpolation * 0.36f * f2);
        }
        if (f < 0.0f) {
            this.W = iRound;
            super.scrollTo(iRound, getScrollY());
        } else {
            this.W = this.s + iRound;
            super.scrollTo(this.W, getScrollY());
        }
        invalidate();
    }

    public void n(MotionEvent motionEvent) {
        w(motionEvent, 1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        int i;
        super.onAttachedToWindow();
        ViewGroup viewGroup = (ViewGroup) ((ViewGroup) getParent()).getParent();
        if (this.c0 != null || (i = this.b0) <= -1) {
            return;
        }
        PageIndicator pageIndicator = (PageIndicator) viewGroup.findViewById(i);
        this.c0 = pageIndicator;
        pageIndicator.d();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            arrayList.add(D(i2));
        }
        PageIndicator pageIndicator2 = this.c0;
        pageIndicator2.getClass();
        for (int i3 = 0; i3 < arrayList.size(); i3++) {
            pageIndicator2.a(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, (v01) arrayList.get(i3));
        }
        View.OnClickListener pageIndicatorClickListener = getPageIndicatorClickListener();
        if (pageIndicatorClickListener != null) {
            this.c0.setOnClickListener(pageIndicatorClickListener);
        }
        this.c0.setContentDescription(getPageIndicatorDescription());
    }

    public void onChildViewAdded(View view, View view2) {
        if (this.c0 != null && !this.k0) {
            int iIndexOfChild = indexOfChild(view2);
            this.c0.a(iIndexOfChild, D(iIndexOfChild));
        }
        this.L = true;
        g0();
        invalidate();
    }

    @Override // android.view.ViewGroup.OnHierarchyChangeListener
    public final void onChildViewRemoved(View view, View view2) {
        this.L = true;
        g0();
        invalidate();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.c0 = null;
    }

    @Override // android.view.View
    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f;
        float axisValue;
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8) {
            if ((motionEvent.getMetaState() & 1) != 0) {
                axisValue = motionEvent.getAxisValue(9);
                f = 0.0f;
            } else {
                f = -motionEvent.getAxisValue(9);
                axisValue = motionEvent.getAxisValue(10);
            }
            if (axisValue != 0.0f || f != 0.0f) {
                if (!this.o0 ? !(axisValue > 0.0f || f > 0.0f) : !(axisValue < 0.0f || f < 0.0f)) {
                    W();
                } else {
                    V();
                }
                return true;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        return true;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setScrollable(getPageCount() > 1);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setScrollable(getPageCount() > 1);
        if (getCurrentPage() < getPageCount() - 1) {
            accessibilityNodeInfo.addAction(MotionScene.Transition.TransitionOnClick.JUMP_TO_START);
        }
        if (getCurrentPage() > 0) {
            accessibilityNodeInfo.addAction(8192);
        }
        accessibilityNodeInfo.setClassName(getClass().getName());
        accessibilityNodeInfo.setLongClickable(false);
        if (ar1.m) {
            accessibilityNodeInfo.removeAction(AccessibilityNodeInfo.AccessibilityAction.ACTION_LONG_CLICK);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0057  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onInterceptTouchEvent(android.view.MotionEvent r7) {
        /*
            Method dump skipped, instruction units count: 208
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.v.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    /* JADX WARN: Removed duplicated region for block: B:77:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void onLayout(boolean r17, int r18, int r19, int r20, int r21) {
        /*
            Method dump skipped, instruction units count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.v.onLayout(boolean, int, int, int, int):void");
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int viewportWidth;
        int viewportHeight;
        int i5;
        Rect rect = this.n0;
        try {
            if (getChildCount() == 0) {
                super.onMeasure(i, i2);
                return;
            }
            int mode = View.MeasureSpec.getMode(i);
            int size = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size2 = View.MeasureSpec.getSize(i2);
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int iMax = (int) (Math.max(displayMetrics.widthPixels + rect.left + rect.right, displayMetrics.heightPixels + rect.top + rect.bottom) * 2.0f);
            if (this.f0) {
                i3 = (int) (iMax / this.e0);
                i4 = i3;
            } else {
                i3 = size;
                i4 = size2;
            }
            this.d0.set(0, 0, size, size2);
            if (mode != 0 && mode2 != 0) {
                if (size > 0 && size2 > 0) {
                    int paddingTop = getPaddingTop() + getPaddingBottom();
                    int paddingLeft = getPaddingLeft() + getPaddingRight();
                    getPaddingLeft();
                    getPaddingRight();
                    int childCount = getChildCount();
                    int i6 = 0;
                    for (int i7 = 0; i7 < childCount; i7++) {
                        View viewC = C(i7);
                        if (viewC.getVisibility() != 8) {
                            b11 b11Var = (b11) viewC.getLayoutParams();
                            if (b11Var.a) {
                                viewportWidth = getViewportWidth();
                                viewportHeight = getViewportHeight();
                                i5 = 1073741824;
                            } else {
                                int i8 = ((ViewGroup.LayoutParams) b11Var).width == -2 ? RtlSpacingHelper.UNDEFINED : 1073741824;
                                i = ((ViewGroup.LayoutParams) b11Var).height == -2 ? RtlSpacingHelper.UNDEFINED : 1073741824;
                                getViewportWidth();
                                viewportWidth = ((getViewportWidth() - paddingLeft) - rect.left) - rect.right;
                                viewportHeight = ((getViewportHeight() - paddingTop) - rect.top) - rect.bottom;
                                this.n = viewportHeight;
                                int i9 = i;
                                i = i8;
                                i5 = i9;
                            }
                            if (i6 == 0) {
                                i6 = viewportWidth;
                            }
                            viewC.measure(View.MeasureSpec.makeMeasureSpec(viewportWidth, i), View.MeasureSpec.makeMeasureSpec(viewportHeight, i5));
                        }
                    }
                    setMeasuredDimension(i3, i4);
                    return;
                }
                super.onMeasure(i, i2);
                return;
            }
            super.onMeasure(i, i2);
        } catch (Throwable th) {
            th.getMessage();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2 = this.r;
        if (i2 == -1) {
            i2 = this.o;
        }
        View viewC = C(i2);
        return viewC != null && viewC.requestFocus(i, rect);
    }

    /* JADX WARN: Removed duplicated region for block: B:134:0x0268  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02b4  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x02bc  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r22) {
        /*
            Method dump skipped, instruction units count: 1004
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.v.onTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.View
    public final boolean performAccessibilityAction(int i, Bundle bundle) {
        if (super.performAccessibilityAction(i, bundle)) {
            return true;
        }
        if (i == 4096) {
            if (getCurrentPage() >= getPageCount() - 1) {
                return false;
            }
            W();
            return true;
        }
        if (i != 8192 || getCurrentPage() <= 0) {
            return false;
        }
        V();
        return true;
    }

    @Override // android.view.View
    public final boolean performLongClick() {
        this.I = true;
        return super.performLongClick();
    }

    @Override // android.view.ViewGroup
    public final void removeAllViewsInLayout() {
        PageIndicator pageIndicator = this.c0;
        if (pageIndicator != null) {
            pageIndicator.d();
        }
        super.removeAllViewsInLayout();
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        int iIndexOfChild = indexOfChild(view);
        PageIndicator pageIndicator = this.c0;
        if (pageIndicator != null && !this.k0) {
            pageIndicator.e(iIndexOfChild);
        }
        super.removeView(view);
    }

    @Override // android.view.ViewGroup
    public final void removeViewAt(int i) {
        PageIndicator pageIndicator = this.c0;
        if (pageIndicator != null && !this.k0) {
            pageIndicator.e(i);
        }
        super.removeViewAt(i);
    }

    @Override // android.view.ViewGroup
    public final void removeViewInLayout(View view) {
        int iIndexOfChild = indexOfChild(view);
        PageIndicator pageIndicator = this.c0;
        if (pageIndicator != null && !this.k0) {
            pageIndicator.e(iIndexOfChild);
        }
        super.removeViewInLayout(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        super.requestChildFocus(view, view2);
        int iIndexOfChild = indexOfChild(view);
        if (iIndexOfChild < 0 || iIndexOfChild == getCurrentPage() || isInTouchMode()) {
            return;
        }
        Z(iIndexOfChild);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        int iIndexOfChild = indexOfChild(view);
        int i = this.o;
        boolean z2 = this.t.o;
        if (iIndexOfChild == i && z2) {
            return false;
        }
        Z(iIndexOfChild);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            C(this.o).cancelLongPress();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // android.view.View
    public final void scrollBy(int i, int i2) {
        scrollTo(getUnboundedScrollX() + i, getScrollY() + i2);
    }

    @Override // android.view.View
    public void scrollTo(int i, int i2) {
        if (this.g) {
            ul0 ul0Var = this.t;
            if (!ul0Var.o && (i > this.i || i < this.h)) {
                ul0Var.o = true;
            }
            i = Math.max(Math.min(i, this.i), this.h);
        }
        this.a0 = i;
        boolean z = this.o0;
        boolean z2 = !z ? i >= 0 : i <= this.s;
        boolean z3 = !z ? i <= this.s : i >= 0;
        if (z2) {
            super.scrollTo(z ? this.s : 0, i2);
            if (this.Q) {
                this.V = true;
                if (z) {
                    S(i - this.s);
                } else {
                    S(i);
                }
            }
        } else if (z3) {
            super.scrollTo(z ? 0 : this.s, i2);
            if (this.Q) {
                this.V = true;
                if (z) {
                    S(i);
                } else {
                    S(i - this.s);
                }
            }
        } else {
            if (this.V) {
                S(0.0f);
                this.V = false;
            }
            this.W = i;
            super.scrollTo(i, i2);
        }
        System.nanoTime();
        if (G()) {
            float[] fArrI = I(this, this.x, this.y);
            this.D = fArrI[0];
            this.F = fArrI[1];
            f0();
        }
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEvent(int i) {
        if (i != 4096) {
            super.sendAccessibilityEvent(i);
        }
    }

    public void setCurrentPage(int i) {
        if (!this.t.o) {
            d(true);
        }
        if (getChildCount() == 0) {
            return;
        }
        this.L = true;
        this.o = h0(i);
        e0();
        K();
        invalidate();
    }

    public void setDefaultInterpolator(Interpolator interpolator) {
        this.u = interpolator;
        this.t.p = interpolator;
    }

    public void setEnableOverscroll(boolean z) {
        this.Q = z;
    }

    public void setMinScale(float f) {
        this.e0 = f;
        this.f0 = true;
        requestLayout();
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.M = onLongClickListener;
        int pageCount = getPageCount();
        for (int i = 0; i < pageCount; i++) {
            C(i).setOnLongClickListener(onLongClickListener);
        }
        super.setOnLongClickListener(onLongClickListener);
    }

    public void setPageSpacing(int i) {
        this.w = i;
        requestLayout();
    }

    public void setPageSwitchListener(c11 c11Var) {
        this.T = c11Var;
        if (c11Var != null) {
            c11Var.onPageSwitch(C(this.o), this.o);
        }
    }

    public void setRestorePage(int i) {
        this.p = i;
    }

    @Override // android.view.View
    public void setScaleX(float f) {
        super.setScaleX(f);
        if (G()) {
            float[] fArrI = I(this, this.x, this.y);
            this.D = fArrI[0];
            this.F = fArrI[1];
            f0();
        }
    }

    public void w(MotionEvent motionEvent, float f) {
        int iFindPointerIndex = motionEvent.findPointerIndex(this.S);
        if (iFindPointerIndex == -1) {
            return;
        }
        float x = motionEvent.getX(iFindPointerIndex);
        if (H((int) x, (int) motionEvent.getY(iFindPointerIndex)) && ((int) Math.abs(x - this.D)) > Math.round(f * this.N)) {
            this.K = 1;
            this.G = Math.abs(this.D - x) + this.G;
            this.D = x;
            this.E = 0.0f;
            getViewportOffsetX();
            getScrollX();
            System.nanoTime();
            O();
            if (this.U) {
                return;
            }
            this.U = true;
            M();
        }
    }

    public final void x() {
        setEnableFreeScroll(false);
    }

    public final void y() {
        setEnableFreeScroll(true);
    }

    public final int z(int i) {
        if (i < 0 || i > getChildCount() - 1) {
            return 0;
        }
        return C(i).getLeft() - getViewportOffsetX();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        b11 b11Var = new b11(layoutParams);
        b11Var.a = false;
        return b11Var;
    }
}
