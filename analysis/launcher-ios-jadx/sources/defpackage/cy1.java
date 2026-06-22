package defpackage;

import android.graphics.Rect;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public abstract class cy1 extends iy1 {
    public static boolean i = false;
    public static Method j;
    public static Class k;
    public static Field l;
    public static Field m;
    public final WindowInsets c;
    public eg0[] d;
    public eg0 e;
    public ly1 f;
    public eg0 g;
    public int h;

    public cy1(ly1 ly1Var, WindowInsets windowInsets) {
        super(ly1Var);
        this.e = null;
        this.c = windowInsets;
    }

    private eg0 s(int i2, boolean z) {
        eg0 eg0VarA = eg0.e;
        for (int i3 = 1; i3 <= 512; i3 <<= 1) {
            if ((i2 & i3) != 0) {
                eg0 eg0VarT = t(i3, z);
                eg0VarA = eg0.a(Math.max(eg0VarA.a, eg0VarT.a), Math.max(eg0VarA.b, eg0VarT.b), Math.max(eg0VarA.c, eg0VarT.c), Math.max(eg0VarA.d, eg0VarT.d));
            }
        }
        return eg0VarA;
    }

    private eg0 u() {
        ly1 ly1Var = this.f;
        return ly1Var != null ? ly1Var.a.h() : eg0.e;
    }

    private eg0 v(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            throw new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        }
        if (!i) {
            w();
        }
        Method method = j;
        if (method != null && k != null && l != null) {
            try {
                Object objInvoke = method.invoke(view, null);
                if (objInvoke != null) {
                    Rect rect = (Rect) l.get(m.get(objInvoke));
                    if (rect != null) {
                        return eg0.a(rect.left, rect.top, rect.right, rect.bottom);
                    }
                }
            } catch (ReflectiveOperationException e) {
                e.getMessage();
            }
        }
        return null;
    }

    private static void w() {
        try {
            j = View.class.getDeclaredMethod("getViewRootImpl", null);
            Class<?> cls = Class.forName("android.view.View$AttachInfo");
            k = cls;
            l = cls.getDeclaredField("mVisibleInsets");
            m = Class.forName("android.view.ViewRootImpl").getDeclaredField("mAttachInfo");
            l.setAccessible(true);
            m.setAccessible(true);
        } catch (ReflectiveOperationException e) {
            e.getMessage();
        }
        i = true;
    }

    public static boolean y(int i2, int i3) {
        return (i2 & 6) == (i3 & 6);
    }

    @Override // defpackage.iy1
    public void d(View view) {
        eg0 eg0VarV = v(view);
        if (eg0VarV == null) {
            eg0VarV = eg0.e;
        }
        x(eg0VarV);
    }

    @Override // defpackage.iy1
    public boolean equals(Object obj) {
        if (!super.equals(obj)) {
            return false;
        }
        cy1 cy1Var = (cy1) obj;
        return Objects.equals(this.g, cy1Var.g) && y(this.h, cy1Var.h);
    }

    @Override // defpackage.iy1
    public eg0 f(int i2) {
        return s(i2, false);
    }

    @Override // defpackage.iy1
    public final eg0 j() {
        if (this.e == null) {
            WindowInsets windowInsets = this.c;
            this.e = eg0.a(windowInsets.getSystemWindowInsetLeft(), windowInsets.getSystemWindowInsetTop(), windowInsets.getSystemWindowInsetRight(), windowInsets.getSystemWindowInsetBottom());
        }
        return this.e;
    }

    @Override // defpackage.iy1
    public ly1 l(int i2, int i3, int i4, int i5) {
        ly1 ly1VarH = ly1.h(this.c, null);
        int i6 = Build.VERSION.SDK_INT;
        by1 ay1Var = i6 >= 34 ? new ay1(ly1VarH) : i6 >= 30 ? new zx1(ly1VarH) : i6 >= 29 ? new yx1(ly1VarH) : new xx1(ly1VarH);
        ay1Var.d(ly1.e(j(), i2, i3, i4, i5));
        ay1Var.c(ly1.e(h(), i2, i3, i4, i5));
        return ay1Var.b();
    }

    @Override // defpackage.iy1
    public boolean n() {
        return this.c.isRound();
    }

    @Override // defpackage.iy1
    public void o(eg0[] eg0VarArr) {
        this.d = eg0VarArr;
    }

    @Override // defpackage.iy1
    public void p(ly1 ly1Var) {
        this.f = ly1Var;
    }

    @Override // defpackage.iy1
    public void r(int i2) {
        this.h = i2;
    }

    public eg0 t(int i2, boolean z) {
        eg0 eg0VarH;
        int i3;
        eg0 eg0Var = eg0.e;
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 8) {
                    eg0[] eg0VarArr = this.d;
                    eg0VarH = eg0VarArr != null ? eg0VarArr[3] : null;
                    if (eg0VarH != null) {
                        return eg0VarH;
                    }
                    eg0 eg0VarJ = j();
                    eg0 eg0VarU = u();
                    int i4 = eg0VarJ.d;
                    if (i4 > eg0VarU.d) {
                        return eg0.a(0, 0, 0, i4);
                    }
                    eg0 eg0Var2 = this.g;
                    if (eg0Var2 != null && !eg0Var2.equals(eg0Var) && (i3 = this.g.d) > eg0VarU.d) {
                        return eg0.a(0, 0, 0, i3);
                    }
                } else {
                    if (i2 == 16) {
                        return i();
                    }
                    if (i2 == 32) {
                        return g();
                    }
                    if (i2 == 64) {
                        return k();
                    }
                    if (i2 == 128) {
                        ly1 ly1Var = this.f;
                        bw bwVarE = ly1Var != null ? ly1Var.a.e() : e();
                        if (bwVarE != null) {
                            int i5 = Build.VERSION.SDK_INT;
                            return eg0.a(i5 >= 28 ? eu.g(bwVarE.a) : 0, i5 >= 28 ? eu.i(bwVarE.a) : 0, i5 >= 28 ? eu.h(bwVarE.a) : 0, i5 >= 28 ? eu.f(bwVarE.a) : 0);
                        }
                    }
                }
            } else {
                if (z) {
                    eg0 eg0VarU2 = u();
                    eg0 eg0VarH2 = h();
                    return eg0.a(Math.max(eg0VarU2.a, eg0VarH2.a), 0, Math.max(eg0VarU2.c, eg0VarH2.c), Math.max(eg0VarU2.d, eg0VarH2.d));
                }
                if ((this.h & 2) == 0) {
                    eg0 eg0VarJ2 = j();
                    ly1 ly1Var2 = this.f;
                    eg0VarH = ly1Var2 != null ? ly1Var2.a.h() : null;
                    int iMin = eg0VarJ2.d;
                    if (eg0VarH != null) {
                        iMin = Math.min(iMin, eg0VarH.d);
                    }
                    return eg0.a(eg0VarJ2.a, 0, eg0VarJ2.c, iMin);
                }
            }
        } else {
            if (z) {
                return eg0.a(0, Math.max(u().b, j().b), 0, 0);
            }
            if ((this.h & 4) == 0) {
                return eg0.a(0, j().b, 0, 0);
            }
        }
        return eg0Var;
    }

    public void x(eg0 eg0Var) {
        this.g = eg0Var;
    }
}
