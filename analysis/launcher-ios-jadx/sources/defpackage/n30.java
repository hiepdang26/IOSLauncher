package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

/* JADX INFO: loaded from: classes.dex */
public abstract class n30 extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
    public boolean g;
    public float h;
    public float i;
    public final /* synthetic */ q30 j;

    public n30(q30 q30Var) {
        this.j = q30Var;
    }

    public abstract float a();

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        float f = (int) this.i;
        rr0 rr0Var = this.j.b;
        if (rr0Var != null) {
            rr0Var.j(f);
        }
        this.g = false;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        boolean z = this.g;
        q30 q30Var = this.j;
        if (!z) {
            rr0 rr0Var = q30Var.b;
            this.h = rr0Var == null ? 0.0f : rr0Var.g.m;
            this.i = a();
            this.g = true;
        }
        float f = this.h;
        float animatedFraction = (int) ((valueAnimator.getAnimatedFraction() * (this.i - f)) + f);
        rr0 rr0Var2 = q30Var.b;
        if (rr0Var2 != null) {
            rr0Var2.j(animatedFraction);
        }
    }
}
