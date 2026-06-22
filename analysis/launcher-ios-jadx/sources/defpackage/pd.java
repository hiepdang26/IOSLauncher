package defpackage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: loaded from: classes.dex */
public abstract class pd extends NestedScrollView {
    public boolean M;
    public float N;
    public boolean O;
    public long P;
    public int Q;
    public Interpolator R;
    public View S;
    public float T;
    public int U;
    public int V;
    public final Rect W;
    public nd a0;

    public pd(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.W = new Rect();
        setOverScrollMode(2);
        setVerticalScrollBarEnabled(false);
        setHorizontalScrollBarEnabled(false);
        setFillViewport(true);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g71.BounceScrollView, 0, 0);
        this.N = typedArrayObtainStyledAttributes.getFloat(g71.BounceScrollView_damping, 4.0f);
        this.M = typedArrayObtainStyledAttributes.getInt(g71.BounceScrollView_scrollOrientation, 0) == 1;
        this.O = typedArrayObtainStyledAttributes.getBoolean(g71.BounceScrollView_incrementalDamping, true);
        this.P = typedArrayObtainStyledAttributes.getInt(g71.BounceScrollView_bounceDelay, 400);
        this.Q = typedArrayObtainStyledAttributes.getInt(g71.BounceScrollView_triggerOverScrollThreshold, 20);
        typedArrayObtainStyledAttributes.recycle();
        if (this.O) {
            this.R = new md(0);
        }
    }

    @Override // android.view.View
    public final boolean canScrollHorizontally(int i) {
        return this.M;
    }

    @Override // android.view.View
    public final boolean canScrollVertically(int i) {
        return !this.M;
    }

    public long getBounceDelay() {
        return this.P;
    }

    public float getDamping() {
        return this.N;
    }

    public int getTriggerOverScrollThreshold() {
        return this.Q;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        if (getChildCount() > 0) {
            this.S = getChildAt(0);
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.T = this.M ? motionEvent.getX() : motionEvent.getY();
        } else if (action == 2) {
            return this.M ? Math.abs(motionEvent.getX() - this.T) >= ((float) this.Q) : Math.abs(motionEvent.getY() - this.T) >= ((float) this.Q);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        View childAt;
        int measuredHeight;
        int i3;
        super.onMeasure(i, i2);
        if (getChildCount() <= 0 || (measuredHeight = (childAt = getChildAt(0)).getMeasuredHeight()) <= 0) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            int marginStart = marginLayoutParams.getMarginStart();
            int i4 = marginLayoutParams.topMargin;
            int marginEnd = marginLayoutParams.getMarginEnd();
            int i5 = marginLayoutParams.bottomMargin;
            if (marginStart == 0 && i4 == 0 && marginEnd == 0 && i5 == 0) {
                return;
            }
            if (measuredHeight <= getMeasuredHeight()) {
                measuredWidth -= marginStart + marginEnd;
                i3 = measuredHeight - (i4 + i5);
            } else {
                i3 = measuredHeight + i4 + i5;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(measuredWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0171 A[PHI: r6
  0x0171: PHI (r6v6 int) = (r6v5 int), (r6v8 int) binds: [B:83:0x0179, B:79:0x0168] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // androidx.core.widget.NestedScrollView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r13) {
        /*
            Method dump skipped, instruction units count: 498
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.pd.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setBounceDelay(long j) {
        if (j >= 0) {
            this.P = j;
        }
    }

    public void setBounceInterpolator(Interpolator interpolator) {
        this.R = interpolator;
    }

    public void setDamping(float f) {
        if (this.N > 0.0f) {
            this.N = f;
        }
    }

    public void setIncrementalDamping(boolean z) {
        this.O = z;
    }

    public void setOnOverScrollListener(nd ndVar) {
        this.a0 = ndVar;
    }

    public void setScrollHorizontally(boolean z) {
        this.M = z;
    }

    public void setTriggerOverScrollThreshold(int i) {
        if (i >= 0) {
            this.Q = i;
        }
    }

    public void setOnScrollListener(od odVar) {
    }
}
