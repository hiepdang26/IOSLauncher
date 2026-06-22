package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class xu1 extends AnimatorListenerAdapter implements vo1 {
    public final View g;
    public final int h;
    public final ViewGroup i;
    public boolean k;
    public boolean l = false;
    public final boolean j = true;

    public xu1(int i, View view) {
        this.g = view;
        this.h = i;
        this.i = (ViewGroup) view.getParent();
        f(true);
    }

    @Override // defpackage.vo1
    public final void b() {
        f(false);
    }

    @Override // defpackage.vo1
    public final void c() {
        f(true);
    }

    @Override // defpackage.vo1
    public final void d(xo1 xo1Var) {
        if (!this.l) {
            pu1.a.s(this.h, this.g);
            ViewGroup viewGroup = this.i;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        f(false);
        xo1Var.u(this);
    }

    public final void f(boolean z) {
        ViewGroup viewGroup;
        if (!this.j || this.k == z || (viewGroup = this.i) == null) {
            return;
        }
        this.k = z;
        n90.E(viewGroup, z);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.l = true;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        if (!this.l) {
            pu1.a.s(this.h, this.g);
            ViewGroup viewGroup = this.i;
            if (viewGroup != null) {
                viewGroup.invalidate();
            }
        }
        f(false);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationPause(Animator animator) {
        if (this.l) {
            return;
        }
        pu1.a.s(this.h, this.g);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorPauseListener
    public final void onAnimationResume(Animator animator) {
        if (this.l) {
            return;
        }
        pu1.a.s(0, this.g);
    }

    @Override // defpackage.vo1
    public final void e() {
    }

    @Override // defpackage.vo1
    public final void a(xo1 xo1Var) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
