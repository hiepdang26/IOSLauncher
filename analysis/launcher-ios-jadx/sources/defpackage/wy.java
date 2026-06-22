package defpackage;

import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.widget.RtlSpacingHelper;

/* JADX INFO: loaded from: classes.dex */
public abstract class wy {
    public int a;
    public final Object b;
    public final Object c;

    public wy(u81 u81Var) {
        this.a = RtlSpacingHelper.UNDEFINED;
        this.c = new Rect();
        this.b = u81Var;
    }

    public static wy a(u81 u81Var, int i) {
        if (i == 0) {
            return new j01(u81Var, 0);
        }
        if (i == 1) {
            return new j01(u81Var, 1);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract int b(View view);

    public abstract int c(View view);

    public abstract int d(View view);

    public abstract int e(View view);

    public abstract int f();

    public abstract int g();

    public abstract int h();

    public abstract int i();

    public abstract int j();

    public abstract int k();

    public abstract int l();

    public abstract int m(View view);

    public abstract int n(View view);

    public abstract void o(int i);

    public wy(yy yyVar) {
        this.a = 0;
        this.c = new iz();
        this.b = yyVar;
    }
}
