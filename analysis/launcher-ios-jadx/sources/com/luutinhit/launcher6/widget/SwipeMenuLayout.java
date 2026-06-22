package com.luutinhit.launcher6.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import defpackage.bl1;
import defpackage.cl1;
import defpackage.g71;

/* JADX INFO: loaded from: classes.dex */
public class SwipeMenuLayout extends ViewGroup {
    public static SwipeMenuLayout y;
    public static boolean z;
    public final int g;
    public final int h;
    public int i;
    public int j;
    public int k;
    public int l;
    public View m;
    public final PointF n;
    public boolean o;
    public final PointF p;
    public boolean q;
    public VelocityTracker r;
    public boolean s;
    public final boolean t;
    public boolean u;
    public final boolean v;
    public ValueAnimator w;
    public ValueAnimator x;

    public SwipeMenuLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.n = new PointF();
        this.o = true;
        this.p = new PointF();
        this.s = true;
        this.t = true;
        this.v = true;
        this.g = ViewConfiguration.get(context).getScaledTouchSlop();
        this.h = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.SwipeMenuLayout);
        this.s = typedArrayObtainStyledAttributes.getBoolean(g71.SwipeMenuLayout_swipeEnable, true);
        this.t = typedArrayObtainStyledAttributes.getBoolean(g71.SwipeMenuLayout_ios, true);
        this.v = typedArrayObtainStyledAttributes.getBoolean(g71.SwipeMenuLayout_leftSwipe, true);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static SwipeMenuLayout getViewCache() {
        return y;
    }

    public final void a() {
        ValueAnimator valueAnimator = this.x;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.x.cancel();
        }
        ValueAnimator valueAnimator2 = this.w;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.w.cancel();
    }

    public final void b() {
        y = null;
        View view = this.m;
        if (view != null) {
            view.setLongClickable(true);
        }
        a();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(getScrollX(), 0);
        this.x = valueAnimatorOfInt;
        valueAnimatorOfInt.addUpdateListener(new bl1(this, 1));
        this.x.setInterpolator(new AccelerateInterpolator());
        this.x.addListener(new cl1(this, 1));
        this.x.setDuration(300L).start();
    }

    public final void c() {
        y = this;
        View view = this.m;
        if (view != null) {
            view.setLongClickable(false);
        }
        a();
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(getScrollX(), this.v ? this.k : -this.k);
        this.w = valueAnimatorOfInt;
        valueAnimatorOfInt.addUpdateListener(new bl1(this, 0));
        this.w.setInterpolator(new OvershootInterpolator());
        this.w.addListener(new cl1(this, 0));
        this.w.setDuration(300L).start();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00a2  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean dispatchTouchEvent(android.view.MotionEvent r8) {
        /*
            Method dump skipped, instruction units count: 343
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.widget.SwipeMenuLayout.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        SwipeMenuLayout swipeMenuLayout = y;
        if (this == swipeMenuLayout) {
            swipeMenuLayout.b();
            y = null;
        }
        super.onDetachedFromWindow();
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0070, code lost:
    
        if (r4.u != false) goto L35;
     */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x006e  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            boolean r0 = r4.s
            if (r0 == 0) goto L73
            int r0 = r5.getAction()
            r1 = 1
            if (r0 == r1) goto L24
            r2 = 2
            if (r0 == r2) goto Lf
            goto L6e
        Lf:
            float r0 = r5.getRawX()
            android.graphics.PointF r2 = r4.p
            float r2 = r2.x
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            int r2 = r4.g
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L6e
            goto L72
        L24:
            boolean r0 = r4.v
            if (r0 == 0) goto L4a
            int r0 = r4.getScrollX()
            int r2 = r4.g
            if (r0 <= r2) goto L69
            float r0 = r5.getX()
            int r2 = r4.getWidth()
            int r3 = r4.getScrollX()
            int r2 = r2 - r3
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 >= 0) goto L69
            boolean r5 = r4.o
            if (r5 == 0) goto L72
            r4.b()
            return r1
        L4a:
            int r0 = r4.getScrollX()
            int r0 = -r0
            int r2 = r4.g
            if (r0 <= r2) goto L69
            float r0 = r5.getX()
            int r2 = r4.getScrollX()
            int r2 = -r2
            float r2 = (float) r2
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L69
            boolean r5 = r4.o
            if (r5 == 0) goto L72
            r4.b()
            return r1
        L69:
            boolean r0 = r4.q
            if (r0 == 0) goto L6e
            goto L72
        L6e:
            boolean r0 = r4.u
            if (r0 == 0) goto L73
        L72:
            return r1
        L73:
            boolean r5 = super.onInterceptTouchEvent(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.luutinhit.launcher6.widget.SwipeMenuLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        int measuredWidth;
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingLeft2 = getPaddingLeft();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                if (i5 == 0) {
                    childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + getPaddingTop());
                    measuredWidth = childAt.getMeasuredWidth();
                } else if (this.v) {
                    childAt.layout(paddingLeft, getPaddingTop(), childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + getPaddingTop());
                    measuredWidth = childAt.getMeasuredWidth();
                } else {
                    childAt.layout(paddingLeft2 - childAt.getMeasuredWidth(), getPaddingTop(), paddingLeft2, childAt.getMeasuredHeight() + getPaddingTop());
                    paddingLeft2 -= childAt.getMeasuredWidth();
                }
                paddingLeft = measuredWidth + paddingLeft;
            }
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        SwipeMenuLayout swipeMenuLayout = this;
        super.onMeasure(i, i2);
        swipeMenuLayout.setClickable(true);
        swipeMenuLayout.k = 0;
        swipeMenuLayout.j = 0;
        int childCount = swipeMenuLayout.getChildCount();
        boolean z2 = View.MeasureSpec.getMode(i2) != 1073741824;
        int measuredWidth = 0;
        boolean z3 = false;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = swipeMenuLayout.getChildAt(i3);
            childAt.setClickable(true);
            if (childAt.getVisibility() != 8) {
                swipeMenuLayout.measureChild(childAt, i, i2);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                swipeMenuLayout.j = Math.max(swipeMenuLayout.j, childAt.getMeasuredHeight());
                if (z2 && marginLayoutParams.height == -1) {
                    z3 = true;
                }
                if (i3 > 0) {
                    swipeMenuLayout.k = childAt.getMeasuredWidth() + swipeMenuLayout.k;
                } else {
                    swipeMenuLayout.m = childAt;
                    measuredWidth = childAt.getMeasuredWidth();
                }
            }
        }
        int i4 = i;
        swipeMenuLayout.setMeasuredDimension(swipeMenuLayout.getPaddingRight() + swipeMenuLayout.getPaddingLeft() + measuredWidth, swipeMenuLayout.getPaddingBottom() + swipeMenuLayout.getPaddingTop() + swipeMenuLayout.j);
        swipeMenuLayout.l = (swipeMenuLayout.k * 4) / 10;
        if (z3) {
            int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(swipeMenuLayout.getMeasuredHeight(), 1073741824);
            int i5 = 0;
            while (i5 < childCount) {
                View childAt2 = swipeMenuLayout.getChildAt(i5);
                if (childAt2.getVisibility() != 8) {
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt2.getLayoutParams();
                    if (marginLayoutParams2.height == -1) {
                        int i6 = marginLayoutParams2.width;
                        marginLayoutParams2.width = childAt2.getMeasuredWidth();
                        swipeMenuLayout.measureChildWithMargins(childAt2, i4, 0, iMakeMeasureSpec, 0);
                        marginLayoutParams2.width = i6;
                    }
                }
                i5++;
                swipeMenuLayout = this;
                i4 = i;
            }
        }
    }

    @Override // android.view.View
    public final boolean performLongClick() {
        return Math.abs(getScrollX()) <= this.g && super.performLongClick();
    }

    public void setSwipeEnable(boolean z2) {
        this.s = z2;
    }
}
