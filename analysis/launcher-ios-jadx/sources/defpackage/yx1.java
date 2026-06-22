package defpackage;

import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
public class yx1 extends by1 {
    public final WindowInsets.Builder a;

    public yx1() {
        this.a = eo1.f();
    }

    @Override // defpackage.by1
    public ly1 b() {
        a();
        ly1 ly1VarH = ly1.h(this.a.build(), null);
        ly1VarH.a.o(null);
        return ly1VarH;
    }

    @Override // defpackage.by1
    public void c(eg0 eg0Var) {
        this.a.setStableInsets(eg0Var.c());
    }

    @Override // defpackage.by1
    public void d(eg0 eg0Var) {
        this.a.setSystemWindowInsets(eg0Var.c());
    }

    public yx1(ly1 ly1Var) {
        WindowInsets.Builder builderF;
        super(ly1Var);
        WindowInsets windowInsetsG = ly1Var.g();
        if (windowInsetsG != null) {
            builderF = eo1.g(windowInsetsG);
        } else {
            builderF = eo1.f();
        }
        this.a = builderF;
    }
}
