package defpackage;

import android.graphics.Canvas;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public abstract class th0 {
    public static final md b = new md(1);
    public static final md c = new md(2);
    public int a;

    public th0(int i) {
        this.a = i;
    }

    public static int b(int i, int i2) {
        int i3;
        int i4 = i & 3158064;
        if (i4 == 0) {
            return i;
        }
        int i5 = i & (~i4);
        if (i2 == 0) {
            i3 = i4 >> 2;
        } else {
            int i6 = i4 >> 1;
            i5 |= (-3158065) & i6;
            i3 = (i6 & 3158064) >> 2;
        }
        return i5 | i3;
    }

    public static int c(int i, int i2) {
        int i3;
        int i4 = i & 789516;
        if (i4 == 0) {
            return i;
        }
        int i5 = i & (~i4);
        if (i2 == 0) {
            i3 = i4 << 2;
        } else {
            int i6 = i4 << 1;
            i5 |= (-789517) & i6;
            i3 = (i6 & 789516) << 2;
        }
        return i5 | i3;
    }

    public static int m(int i, int i2) {
        int i3 = i2 | i;
        return (i << 16) | (i2 << 8) | i3;
    }

    public void a(RecyclerView recyclerView, m91 m91Var) {
        View view = m91Var.g;
        Object tag = view.getTag(o51.item_touch_helper_previous_elevation);
        if (tag instanceof Float) {
            float fFloatValue = ((Float) tag).floatValue();
            WeakHashMap weakHashMap = qs1.a;
            hs1.l(view, fFloatValue);
        }
        view.setTag(o51.item_touch_helper_previous_elevation, null);
        view.setTranslationX(0.0f);
        view.setTranslationY(0.0f);
    }

    public abstract void d(s60 s60Var);

    public abstract void e(s60 s60Var);

    public long f(RecyclerView recyclerView, int i) {
        r81 itemAnimator = recyclerView.getItemAnimator();
        return itemAnimator == null ? i == 8 ? 200L : 250L : i == 8 ? itemAnimator.e : itemAnimator.d;
    }

    public float g() {
        return 0.5f;
    }

    public abstract int h(RecyclerView recyclerView, m91 m91Var);

    public float i() {
        return 0.5f;
    }

    public int j(RecyclerView recyclerView, int i, int i2, long j) {
        if (this.a == -1) {
            this.a = recyclerView.getResources().getDimensionPixelSize(c51.item_touch_helper_max_drag_scroll_per_frame);
        }
        int interpolation = (int) (b.getInterpolation(j <= 2000 ? j / 2000.0f : 1.0f) * ((int) (c.getInterpolation(Math.min(1.0f, (Math.abs(i2) * 1.0f) / i)) * ((int) Math.signum(i2)) * this.a)));
        return interpolation == 0 ? i2 > 0 ? 1 : -1 : interpolation;
    }

    public abstract boolean k();

    public abstract boolean l();

    public void n(Canvas canvas, RecyclerView recyclerView, m91 m91Var, float f, float f2, int i, boolean z) {
        View view = m91Var.g;
        if (z && view.getTag(o51.item_touch_helper_previous_elevation) == null) {
            WeakHashMap weakHashMap = qs1.a;
            Float fValueOf = Float.valueOf(hs1.e(view));
            int childCount = recyclerView.getChildCount();
            float f3 = 0.0f;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = recyclerView.getChildAt(i2);
                if (childAt != view) {
                    WeakHashMap weakHashMap2 = qs1.a;
                    float fE = hs1.e(childAt);
                    if (fE > f3) {
                        f3 = fE;
                    }
                }
            }
            hs1.l(view, f3 + 1.0f);
            view.setTag(o51.item_touch_helper_previous_elevation, fValueOf);
        }
        view.setTranslationX(f);
        view.setTranslationY(f2);
    }

    public void o(m91 m91Var) {
        View view = m91Var.g;
    }

    public abstract void p(s60 s60Var);

    public abstract boolean q(RecyclerView recyclerView, m91 m91Var, m91 m91Var2);

    public abstract void r(s60 s60Var);

    public abstract void s(s60 s60Var);

    public abstract void t(m91 m91Var, int i);

    public abstract void u(m91 m91Var, int i);

    public abstract jd v(s60 s60Var);

    public th0() {
        this.a = -1;
    }
}
