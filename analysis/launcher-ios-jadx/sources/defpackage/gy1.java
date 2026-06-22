package defpackage;

import android.view.View;
import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
public class gy1 extends fy1 {
    public static final ly1 r = ly1.h(WindowInsets.CONSUMED, null);

    public gy1(ly1 ly1Var, WindowInsets windowInsets) {
        super(ly1Var, windowInsets);
    }

    @Override // defpackage.cy1, defpackage.iy1
    public eg0 f(int i) {
        return eg0.b(this.c.getInsets(jy1.a(i)));
    }

    @Override // defpackage.cy1, defpackage.iy1
    public final void d(View view) {
    }
}
