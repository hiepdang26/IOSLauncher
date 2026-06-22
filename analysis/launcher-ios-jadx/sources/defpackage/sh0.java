package defpackage;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class sh0 implements Animator.AnimatorListener {
    public final float g;
    public final float h;
    public final float i;
    public final float j;
    public final m91 k;
    public final int l;
    public final ValueAnimator m;
    public boolean n;
    public float o;
    public float p;
    public boolean q = false;
    public boolean r = false;
    public float s;
    public final /* synthetic */ int t;
    public final /* synthetic */ m91 u;
    public final /* synthetic */ vh0 v;

    public sh0(vh0 vh0Var, m91 m91Var, int i, float f, float f2, float f3, float f4, int i2, m91 m91Var2) {
        this.v = vh0Var;
        this.t = i2;
        this.u = m91Var2;
        this.l = i;
        this.k = m91Var;
        this.g = f;
        this.h = f2;
        this.i = f3;
        this.j = f4;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.m = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(new q7(this, 10));
        valueAnimatorOfFloat.setTarget(m91Var.g);
        valueAnimatorOfFloat.addListener(this);
        this.s = 0.0f;
    }

    public final void a(Animator animator) {
        if (!this.r) {
            this.k.s(true);
        }
        this.r = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.s = 1.0f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        a(animator);
        if (this.q) {
            return;
        }
        int i = this.t;
        m91 m91Var = this.u;
        vh0 vh0Var = this.v;
        if (i <= 0) {
            vh0Var.s.a(vh0Var.x, m91Var);
        } else {
            vh0Var.g.add(m91Var.g);
            this.n = true;
            if (i > 0) {
                vh0Var.x.post(new s1(vh0Var, this, i, 6, false));
            }
        }
        View view = vh0Var.C;
        View view2 = m91Var.g;
        if (view == view2) {
            vh0Var.r(view2);
        }
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
