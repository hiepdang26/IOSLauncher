package defpackage;

import android.graphics.Rect;
import android.view.WindowInsets;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: classes.dex */
public final class xx1 extends by1 {
    public static Field c = null;
    public static boolean d = false;
    public static Constructor e = null;
    public static boolean f = false;
    public WindowInsets a;
    public eg0 b;

    public xx1() {
        this.a = e();
    }

    private static WindowInsets e() {
        if (!d) {
            try {
                c = WindowInsets.class.getDeclaredField("CONSUMED");
            } catch (ReflectiveOperationException unused) {
            }
            d = true;
        }
        Field field = c;
        if (field != null) {
            try {
                WindowInsets windowInsets = (WindowInsets) field.get(null);
                if (windowInsets != null) {
                    return new WindowInsets(windowInsets);
                }
            } catch (ReflectiveOperationException unused2) {
            }
        }
        if (!f) {
            try {
                e = WindowInsets.class.getConstructor(Rect.class);
            } catch (ReflectiveOperationException unused3) {
            }
            f = true;
        }
        Constructor constructor = e;
        if (constructor != null) {
            try {
                return (WindowInsets) constructor.newInstance(new Rect());
            } catch (ReflectiveOperationException unused4) {
            }
        }
        return null;
    }

    @Override // defpackage.by1
    public ly1 b() {
        a();
        ly1 ly1VarH = ly1.h(this.a, null);
        iy1 iy1Var = ly1VarH.a;
        iy1Var.o(null);
        iy1Var.q(this.b);
        return ly1VarH;
    }

    @Override // defpackage.by1
    public void c(eg0 eg0Var) {
        this.b = eg0Var;
    }

    @Override // defpackage.by1
    public void d(eg0 eg0Var) {
        WindowInsets windowInsets = this.a;
        if (windowInsets != null) {
            this.a = windowInsets.replaceSystemWindowInsets(eg0Var.a, eg0Var.b, eg0Var.c, eg0Var.d);
        }
    }

    public xx1(ly1 ly1Var) {
        super(ly1Var);
        this.a = ly1Var.g();
    }
}
