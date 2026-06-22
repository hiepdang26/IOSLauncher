package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.luutinhit.launcher6.widget.SwipeMenuLayout;

/* JADX INFO: loaded from: classes.dex */
public final class cl1 extends AnimatorListenerAdapter {
    public final /* synthetic */ int g;
    public final /* synthetic */ SwipeMenuLayout h;

    public /* synthetic */ cl1(SwipeMenuLayout swipeMenuLayout, int i) {
        this.g = i;
        this.h = swipeMenuLayout;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        SwipeMenuLayout swipeMenuLayout = this.h;
        switch (this.g) {
            case 0:
                SwipeMenuLayout swipeMenuLayout2 = SwipeMenuLayout.y;
                swipeMenuLayout.getClass();
                break;
            default:
                SwipeMenuLayout swipeMenuLayout3 = SwipeMenuLayout.y;
                swipeMenuLayout.getClass();
                break;
        }
    }
}
