package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.luutinhit.launcher6.LauncherRootView;

/* JADX INFO: loaded from: classes.dex */
public final class d8 extends AnimatorListenerAdapter {
    public final /* synthetic */ int g;
    public final /* synthetic */ e8 h;

    public /* synthetic */ d8(e8 e8Var, int i) {
        this.g = i;
        this.h = e8Var;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.g) {
            case 0:
                this.h.getClass();
                break;
            default:
                r1 r1Var = new r1(this, 2);
                e8 e8Var = this.h;
                e8Var.post(r1Var);
                LauncherRootView launcherRootView = (LauncherRootView) e8Var.getParent();
                if (launcherRootView != null) {
                    launcherRootView.removeView(e8Var);
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        switch (this.g) {
            case 0:
                this.h.getClass();
                break;
            default:
                e8 e8Var = this.h;
                e8Var.getClass();
                e8Var.k.showAppsLibrary();
                break;
        }
    }
}
