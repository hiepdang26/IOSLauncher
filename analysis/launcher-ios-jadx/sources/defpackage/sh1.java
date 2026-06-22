package defpackage;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.RtlSpacingHelper;
import java.util.Iterator;
import java.util.Objects;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class sh1 extends ViewGroup {
    public static final int[] O = {R.attr.gravity};
    public int A;
    public float B;
    public boolean C;
    public boolean D;
    public float E;
    public float F;
    public float G;
    public float H;
    public boolean I;
    public final CopyOnWriteArrayList J;
    public View.OnClickListener K;
    public final us1 L;
    public boolean M;
    public final Rect N;
    public int g;
    public int h;
    public final Paint i;
    public final Drawable j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public boolean p;
    public View q;
    public int r;
    public View s;
    public final int t;
    public oe1 u;
    public View v;
    public View w;
    public rh1 x;
    public rh1 y;
    public float z;

    /* JADX WARN: Removed duplicated region for block: B:17:0x00dc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public sh1(android.content.Context r10, android.util.AttributeSet r11) {
        /*
            Method dump skipped, instruction units count: 342
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sh1.<init>(android.content.Context, android.util.AttributeSet):void");
    }

    public final void a(qh1 qh1Var) {
        Objects.toString(qh1Var);
        synchronized (this.J) {
            this.J.add(qh1Var);
        }
    }

    public final int b(float f) {
        View view = this.v;
        int i = (int) (f * this.A);
        return this.n ? ((getMeasuredHeight() - getPaddingBottom()) - this.k) - i : (getPaddingTop() - (view != null ? view.getMeasuredHeight() : 0)) + this.k + i;
    }

    public final float c(int i) {
        float f;
        int i2;
        int iB = b(0.0f);
        if (this.n) {
            f = iB - i;
            i2 = this.A;
        } else {
            f = i - iB;
            i2 = this.A;
        }
        return f / i2;
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        Objects.toString(layoutParams);
        return (layoutParams instanceof ph1) && super.checkLayoutParams(layoutParams);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0037  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void computeScroll() {
        /*
            r11 = this;
            us1 r0 = r11.L
            if (r0 == 0) goto L86
            android.view.View r1 = r0.q
            r2 = 0
            if (r1 != 0) goto La
            goto L75
        La:
            int r1 = r0.a
            r3 = 1
            r4 = 2
            if (r1 != r4) goto L70
            android.widget.OverScroller r1 = r0.o
            boolean r5 = r1.computeScrollOffset()
            int r6 = r1.getCurrX()
            int r7 = r1.getCurrY()
            android.view.View r8 = r0.q
            int r8 = r8.getLeft()
            int r8 = r6 - r8
            android.view.View r9 = r0.q
            int r9 = r9.getTop()
            int r9 = r7 - r9
            if (r5 != 0) goto L39
            if (r9 == 0) goto L39
            android.view.View r1 = r0.q
            r1.setTop(r2)
        L37:
            r2 = 1
            goto L75
        L39:
            if (r8 == 0) goto L40
            android.view.View r10 = r0.q
            r10.offsetLeftAndRight(r8)
        L40:
            if (r9 == 0) goto L47
            android.view.View r10 = r0.q
            r10.offsetTopAndBottom(r9)
        L47:
            if (r8 != 0) goto L4b
            if (r9 == 0) goto L52
        L4b:
            ow1 r8 = r0.p
            android.view.View r9 = r0.q
            r8.t(r7, r9)
        L52:
            if (r5 == 0) goto L67
            int r8 = r1.getFinalX()
            if (r6 != r8) goto L67
            int r6 = r1.getFinalY()
            if (r7 != r6) goto L67
            r1.abortAnimation()
            boolean r5 = r1.isFinished()
        L67:
            if (r5 != 0) goto L70
            fl0 r1 = r0.t
            sh1 r5 = r0.s
            r5.post(r1)
        L70:
            int r1 = r0.a
            if (r1 != r4) goto L75
            goto L37
        L75:
            if (r2 == 0) goto L86
            boolean r1 = r11.isEnabled()
            if (r1 != 0) goto L81
            r0.a()
            return
        L81:
            java.util.WeakHashMap r0 = defpackage.qs1.a
            r11.postInvalidateOnAnimation()
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sh1.computeScroll():void");
    }

    public final boolean d() {
        return (!this.D || this.v == null || this.x == rh1.j) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        int action;
        us1 us1Var = this.L;
        Objects.toString(motionEvent);
        try {
            action = motionEvent.getAction();
        } catch (Throwable th) {
            th.getMessage();
        }
        if (us1Var.a == 2 && action == 0) {
            return true;
        }
        if (isEnabled() && d() && (!this.C || action == 0)) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            if (action == 0) {
                this.I = false;
                this.E = x;
                this.F = y;
            } else if (action == 2) {
                float f = x - this.E;
                float f2 = y - this.F;
                this.E = x;
                this.F = y;
                if (Math.abs(f) > Math.abs(f2)) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                if (!e(this.s, (int) this.G, (int) this.H)) {
                    return super.dispatchTouchEvent(motionEvent);
                }
                boolean z = this.n;
                if ((z ? 1 : -1) * f2 > 0.0f) {
                    oe1 oe1Var = this.u;
                    View view = this.s;
                    oe1Var.getClass();
                    if (oe1.a(view, z) > 0) {
                        this.I = true;
                        return super.dispatchTouchEvent(motionEvent);
                    }
                    if (this.I) {
                        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                        motionEventObtain.setAction(3);
                        super.dispatchTouchEvent(motionEventObtain);
                        motionEventObtain.recycle();
                        motionEvent.setAction(0);
                    }
                    this.I = false;
                    return onTouchEvent(motionEvent);
                }
                if (f2 * (z ? 1 : -1) < 0.0f) {
                    if (this.z < 1.0f) {
                        this.I = false;
                        return onTouchEvent(motionEvent);
                    }
                    if (!this.I) {
                        if (us1Var.a == 1) {
                            us1Var.b();
                            motionEvent.setAction(0);
                        }
                    }
                    this.I = true;
                    return super.dispatchTouchEvent(motionEvent);
                }
            } else if (action == 1 && this.I) {
                us1Var.l(0);
            }
            return super.dispatchTouchEvent(motionEvent);
        }
        us1Var.a();
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        View view;
        int bottom;
        int bottom2;
        Objects.toString(canvas);
        super.draw(canvas);
        Drawable drawable = this.j;
        if (drawable == null || (view = this.v) == null) {
            return;
        }
        int right = view.getRight();
        if (this.n) {
            bottom = this.v.getTop() - this.l;
            bottom2 = this.v.getTop();
        } else {
            bottom = this.v.getBottom();
            bottom2 = this.v.getBottom() + this.l;
        }
        drawable.setBounds(this.v.getLeft(), bottom, right, bottom2);
        drawable.draw(canvas);
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j) {
        boolean zDrawChild;
        Objects.toString(canvas);
        Objects.toString(view);
        int iSave = canvas.save();
        View view2 = this.v;
        if (view2 == null || view2 == view) {
            zDrawChild = super.drawChild(canvas, view, j);
        } else {
            Rect rect = this.N;
            canvas.getClipBounds(rect);
            if (!this.o) {
                if (this.n) {
                    rect.bottom = Math.min(rect.bottom, this.v.getTop());
                } else {
                    rect.top = Math.max(rect.top, this.v.getBottom());
                }
            }
            if (this.p) {
                canvas.clipRect(rect);
            }
            zDrawChild = super.drawChild(canvas, view, j);
            int i = this.h;
            if (i != 0) {
                float f = this.z;
                if (f > 0.0f) {
                    int i2 = (i & 16777215) | (((int) ((((-16777216) & i) >>> 24) * f)) << 24);
                    Paint paint = this.i;
                    paint.setColor(i2);
                    canvas.drawRect(rect, paint);
                }
            }
        }
        canvas.restoreToCount(iSave);
        return zDrawChild;
    }

    public final boolean e(View view, int i, int i2) {
        int i3;
        Objects.toString(view);
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i4 = iArr2[0] + i;
        int i5 = iArr2[1] + i2;
        int i6 = iArr[0];
        return i4 >= i6 && i4 < view.getWidth() + i6 && i5 >= (i3 = iArr[1]) && i5 < view.getHeight() + i3;
    }

    public final void f() {
        int iB = b(0.0f);
        View view = this.v;
        if (view != null) {
            view.setTop(iB);
        }
    }

    public final void g(float f) {
        if (!isEnabled() || this.v == null) {
            return;
        }
        int iB = b(f);
        View view = this.v;
        int left = view.getLeft();
        us1 us1Var = this.L;
        us1Var.q = view;
        us1Var.c = -1;
        if (us1Var.g(left, iB, 0, 0)) {
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt.getVisibility() == 4) {
                    childAt.setVisibility(0);
                }
            }
            WeakHashMap weakHashMap = qs1.a;
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ph1 ph1Var = new ph1(-1, -1);
        ph1Var.a = 0.0f;
        return ph1Var;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        Objects.toString(layoutParams);
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ph1 ph1Var = new ph1((ViewGroup.MarginLayoutParams) layoutParams);
            ph1Var.a = 0.0f;
            return ph1Var;
        }
        ph1 ph1Var2 = new ph1(layoutParams);
        ph1Var2.a = 0.0f;
        return ph1Var2;
    }

    public float getAnchorPoint() {
        return this.B;
    }

    public int getCoveredFadeColor() {
        return this.h;
    }

    public int getCurrentParallaxOffset() {
        int iMax = (int) (Math.max(this.z, 0.0f) * this.m);
        return this.n ? -iMax : iMax;
    }

    public float getCurrentSlideOffset() {
        return this.z;
    }

    public View getDragView() {
        return this.q;
    }

    public int getMinFlingVelocity() {
        return this.g;
    }

    public int getPanelHeight() {
        return this.k;
    }

    public rh1 getPanelState() {
        return this.x;
    }

    public int getShadowHeight() {
        return this.l;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h() {
        /*
            r11 = this;
            int r0 = r11.getChildCount()
            if (r0 != 0) goto L7
            return
        L7:
            int r0 = r11.getPaddingLeft()
            int r1 = r11.getWidth()
            int r2 = r11.getPaddingRight()
            int r1 = r1 - r2
            int r2 = r11.getPaddingTop()
            int r3 = r11.getHeight()
            int r4 = r11.getPaddingBottom()
            int r3 = r3 - r4
            android.view.View r4 = r11.v
            r5 = 0
            if (r4 == 0) goto L4f
            java.util.Objects.toString(r4)
            android.graphics.drawable.Drawable r4 = r4.getBackground()
            if (r4 == 0) goto L4f
            int r4 = r4.getOpacity()
            r6 = -1
            if (r4 != r6) goto L4f
            android.view.View r4 = r11.v
            int r4 = r4.getLeft()
            android.view.View r6 = r11.v
            int r6 = r6.getRight()
            android.view.View r7 = r11.v
            int r7 = r7.getTop()
            android.view.View r8 = r11.v
            int r8 = r8.getBottom()
            goto L53
        L4f:
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
        L53:
            android.view.View r9 = r11.getChildAt(r5)
            int r10 = r9.getLeft()
            int r0 = java.lang.Math.max(r0, r10)
            int r10 = r9.getTop()
            int r2 = java.lang.Math.max(r2, r10)
            int r10 = r9.getRight()
            int r1 = java.lang.Math.min(r1, r10)
            int r10 = r9.getBottom()
            int r3 = java.lang.Math.min(r3, r10)
            if (r0 < r4) goto L80
            if (r2 < r7) goto L80
            if (r1 > r6) goto L80
            if (r3 > r8) goto L80
            r5 = 4
        L80:
            r9.setVisibility(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sh1.h():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.M = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.M = true;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.r;
        if (i != -1) {
            setDragView(findViewById(i));
        }
        int i2 = this.t;
        if (i2 != -1) {
            setScrollableView(findViewById(i2));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0187  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r12) {
        /*
            Method dump skipped, instruction units count: 441
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.sh1.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.M) {
            int iOrdinal = this.x.ordinal();
            if (iOrdinal == 0) {
                this.z = 1.0f;
            } else if (iOrdinal == 2) {
                this.z = this.B;
            } else if (iOrdinal != 3) {
                this.z = 0.0f;
            } else {
                this.z = c(b(0.0f) + (this.n ? this.k : -this.k));
            }
        }
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            ph1 ph1Var = (ph1) childAt.getLayoutParams();
            if (childAt.getVisibility() != 8 || (i5 != 0 && !this.M)) {
                int measuredHeight = childAt.getMeasuredHeight();
                int iB = childAt == this.v ? b(this.z) : paddingTop;
                if (!this.n && childAt == this.w && !this.o) {
                    iB = b(this.z) + this.v.getMeasuredHeight();
                }
                int i6 = ((ViewGroup.MarginLayoutParams) ph1Var).leftMargin + paddingLeft;
                childAt.layout(i6, iB, childAt.getMeasuredWidth() + i6, measuredHeight + iB);
            }
        }
        if (this.M) {
            h();
        }
        if (this.m > 0) {
            this.w.setTranslationY(getCurrentParallaxOffset());
        }
        this.M = false;
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int iMakeMeasureSpec;
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824 && mode != Integer.MIN_VALUE) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        }
        if (mode2 != 1073741824 && mode2 != Integer.MIN_VALUE) {
            throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
        }
        int childCount = getChildCount();
        if (childCount != 2) {
            throw new IllegalStateException("Sliding up panel layout must have exactly 2 children!");
        }
        this.w = getChildAt(0);
        View childAt = getChildAt(1);
        this.v = childAt;
        if (this.q == null) {
            setDragView(childAt);
        }
        int visibility = this.v.getVisibility();
        rh1 rh1Var = rh1.j;
        if (visibility != 0) {
            this.x = rh1Var;
        }
        int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt2 = getChildAt(i5);
            ph1 ph1Var = (ph1) childAt2.getLayoutParams();
            if (childAt2.getVisibility() != 8 || i5 != 0) {
                if (childAt2 == this.w) {
                    i3 = (this.o || this.x == rh1Var) ? paddingTop : paddingTop - this.k;
                    i4 = paddingLeft - (((ViewGroup.MarginLayoutParams) ph1Var).leftMargin + ((ViewGroup.MarginLayoutParams) ph1Var).rightMargin);
                } else {
                    i3 = childAt2 == this.v ? paddingTop - ((ViewGroup.MarginLayoutParams) ph1Var).topMargin : paddingTop;
                    i4 = paddingLeft;
                }
                int i6 = ((ViewGroup.MarginLayoutParams) ph1Var).width;
                int iMakeMeasureSpec2 = i6 == -2 ? View.MeasureSpec.makeMeasureSpec(i4, RtlSpacingHelper.UNDEFINED) : i6 == -1 ? View.MeasureSpec.makeMeasureSpec(i4, 1073741824) : View.MeasureSpec.makeMeasureSpec(i6, 1073741824);
                int i7 = ((ViewGroup.MarginLayoutParams) ph1Var).height;
                if (i7 == -2) {
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, RtlSpacingHelper.UNDEFINED);
                } else {
                    float f = ph1Var.a;
                    if (f > 0.0f && f < 1.0f) {
                        i3 = (int) (i3 * f);
                    } else if (i7 != -1) {
                        i3 = i7;
                    }
                    iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i3, 1073741824);
                }
                childAt2.measure(iMakeMeasureSpec2, iMakeMeasureSpec);
                View view = this.v;
                if (childAt2 == view) {
                    this.A = view.getMeasuredHeight() - this.k;
                }
            }
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        Objects.toString(parcelable);
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            rh1 rh1Var = (rh1) bundle.getSerializable("sliding_state");
            this.x = rh1Var;
            if (rh1Var == null) {
                rh1Var = rh1.h;
            }
            this.x = rh1Var;
            parcelable = bundle.getParcelable("superState");
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("superState", super.onSaveInstanceState());
        rh1 rh1Var = this.x;
        if (rh1Var == rh1.k) {
            rh1Var = this.y;
        }
        bundle.putSerializable("sliding_state", rh1Var);
        return bundle;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i2 != i4) {
            this.M = true;
        }
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        Objects.toString(motionEvent);
        if (!isEnabled() || !d()) {
            return super.onTouchEvent(motionEvent);
        }
        try {
            this.L.h(motionEvent);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public void setAnchorPoint(float f) {
        if (f <= 0.0f || f > 1.0f) {
            return;
        }
        this.B = f;
        this.M = true;
        requestLayout();
    }

    public void setClipPanel(boolean z) {
        this.p = z;
    }

    public void setCoveredFadeColor(int i) {
        this.h = i;
        requestLayout();
    }

    public void setDragView(View view) {
        Objects.toString(view);
        View view2 = this.q;
        if (view2 != null) {
            view2.setOnClickListener(null);
        }
        this.q = view;
        if (view != null) {
            view.setClickable(true);
            this.q.setFocusable(false);
            this.q.setFocusableInTouchMode(false);
            this.q.setOnClickListener(new oh1(this));
        }
    }

    public void setFadeOnClickListener(View.OnClickListener onClickListener) {
        Objects.toString(onClickListener);
        this.K = onClickListener;
    }

    public void setGravity(int i) {
        if (i != 48 && i != 80) {
            throw new IllegalArgumentException("gravity must be set to either top or bottom");
        }
        this.n = i == 80;
        if (this.M) {
            return;
        }
        requestLayout();
    }

    public void setMinFlingVelocity(int i) {
        this.g = i;
    }

    public void setOverlayed(boolean z) {
        this.o = z;
    }

    public void setPanelHeight(int i) {
        if (getPanelHeight() == i) {
            return;
        }
        this.k = i;
        if (!this.M) {
            requestLayout();
        }
        if (getPanelState() == rh1.h) {
            g(0.0f);
            invalidate();
        }
    }

    public void setPanelState(rh1 rh1Var) {
        rh1 rh1Var2;
        rh1 rh1Var3;
        Objects.toString(rh1Var);
        us1 us1Var = this.L;
        if (us1Var.a == 2) {
            us1Var.a();
        }
        if (rh1Var == null || rh1Var == (rh1Var2 = rh1.k)) {
            throw new IllegalArgumentException("Panel state cannot be null or DRAGGING.");
        }
        if (isEnabled()) {
            boolean z = this.M;
            if ((!z && this.v == null) || rh1Var == (rh1Var3 = this.x) || rh1Var3 == rh1Var2) {
                return;
            }
            if (z) {
                setPanelStateInternal(rh1Var);
                return;
            }
            if (rh1Var3 == rh1.j) {
                this.v.setVisibility(0);
                requestLayout();
            }
            int iOrdinal = rh1Var.ordinal();
            if (iOrdinal == 0) {
                g(1.0f);
                return;
            }
            if (iOrdinal == 1) {
                g(0.0f);
            } else if (iOrdinal == 2) {
                g(this.B);
            } else {
                if (iOrdinal != 3) {
                    return;
                }
                g(c(b(0.0f) + (this.n ? this.k : -this.k)));
            }
        }
    }

    public void setPanelStateInternal(rh1 rh1Var) {
        Objects.toString(rh1Var);
        rh1 rh1Var2 = this.x;
        if (rh1Var2 == rh1Var) {
            return;
        }
        this.x = rh1Var;
        Objects.toString(this);
        Objects.toString(rh1Var2);
        Objects.toString(rh1Var);
        synchronized (this.J) {
            try {
                Iterator it = this.J.iterator();
                while (it.hasNext()) {
                    ((qh1) it.next()).b(rh1Var);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        sendAccessibilityEvent(32);
    }

    public void setParallaxOffset(int i) {
        this.m = i;
        if (this.M) {
            return;
        }
        requestLayout();
    }

    public void setScrollableView(View view) {
        Objects.toString(view);
        this.s = view;
    }

    public void setScrollableViewHelper(oe1 oe1Var) {
        Objects.toString(oe1Var);
        this.u = oe1Var;
    }

    public void setShadowHeight(int i) {
        this.l = i;
        if (this.M) {
            return;
        }
        invalidate();
    }

    public void setTouchEnabled(boolean z) {
        this.D = z;
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Objects.toString(attributeSet);
        Context context = getContext();
        ph1 ph1Var = new ph1(context, attributeSet);
        ph1Var.a = 0.0f;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ph1.b);
        if (typedArrayObtainStyledAttributes != null) {
            ph1Var.a = typedArrayObtainStyledAttributes.getFloat(0, 0.0f);
            typedArrayObtainStyledAttributes.recycle();
        }
        return ph1Var;
    }

    public void setDragView(int i) {
        this.r = i;
        setDragView(findViewById(i));
    }
}
