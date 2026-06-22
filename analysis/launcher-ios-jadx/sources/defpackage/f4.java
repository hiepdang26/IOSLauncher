package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class f4 extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {
    public final ViewGroup g;
    public final boolean h;

    public f4(ViewGroup viewGroup, boolean z) {
        this.g = viewGroup;
        this.h = z;
    }

    public static void a(View view, boolean z) {
        int i = z ? 8 : 4;
        if (view.getAlpha() < 0.01f && view.getVisibility() != i) {
            view.setVisibility(i);
        } else {
            if (view.getAlpha() <= 0.01f || view.getVisibility() == 0) {
                return;
            }
            view.setVisibility(0);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        a(this.g, this.h);
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.g.setVisibility(0);
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        a(this.g, this.h);
    }
}
