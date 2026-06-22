package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.luutinhit.launcher6.DragLayer;

/* JADX INFO: loaded from: classes.dex */
public final class ow extends AnimatorListenerAdapter {
    public final /* synthetic */ Runnable g;
    public final /* synthetic */ int h;
    public final /* synthetic */ DragLayer i;

    public ow(DragLayer dragLayer, Runnable runnable, int i) {
        this.i = dragLayer;
        this.g = runnable;
        this.h = i;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        Runnable runnable = this.g;
        if (runnable != null) {
            runnable.run();
        }
        if (this.h != 0) {
            return;
        }
        this.i.clearAnimatedView();
    }
}
