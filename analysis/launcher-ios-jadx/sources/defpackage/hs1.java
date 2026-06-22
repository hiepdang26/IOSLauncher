package defpackage;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
public abstract class hs1 {
    public static void a(WindowInsets windowInsets, View view) {
        View.OnApplyWindowInsetsListener onApplyWindowInsetsListener = (View.OnApplyWindowInsetsListener) view.getTag(y51.tag_window_insets_animation_callback);
        if (onApplyWindowInsetsListener != null) {
            onApplyWindowInsetsListener.onApplyWindowInsets(view, windowInsets);
        }
    }

    public static ly1 b(View view, ly1 ly1Var, Rect rect) {
        WindowInsets windowInsetsG = ly1Var.g();
        if (windowInsetsG != null) {
            return ly1.h(view.computeSystemWindowInsets(windowInsetsG, rect), view);
        }
        rect.setEmpty();
        return ly1Var;
    }

    public static ColorStateList c(View view) {
        return view.getBackgroundTintList();
    }

    public static PorterDuff.Mode d(View view) {
        return view.getBackgroundTintMode();
    }

    public static float e(View view) {
        return view.getElevation();
    }

    public static ly1 f(View view) {
        if (!wx1.d || !view.isAttachedToWindow()) {
            return null;
        }
        try {
            Object obj = wx1.a.get(view.getRootView());
            if (obj == null) {
                return null;
            }
            Rect rect = (Rect) wx1.b.get(obj);
            Rect rect2 = (Rect) wx1.c.get(obj);
            if (rect == null || rect2 == null) {
                return null;
            }
            int i = Build.VERSION.SDK_INT;
            by1 ay1Var = i >= 34 ? new ay1() : i >= 30 ? new zx1() : i >= 29 ? new yx1() : new xx1();
            ay1Var.c(eg0.a(rect.left, rect.top, rect.right, rect.bottom));
            ay1Var.d(eg0.a(rect2.left, rect2.top, rect2.right, rect2.bottom));
            ly1 ly1VarB = ay1Var.b();
            ly1VarB.a.p(ly1VarB);
            ly1VarB.a.d(view.getRootView());
            return ly1VarB;
        } catch (IllegalAccessException e) {
            e.getMessage();
            return null;
        }
    }

    public static String g(View view) {
        return view.getTransitionName();
    }

    public static float h(View view) {
        return view.getZ();
    }

    public static boolean i(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void j(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
    }

    public static void k(View view, PorterDuff.Mode mode) {
        view.setBackgroundTintMode(mode);
    }

    public static void l(View view, float f) {
        view.setElevation(f);
    }

    public static void m(View view, ny0 ny0Var) {
        gs1 gs1Var = ny0Var != null ? new gs1(view, ny0Var) : null;
        if (Build.VERSION.SDK_INT < 30) {
            view.setTag(y51.tag_on_apply_window_listener, gs1Var);
        }
        if (view.getTag(y51.tag_compat_insets_dispatch) != null) {
            return;
        }
        if (gs1Var != null) {
            view.setOnApplyWindowInsetsListener(gs1Var);
        } else {
            view.setOnApplyWindowInsetsListener((View.OnApplyWindowInsetsListener) view.getTag(y51.tag_window_insets_animation_callback));
        }
    }

    public static void n(View view) {
        view.stopNestedScroll();
    }
}
