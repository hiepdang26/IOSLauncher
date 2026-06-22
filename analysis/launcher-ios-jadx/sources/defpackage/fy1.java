package defpackage;

import android.view.WindowInsets;

/* JADX INFO: loaded from: classes.dex */
public class fy1 extends ey1 {
    public eg0 o;
    public eg0 p;
    public eg0 q;

    public fy1(ly1 ly1Var, WindowInsets windowInsets) {
        super(ly1Var, windowInsets);
        this.o = null;
        this.p = null;
        this.q = null;
    }

    @Override // defpackage.iy1
    public eg0 g() {
        if (this.p == null) {
            this.p = eg0.b(this.c.getMandatorySystemGestureInsets());
        }
        return this.p;
    }

    @Override // defpackage.iy1
    public eg0 i() {
        if (this.o == null) {
            this.o = eg0.b(this.c.getSystemGestureInsets());
        }
        return this.o;
    }

    @Override // defpackage.iy1
    public eg0 k() {
        if (this.q == null) {
            this.q = eg0.b(this.c.getTappableElementInsets());
        }
        return this.q;
    }

    @Override // defpackage.cy1, defpackage.iy1
    public ly1 l(int i, int i2, int i3, int i4) {
        return ly1.h(this.c.inset(i, i2, i3, i4), null);
    }

    @Override // defpackage.dy1, defpackage.iy1
    public void q(eg0 eg0Var) {
    }
}
