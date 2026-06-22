package defpackage;

import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
public final class hy1 extends gy1 {
    public static final ly1 s = ly1.h(WindowInsets.CONSUMED, null);

    public hy1(ly1 ly1Var, WindowInsets windowInsets) {
        super(ly1Var, windowInsets);
    }

    @Override // defpackage.gy1, defpackage.cy1, defpackage.iy1
    public eg0 f(int i) {
        return eg0.b(this.c.getInsets(ky1.a(i)));
    }
}
