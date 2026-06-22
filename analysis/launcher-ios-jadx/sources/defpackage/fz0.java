package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
public final class fz0 extends AnimatorListenerAdapter {
    public final /* synthetic */ int g;
    public final /* synthetic */ hz0 h;

    public /* synthetic */ fz0(hz0 hz0Var, int i) {
        this.g = i;
        this.h = hz0Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.g) {
            case 0:
                hz0 hz0Var = this.h;
                hz0Var.k.getDragLayer().setRenderEffect(null);
                hz0Var.l.o();
                break;
            default:
                this.h.l.o();
                break;
        }
    }
}
