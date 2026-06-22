package defpackage;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;

/* JADX INFO: loaded from: classes.dex */
public final class o02 implements TimeInterpolator {
    public final yg0 a;
    public final DecelerateInterpolator b;

    public o02() {
        yg0 yg0Var = new yg0();
        yg0Var.a = new n20(1);
        this.a = yg0Var;
        this.b = new DecelerateInterpolator(3.0f);
    }

    @Override // android.animation.TimeInterpolator
    public final float getInterpolation(float f) {
        return this.b.getInterpolation(this.a.getInterpolation(f));
    }
}
