package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
public final class zl1 extends AnimatorListenerAdapter {
    public final /* synthetic */ int g;
    public final /* synthetic */ am1 h;

    public zl1(am1 am1Var, int i) {
        this.h = am1Var;
        this.g = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.h.h = this.g;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.h.h = this.g;
    }
}
