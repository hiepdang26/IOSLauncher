package defpackage;

import androidx.constraintlayout.motion.widget.MotionInterpolator;

/* JADX INFO: loaded from: classes.dex */
public final class oj1 extends MotionInterpolator {
    public final pj1 a;
    public oi1 b;
    public nj1 c;

    public oj1() {
        pj1 pj1Var = new pj1();
        pj1Var.k = false;
        this.a = pj1Var;
        this.c = pj1Var;
    }

    public final void a(float f, float f2, float f3, float f4, float f5, float f6) {
        pj1 pj1Var = this.a;
        this.c = pj1Var;
        pj1Var.l = f;
        boolean z = f > f2;
        pj1Var.k = z;
        if (z) {
            pj1Var.d(-f3, f - f2, f5, f6, f4);
        } else {
            pj1Var.d(f3, f2 - f, f5, f6, f4);
        }
    }

    public final void b(float f, float f2, float f3, float f4, float f5, float f6, int i) {
        if (this.b == null) {
            oi1 oi1Var = new oi1();
            oi1Var.a = 0.5d;
            oi1Var.i = 0;
            this.b = oi1Var;
        }
        oi1 oi1Var2 = this.b;
        this.c = oi1Var2;
        oi1Var2.c = f2;
        oi1Var2.a = f5;
        oi1Var2.e = f;
        oi1Var2.b = f4;
        oi1Var2.g = f3;
        oi1Var2.h = f6;
        oi1Var2.i = i;
        oi1Var2.d = 0.0f;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator, android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        return this.c.getInterpolation(f);
    }

    @Override // androidx.constraintlayout.motion.widget.MotionInterpolator
    public final float getVelocity() {
        return this.c.b();
    }
}
