package defpackage;

import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
public class dy1 extends cy1 {
    public eg0 n;

    public dy1(ly1 ly1Var, WindowInsets windowInsets) {
        super(ly1Var, windowInsets);
        this.n = null;
    }

    @Override // defpackage.iy1
    public ly1 b() {
        return ly1.h(this.c.consumeStableInsets(), null);
    }

    @Override // defpackage.iy1
    public ly1 c() {
        return ly1.h(this.c.consumeSystemWindowInsets(), null);
    }

    @Override // defpackage.iy1
    public final eg0 h() {
        if (this.n == null) {
            WindowInsets windowInsets = this.c;
            this.n = eg0.a(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.n;
    }

    @Override // defpackage.iy1
    public boolean m() {
        return this.c.isConsumed();
    }

    @Override // defpackage.iy1
    public void q(eg0 eg0Var) {
        this.n = eg0Var;
    }
}
