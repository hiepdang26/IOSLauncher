package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
public final class hj extends AnimatorListenerAdapter {
    public final /* synthetic */ int g;
    public final /* synthetic */ jj h;

    public /* synthetic */ hj(jj jjVar, int i) {
        this.g = i;
        this.h = jjVar;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.g) {
            case 1:
                this.h.a.setEndIconVisible(false);
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.g) {
            case 0:
                this.h.a.setEndIconVisible(true);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
