package defpackage;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.View;
import android.widget.LinearLayout;
import com.google.android.material.tabs.TabLayout;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class am1 extends LinearLayout {
    public static final /* synthetic */ int l = 0;
    public ValueAnimator g;
    public int h;
    public float i;
    public int j;
    public final /* synthetic */ TabLayout k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public am1(TabLayout tabLayout, Context context) {
        super(context);
        this.k = tabLayout;
        this.h = -1;
        this.j = -1;
        setWillNotDraw(false);
    }

    public final void a() {
        View childAt = getChildAt(this.h);
        TabLayout tabLayout = this.k;
        ta1 ta1Var = tabLayout.L;
        Drawable drawable = tabLayout.r;
        ta1Var.getClass();
        RectF rectFF = ta1.f(tabLayout, childAt);
        drawable.setBounds((int) rectFF.left, drawable.getBounds().top, (int) rectFF.right, drawable.getBounds().bottom);
    }

    public final void b(int i) {
        TabLayout tabLayout = this.k;
        Rect bounds = tabLayout.r.getBounds();
        tabLayout.r.setBounds(bounds.left, 0, bounds.right, i);
        requestLayout();
    }

    public final void c(View view, View view2, float f) {
        TabLayout tabLayout = this.k;
        if (view == null || view.getWidth() <= 0) {
            Drawable drawable = tabLayout.r;
            drawable.setBounds(-1, drawable.getBounds().top, -1, tabLayout.r.getBounds().bottom);
        } else {
            tabLayout.L.g(tabLayout, view, view2, f, tabLayout.r);
        }
        WeakHashMap weakHashMap = qs1.a;
        postInvalidateOnAnimation();
    }

    public final void d(int i, int i2, boolean z) {
        View childAt = getChildAt(this.h);
        View childAt2 = getChildAt(i);
        if (childAt2 == null) {
            a();
            return;
        }
        yl1 yl1Var = new yl1(this, childAt, childAt2);
        if (!z) {
            this.g.removeAllUpdateListeners();
            this.g.addUpdateListener(yl1Var);
            return;
        }
        ValueAnimator valueAnimator = new ValueAnimator();
        this.g = valueAnimator;
        valueAnimator.setInterpolator(n5.b);
        valueAnimator.setDuration(i2);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        valueAnimator.addUpdateListener(yl1Var);
        valueAnimator.addListener(new zl1(this, i));
        valueAnimator.start();
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        int height;
        TabLayout tabLayout = this.k;
        int iHeight = tabLayout.r.getBounds().height();
        if (iHeight < 0) {
            iHeight = tabLayout.r.getIntrinsicHeight();
        }
        int i = tabLayout.E;
        if (i == 0) {
            height = getHeight() - iHeight;
            iHeight = getHeight();
        } else if (i != 1) {
            height = 0;
            if (i != 2) {
                iHeight = i != 3 ? 0 : getHeight();
            }
        } else {
            height = (getHeight() - iHeight) / 2;
            iHeight = (getHeight() + iHeight) / 2;
        }
        if (tabLayout.r.getBounds().width() > 0) {
            Rect bounds = tabLayout.r.getBounds();
            tabLayout.r.setBounds(bounds.left, height, bounds.right, iHeight);
            Drawable drawableL = tabLayout.r;
            if (tabLayout.s != 0) {
                drawableL = az1.L(drawableL);
                if (Build.VERSION.SDK_INT == 21) {
                    drawableL.setColorFilter(tabLayout.s, PorterDuff.Mode.SRC_IN);
                } else {
                    drawableL.setTint(tabLayout.s);
                }
            } else if (Build.VERSION.SDK_INT == 21) {
                drawableL.setColorFilter(null);
            } else {
                drawableL.setTintList(null);
            }
            drawableL.draw(canvas);
        }
        super.draw(canvas);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        ValueAnimator valueAnimator = this.g;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            a();
        } else {
            d(this.h, -1, false);
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            return;
        }
        TabLayout tabLayout = this.k;
        boolean z = true;
        if (tabLayout.C == 1 || tabLayout.F == 2) {
            int childCount = getChildCount();
            int iMax = 0;
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    iMax = Math.max(iMax, childAt.getMeasuredWidth());
                }
            }
            if (iMax <= 0) {
                return;
            }
            if (iMax * childCount <= getMeasuredWidth() - (((int) qg0.q(getContext(), 16)) * 2)) {
                boolean z2 = false;
                for (int i4 = 0; i4 < childCount; i4++) {
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) getChildAt(i4).getLayoutParams();
                    if (layoutParams.width != iMax || layoutParams.weight != 0.0f) {
                        layoutParams.width = iMax;
                        layoutParams.weight = 0.0f;
                        z2 = true;
                    }
                }
                z = z2;
            } else {
                tabLayout.C = 0;
                tabLayout.n(false);
            }
            if (z) {
                super.onMeasure(i, i2);
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onRtlPropertiesChanged(int i) {
        super.onRtlPropertiesChanged(i);
        if (Build.VERSION.SDK_INT >= 23 || this.j == i) {
            return;
        }
        requestLayout();
        this.j = i;
    }
}
