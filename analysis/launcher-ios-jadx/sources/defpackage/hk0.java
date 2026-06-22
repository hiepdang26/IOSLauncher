package defpackage;

import android.animation.Animator;

/* JADX INFO: loaded from: classes.dex */
public final class hk0 implements Animator.AnimatorListener {
    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        ik0.a.remove(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        ik0.a.remove(animator);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        ik0.a.put(animator, null);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }
}
