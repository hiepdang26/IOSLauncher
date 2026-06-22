package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.luutinhit.launcher6.util.BadgeTextView;

/* JADX INFO: loaded from: classes.dex */
public final class ra extends AnimatorListenerAdapter {
    public final /* synthetic */ int g;
    public final /* synthetic */ BadgeTextView h;

    public /* synthetic */ ra(BadgeTextView badgeTextView, int i) {
        this.g = i;
        this.h = badgeTextView;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        switch (this.g) {
            case 1:
                super/*android.widget.TextView*/.setVisibility(8);
                super.onAnimationEnd(animator);
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
                super/*android.widget.TextView*/.setVisibility(0);
                super.onAnimationStart(animator);
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }
}
