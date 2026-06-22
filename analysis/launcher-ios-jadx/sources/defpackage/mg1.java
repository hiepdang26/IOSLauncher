package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public final class mg1 extends AnimatorListenerAdapter {
    public final /* synthetic */ int g;
    public final /* synthetic */ View h;

    public /* synthetic */ mg1(int i, View view) {
        this.g = i;
        this.h = view;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.g) {
            case 0:
                super.onAnimationEnd(animator);
                this.h.setLayerType(0, null);
                animator.removeListener(this);
                break;
            default:
                super.onAnimationEnd(animator);
                this.h.setLayerType(0, null);
                animator.removeListener(this);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.g) {
            case 0:
                super.onAnimationStart(animator);
                this.h.setLayerType(2, null);
                break;
            default:
                super.onAnimationStart(animator);
                this.h.setLayerType(2, null);
                break;
        }
    }
}
