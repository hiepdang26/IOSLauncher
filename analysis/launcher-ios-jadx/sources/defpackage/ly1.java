package defpackage;

import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.util.Objects;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes.dex */
public final class ly1 {
    public static final ly1 b;
    public final iy1 a;

    static {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            b = hy1.s;
        } else if (i >= 30) {
            b = gy1.r;
        } else {
            b = iy1.b;
        }
    }

    public ly1(WindowInsets windowInsets) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 34) {
            this.a = new hy1(this, windowInsets);
            return;
        }
        if (i >= 30) {
            this.a = new gy1(this, windowInsets);
            return;
        }
        if (i >= 29) {
            this.a = new fy1(this, windowInsets);
        } else if (i >= 28) {
            this.a = new ey1(this, windowInsets);
        } else {
            this.a = new dy1(this, windowInsets);
        }
    }

    public static eg0 e(eg0 eg0Var, int i, int i2, int i3, int i4) {
        int iMax = Math.max(0, eg0Var.a - i);
        int iMax2 = Math.max(0, eg0Var.b - i2);
        int iMax3 = Math.max(0, eg0Var.c - i3);
        int iMax4 = Math.max(0, eg0Var.d - i4);
        return (iMax == i && iMax2 == i2 && iMax3 == i3 && iMax4 == i4) ? eg0Var : eg0.a(iMax, iMax2, iMax3, iMax4);
    }

    public static ly1 h(WindowInsets windowInsets, View view) {
        windowInsets.getClass();
        ly1 ly1Var = new ly1(windowInsets);
        if (view != null && view.isAttachedToWindow()) {
            WeakHashMap weakHashMap = qs1.a;
            ly1 ly1VarA = Build.VERSION.SDK_INT >= 23 ? is1.a(view) : hs1.f(view);
            iy1 iy1Var = ly1Var.a;
            iy1Var.p(ly1VarA);
            iy1Var.d(view.getRootView());
            iy1Var.r(view.getWindowSystemUiVisibility());
        }
        return ly1Var;
    }

    public final int a() {
        return this.a.j().d;
    }

    public final int b() {
        return this.a.j().a;
    }

    public final int c() {
        return this.a.j().c;
    }

    public final int d() {
        return this.a.j().b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ly1)) {
            return false;
        }
        return Objects.equals(this.a, ((ly1) obj).a);
    }

    public final ly1 f(int i, int i2, int i3, int i4) {
        int i5 = Build.VERSION.SDK_INT;
        by1 ay1Var = i5 >= 34 ? new ay1(this) : i5 >= 30 ? new zx1(this) : i5 >= 29 ? new yx1(this) : new xx1(this);
        ay1Var.d(eg0.a(i, i2, i3, i4));
        return ay1Var.b();
    }

    public final WindowInsets g() {
        iy1 iy1Var = this.a;
        if (iy1Var instanceof cy1) {
            return ((cy1) iy1Var).c;
        }
        return null;
    }

    public final int hashCode() {
        iy1 iy1Var = this.a;
        if (iy1Var == null) {
            return 0;
        }
        return iy1Var.hashCode();
    }

    public ly1() {
        this.a = new iy1(this);
    }
}
