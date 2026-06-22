package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewPropertyAnimator;

/* JADX INFO: loaded from: classes.dex */
public final class gt extends AnimatorListenerAdapter {
    public final /* synthetic */ m91 g;
    public final /* synthetic */ int h;
    public final /* synthetic */ View i;
    public final /* synthetic */ int j;
    public final /* synthetic */ ViewPropertyAnimator k;
    public final /* synthetic */ lt l;

    public gt(lt ltVar, m91 m91Var, int i, View view, int i2, ViewPropertyAnimator viewPropertyAnimator) {
        this.l = ltVar;
        this.g = m91Var;
        this.h = i;
        this.i = view;
        this.j = i2;
        this.k = viewPropertyAnimator;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        int i = this.h;
        View view = this.i;
        if (i != 0) {
            view.setTranslationX(0.0f);
        }
        if (this.j != 0) {
            view.setTranslationY(0.0f);
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        this.k.setListener(null);
        lt ltVar = this.l;
        m91 m91Var = this.g;
        ltVar.c(m91Var);
        ltVar.p.remove(m91Var);
        ltVar.i();
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
        this.l.getClass();
    }
}
