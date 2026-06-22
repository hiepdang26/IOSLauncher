package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: loaded from: classes.dex */
public final class f20 extends AnimatorListenerAdapter {
    public final /* synthetic */ int g = 1;
    public final /* synthetic */ boolean h;
    public final /* synthetic */ View i;
    public final /* synthetic */ Object j;

    public f20(boolean z, View view, View view2) {
        this.h = z;
        this.i = view;
        this.j = view2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.g) {
            case 0:
                if (!this.h) {
                    this.i.setVisibility(4);
                    View view = (View) this.j;
                    view.setAlpha(1.0f);
                    view.setVisibility(0);
                }
                break;
            default:
                ((f02) this.j).c = null;
                if (this.h) {
                    ViewGroup viewGroup = (ViewGroup) this.i;
                    if (viewGroup.getVisibility() == 0) {
                        viewGroup.getChildAt(0).performAccessibilityAction(64, null);
                    }
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.g) {
            case 0:
                if (this.h) {
                    this.i.setVisibility(0);
                    View view = (View) this.j;
                    view.setAlpha(0.0f);
                    view.setVisibility(4);
                }
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public f20(f02 f02Var, boolean z, ViewGroup viewGroup) {
        this.j = f02Var;
        this.h = z;
        this.i = viewGroup;
    }
}
