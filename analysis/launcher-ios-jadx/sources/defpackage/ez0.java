package defpackage;

import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class ez0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ int g;
    public final /* synthetic */ hz0 h;

    public /* synthetic */ ez0(hz0 hz0Var, int i) {
        this.g = i;
        this.h = hz0Var;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.g) {
            case 0:
                hz0 hz0Var = this.h;
                hz0Var.getClass();
                hz0Var.d(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            default:
                hz0 hz0Var2 = this.h;
                hz0Var2.getClass();
                hz0Var2.d(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
        }
    }
}
