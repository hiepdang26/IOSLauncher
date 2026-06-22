package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

/* JADX INFO: loaded from: classes.dex */
public final class ce extends AnimatorListenerAdapter {
    public final /* synthetic */ int g;

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.g) {
            case 2:
                super.onAnimationEnd(animator);
                animator.removeListener(this);
                break;
            default:
                super.onAnimationEnd(animator);
                break;
        }
    }
}
